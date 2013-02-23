package sonok.main;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sonok.global.CPanel;
import sonok.global.RectangleD;
import sonok.global.guiMenu;

public class MainFrame extends JFrame {
	private JPanel menu;
	private ArrayList<CPanel> panels = new ArrayList<CPanel>();
	final int windowheight = 600;
	final int windowwidth = 800;
	
	public MainFrame() {
		Init();
	}
	
	private void Init() {
		setBounds(0,0,0,800);
		setVisible(true);
		setLayout(null);
				
		return;
	}
	
	public JPanel getMenu() {
		return menu;
	}
	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public boolean add(JPanel p) {
		this.add(p);
		return panels.add(new CPanel(p));
	}
	public void clear() {
		for (int i = 0; i < panels.size(); i++) {
			this.remove(panels.get(i).getPanel());
		}
		panels.clear();		
	}
	public JPanel get(int index) {
		return panels.get(index).getPanel();
	}

	public void Update() {
		int c = 0;
		final int x = getX();
		final int y = getY();
		final int w;
		final int h = windowheight;
		
		if (panels.size()>0) {					
			for (int i = 0; i < panels.size(); i++) {
				panels.get(i).setTarget(0, c, 300, 300);
				c += panels.get(i).getPanel().getHeight();
			}
			
			w = menu.getWidth();
		} else {
			w = windowwidth;
			
		}
	}
	private void Move() {
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).Update(10);
		}
	}
	
//==========================================================================================
//Bounce Fenster, Bounce!
//==========================================================================================

	public void moveTo(final Rectangle Bounds, final int acceleration) {		
		new Timer(true).scheduleAtFixedRate(new TimerTask() {
			RectangleD curbounds = new RectangleD(getBounds());
			RectangleD tarbounds = new RectangleD(Bounds);
			RectangleD spdbounds = new RectangleD();
			
			@Override
			public void run() {
			  //Geschwindigkeitsvektoren
				RectangleD accbounds = new RectangleD(
					(tarbounds.x - curbounds.x) * acceleration / 1000,
					(tarbounds.y - curbounds.y) * acceleration / 1000,
					(tarbounds.w - curbounds.w) * acceleration / 1000,
					(tarbounds.h - curbounds.h) * acceleration / 1000
				);
				spdbounds.add(accbounds);
				
			  //Bewegungsvektoren
				RectangleD movbounds = new RectangleD(
					(tarbounds.x - curbounds.x) / 20,
					(tarbounds.y - curbounds.y) / 20,
					(tarbounds.w - curbounds.w) / 20,
					(tarbounds.h - curbounds.h) / 20
				);
				movbounds.add(spdbounds);
								
			  //Neue pos setzen
				curbounds.add(movbounds);
				
			  //Wenn abstand <= 1 dann ende				
				if (Math.abs(curbounds.x-tarbounds.x)<=1 &&
					Math.abs(curbounds.y-tarbounds.y)<=1 &&
					Math.abs(curbounds.w-tarbounds.w)<=1 &&
					Math.abs(curbounds.h-tarbounds.h)<=1 )
				{	
					setBounds(tarbounds.getRectangle());
					cancel();
				} else {
					setBounds(curbounds.getRectangle());	
				}
			}
		}, 0, 10);
	}
	public void moveTo(int x, int y, int w, int h, int acceleration) {
		moveTo(new Rectangle(x,y,w,h),acceleration);
	}
	public void moveTo(int x, int y, int w, int h) {
		moveTo(new Rectangle(x,y,w,h));
		
	}
	public void moveTo(final Rectangle Bounds) {
		moveTo(Bounds,5);
	}
}
