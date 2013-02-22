package sonok.main;

import java.awt.event.MouseEvent;

import sonok.global.guiMenuNode;

public class Main {

	public static ContentManager Manager;
	public static MainFrame Frame;
	
	public static void main(String[] args) {
		Init();
	}
	
	private static void Init() {
		Manager = new ContentManager();
		Frame = new MainFrame();


		guiMenuNode p = new guiMenuNode() {
			
			@Override
			public void onMouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Frame.add(p);
	}
}
