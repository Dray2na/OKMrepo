package sonok.global;

import java.util.ArrayList;

import javax.swing.JPanel;

public class guiMenu extends JPanel {

	ArrayList<guiMenuNode> nodes = new ArrayList<guiMenuNode>();
	
	private int elementHeight = 32;

	public guiMenu() {
		super();
	}
	
	public guiMenuNode addChildNode(guiMenuNode parent, guiMenuNode child){
		this.add(child);
		child.setVisible(true);
		child.setBounds(parent.getX(),parent.getY(),elementHeight,elementHeight);
		child.owner = this;
		child.setElementSize(parent.getElementSize());
		
		parent.addChild(child);
		
		return child;
	}
	public guiMenuNode addNode(guiMenuNode node) {
		this.add(node);
		node.setVisible(true);
		node.setBounds(0,0,elementHeight,elementHeight);
		node.owner = this;

		nodes.add(node);
				
		return node;
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

	public void update(final int speed){		
		int c = 0;
		final int width = getWidth();
				
		for (int i = 0; i < nodes.size(); i++) {				
			final guiMenuNode n = nodes.get(i);		
			
			n.moveTo(0, c, width, n.getElementSize(), speed);
			
			c+= n.update(speed);
		}
		
		return;
	}
	public void update(){
		update(3);
	}
	public void updateQuick(){
		update(-1);
	}
}
