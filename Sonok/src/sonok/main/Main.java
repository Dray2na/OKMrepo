package sonok.main;

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
