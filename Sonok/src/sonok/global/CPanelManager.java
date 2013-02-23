package sonok.global;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CPanelManager extends JPanel {
	private ArrayList<CPanel> panels = new ArrayList<CPanel>();

	public CPanelManager() {
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
	}
	
	private void Move() {
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).Update(10);
		}
	}
	public void Update() {
		int c = 0;
		final int x = getX();
		final int y = getY();
		final int w = getWidth();
		final int h = w;
		
		if (panels.size()>0) {					
			for (int i = 0; i < panels.size(); i++) {
				panels.get(i).setTarget(x, c, w, h);
				c += panels.get(i).getPanel().getHeight();
			}			
		}
	}

	public boolean add(CPanel e) {
		return panels.add(e);
	}
	public void add(int index, CPanel element) {
		panels.add(index, element);
	}
	public void clear() {
		panels.clear();
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
	public void remove(int index) {
		panels.remove(index);
	}
	public boolean remove(Object o) {
		return panels.remove(o);
	}
	public int count() {
		return panels.size();
	}
}

