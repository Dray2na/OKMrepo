package sonok.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class GUI_Task_View extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GUI_Task_View() {
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblDatum = new JLabel("Erstellungsdatum:");
		
		JLabel lblDatum_Inhalt = new JLabel("Datum_Inhalt");
		
		JLabel lblAutor = new JLabel("Autor:");
		
		JLabel lblAutor_Inhalt = new JLabel("Autor_Inhalt");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblRollenverteilung = new JLabel("Rollenverteilung:");
		
		JButton btnAnnehmen = new JButton("Annehmen");
		
		JTextPane txtpnBeschreibung = new JTextPane();
		txtpnBeschreibung.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnBeschreibung.setText("Beschreibung");
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitel, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAutor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAutor_Inhalt)
									.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
									.addComponent(lblDatum)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDatum_Inhalt))
								.addComponent(lblRollenverteilung)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAnnehmen))
								.addComponent(txtpnBeschreibung, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBeschreibung))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatum)
						.addComponent(lblDatum_Inhalt)
						.addComponent(lblAutor)
						.addComponent(lblAutor_Inhalt))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRollenverteilung)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAnnehmen))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(lblBeschreibung)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnBeschreibung, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Rolle", "Inhaber"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}

}
