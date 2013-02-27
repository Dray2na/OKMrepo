package gruppeadministrieren.gui;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;

public class Gruppeeditieren extends JPanel {

	/**
	 * Create the panel.
	 */
	public Gruppeeditieren() {
		
		JLabel lblNewLabel = new JLabel("Gruppenname");
		
		JLabel lblnderungenGeltenFr = new JLabel("Gruppenmitglieder");
		
		JLabel lblSichtbarkeit = new JLabel("Aufgabe/n ist/sind f\u00FCr diese Gruppe");
		
		JRadioButton rdbtnSichtbar = new JRadioButton("sichtbar");
		
		JRadioButton rdbtnUnsichtbar = new JRadioButton("unsichtbar");
		
		JRadioButton rdbtnEditierbar = new JRadioButton("editierbar");
		
		JRadioButton rdbtnNichtEditierbar = new JRadioButton("nicht editierbar");
		
		JLabel lblGruppeDarfSich = new JLabel("Gruppe darf sich den Rollen zuordnen");
		
		JRadioButton rdbtnJa = new JRadioButton("ja");
		
		JRadioButton rdbtnNein = new JRadioButton("nein");
		
		JFormattedTextField frmtdtxtfldGruppenname = new JFormattedTextField();
		frmtdtxtfldGruppenname.setText("Gruppenname");
		
		JButton btnSuchen = new JButton("hinzuf\u00FCgen");
		
		JTextPane textPane = new JTextPane();
		
		JButton btnSpeichern = new JButton("speichern");
		
		JLabel lblDienderungenGelten = new JLabel("Die \u00C4nderungen gelten f\u00FCr");
		
		JRadioButton rdbtnAlleDieseGruppe = new JRadioButton("alle diese Gruppe betreffenden Aufgaben");
		
		JRadioButton rdbtnNurDieseAufgabe = new JRadioButton("nur diese Aufgabe");
		
		JList list = new JList();
		list.setToolTipText("");
		
		JLabel lblAufgabe = new JLabel("Aufgabe");
		
		JLabel lblAufgabenberschrift = new JLabel("Aufgaben\u00FCberschrift");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSichtbarkeit)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblGruppeDarfSich)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(rdbtnJa)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnNein)
											.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblDienderungenGelten)
												.addContainerGap())
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(rdbtnAlleDieseGruppe)
													.addContainerGap())
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
															.addComponent(lblAufgabe))
														.addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(lblAufgabenberschrift)
															.addComponent(frmtdtxtfldGruppenname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(277))
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(rdbtnNurDieseAufgabe)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnSpeichern))
															.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblnderungenGeltenFr)
																.addGap(18)
																.addComponent(list, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnSuchen))
															.addComponent(textPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
														.addContainerGap(32, Short.MAX_VALUE))))))))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnUnsichtbar)
									.addComponent(rdbtnSichtbar))
								.addGap(73)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnEditierbar)
									.addComponent(rdbtnNichtEditierbar))
								.addGap(211)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(frmtdtxtfldGruppenname, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAufgabe)
						.addComponent(lblAufgabenberschrift))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
								.addComponent(btnSuchen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblnderungenGeltenFr)
							.addGap(18)))
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSichtbarkeit)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnEditierbar)
								.addComponent(rdbtnSichtbar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnUnsichtbar)
								.addComponent(rdbtnNichtEditierbar))
							.addGap(18)
							.addComponent(lblGruppeDarfSich)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnJa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNein)
							.addGap(18)
							.addComponent(lblDienderungenGelten)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnAlleDieseGruppe)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNurDieseAufgabe))
						.addComponent(btnSpeichern))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
