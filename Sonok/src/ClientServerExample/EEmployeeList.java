package ClientServerExample;
/**
* Inhalt:
*     EEmployeeList - Klasse
* Stichworte:
*	 Implementiert die Liste und die Suchfunktion
* @author TBE
*/
import java.util.Hashtable;

public class EEmployeeList {
    private Hashtable Entrys = new Hashtable(  );

    public EEmployeeList(  ) {
        Entrys.put( new String( "Picard" ), new Integer( 1001 ) );
        Entrys.put( new String( "Data" ), new Integer( 1002 ) );
        Entrys.put( new String( "1" ), new Integer( 1003 ) );
    }

    public int searchEmployeeNumber( String name ) {
        Integer i = (Integer) Entrys.get( name );

        if( i == null ) {
            return -1;
        }

        return i.intValue(  );
    }
}
