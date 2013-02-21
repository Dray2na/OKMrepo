package ExampleClientServer;
/**
* Inhalt:
*     EGuiPanel - Klasse
* Stichworte:
*     Das Panel für das ESearchEmployeeApplet
* @author TBE
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EGuiPanel extends JPanel {
    private JButton jbSearch;
    private JLabel jlEmployee;
    private JLabel jlNumber;
    private JLabel jlDummy;
    private JTextField jtName;

    public EGuiPanel( ActionListener actionHandler ) {
        jlEmployee = new JLabel( "Employee" );
        jtName = new JTextField( "", 40 );
        jlNumber = new JLabel( "Number" );
        jlDummy = new JLabel( "--" );
        jbSearch = new JButton( "Search ..." );
        
        jbSearch.setEnabled(true);

        GridBagLayout l = new GridBagLayout(  );

        setLayout( l );

        GridBagConstraints c = new GridBagConstraints(  );

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;

        l.setConstraints( jlEmployee, c );
        add( jlEmployee );
        c.gridwidth = GridBagConstraints.REMAINDER;
        l.setConstraints( jtName, c );
        add( jtName );

        c.gridwidth = 1;
        l.setConstraints( jlNumber, c );
        add( jlNumber );
        c.gridwidth = GridBagConstraints.REMAINDER;
        l.setConstraints( jlDummy, c );
        add( jlDummy );

        c.gridwidth = GridBagConstraints.REMAINDER;
        l.setConstraints( jbSearch, c );
        add( jbSearch );
        jbSearch.addActionListener( actionHandler );
    }

    public String getName(  ) {
        return jtName.getText(  );
    }

    public void setNummer( String text ) {
        jlDummy.setText( text );
    }

    public void setNummer( int integer ) {
        setNummer( "" + integer );
    }
}
