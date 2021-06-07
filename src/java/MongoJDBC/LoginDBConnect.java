package MongoJDBC;
import DataList.LoginData;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.include;
import java.util.Collection;
import java.util.Set;
import org.bson.Document;


public class LoginDBConnect {
    LoginData l=new LoginData();
    public String u;
    Document d;
    public static int login_fail_flag;
    public static int size;
    public static String username,tablename;
    
    MongoCollection<Document> coll;
    MongoCollection<Document> active_user;
    
        MongoClient mongoClient = MongoClients.create("mongodb+srv://data:2001anand@cluster0.nownt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("sdbms");
     
    public void closeConnection()
    {
        mongoClient.close();
    }
        
    public MongoDatabase getDatabaseName()
    {
        return database;
    }
    public void connectToDatabase(LoginData l)
    {
        if(l.getUser().equalsIgnoreCase("teacher"))
        {
            u="teacher";
        }
        else if(l.getUser().equalsIgnoreCase("student"))
        {
            u="students";
        }
        else if(l.getUser().equalsIgnoreCase("admin"))
        {
            u="admin";
        }
       coll = database.getCollection(u);
       active_user=database.getCollection("active");
    }
    
    public boolean isActive(String id,String password)
    {
        Document da=active_user.find(and(eq("ID",id),eq("Password",password))).first();
        try
        {
            String str=da.toJson();
        }
        catch(NullPointerException e)
        {
            return false;
        }
          login_fail_flag=1;
          return true;
    }
    
   
    public int verifyUser(LoginData l)
    {
          if(isActive(l.getUserID(),l.getPassword()))
          {
              return 0;
          }
          Document doc=coll.find(and(eq("ID",l.getUserID()),eq("Password",l.getPassword()))).first();
          try
          {
              String str=doc.toJson();
          }
          catch(Exception e)
          {
              return 0;
          }
              new RegisterDBConnect().addtoactiveUser(l.getUserID(), l.getPassword(), active_user);
              return 1;
          
    }
    
    public Document getDocument(String user,String Tname)
    {
        coll=database.getCollection(Tname.toLowerCase());
        
        FindIterable<Document> doc=coll.find(eq("ID",user)).projection(exclude("_id","ID","Password","ImageID"));
        MongoCursor<Document> it=doc.iterator();
        
        while(it.hasNext())
        {
            d=it.next();
        }
        size=d.size();
        return d;
        
    }
    
    public String[] getValues(String user,String Tname)
    {
        Document d=getDocument(user, Tname);
        Collection<Object> obj=d.values();
        return obj.toArray(new String[obj.size()]);
    }
    
    public String[] getKeys(String user,String Tname)
    {
        Document d=getDocument(user, Tname);
        Set<String> keyset=d.keySet();
        return keyset.toArray(new String[keyset.size()]);
        
    }
    
    public String getObjectID(String userID,String cName)
    {
        coll=database.getCollection(cName);
        Document da=coll.find(eq("ID",userID)).projection(and(include("ImageID"),exclude("_id"))).first();
        
        return da.values().toArray(new String[da.size()])[0];
        
    }
}
