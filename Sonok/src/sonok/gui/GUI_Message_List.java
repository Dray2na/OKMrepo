package sonok.gui;

import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class GUI_Message_List extends JPanel {
	private JTable table_Nachrichten;
	private JTextField txtAutor;

	/**
	 * Create the panel.
	 */
	public GUI_Message_List() {
		
		JButton btn_NachrichtenSuche = new JButton("Suchen");
		
		table_Nachrichten = new JTable();
		table_Nachrichten.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Nachrichten.setModel(new DefaultTableModel(
			new Object[][] {
				{"Titel", "Autor", "Datum"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nachricht", "Autor", "Datum"
			}
		));
		table_Nachrichten.getColumnModel().getColumn(0).setPreferredWidth(175);
		
		txtAutor = new JTextField();
		txtAutor.setText("Autor");
		txtAutor.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Gesendet");
		
		JButton btnNewButton_2 = new JButton("Erhalten");
		
		JTextPane textPane_inhaltNachrichten = new JTextPane();
		
		JLabel lblAutor = new JLabel("Autor:");
		
		JLabel lblDatum = new JLabel("Datum:");
		
		JLabel lblAusgabe_Autor = new JLabel(" ");
		
		JLabel lblAusgabe_Datum = new JLabel(" ");
		
		JButton btn_Antworten = new JButton("Anworten");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(table_Nachrichten, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_Antworten)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGap(22)
								.addComponent(textPane_inhaltNachrichten, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1)
									.addComponent(btnNewButton_2)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAutor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAusgabe_Autor, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(lblDatum)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAusgabe_Datum, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(123)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(btn_NachrichtenSuche)))))))
					.addGap(128))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(table_Nachrichten, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2)
								.addComponent(btn_NachrichtenSuche))
							.addGap(147)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutor)
								.addComponent(lblAusgabe_Autor)
								.addComponent(lblDatum)
								.addComponent(lblAusgabe_Datum))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textPane_inhaltNachrichten, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Antworten)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
