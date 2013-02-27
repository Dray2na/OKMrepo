package sonok.main;

import java.awt.Color;

import javax.swing.JPanel;

import sonok.global.guiMenuNode;
import sonok.gui.GUI_LogIn;
import sonok.gui.GUI_Menu;
	
public class Main {
	public static ContentManager Manager = new ContentManager();
	public static MainFrame Frame = new MainFrame();
	public static GUI_Menu Menu = new GUI_Menu();
	public static GUI_LogIn LogIn = new GUI_LogIn();
	
	public static void main(String[] args) {
		Init();
	}
	
	private static void Init() {
		//Frame.setBounds(200, 200, 200, 500);
		Frame.setMenu(Menu);

		Menu.AddEntry("Menu",null).setElementSize(48);
		Menu.AddEntry("Mister Mustermann","db",null).setElementSize(24);
		
		guiMenuNode freunde = Menu.addNode(new guiMenuNode("Freunde","./data/icon/user.png") {			
			@Override
			public void onClick(int button) {
				if (isOpen()) {
					setElementSize(32);
				} else {
					setElementSize(24);
				}
				toggle();
			}
		});
		guiMenuNode user1 = Menu.addChildNode(freunde,new guiMenuNode("User 1","./data/icon/offline.png") {			
			@Override
			public void onClick(int button) {
			}
		});
		guiMenuNode user2 = Menu.addChildNode(freunde,new guiMenuNode("User 2","./data/icon/offline.png") {			
			@Override
			public void onClick(int button) {
			}
		});
		guiMenuNode user3 = Menu.addChildNode(freunde,new guiMenuNode("User 3","./data/icon/user.png") {			
			@Override
			public void onClick(int button) {
				if (isOpen()) {
					setElementSize(32);
				} else {
					setElementSize(24);
				}
				toggle();
			}
		});
		guiMenuNode user4 = Menu.addChildNode(freunde,new guiMenuNode("User 4","./data/icon/offline.png") {			
			@Override
			public void onClick(int button) {
			}
		});
		
		guiMenuNode profil = Menu.addChildNode(user3, new guiMenuNode("Profil","./data/icon/user.png") {
			@Override
			public void onClick(int button) {				
			}
		});
		
		guiMenuNode nachricht = Menu.addChildNode(user3, new guiMenuNode("Nachricht","./data/icon/note.png") {
			@Override
			public void onClick(int button) {				
			}
		});
		
		guiMenuNode add = Menu.addChildNode(user3, new guiMenuNode("Hinzufügen","./data/icon/add.png") {
			@Override
			public void onClick(int button) {				
			}
		});


		Menu.AddEntry("Panel+","add", new Thread(){
			@Override
			public void run() {
				Frame.addPanel(new GUI_LogIn());
			}
		});
		Menu.AddEntry("Panel-","delete", new Thread(){
			@Override
			public void run() {
				Frame.addPanel(new GUI_LogIn());
			}
		});		
		Menu.AddEntry("Schließen","close", new Thread(){
			@Override
			public void run() {
				System.exit(0);
			}
		});
	}	
}
