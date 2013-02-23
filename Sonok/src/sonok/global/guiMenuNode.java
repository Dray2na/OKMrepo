package sonok.global;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class guiMenuNode extends guiComponent {

	guiMenu owner;
	
	Image icon;
	Image image;
	String caption;

	ArrayList<guiMenuNode> childs = new ArrayList<guiMenuNode>();
		
	private boolean isOpen;
	private int state = 0;
	private int totalHeight;
	
	//Konstruktor
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
	//Event
	public abstract void onClick(int button);	
	//Grafik
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	 //init	
		int w = getWidth()-1;
		int h = getHeight()-1;
		
		int textpos = (icon != null) ? h+10 : 10;
		
		Color back = getBackground();
		Color front;
		boolean press = false;

		switch (state) {
			case 1:
				front = Color.BLUE;
				break;
			case 2:
				front = Color.GREEN;	
				press = true;
				break;
			default:
				front = Color.BLACK;
				break;
		}
		
	 //draw

		if (image != null) {
			g.drawImage(image, 0, 0, w, h, null);			
		}
		
		if (icon != null) {
			g.drawImage(icon, 0, 0, h, h, null);
		}
		
		g.setFont(new Font("Arial",
							(state == 1) ? Font.BOLD : Font.PLAIN, 
							h/2
				));
		g.setColor(front);		
		g.drawString(caption, textpos, h / 2);		
		g.draw3DRect(0, 0, w, h, !press);
	}
	//Methoden
	public int getTotalHeight() {
		return totalHeight;
	}
	public void updateChilds(final int childHeight) {
		int result = 0;
		final int ch = childHeight;
		final int width = getWidth();
		final int cw = (int) Math.round(width*0.9);
		final int cx = (int)(getX()+Math.round(width*0.1));
		
		result += this.getHeight();
		
		for (int i = 0; i < childs.size(); i++) {
			guiMenuNode c = childs.get(i);

			result += ch;
			c.moveTo(cx, result, cw , ch);			
		}
		
		totalHeight = result;
	}
	
	public boolean isOpen() {
		return isOpen;		
	}
	public void setOpen(boolean open) {
		updateChilds(open ? 32 : 0);
		
		isOpen = open;		
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
	
	public boolean addChild(guiMenuNode e) {
		e.setBounds(getBounds());
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
	//Abstrakte
	@Override	
	void onMouseDown(MouseEvent e){
		state = 2;
		repaint();
	}	
	@Override
 	void onMouseUp(MouseEvent e) {
		if (state == 2) {
			state = 1;
			onClick(e.getButton());
			repaint();			
		}
	}
	@Override
	void onMouseMove(MouseEvent e) {
	}	
	@Override
	void onMouseEntered(MouseEvent e) {
		state = 1;
		repaint();		
	}	
	@Override
	void onMouseExited(MouseEvent e) {
		state = 0;
		repaint();		
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
	void onMoveDone() {
		updateChilds(isOpen ? this.getHeight()/2 : 0);
	}
}
