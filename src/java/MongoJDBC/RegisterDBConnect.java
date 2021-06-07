package MongoJDBC;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import DataList.RegisterData;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.gridfs.*;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.io.FileInputStream;
import java.io.InputStream;
import org.bson.types.ObjectId;

public class RegisterDBConnect {
    
    MongoClient mongoClient = MongoClients.create("mongodb+srv://data:2001anand@cluster0.nownt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("sdbms");
    MongoCollection<Document> c;
    Document d;
    public void checkAndAddToDB(RegisterData reg)
    {
        if(reg.getUser().equalsIgnoreCase("teacher"))
        {
            c=database.getCollection("teacher");
            addtoTeacherDatabase(reg,c);
        }
        if(reg.getUser().equalsIgnoreCase("student"))
        {
            c=database.getCollection("students");
            addtoStudentDatabase(reg,c);
        }
    }
    public void addtoStudentDatabase(RegisterData reg,MongoCollection<Document> c)
    {
        d=new Document("ID",reg.getUid()).append("Password",reg.getPassword()).append("Name", reg.getName()).append("Gender", reg.getGender()).append("DOB", reg.getDob()).append("Phno",reg.getPhno()).append("Address",reg.getAddress()).append("E-Mail",reg.getEmail()).append("Branch", reg.getBranch()).append("Department",reg.getDepartment()).append("Degree", reg.getDegree()).append("ImageID", reg.getImageID());
        c.insertOne(d);
    }
    public void addtoTeacherDatabase(RegisterData reg,MongoCollection<Document> c)
    {
        d=new Document("EID",reg.getEid()).append("ID",reg.getUid()).append("Password",reg.getPassword()).append("Name", reg.getName()).append("Gender", reg.getGender()).append("Qualifications", reg.getQf()).append("E-Mail",reg.getEmail()).append("Phno",reg.getPhno()).append("Address",reg.getAddress()).append("Branch", reg.getBranch()).append("Department",reg.getDepartment()).append("ImageID", reg.getImageID());
        c.insertOne(d);
    }
    
    public void addtoactiveUser(String id,String password,MongoCollection<Document> c)
    {
        d=new Document("ID",id).append("Password", password);
        c.insertOne(d);
    }
    
    public void findandDelete(String id)
    {
        database.getCollection("active").deleteOne(eq("ID",id));
    }
    public int findandDeleteWithPassword(String password)
    {
      
        DeleteResult d=database.getCollection("active").deleteOne(eq("Password",password));  
        if(d.getDeletedCount()>0)
        {
            return 1;
        }
        else 
            return 0;
        
    }
    
    
    public String storeAndReturnImgID(String path,String name)
    {
       ObjectId d = null;
       GridFSBucket g=GridFSBuckets.create(database);
       try
       {
        InputStream in=new FileInputStream(path);
        GridFSUploadOptions uploadOptions = new GridFSUploadOptions();
        d=g.uploadFromStream(name, in, uploadOptions); 
        
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
         return d.toString();
    }
}
