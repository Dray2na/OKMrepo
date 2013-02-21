package MSAccess;
/**

* Inhalt:
* 	JDBC
* Stichworte:
* 	Datenbank manipulieren
* @author TBE
*/

import java.sql.*;

public class AccessODBC {
	public String url = null;
	public String query = null;
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	
	public boolean connect( String url ) {
		boolean connected = true;
		try {
			this.url = url;
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
			connection = DriverManager.getConnection( this.url, null, null );
			// c.close();
		}
		catch ( ClassNotFoundException e ){
			connected = false;
			System.out.println( e.getMessage() );
		}
		catch ( SQLException e ){
			connected = false;
			System.out.println( e.getMessage() );
		}
		return connected;
	}	
	
	public boolean executeQuery( String query ) {
		boolean executed = true;
		try {
			this.query = query;
			this.setStatement( connection.createStatement() );
			setResultSet( getStatement().executeQuery( this.query ) );
		}
		catch ( SQLException e ){
			executed = false;
			System.out.println( e.getMessage() );
		}
		return executed;
	}
	
	public boolean display() {
		boolean displayed = true;
		try {
			ResultSetMetaData metadata = getResultSet().getMetaData();
			 
			int colCount = metadata.getColumnCount(); 	
				while ( resultSet.next() ) { 
					for ( int colNum = 1; colNum <= colCount; colNum++ ) {
						System.out.print( "CName:" + metadata.getColumnName( colNum ) );
						System.out.print( " CType: " + metadata.getColumnTypeName( colNum ) );
						System.out.print( " [ " + getResultSet().getObject( colNum ) );
						System.out.print( " ] " );
					}
					System.out.println(); 
			}
		} catch ( SQLException e ){
			displayed = false;
			System.out.println( e.getMessage() );
		}
		return displayed;
	}
	
	public boolean insert( String query ) {
		boolean inserted = true;
		// Hier fehlt die Implementierung
		return inserted;
	}
	
	public boolean update( String query ) {
		boolean updated = true;
		// Hier fehlt die Implementierung
		return updated;
	}

	public boolean delete( String query ) {
			boolean deleted = true;
			// Hier fehlt die Implementierung
			return deleted;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public String getUrl() {
		return url;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}