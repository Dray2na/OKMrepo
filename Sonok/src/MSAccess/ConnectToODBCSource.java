package MSAccess;
/**

* Inhalt:
* 	JDBC
* Stichworte:
* 	Kunden.mdb verteilen, ODBC - Treiber einrichten, Test - Connection
* @author TBE
*/
import java.sql.*;

public class ConnectToODBCSource {
	public static void main( String[] args ) {
		String url = "jdbc:odbc:" + "Kunden";
		Connection c = null;

		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
			c = DriverManager.getConnection( url, "", "" );
		} catch ( Exception e ) {
		}
		
		String catalogName = null;
		// DatabaseMetaData dbmd = c.getMetaData();
		try {
			catalogName = c.getCatalog();			
		} catch ( Exception e ) {
		}
		System.out.println( catalogName );
	}
}
