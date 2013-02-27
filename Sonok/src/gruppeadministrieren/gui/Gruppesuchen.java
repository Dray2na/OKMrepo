package gruppeadministrieren.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

public class Gruppesuchen extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Gruppesuchen() {
		
		JButton btnNewButton = new JButton("suchen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNameDerGruppe = new JLabel("Name der Gruppe");
		
		JList list = new JList();
		
		JButton btnAusgewhlteGruppeEditieren = new JButton("Ausgew\u00E4hlte Gruppe editieren");
		
		JButton btnNeueGruppeAnlegen = new JButton("Neue Gruppe anlegen");
		
		JLabel lblErstellungsdatum = new JLabel("Erstellungsdatum");
		
		JFormattedTextField frmtdtxtfldTtmmjj = new JFormattedTextField();
		frmtdtxtfldTtmmjj.setText("TT/MM/JJ");
		
		JLabel lblSuchergebnisse = new JLabel("Suchergebnisse");
		
		JLabel lblAufgabe = new JLabel("Aufgabe");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNameDerGruppe)
								.addComponent(lblAufgabe)
								.addComponent(lblErstellungsdatum)
								.addComponent(lblSuchergebnisse))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(frmtdtxtfldTtmmjj)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(30))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAusgewhlteGruppeEditieren)
									.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
									.addComponent(btnNeueGruppeAnlegen, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))))
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameDerGruppe)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAufgabe)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(frmtdtxtfldTtmmjj, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErstellungsdatum)
						.addComponent(btnNewButton))
					.addGap(33)
					.addComponent(lblSuchergebnisse)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAusgewhlteGruppeEditieren)
						.addComponent(btnNeueGruppeAnlegen))
					.addGap(55))
		);
		setLayout(groupLayout);

	}
}
