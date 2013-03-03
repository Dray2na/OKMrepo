package sonok.global;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class CPanel {
	private JPanel panel;			
	private RectangleD curbounds;
	private RectangleD tarbounds;
	private RectangleD spdbounds;
	
	private guiMenuNode menunode = null;

	public CPanel(JPanel p) {
		panel = p;	
		curbounds = new RectangleD(p.getBounds());
		tarbounds = null;
		spdbounds = new RectangleD();
	}
	public CPanel(JPanel p, guiMenuNode n) {
		panel = p;	
		curbounds = new RectangleD(p.getBounds());
		tarbounds = null;
		spdbounds = new RectangleD();
		
		menunode = n;
	}
	

	public void setTarget(int x, int y, int w, int h) {
		tarbounds = new RectangleD(x,y,w,h);
		
	}
	public void setTarget(final Rectangle Bounds) {
		tarbounds = new RectangleD(Bounds);
	}
	public JPanel getPanel() {
		return panel;
	}
	
	public boolean Update(final int acceleration) {
		boolean result = true;
		
		if (tarbounds != null) {
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
					(tarbounds.x - curbounds.x) / 10,
					(tarbounds.y - curbounds.y) / 10,
					(tarbounds.w - curbounds.w) / 10,
					(tarbounds.h - curbounds.h) / 10
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
					panel.setBounds(tarbounds.getRectangle());
					tarbounds = null;
					result = false;
				} else {
					panel.setBounds(curbounds.getRectangle());	
				}
		}

		panel.repaint();
		
		return result;
	}

	public Point getPosInMenu() {
		final Point p;
		
		if (menunode != null) {
			p = new Point(menunode.getY(), menunode.getY()+menunode.getHeight());
		} else {
			p = new Point(0, 0);
		}
		
		return p;
	}
}
