package sonok.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sonok.global.CPanel;
import sonok.global.CPanelManager;
import sonok.global.RectangleD;
import sonok.global.guiMenuNode;
import sonok.gui.GUI_Menu;

public class MainFrame extends JFrame {
	private GUI_Menu menu;
	private CPanelManager panelmanager =  new CPanelManager();
		
	public MainFrame() {
		Init();
	}
	
	private void Init() {
		setVisible(true);
		setLayout(null);
		
		this.add(panelmanager);
				
		addWindowListener(new WindowListener() {			
			@Override
			public void windowOpened(WindowEvent arg0) {
			}			
			@Override
			public void windowIconified(WindowEvent arg0) {
			}			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				System.exit(0);
				
			}
			@Override
			public void windowClosed(WindowEvent arg0) {
			}			
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
		addComponentListener(new ComponentListener() {			
			@Override
			public void componentShown(ComponentEvent arg0) {
			}			
			@Override
			public void componentResized(ComponentEvent arg0) {
				updateWindow();				
			}			
			@Override
			public void componentMoved(ComponentEvent arg0) {
			}			
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		return;
	}

	public void setMenu(GUI_Menu m) {
		if (menu != null) {
			this.remove(menu);
		}
		if (m != null) {
			this.add(m);			
		}
		this.menu = m;		
				
		fitWindow();
	}
	public GUI_Menu getMenu() {
		return menu;
	}
	public JPanel addPanel(final JPanel p, final guiMenuNode n) {
		boolean firstadd = !panelmanager.hasPanel();
		
		//TODO Doppeltes Hinzufügen vermeiden!
		
		panelmanager.addPanel(p,n);
				
		if (firstadd)
			fitWindow();
				
		return p;
	}	
	public JPanel addPanel(JPanel p) {
		return addPanel(p, null);
	}
	public void removePanel(JPanel p) {
		if (panelmanager.hasPanel()) {
			panelmanager.removePanel(p);
			if (!panelmanager.hasPanel()) {
				fitWindow();
			}
		}		
	}	
	public void removePanel(guiMenuNode n) {
		if (panelmanager.hasPanel()) {
			panelmanager.removePanel(n);
			if (!panelmanager.hasPanel()) {
				fitWindow();
			}
		}	
	}
	public void clearPanels() {
		for (int i = 0; i < panelmanager.PanelCount(); i++) {
			this.remove(panelmanager.getPanel(i));
		}
		panelmanager.clearPanels();
		fitWindow();		
	}
			
	private void updateWindow(){		
		final boolean hasMenu = (menu != null);
		final boolean hasPanel = (panelmanager.PanelCount() > 0);		
		final int width = getWidth();
		final int height = getHeight();
		
		final int widthMenu;
		final int widthPanel;
		final int xMenu;
		final int xPanel;
		
		if (hasMenu && hasPanel){
			widthMenu = 250;
			widthPanel = width-widthMenu;
			xMenu = 0;
			xPanel = widthMenu;	
		} else if (hasMenu) {
			widthMenu = width;
			widthPanel = 0;
			xMenu = 0;
			xPanel = width;
		} else if (hasPanel){
			widthMenu = 0;
			widthPanel = width;
			xMenu = width;
			xPanel = 0;
		} else {
			widthMenu = 0;
			widthPanel = 0;
			xMenu = 0;
			xPanel = width;
		}
		
		if (menu != null) {				
			if (widthMenu > 0) {
				menu.setVisible(true);	
				menu.setBounds(xMenu,0,widthMenu,height);
				menu.updateQuick();
				menu.repaint();
			} else {
				menu.setVisible(false);		
			}
		}	
		
		if (widthPanel > 0) {
			panelmanager.setVisible(true);
			panelmanager.setBounds(xPanel,0,widthPanel,height);
			panelmanager.repaint();
		} else {	
			panelmanager.setVisible(false);
		}
		
		return;
	}

	private void fitWindow() {
		final Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
		final boolean hasMenu = (menu != null);
		final boolean hasPanel = (panelmanager.hasPanel());
		final int x,y,w,h;
		x = 10;
		
		if (hasMenu && hasPanel) {
			w = 800;
			h = 600;
			y = Screen.height / 2 - h/2;
		} else if (hasPanel) {
			w = 550;
			h = 600;
			y = Screen.height / 2 - h/2;
		} else if (hasMenu) {
			w = 250;
			h = 600;
			y = Screen.height / 2 - h/2;
		} else {
			w = 100;
			h = 100;
			y = Screen.height / 2 - h/2;
		}		
		
		setBounds(x, y, w, h);
		updateWindow();
//		moveTo(x,y,w,h,3);
	}
	public void Refresh() {
		updateWindow();
	}
//Override
	@Override
	public void setBackground(Color c) {
		super.setBackground(c);
		if (panelmanager != null) {
			panelmanager.setBackground(c);	
		}
		if (menu != null) {
			menu.setBackground(c);
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
				if ((acceleration < 0) ||
						((Math.abs(curbounds.x-tarbounds.x)<=1 &&
						 Math.abs(curbounds.y-tarbounds.y)<=1 &&
						 Math.abs(curbounds.w-tarbounds.w)<=1 &&
						 Math.abs(curbounds.h-tarbounds.h)<=1 ) && 
						 (Math.abs(spdbounds.x)<=1 &&
						 Math.abs(spdbounds.y)<=1 &&
						 Math.abs(spdbounds.w)<=1 &&
						 Math.abs(spdbounds.h)<=1 ))
						)
				{	
					setBounds(tarbounds.getRectangle());
					updateWindow();
					cancel();
					
					return;
				} else {
					setBounds(curbounds.getRectangle());
				}
			}
		}, ((acceleration < 0) ? 250 : 10), 10);
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
