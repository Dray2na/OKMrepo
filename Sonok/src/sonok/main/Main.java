package sonok.main;

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
		Frame.setBounds(200, 200, 200, 500);
		Frame.setMenu(Menu);
		Frame.addPanel(new JPanel());

		guiMenuNode n = new guiMenuNode("Benutzer","./data/icon/user.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();
			}
		};
		guiMenuNode n2 = new guiMenuNode("User1","./data/icon/offline.png") {			
			@Override
			public void onClick(int button) {
				Menu.update();				
			}
		};
		guiMenuNode n3 = new guiMenuNode("User2","./data/icon/offline.png") {			
			@Override
			public void onClick(int button) {
				Menu.update();	
			}
		};
		guiMenuNode n4 = new guiMenuNode("User3","./data/icon/user.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();					
			}
		};
		guiMenuNode n5 = new guiMenuNode("Profil",null,"./data/icon/export.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();					
			}
		};
		guiMenuNode n6 = new guiMenuNode("Nachricht","./data/icon/note.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();					
			}
		};
		guiMenuNode n7 = new guiMenuNode("Aufgaben","./data/icon/task.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();					
			}
		};
		guiMenuNode n8 = new guiMenuNode("Profil","./data/icon/user.png") {			
			@Override
			public void onClick(int button) {
				toggle();
				Menu.update();					
			}
		};
		Menu.addNode(n);
		Menu.addChildNode(n,n2);
		Menu.addChildNode(n,n3);
		Menu.addChildNode(n,n4);
		Menu.addChildNode(n4,n5);
		Menu.addChildNode(n4,n6);
		Menu.addChildNode(n4,n7);
		Menu.addChildNode(n4,n8);

		Menu.addNode(new guiMenuNode("Nachrichten","./data/icon/note.png") {			
			@Override
			public void onClick(int button) {				
			}
		});
		Menu.addNode(new guiMenuNode("Web","./data/icon/browser.png") {			
			@Override
			public void onClick(int button) {				
			}
		});
		Menu.addNode(new guiMenuNode("Aufgaben","./data/icon/task.png") {			
			@Override
			public void onClick(int button) {				
			}
		});
		
		Menu.update();
	}	
}
