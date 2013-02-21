package ExampleClientServer;
/**
* Inhalt:
*     EEmployeeListApplet - Klasse
* Stichworte:
*     Nutzt EGuiPanel als GUI und verbindet mit dem Host,
*     liest den Employee - Namen aus der GUI und schreibt die
*     Antwort in die GUI
* @author TBE
*/
import java.awt.*;
import java.awt.event.*;

import java.io.*;

import java.net.*;

import javax.swing.*;

public class ESearchEmployeeApplet extends JApplet implements ActionListener {
    private final static int port = 0xCafe;
    private Socket socketToHost = null;
    private PrintWriter os = null;
    private BufferedReader in = null;
    private EGuiPanel myPanel;

    public void init(  ) {
        getContentPane(  ).add( ( myPanel = new EGuiPanel( this ) ), BorderLayout.CENTER );
    }

    public void closeAll(  ) {
        try {
            if( os != null ) {
                os.close(  );
            }

            if( in != null ) {
                in.close(  );
            }

            if( socketToHost != null ) {
                socketToHost.close(  );
            }
        } catch( IOException e ) {
            System.out.println( e );
        }

        socketToHost = null;
        os = null;
        in = null;
    }

    boolean connectToHost(  ) {
        if( socketToHost != null ) {
            return true;
        }

        try {
        	String host = InetAddress.getByName( "10.4.23.36" ).getHostName(  );
//            String host = InetAddress.getByName( "127.0.0.1" ).getHostName(  );
            // String host = getDocumentBase().getHost (); für localhost
        	// String host = InetAddress.getByName( "localhost" ).getHostName();
        	// String host = InetAddress.getByName( "http://www.amazon.de" ).getHostName();
        	// String host = InetAddress.getByName( null ).getHostName();
            
            socketToHost = new Socket( host, port );
            
            os = new PrintWriter( socketToHost.getOutputStream(  ) );
            in = new BufferedReader( new InputStreamReader( socketToHost.getInputStream(  ) ) );

            return true;
        } catch( UnknownHostException e ) {
            System.err.println( e );
        } catch( IOException e ) {
            System.err.println( e );
        }

        closeAll(  );

        return false;
    }

    public void actionPerformed( ActionEvent event ) {
        if( !connectToHost(  ) ) {
            return;
        }

        try {
            String t = myPanel.getName(  );

            System.out.println( "Get:" + t + "." );
            os.println( t );
            os.flush(  );
            myPanel.setNummer( in.readLine(  ) );
            socketToHost.close();
            
        } catch( IOException e ) {
            System.err.println( e );
        }

        closeAll(  );
    }
}
