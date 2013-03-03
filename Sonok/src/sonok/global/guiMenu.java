package sonok.global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class guiMenu extends JPanel {

	ArrayList<guiMenuNode> nodes = new ArrayList<guiMenuNode>();
	
	private int scroll = 0;

	public guiMenu() {
		super();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < nodes.size(); i++) {
			paintNode(g, nodes.get(i));
		}
	}
	
	private void paintNode(Graphics g, guiMenuNode n) {
		g.setColor(Color.DARK_GRAY);
		
		if (n.isOpen()) {
			for (int j = 0; j < n.countOfChilds(); j++) {
				guiMenuNode c = n.getChild(j);
				Rectangle r = new Rectangle(
						n.getX() + 5,
						n.getY() + n.getElementSize(),
						c.getX(),
						c.getY() + c.getElementSize()/2
						);

				g.drawLine(r.x,r.y,r.x,r.height);
				g.drawLine(r.x,r.height,r.width,r.height);
				
				paintNode(g, c);
			}
		}
	}
	
	public guiMenuNode addChildNode(guiMenuNode parent, guiMenuNode child){
		this.add(child);
		child.setVisible(true);
		child.setBounds(parent.getBounds());
		child.owner = this;
		
		parent.addChild(child);
		
		return child;
	}
	public guiMenuNode addNode(guiMenuNode node) {
		this.add(node);
		node.setVisible(true);
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

	public int update(final int speed){		
		int c = scroll;
		final int width = getWidth();
				
		for (int i = 0; i < nodes.size(); i++) {				
			final guiMenuNode n = nodes.get(i);		
			
			n.moveTo(0, c, width, n.getElementSize(), speed);
			
			c+= n.update(speed);
			
			n.MoveDoneEvent = new Thread(){
				@Override
				public void run() {
					super.run();
					
					repaint();
				}
			};
		}
				
		//repaint();
		
		return c;
	}
	public void update(){
		update(3);
	}
	public void updateQuick(){
		update(-1);
	}
	public int getTotalHeight(){
		int h = 0;
		for (int i = 0; i < nodes.size(); i++) {
			h += nodes.get(i).getTotalHeight();
		}
		return h;
	}
}
