package ExampleClientServer;
/**
* Inhalt:
*     EEmployeeListServer - Klasse
* Stichworte:
*	 Startet den Server, benutzt EEmployeeList
* @author TBE
*/
import java.io.*;

import java.net.*;

public class EEmployeeListServer {
    final static int port = 0xCafe; // 51966
    private Socket con = null;
    private PrintWriter os = null;
    private InputStream is = null;
    private BufferedReader bin = null;
    private EEmployeeList employeeList = null;
    int ialter; 

    public EEmployeeListServer(  ) {
        employeeList = new EEmployeeList(  );
    }

    public void closeAll(  ) {
    	int ialter=0;
        try {
            if( os != null ) {
                os.close(  );
            }

            if( is != null ) {
                is.close(  );
            }

            if( con != null ) {
                con.close(  );
            }

            if( bin != null ) {
                bin.close(  );
            }
        } catch( IOException e ) {
            System.out.println( e );
        }

        con = null;
        os = null;
        is = null;
        bin = null;
    }

    public void ServeConnection(  ) {
        try {
            os = new PrintWriter( con.getOutputStream(  ) );
            is = con.getInputStream(  );
            bin = new BufferedReader( new InputStreamReader( is ) );
            
            // ObjectOutputStream out = new ObjectOutputStream( con.getOutputStream() );
            // ObjectInputStream in = new ObjectInputStream( con.getInputStream() );

            String name = bin.readLine(  );
            
            int nr = employeeList.searchEmployeeNumber( name );

            System.out.println( "Write:" + nr + "." );

            os.println( nr );
            
            os.flush(  );
        } catch( IOException e ) {
            System.out.println( e );
        }

        closeAll(  );
    }

    public void Serve(  ) {
        try {
            ServerSocket s = new ServerSocket( port );

            if( employeeList == null ) {
                System.err.println( "Error: Employee - List." );
                System.exit( 1 );
            }

            // System.out.println( "Socket: " + s + "." );

            while( true ) {
                System.out.println( "Waiting!" );
                con = s.accept(  );
                System.out.println( "Accept: " + con + "." );
                ServeConnection(  );
            }
        } catch( Exception e ) {
            System.err.println( "Error:" + e + "." );
            System.exit( 1 );
        }
    }

    public static void main( String[] args ) {
        new EEmployeeListServer(  ).Serve(  );
    }
}
