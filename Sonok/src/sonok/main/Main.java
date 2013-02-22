package sonok.main;

import java.awt.event.MouseEvent;

import sonok.global.*;

public class Main {

	public static ContentManager Manager;
	public static MainFrame Frame;
	
	public static void main(String[] args) {
		Init();
	}
	
	private static void Init() {
		Manager = new ContentManager();
		Frame = new MainFrame();
	}
}
