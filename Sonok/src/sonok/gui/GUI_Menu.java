package sonok.gui;

import javax.swing.JPanel;

import sonok.global.guiMenu;

public class GUI_Menu extends JPanel {

	guiMenu menu;
	
	public GUI_Menu() {
		Init();
	}
	
	private void Init() {
		menu = new guiMenu();
	}

}
