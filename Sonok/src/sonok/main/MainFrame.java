package sonok.main;

import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sonok.global.CPanel;
import sonok.global.CPanelManager;
import sonok.global.RectangleD;
import sonok.global.guiMenu;

public class MainFrame extends JFrame {
	private JPanel menu;
	private CPanelManager panelmanager =  new CPanelManager();
	
	final int windowheight = 600;
	final int windowwidth = 800;
	
	public MainFrame() {
		Init();
	}
	
	private void Init() {
		setBounds(0,0,0,800);
		setVisible(true);
		setLayout(null);
		
		this.add(panelmanager);
				
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				onResize();
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return;
	}

	public void setMenu(JPanel m) {
		if (menu != null) {
			this.remove(menu);
		}
		if (m != null) {
			this.add(m);			
		}
		this.menu = m;
	}
	public void addPanel(JPanel p) {
		this.add(p);
		panelmanager.add(new CPanel(p));
	}
	public void clearPanels() {
		for (int i = 0; i < panelmanager.count(); i++) {
			this.remove(panelmanager.get(i));
		}
		panelmanager.clear();		
	}
		
	private void onResize() {	
		final boolean hasMenu = (menu != null);
		final boolean hasPanel = (panelmanager.count() > 0);
		final int widthMenu;
		final int widthPanel;
		final int xMenu;
		final int xPanel;
		
		if (hasMenu && hasPanel){
			widthMenu = (int) Math.round(getWidth() * 0.3);
			widthPanel = (int) Math.round(getWidth() * 0.7);
			xMenu = 0;
			xPanel = getWidth();
			
			menu.setBounds(0,0,getWidth(),getHeight());			
		} else if (hasMenu) {
			widthMenu = getWidth();
			widthPanel = 0;
			xMenu = 0;
			xPanel = getWidth();
		} else if (hasPanel){
			widthMenu = 0;
			widthPanel = getWidth();
			xMenu = getWidth();
			xPanel = 0;
		} else {
			widthMenu = 0;
			widthPanel = 0;
			xMenu = 0;
			xPanel = getWidth();
		}
		
		if (menu != null) {				
			if (widthMenu > 0) {
				menu.setVisible(true);	
				menu.setBounds(xMenu,0,getWidth(),getHeight());			
			} else {
				menu.setVisible(false);		
			}
		}	
		
		if (widthPanel > 0) {
			panelmanager.setVisible(true);
			panelmanager.setBounds(xPanel,0,getWidth(),getHeight());			
		} else {	
			panelmanager.setVisible(false);
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
