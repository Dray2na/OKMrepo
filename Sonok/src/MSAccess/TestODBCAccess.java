
package MSAccess;

/**
* Inhalt:
* 	JDBC
* Stichworte:
* 	Klasse AccessDB testen
* @author TBE
*/

public class TestODBCAccess {
	public static void main( String[] args ) {
		AccessODBC a = new AccessODBC();
		
		//String url ="Driver= {MicrosoftAccessDriver(*.mdb)};DBQ=C:\\Java\\EclipseJavaGV\\Workspace\\EJDBC\\Kunden.mdb;;;";
		
		if( a.connect( "jdbc:odbc:" + "Kunden" ) ){
			System.out.println( "Connect to " + a.getUrl() + "." );
		}
		if( a.executeQuery( "SELECT * FROM Adressen" ) ){
			System.out.println( "Query " + a.getQuery() + " executed on " + a.getUrl() + "." );
		}
		if( a.display() ) {
			System.out.println( "Ready display result for " + a.getQuery() + "." );
		}
	}
}
