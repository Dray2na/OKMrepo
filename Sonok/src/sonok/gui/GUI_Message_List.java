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
		
		txtAutor = new JTextField();
		txtAutor.setText("Autor");
		txtAutor.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Gesendet");
		
		JButton btnNewButton_2 = new JButton("Erhalten");
		
		JTextPane textPane_inhaltNachrichten = new JTextPane();
		textPane_inhaltNachrichten.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAutor = new JLabel("Autor:");
		
		JLabel lblDatum = new JLabel("Datum:");
		
		JLabel lblAusgabe_Autor = new JLabel(" ");
		
		JLabel lblAusgabe_Datum = new JLabel(" ");
		
		JButton btnNewButton = new JButton("Anworten");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnLschen = new JButton("L\u00F6schen");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAutor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAusgabe_Autor, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblDatum)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAusgabe_Datum, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btn_NachrichtenSuche)
										.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnLschen)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton))
								.addComponent(textPane_inhaltNachrichten, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
							.addGap(40)))
					.addGap(193))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_NachrichtenSuche))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(2)
									.addComponent(btnNewButton_2)))
							.addGap(147)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDatum)
								.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAusgabe_Datum, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAusgabe_Autor))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPane_inhaltNachrichten, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLschen)
						.addComponent(btnNewButton))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		table_Nachrichten = new JTable();
		scrollPane.setViewportView(table_Nachrichten);
		table_Nachrichten.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Nachrichten.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", ""},
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
		setLayout(groupLayout);

	}
}
