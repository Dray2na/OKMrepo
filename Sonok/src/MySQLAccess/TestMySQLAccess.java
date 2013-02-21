package MySQLAccess;


/**
* Inhalt:
* 	JDBC
* Stichworte:
* 	Klasse AccessDB testen
* @author TBE
*/

public class TestMySQLAccess {
	public static void main( String[] args ) {
		AccessMySQL a = new AccessMySQL();
		if( a.connect( "jdbc:mysql://localhost:3306/testdb", "root", "root" ) ){
			System.out.println( "Connect to [" + a.getUrl() + " ]." );
		}
		if( a.executeQuery( "SELECT * FROM t_artikel;" ) ){
			System.out.println( "Query [ " + a.getQuery() + " ] executed." );
		}
		if( a.display() ) {
			System.out.println( "Ready display result for [ " + a.getQuery() + " ]." );
		}
		if( a.close() ) { 
			System.out.println( "Close connection to[ " + a.getUrl() + " ]." );
		}
	}
}
