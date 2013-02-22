package sonok.global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class guiMenuNode extends guiComponent {

	Image icon;
	Image image;
	String caption;

	ArrayList<guiMenuNode> childs = new ArrayList<guiMenuNode>();
		
	private boolean isOpen;
	private int state = 0;
	
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
		
		if (isOpen) {
			if (childs.size() > 0) {
				for (int i = 0; i < childs.size(); i++) {
					childs.get(i).moveTo(getX()+10, getY() + (getHeight()*(i+1)), getWidth()-10, getHeight());
				}				
			}
		} else {
			if (childs.size() > 0) {
				for (int i = 0; i < childs.size(); i++) {
					childs.get(i).moveTo(getX(),getY(),32,0);
				}				
			}
		}
	}	
	public void expand() {
		setOpen(true);
	}	
	public void collapse() {
		setOpen(false);
	}	
	public void toggle() {
		setOpen(!isOpen);
	}

	public guiMenuNode(String cap, Image ico, Image img) {
		super();

		image = img;
		icon = ico;
		caption = cap;

	}
	public guiMenuNode(String cap, Image ico) {
		super();

		image = null;
		icon = ico;
		caption = cap;
	}
	public guiMenuNode(String cap){
		super();

		icon = null;
		image = null;
		caption = cap;
	}
	public guiMenuNode() {
		super();

		icon = null;
		image = null;
		caption = "";
	}

	public boolean addChild(guiMenuNode e) {
		return childs.add(e);
	}

	public void clearChilds() {
		childs.clear();
	}

	public guiMenuNode getChild(int index) {
		return childs.get(index);
	}

	public int indexOfChild(Object o) {
		return childs.indexOf(o);
	}

	public void removeChild(int index) {
		childs.remove(index);
	}

	public void removeChild(Object o) {
		childs.remove(o);
	}

	public int countOfChilds() {
		return childs.size();
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
	 //init	
		int w = getWidth()-1;
		int h = getHeight()-1;
		
		int textpos = (icon != null) ? h+10 : 10;
		
		Color back = getBackground();
		Color front = getForeground();
		
	 //draw

		if (image != null) {
			g.drawImage(image, 0, 0, w, h, null);			
		}

		if (icon != null) {
			g.drawImage(icon, 0, 0, h, h, null);
		}
		
		g.setColor(front);
		
		g.drawString(caption, textpos, h / 2);
		
		g.draw3DRect(0, 0, w, h, false);
	}
	
	@Override
	public abstract void onMouseDown(MouseEvent e);
	
	@Override
 	void onMouseUp(MouseEvent e) {

	}

	@Override
	void onMouseMove(MouseEvent e) {

	}

	@Override
	void onMouseDrag(MouseEvent e) {

	}

	@Override
	void onMouseWheel(MouseEvent e) {

	}

	@Override
	void onKey(KeyEvent e) {

	}

	@Override
	void onKeyUp(KeyEvent e) {

	}

	@Override
	void onKeyDown(KeyEvent e) {

	}

	@Override
	void onResize(ComponentEvent e) {

	}

	@Override
	void onMove(ComponentEvent e) {

	}

	@Override
	void onShow(ComponentEvent e) {

	}

	@Override
	void onHide(ComponentEvent e) {

	}

	@Override
	void doMove() {

	}

	@Override
	void doDraw() {

	}

}
