package sonok.content;

import javax.swing.JPanel;

import sonok.interfaces.SqlObject;
import javax.swing.JTextField;

public class Page_LogIn extends JPanel implements SqlObject {
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	public Page_LogIn() {
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);

	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pull() {
		// TODO Auto-generated method stub
		
	}

}
