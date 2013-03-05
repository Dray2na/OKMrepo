package sonok.global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CPanelManager extends JPanel {
	private ArrayList<CPanel> panels = new ArrayList<CPanel>();
	private int scroll = 0;
	private int maxScroll = 0;
	private int minScroll = 0;
	
	private TimerTask move = null;

	public CPanelManager() {
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
		
		addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Scroll(e.getWheelRotation()*50);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < panels.size(); i++) {
			CPanel p = panels.get(i);
			final Point mpos = p.getPosInMenu();
			final Color basecolor = p.getPanel().getBackground();
			final Color shadecolor = new Color(
					(int)Math.round(basecolor.getRed()*0.7),
					(int)Math.round(basecolor.getGreen()*0.7),
					(int)Math.round(basecolor.getBlue()*0.7));
			g.setColor(shadecolor);
			
			//polygon
			//0 |mpos.x
			//50 | panel.y
			//50 | panel.y + panel.height
			//0 | mpos.y
			Polygon poly = new Polygon(
					new int[] {0,
							p.getPanel().getX(),
							p.getPanel().getX(),
							0},
					new int[] {mpos.x,
								p.getPanel().getY(),
								p.getPanel().getY()+p.getPanel().getHeight(),
								mpos.y},4);

			g.fillPolygon(poly);
			
			g.setColor(basecolor);
			g.drawPolygon(poly);
		}
	}
	
	private void Move() {		
		if (move != null) {
			move.cancel();
		}
		
		move = new TimerTask() {

			@Override
			public void run() {			
				boolean moving = false;

				for (int i = 0; i < panels.size(); i++) {
					if (panels.get(i).Update(3)) moving = true;
				}
				repaint();
	
				if (!moving) {
					cancel();
					move = null;
				}
			}
		};
		
		new Timer(true).scheduleAtFixedRate(move,25,25);		
	}
	public void Update() {
		final int x = 50;
		int y = -scroll;
		final int w = 500;
		int height = 0;
		
		if (panels.size()>0) {					
			for (int i = 0; i < panels.size(); i++) {
				final int h = w;
				
				panels.get(i).setTarget(x, y, w, h);
				y += h;
				height += h;				
			}			
		}
		
		maxScroll = height - getHeight() +50;
		minScroll = -10;
		
		return;
	}

	private void addPanel(final CPanel e) {
		this.add(e.getPanel());		
		panels.add(e);
		
		Update();
		
		Move();
		
		return;
	}
	public void addPanel(final JPanel p) {
		addPanel(new CPanel(p));
	}
	public void addPanel(final JPanel p, final guiMenuNode n) {
		addPanel(new CPanel(p,n));
	}
	public void clearPanels() {
		for (int i = 0; i < panels.size(); i++) {
			remove(panels.get(i).getPanel());
		}
		panels.clear();
		scroll = 0;
		
		repaint();
	}
	
	public JPanel getPanel(int index) {
		return panels.get(index).getPanel();
	}
	public boolean hasPanel() {
		return !panels.isEmpty();
	}
	public void removePanel(JPanel o) {
		for (int i = 0; i < panels.size(); i++) {
			final JPanel p = panels.get(i).getPanel();
			
			if (p == o) {
				this.remove(p);				
				panels.remove(i);
			}
		}
		
		Update();

		Move();
	}	
	public void removePanel(guiMenuNode o) {
		for (int i = 0; i < panels.size(); i++) {
			final guiMenuNode n = panels.get(i).getNode();
			final JPanel p = panels.get(i).getPanel();
			
			if (n == o) {
				this.remove(p);
				panels.remove(i);
			}
		}		
		
		Update();

		Move();
	}
	public int PanelCount() {
		return panels.size();
	}

	public void Scroll(int Scroll) {
		scroll += Scroll;
		
		if (scroll < minScroll) {
			scroll = minScroll;
		} else if (scroll > maxScroll){
			scroll = maxScroll;
		}
		
		Update();
		
		Move();
	}
}

