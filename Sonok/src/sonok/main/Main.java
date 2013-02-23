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
		
		//InitWiki();
		InitNachrichten();
		
	}
	
	private static void InitWiki() {
		guiMenuNode p = new guiMenuNode("Wiki",new CImage("./data/icon/info.png").getImage()) {			
			@Override
			public void onClick(int button) {
				toggle();				
			}
		};
		for (int i = 0; i < 4; i++) {			
			guiMenuNode p2 = new guiMenuNode("Seite",new CImage("./data/icon/info.png").getImage()) {
				@Override
				public void onClick(int button) {
					//				
				}
			};
			p.addChild(p2);
			Frame.add(p2);			
		}
		Frame.add(p);
		p.moveTo(2,32,250,32);
	}
	
	private static void InitNachrichten() {
		guiMenuNode p = new guiMenuNode("Nachrichten",new CImage("./data/icon/project.png").getImage()) {			
			@Override
			public void onClick(int button) {
				toggle();				
			}
		};
		for (int i = 0; i < 4; i++) {			
			guiMenuNode p2 = new guiMenuNode("Test",new CImage("./data/icon/note.png").getImage()) {
				@Override
				public void onClick(int button) {
					//				
				}
			};
			p.addChild(p2);
			Frame.add(p2);			
		}
		Frame.add(p);
		p.moveTo(2,32,250,32);
	}
}
