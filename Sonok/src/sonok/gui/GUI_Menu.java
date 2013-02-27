package sonok.gui;

import java.awt.Color;

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
	
	// TODO Make.... stadt add
	
	public guiMenuNode AddImage(String Caption, String ImageName, final Thread OnClickEvent) {
		guiMenuNode node = new guiMenuNode(Caption,null,"./data/icon/" + ImageName + ".png") {
			@Override
			public void onClick(int button) {
				if (OnClickEvent != null) {
					OnClickEvent.run();
				}
				toggle();
			}
		};
		
		addNode(node);
		
		return node;		
	}	
	public guiMenuNode AddEntry(String Caption, String IconName, String ImageName, final Thread OnClickEvent) {
		guiMenuNode node = new guiMenuNode(Caption,"./data/icon/" + IconName + ".png","./data/icon/" + ImageName + ".png") {
			@Override
			public void onClick(int button) {
				if (OnClickEvent != null) {
					OnClickEvent.run();
				}
				toggle();
			}
		};
		
		addNode(node);
		
		return node;		
	}
	public guiMenuNode AddEntry(String Caption, String IconName, final Thread OnClickEvent) {
		guiMenuNode node = new guiMenuNode(Caption,"./data/icon/" + IconName + ".png") {
			@Override
			public void onClick(int button) {
				if (OnClickEvent != null) {
					OnClickEvent.run();
				}
				toggle();
			}
		};
		
		addNode(node);
		
		return node;		
	}
	public guiMenuNode AddEntry(String Caption, final Thread OnClickEvent) {
		guiMenuNode node = new guiMenuNode(Caption) {
			@Override
			public void onClick(int button) {
				if (OnClickEvent != null) {
					OnClickEvent.run();
				}
				toggle();
			}
		};
		
		addNode(node);
		
		return node;		
	}
}
