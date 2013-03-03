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

	public CPanelManager() {
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
		
		addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Scroll(e.getWheelRotation()*25);
			}
		});
		//TODO Stop
		new Timer(true).scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Move();
			}
		},1000,25);
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
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).Update(3);
		}
		repaint();
	}
	public void Update() {
		final int x = 50;
		int y = -scroll;
		final int w = 500;
		final int h = w;
		
		if (panels.size()>0) {					
			for (int i = 0; i < panels.size(); i++) {
				panels.get(i).setTarget(x, y, w, h);
				y += h;
			}			
		}
		
		maxScroll = 0;
		minScroll = -y;
	}

	public void add(final CPanel e) {
		this.add(e.getPanel());
		Update();
		panels.add(e);
	}
	public void clear() {
		for (int i = 0; i < panels.size(); i++) {
			remove(panels.get(i).getPanel());
		}
		panels.clear();
		repaint();
	}
	
	public JPanel get(int index) {
		return panels.get(index).getPanel();
	}
	public int indexOf(Object o) {
		return panels.indexOf(o);
	}
	public boolean isEmpty() {
		return panels.isEmpty();
	}
	public void removePanel(int index) {
		panels.remove(index);
	}
	public boolean removePanel(Object o) {
		return panels.remove(o);
	}
	public int count() {
		return panels.size();
	}

	public void Scroll(int scroll) {
		this.scroll += scroll;
		
		if (scroll < minScroll) {
			scroll = minScroll;
		} else if (scroll > maxScroll){
			scroll = maxScroll;
		}
		
		Update();
	}
}

