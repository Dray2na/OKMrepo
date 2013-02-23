package sonok.global;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class guiMenu extends JPanel {

	ArrayList<guiMenuNode> nodes = new ArrayList<guiMenuNode>();
	
	private int elementHeight = 32;

	public boolean addNode(guiMenuNode e) {
		return nodes.add(e);
	}
	public void clearNodes() {
		nodes.clear();
	}
	public guiMenuNode getNode(int index) {
		return nodes.get(index);
	}
	public guiMenuNode removeNode(int index) {
		return nodes.remove(index);
	}
	public boolean removeNode(Object o) {
		return nodes.remove(o);
	}
	public int countNodes() {
		return nodes.size();
	}

	public void update(){
		int c = 0;
		final int width = getWidth();
		
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setBounds(0, c, width, elementHeight);
			nodes.get(i).updateChilds(elementHeight);
			c += nodes.get(i).getTotalHeight();
		}
	}
}
