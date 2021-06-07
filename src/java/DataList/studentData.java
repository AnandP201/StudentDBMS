package DataList;

import MongoJDBC.DBConnect;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bson.Document;
import sessions.functions;

public class studentData {
    
     public static HashMap<Integer,List<String>>student=new HashMap<>();
     public static String[] tableHeader;
     public static int totalStudents;
     public static int totalFields;
     public static String adminName;
     public static String currTable=" ";
     public static int actionAndDespFlag=0;
     public static String warning=null;
     public static String currRegisteredTable;
     
     
     public static HashMap<Integer,List<String>>leaves=new HashMap<>();
     public static HashMap<Integer,List<String>>titles=new HashMap<>();
     public static HashMap<Integer,String>leaveID=new HashMap<>();
     
     public static HashMap<Integer,List<String>>peer=new HashMap<>();
     public static String[] keys;
     public void setHeader(FindIterable<Document> f)
   {
       MongoCursor<Document> C=f.iterator();
       Document document=C.next();
       tableHeader=document.keySet().toArray(new String[document.size()]);
       totalFields=tableHeader.length;
   }
     
     public static void delocateFlags()
     {
         actionAndDespFlag=0;
         
     }
     public void parseRecordAndGenerate(FindIterable<Document> studentsRecord)
     {
         try
         {
             setHeader(studentsRecord);
             warning=null;
         }
        catch(Exception e)
        {
            tableHeader=null;
            warning="Records not found ";
        }
        MongoCursor<Document> main=studentsRecord.iterator();
        int k=0;
       while(main.hasNext())
       {
           Document cur=main.next();
           String[] vals=cur.values().toArray(new String[totalFields]);
           student.put(k, Arrays.asList(vals));
           k++;
       }
       /**Debug 
        for(int i=0;i<totalStudents;i++)
       {
           for(int j=0;j<totalFields;j++)
           {
               System.out.println(tableHeader[j]+" : "+student[i][j]);
           }
           System.out.println("\n");
       }**
       * 
       * 
       * */
     }
     
     public static boolean isAlotted(String name)
     {
         if(new DBConnect().isPresent(name)==1)
         {
             return true;
         }
         return false;
     }
     
     
     public static void leaveDisplay(String name)
     {
            FindIterable<Document> doc=new DBConnect().getLeaveRecords(name);
            FindIterable<Document> obj=new DBConnect().getLeaveID(name);
            MongoCursor<Document> m=obj.iterator();
            int z=0;
            while(m.hasNext())
            {
                Document docs=m.next();
                leaveID.put(z, docs.getObjectId("_id").toString());
                z++;
            }
            
            MongoCursor<Document> mongo=doc.iterator();
            int k=0;
            while(mongo.hasNext())
            {
                Document document=mongo.next();
                String []t=document.keySet().toArray(new String[document.size()]);
                String []values=document.values().toArray(new String[document.size()]);
                leaves.put(k, Arrays.asList(values));
                titles.put(k, Arrays.asList(t));
                k++;
            }
     }
     
     
     public static String getLeaveApproveStatus(String ID)
     {
         Document d=new DBConnect().getDocumentById(ID);
         return d.getString("Approve Status");
     }
     
     public static int setLeaves(FindIterable<Document>d)
     {
         if(d.first()==null)
         {
             return 1;
         }
         else
         {
            MongoCursor<Document> cursor=d.iterator();
         int k=0;
         while(cursor.hasNext())
         {
             Document doc=cursor.next();
             String []t=doc.keySet().toArray(new String[doc.size()]);
             String []values=doc.values().toArray(new String[doc.size()]);
             leaves.put(k, Arrays.asList(values));
             titles.put(k, Arrays.asList(t));
             k++;
         } 
         }
         return 0;
     }
     
     public static int extractLeaveIDS(String section)
     {
         FindIterable<Document> doc=new DBConnect().getLeavesWithID(section);
         if(doc.first()==null)
         {
             return 1;
         }
         else
         {
          MongoCursor<Document> cur=doc.iterator();
         int z=0;
         while(cur.hasNext())
         {
             Document document=cur.next();
             if(document==null)
             {
                 return 1;
             }
             leaveID.put(z, document.getObjectId("_id").toString());
             z++;
         }   
         }
         return 0;
     }
             
     public void setPeers(String name)
     {
         FindIterable<Document> docs=new DBConnect().getPeerRecords(name);
         MongoCursor<Document>m=docs.iterator();
         
         int l=0;
         while(m.hasNext())
         {
             Document d=m.next();
             String values[]=d.values().toArray(new String[d.size()]);
             peer.put(l, Arrays.asList(values));
             l++;
         }  
         
         keys=docs.first().keySet().toArray(new String[6]);
     }
     
     
}
