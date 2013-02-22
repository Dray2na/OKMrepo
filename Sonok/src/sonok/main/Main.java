package sonok.main;

import sonok.content.ContentManager;

public class Main {

	static ContentManager Manager;
	static MainFrame Frame;
	
	public static void main(String[] args) {
		Init();
	}
	
	private static void Init() {
		Manager = new ContentManager();
		Frame = new MainFrame();

	}
}
