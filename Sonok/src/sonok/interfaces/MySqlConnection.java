package sonok.interfaces;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MySqlConnection{
    private java.sql.Connection con = null;
    
    private String servername = "vmcsql01:49250";
    private String tablename = "aufgabenliste";
    private String username = "user_aufgabenliste";
    private String userpass = "user_aufgabenliste";
    
    public MySqlConnection(){
    }
    
    public MySqlConnection(String server, String table, String user, String pass){    	
    	servername = server;
    	tablename = table;
    	username = user;
    	userpass = pass;
    	
        getConnection();
       }

    private java.sql.Connection getConnection(){
         try{
       	  Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
       	  con = DriverManager.getConnection( "jdbc:jtds:sqlserver://"+ servername +"/"+ tablename, username, userpass);
              if(con!=null) System.out.println("Verbindung erfolgreich!");
         }catch(Exception e){
              e.printStackTrace();
              System.out.println("Fehler in der Datenanbindung : " + e.getMessage());
        }
         return con;
     }


    public void displayDbProperties(){
         java.sql.DatabaseMetaData dm = null;
         java.sql.ResultSet rs = null;
         try{
              con= this.getConnection();
              if(con!=null){
                   dm = con.getMetaData();
                   System.out.println("Driver Information");
                   System.out.println("\tDriver Name: "+ dm.getDriverName());
                   System.out.println("\tDriver Version: "+ dm.getDriverVersion ());
                   System.out.println("Database Information ");
                   System.out.println("\tDatabase Name: "+ dm.getDatabaseProductName());
                   System.out.println("\tDatabase Version: "+ dm.getDatabaseProductVersion());
                   System.out.println("Avalilable Catalogs ");
                   rs = dm.getCatalogs();
                   while(rs.next()){
                	   System.out.println("\tcatalog: "+ rs.getString(1));
                   } 
                   rs.close();
                   rs = null;
                   closeConnection();
              }else System.out.println("Fehler! Keine aktive Verbindung vorhanden.");
         }catch(Exception e){
              e.printStackTrace();
         }
         dm=null;
    }     
    
    private void closeConnection(){
         try{
              if(con!=null)
                   con.close();
              con=null;
         }catch(Exception e){
              e.printStackTrace();
         }
    }
    
    public String doSQL(String s, boolean read){
    	System.out.println(s);
    	
      String result = null;
    	try {    		
    		if (con != null){
	    		java.sql.Statement statement = con.createStatement();
	    		
	    		if (!read){
	    			statement.executeUpdate(s);	    			
	    		} else {		  
		    		ResultSet rs = statement.executeQuery(s);
		    		
		    		ResultSetMetaData rsmd = rs.getMetaData();
		    	    int cols = rsmd.getColumnCount();
	
	
		    	    while(rs.next())
		    	    {
		    	        // eine zeile ausgeben
		    	       result = rs.getString(1);
		    	    }

		    	    System.out.println(result);
	    		}
	    		
	    		statement.close();	
    		} else {
    			System.out.println("connect.no sql connection!");
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
      return result;
    }
    
    public int Insert(String Table, String Field, String Value){
    	String mid = Select(Table,"Max(ID)");
    	if (mid == null) mid = "-1";
		int nid = Integer.parseInt(mid) + 1;
    	
    	String sqlstr = "INSERT INTO " + Table;	
    	sqlstr += " (ID,"+Field+") ";
    	sqlstr += "VALUES (" + nid + "," + Value + ")"; 
    	
    	doSQL(sqlstr,false);   
    	
    	return nid;
    }    
    public int Insert(String Table){
    	String mid = Select(Table,"Max(ID)");
    	if (mid == null) mid = "-1";
		int nid = Integer.parseInt(mid) + 1;
    	
    	String sqlstr = "INSERT INTO " + Table;	
    	sqlstr += " (ID) ";
    	sqlstr += "VALUES (" + nid + ")"; 
    	
    	doSQL(sqlstr,false);  
    	
    	return nid;  	
    }
    
    public void Update(String Table, String Field, String Value, String Where){
    	String sqlstr = "UPDATE " + Table;
    	sqlstr += " SET " + Field + "=" + Value;
    	
       if (Where != "")
    	sqlstr += " WHERE " + Where;
    	
    	doSQL(sqlstr,false);    	    	
    }
    
    public void Delete(String Table, String Where){
    	String sqlstr = "DELETE FROM " + Table;
    	sqlstr += " WHERE " + Where;
    	
    	doSQL(sqlstr, false);
    }
    
    public String Select(String Table, String Field, String Where){
    	try {
			String sqlstr = "SELECT " + Field + " FROM " + Table;
			sqlstr += " WHERE (" + Where+")";
			
			return doSQL(sqlstr, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
    }
    public String Select(String Table, String Field){
    	String sqlstr = "SELECT " + Field + " FROM " + Table;
            	
        return doSQL(sqlstr, true);
    }  
    
    
}

