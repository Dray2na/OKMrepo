package sonok.global;

import java.util.ArrayList;

import javax.swing.JPanel;

public class guiMenu extends JPanel {

	ArrayList<guiMenuNode> nodes = new ArrayList<guiMenuNode>();
	
	private int elementHeight = 32;

	public guiMenuNode addChildNode(guiMenuNode parent, guiMenuNode child){
		parent.addChild(child);
		this.add(child);
		child.setVisible(true);
		child.setBounds(0,0,elementHeight,elementHeight);
		
		return child;
	}
	public guiMenuNode addNode(guiMenuNode e) {
		nodes.add(e);
		this.add(e);
		e.setVisible(true);
		e.setBounds(0,0,elementHeight,elementHeight);
		
		return e;
	}
	public void clearNodes() {
		for (int i = 0; i < nodes.size(); i++) {
			this.remove(nodes.get(i));
		}
		nodes.clear();
	}
	public guiMenuNode getNode(int index) {
		return nodes.get(index);
	}
	public guiMenuNode removeNode(int index) {
		this.remove(nodes.get(index));
		return nodes.remove(index);
	}
	public int indexOfNode(Object o) {
		return nodes.indexOf(o);
	}
	public int countNodes() {
		return nodes.size();
	}

	public void update(){
		int c = 0;
		final int width = getWidth();
		
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).moveTo(0, c, width, elementHeight);
			//nodes.get(i).updateChilds();
			c += nodes.get(i).getTotalHeight();
		}
	}
}
