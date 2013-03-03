package sonok.gui;

import java.awt.Color;
import java.awt.Image;

import sonok.global.CImage;
import sonok.global.guiMenu;
import sonok.global.guiMenuNode;
import java.lang.Thread;

public class GUI_Menu extends guiMenu {
		
	public GUI_Menu() {
		Init();
	}
	
	private void Init() {
		setVisible(true);

		setBackground(Color.WHITE);		
	}

	public GUI_Menu_Entry addEntry(GUI_Menu_Entry entry){
		return (GUI_Menu_Entry) addNode(entry);
	}
	public GUI_Menu_Entry addEntryChild(guiMenuNode parent, GUI_Menu_Entry entry){
		return (GUI_Menu_Entry) addChildNode(parent,entry);
	}
	
	public void ClearEntries(){
		clearNodes();
	}

}