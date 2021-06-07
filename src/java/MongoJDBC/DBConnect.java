package MongoJDBC;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import DataList.studentData;
import DataList.teacherData;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import sessions.functions;
import org.bson.Document;
import org.bson.types.ObjectId;
import sessions.login;

public class DBConnect {

    MongoClient mongoClient = MongoClients.create("mongodb+srv://data:2001anand@cluster0.nownt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("sdbms");
    MongoCollection c;
    public static String[] sections={"coa","cob","csa","csb"};
    
    public void closeConnection()
    {
        mongoClient.close();
    }
    
    public int isPresent(String name)
    {
       for (String s:sections)
       {
           c = database.getCollection(s);
             if(c.countDocuments(eq("Name",name))==1)
             {
                 studentData.currRegisteredTable=s;
                 return 1;
             }
       }
       return 0;
    }
    
    public String getSectionOfStudent(String name)
    {
        for (String s:sections)
       {
           c = database.getCollection(s);
             if(c.countDocuments(eq("Name",name))==1)
             {
                 return s;
             }
       }
        return null;
    }
    
    public String getAlloted(String name)
    {
        String cString=" ";
        int count=0;
        for(String s:sections)
        {
            c=database.getCollection(s);
            if(c.countDocuments(eq("Name",name))==1)
            {
                count++;
                cString=cString+s+",";
            }
        }
        if(count>0)
        {
            return cString;
        }
        return null;
    }
    
    public FindIterable<Document> getRecords(String tablename)
    {
        c=database.getCollection(tablename);
        if(!tablename.equalsIgnoreCase("students"))
        {
            studentData.totalStudents=(int)c.countDocuments(eq("Entity","Student"));
            return c.find(eq("Entity","Student")).projection(exclude("Entity","_id"));
        }
        studentData.totalStudents=(int)c.countDocuments();
        return c.find(new Document()).projection(exclude("_id","Password","ImageID"));
    }
    
    public FindIterable<Document> getTRecords(String tablename)
    {
        c=database.getCollection(tablename);
        if(!tablename.equalsIgnoreCase("teacher"))
        {
            teacherData.totalTeachers=(int)c.countDocuments(eq("Entity","Faculty"));
            return c.find(eq("Entity","Faculty")).projection(exclude("Entity","_id"));
        }
        teacherData.totalTeachers=(int)c.countDocuments();
        return c.find(new Document()).projection(exclude("_id","Password","ImageID","Class alloted"));
    }
    
    public void addtoClass(String section,String UID,String name)
    {
        c=database.getCollection(section);
        c.insertOne(new Document("Name",name).append("CID", UID).append("Entity","Student").append("Leave Count","0"));
        c=database.getCollection("students");
        c.updateOne(eq("ID",name),combine(set("CID",UID),set("Section",section.toUpperCase())));
        closeConnection();
    }
     
    public void addtoClass(String section,String UID,String name,String subjects)
    {
             c=database.getCollection(section);
             c.insertOne(new Document("Name",name).append("EID", UID).append("Subjects", subjects).append("Entity","Faculty"));
             c=database.getCollection("teacher");
             c.updateOne(eq("ID",name),combine(set("EID",UID)));
             closeConnection();
    }
    
    
    public int getLeaveCount(FindIterable<Document> f)
    {
        Document d=f.first();
        int a=Integer.parseInt(d.getString("Leave Count"));
        System.out.println("Count is"+a);
        return a;
    }
    
    public String getCurTimeAndDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public void addLeave(String startTime,String endTime,String date,String leaveType,String leaveReason)
    {
         MongoCollection collection=database.getCollection("Leave");
         String studentName=login.userID;
         String section=getSectionOfStudent(studentName);
         collection.insertOne(new Document("Entity","student").append("Applicant",studentName).append("Section",section).append("Leave Type", leaveType.toUpperCase()).append("On Date",date).append("From Time",startTime).append("To Time",endTime).append("Reason",leaveReason).append("Applied On", getCurTimeAndDate()).append("Approve Status","NO"));
         
         collection=database.getCollection(section);
         int count=getLeaveCount(collection.find(eq("Name",studentName)).projection(fields(include("Leave Count"),exclude("_id"))));
         count+=1;
         collection.updateOne(eq("Name",studentName), set("Leave Count",String.valueOf(count)));
         closeConnection();
    }
    
    public void addLeave(String startDate,String leaveType,String leaveReason)
    {
        MongoCollection collection=database.getCollection("Leave");
        String studentName=login.userID;
        String section=getSectionOfStudent(studentName);
        collection.insertOne(new Document("Entity","student").append("Applicant",studentName).append("Section",section).append("Leave Type", leaveType.toUpperCase()).append("For Date", startDate).append("Reason", leaveReason).append("Applied On", getCurTimeAndDate()).append("Approve Status","NO"));
      
        collection=database.getCollection(section);
       int count=getLeaveCount(collection.find(eq("Name",studentName)).projection(fields(include("Leave Count"),exclude("_id"))));
        count+=1; 
       collection.updateOne(eq("Name",studentName), set("Leave Count",String.valueOf(count)));
        closeConnection();
    }
    
    public void addLeave(String startDate,String endDate,String leaveType,String leaveReason)
    {
        MongoCollection collection=database.getCollection("Leave");
        String studentName=login.userID;
        String section=getSectionOfStudent(studentName);
        collection.insertOne(new Document("Entity","student").append("Applicant",studentName).append("Section",section).append("Leave Type", leaveType.toUpperCase()).append("From Date",startDate).append("To Date",endDate).append("Reason",leaveReason).append("Applied On", getCurTimeAndDate()).append("Approve Status","NO"));
        
        collection=database.getCollection(section);
        int count=getLeaveCount(collection.find(eq("Name",studentName)).projection(fields(include("Leave Count"),exclude("_id"))));
        count+=1;
        collection.updateOne(eq("Name",studentName), set("Leave Count",String.valueOf(count)));
        closeConnection();
    }
    
    public FindIterable<Document> getLeaveID(String name)
    {
        c=database.getCollection("Leave");
        return c.find(eq("Applicant",name)).projection(include("_id"));
    }
    
    public FindIterable<Document> getLeavesWithID(String section)
    {
        c=database.getCollection("Leave");
        return c.find(eq("Section",section)).projection(include("_id"));
    }
    
    public FindIterable<Document> getLeaveRecords(String name)
    {
        c=database.getCollection("Leave");
        functions.numberOfLeaves=(int)c.countDocuments(eq("Applicant",name));
        return c.find(eq("Applicant",name)).projection(exclude("_id","Applicant","Entity","Section"));
    }
    
    public Document getDocumentById(String ID)
    {
        c=database.getCollection("Leave");
        FindIterable<Document> v=c.find(eq("_id",new ObjectId(ID))).projection(exclude("_id"));
        return v.first();
    }
    
    public void decrementLeaveCount(String name)
    {
        String sec=getSectionOfStudent(name);
        c=database.getCollection(sec);
        int count=getLeaveCount(c.find(eq("Name",name)).projection(and(include("Leave Count"),exclude("_id"))));
        count-=1;
        c.updateOne(eq("Name",name), set("Leave Count",String.valueOf(count)));
    }
    
   
    
    public void dropLeaveById(String ID,String name)
    {
        if(studentData.getLeaveApproveStatus(ID).equalsIgnoreCase("NO"))
        {
            decrementLeaveCount(name);
        }
        c=database.getCollection("Leave");
        c.deleteOne(eq("_id",new ObjectId(ID)));
    }
   
    public FindIterable<Document> getLeavesFromSection(String section)
    {
        c=database.getCollection("Leave");
        functions.numberOfLeaves=(int)c.countDocuments(eq("Section",section.toLowerCase()));
        return c.find(and(eq("Section",section.toLowerCase()),eq("Approve Status","NO"))).projection(exclude("_id","Entity"));
    }
    
    public void approveLeave(String ID,String adminName)
    {
        c=database.getCollection("Leave");
        c.updateOne(eq("_id",new ObjectId(ID)),set("Approve Status","YES"));
        String applicantName=getNameOfAppliedLeaveID(c.find(eq("_id",new ObjectId(ID))).projection(exclude("_id")));
        
        c=database.getCollection("ALeaves");
        String dateTime=getCurTimeAndDate();
        functions.displayleaveAtAdmin=0;
        c.insertOne(new Document("Leave ID",ID).append("Applicant Student", applicantName).append("Approved By",adminName).append("On",dateTime));
    }
    
    public String getNameOfAppliedLeaveID(FindIterable<Document> doc)
    {
        return doc.first().getString("Applicant");
    }
    
    public void rejectLeave(String ID)
    {
        c=database.getCollection("Leave");
        c.updateOne(eq("_id",new ObjectId(ID)),set("Approve Status","INV"));
        String applicantName=getNameOfAppliedLeaveID(c.find(eq("_id",new ObjectId(ID))).projection(exclude("_id")));
        functions.displayleaveAtAdmin=0;
        decrementLeaveCount(applicantName);
    }
    
    public FindIterable<Document> getPeerRecords(String name)
    {
        MongoCollection coll=database.getCollection("students");
        String section=getSectionOfStudent(name);
        return coll.find(eq("Section",section.toUpperCase())).projection(and(include("CID","Name","Gender","DOB","E-Mail","Phno"),exclude("_id")));
    }
    
    
    public boolean isTeacher(String name)
    {
        MongoCollection z=database.getCollection(getSectionOfStudent(name));
        int count=(int)z.countDocuments(and(eq("Name",name),eq("Entity","Faculty")));
        if(count>0)
        {
            return true;
        }
        return false;
    }
}
