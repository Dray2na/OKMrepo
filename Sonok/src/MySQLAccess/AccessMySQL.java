package MySQLAccess;
/**
* Inhalt:
* 	JDBC
* Stichworte:
* 	Datenbank manipulieren
* @author TBE
*/

import java.sql.*;

public class AccessMySQL {
	public String url = null;
	public String query = null;
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	
	public boolean connect( String url, String user, String password ) {
		boolean connected = true;
		try {
			this.url = url;
			Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
			//c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/testdb", user,password );
			connection = DriverManager.getConnection( getUrl(), user,password );
			//c.close();
		}
		catch (Exception e) {
			connected = false;
            System.err.println ("Cannot connect to database server");
        }
		/*
		catch ( ClassNotFoundException e ){
			connected = false;
			System.out.println( e.getMessage() );
		}
		catch ( SQLException e ){
			connected = false;
			System.out.println( e.getMessage() );
		}*/
		
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
			int row = 1;
			ResultSetMetaData meta = getResultSet().getMetaData();
			 
			int columnCount = meta.getColumnCount(); 	
				while ( resultSet.next() ) { 
					System.out.print( "ROW[ " + row + " ] " );
					for ( int columnNumber = 1; columnNumber <= columnCount; columnNumber++ ) {
						System.out.print( "COLUMN[ " + columnNumber + " ]" );
						System.out.print( "Columnname[ " + meta.getColumnName( columnNumber ) + " ]" );
						System.out.print( " Columntype[ " + meta.getColumnTypeName( columnNumber ) + " ]" );
						System.out.print( " Columncontent[ " + getResultSet().getObject( columnNumber ) + " ] - " );
					}
					System.out.println(); 
					row++;
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
	
	public boolean close( ) {
		boolean closed = true;
		if( getConnection() != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				closed = false;
				e.printStackTrace();
			}
		}
		return closed;
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

	public void setConnection(Connection c) {
		this.connection = c;
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