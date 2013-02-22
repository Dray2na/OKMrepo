package sonok.main;

import java.awt.event.MouseEvent;

import sonok.global.CImage;
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
		
		
		guiMenuNode p = new guiMenuNode("Test",new CImage("./data/icon/user.png").getScaledInstance(64, 64)) {
			
			@Override
			public void onMouseDown(MouseEvent e) {
				expand
				
			}
		};

		Frame.add(p);

		p.moveTo(10,32,250,32);
		

		for (int i = 0; i < 15; i++) {
			
			guiMenuNode p2 = new guiMenuNode("Test",new CImage("./data/icon/user.png").getScaledInstance(64, 64)) {
				
				@Override
				public void onMouseDown(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			};

			p.addChild(p2);
			Frame.add(p2);
			
		}
	}
}
