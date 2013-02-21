package MSAccess;
/**

* Inhalt:
* 	JDBC
* Stichworte:
* 	Datenbank Inhalte ausgeben
* @author TBE
*/
import java.sql.*;

public class ManipulateODBCSource {
	
	public static void main( String[] args ) {
		String url = "jdbc:odbc:" + "Kunden";
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
			c = DriverManager.getConnection( url, "", "" );
			
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Adressen" ); 

			ResultSetMetaData meta = rs.getMetaData(); 
			
			int colCount = meta.getColumnCount(); 
			
			while ( rs.next() ) { 
				for ( int colNum = 1; colNum <= colCount; colNum++ ) { 
					System.out.print( "[ " + rs.getObject( colNum ) ); 
					System.out.print( " ]" );
				}
				System.out.println(); 
			} 
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
}
