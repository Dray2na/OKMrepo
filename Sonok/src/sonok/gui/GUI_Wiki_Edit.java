package sonok.gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class GUI_Wiki_Edit extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUI_Wiki_Edit() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		add(textArea);

	}

}
