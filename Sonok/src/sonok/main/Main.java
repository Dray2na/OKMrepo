package sonok.main;

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
		Frame.moveTo(200, 200, 500, 500);
		Frame.setMenu(Menu);
	}	
}
