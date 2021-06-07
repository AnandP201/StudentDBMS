package DataList;

import MongoJDBC.DBConnect;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bson.Document;

public class teacherData{
    public static HashMap<Integer,List<String>>teacher=new HashMap<>();
    public static String[] tableHeader;
    public static int totalTeachers;
    public static int totalFields;
    public static String adminName;
    public static String currTable=" ";
    public static int actionAndDespFlag=0;
    public static String warning=null;
    public static String currRegisteredTable;
    public static int displayFlag=0;
    public static int rf;

    public static HashMap<Integer,List<String>>leaves=new HashMap<>();
     public static HashMap<Integer,List<String>>titles=new HashMap<>();
     public static HashMap<Integer,String>leaveID=new HashMap<>();
    
     public void setHeader(FindIterable<Document> f)
   {
       MongoCursor<Document> C=f.iterator();
       Document document=C.next();
       tableHeader=document.keySet().toArray(new String[document.size()]);
       totalFields=tableHeader.length;
       System.out.println(totalFields);
   }
     
     
     
     public void parseRecordAndGenerate(FindIterable<Document> teachersRecord)
     {
         try
         {
             setHeader(teachersRecord);
             warning=null;
         }
        catch(Exception e)
        {
            tableHeader=null;
            warning="Records not found";
        }
        MongoCursor<Document> main=teachersRecord.iterator();
        int k=0;
       while(main.hasNext())
       {
           Document cur=main.next();
           String []vals=cur.values().toArray(new String[totalFields]);
           teacher.put(k, Arrays.asList(vals));
           k++;
       }
     }
     
     
     public static String getAllotedSections(String name)
     {
         String c=new DBConnect().getAlloted(name);
         if(c==null)
         {
             return null;
         }
         int l=c.length();
         return c.substring(0,l-1).toUpperCase();
     }
}
