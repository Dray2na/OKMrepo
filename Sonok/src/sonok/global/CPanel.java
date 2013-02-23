package sonok.global;

import java.awt.Rectangle;

import javax.swing.JPanel;

public class CPanel {
	private JPanel panel;			
	private RectangleD curbounds;
	private RectangleD tarbounds;
	private RectangleD spdbounds;
	
	public CPanel(JPanel p) {
		panel = p;	
		curbounds = new RectangleD(p.getBounds());
		tarbounds = null;
		spdbounds = new RectangleD();
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
	
	public void Update(final int acceleration) {
		
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
					panel.setBounds(tarbounds.getRectangle());
					tarbounds = null;
				} else {
					panel.setBounds(curbounds.getRectangle());	
				}
		}
	}
}
