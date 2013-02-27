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
	ArrayList<guiMenuNode> childs = new ArrayList<guiMenuNode>();
	
	Image icon;
	Image image;
	String caption;
	
	Thread MoveDoneEvent;
		
	private boolean isOpen;
	private int state = 0;
	private int margin = 4;
	private int elementSize = 32;
	
	public int getElementSize() {
		return elementSize;
	}
	public void setElementSize(int size) {
		this.elementSize = size;
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	//Konstruktor
	public guiMenuNode(String cap, Image ico, Image img) {
		super();


		if (cap != null)
			caption = cap;
		else
			caption = "";
		image = img;
		icon = ico;

	}
	public guiMenuNode(String cap, String ico, String img) {
		super();

		if (cap != null)
			caption = cap;
		else
			caption = "";
		
		if ((img != null) && (img != ""))
			image = new CImage(img).getImage();
		else
			image = null;
			
		if ((ico != null) && (ico != ""))
			icon = new CImage(ico).getImage();
		else
			icon = null;

	}
	public guiMenuNode(String cap, Image ico) {
		super();

		image = null;
		icon = ico;
		caption = cap;
	}
	public guiMenuNode(String cap, String ico) {
		super();		

		if (cap != null)
			caption = cap;
		else
			caption = "";
		image = null;
		if ((ico != null) && (ico != ""))
			icon = new CImage(ico).getImage();
		else
			icon = null;
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
		
//		Color back = getBackground();
		Color front = getForeground();
		boolean press = false;

		switch (state) {
			case 1:
				front = new Color(0, 128, 255);	
				break;
			case 2:
				front = new Color(255, 128, 0);
				press = true;
				break;
			default:
				front = Color.GRAY;
				break;
		}
		
	 //draw

		if (image != null) {
			g.drawImage(image, 0, 0, w, h, null);			
		}
		
		if (icon != null) {
			g.drawImage(icon, margin, margin, h-margin*2, h-margin*2, null);
		}
		
		g.setFont(new Font("Arial",(state == 1) ? Font.BOLD : Font.PLAIN,h/2));
		g.setColor(front);
		g.drawString(caption, textpos, h / 2);	
		if (!isOpen && childs.size() > 0) {
			g.drawString("+"+Integer.toString(childs.size()), w-50, h);				
		}	
		g.draw3DRect(0, 0, w, h, !press);
	}
	//Methoden
	@Deprecated
	public int getTotalHeight() {
		int result = getBounds().height;
		
		if (isOpen) {
			for (int i = 0; i < childs.size(); i++) {
				result += childs.get(i).getTotalHeight();		
			}
		}
		
		return result;
	}
	public int update(final int speed) {
		final	int width = getBounds().width;
		final	int y = getBounds().y;	
		
		final 	int cx = (int) (getBounds().x+Math.round(width*0.1));
				int cy = getBounds().height;
		final 	int cw = (int) Math.round(width*0.9);
						
		
		for (int i = 0; i < childs.size(); i++) {
			final guiMenuNode c = childs.get(i);

			if (this.isOpen) {
				c.moveTo(cx, y + cy, cw , c.getElementSize(), speed);	
				System.out.println(c.caption + "|" + c.getElementSize());
				cy += c.update(speed);
			} else {
				c.moveTo(this.getBounds(),speed);	
				c.update(speed);
			}	
		}			
				
		return cy;
	}
	public int update() {
		return update(3);
	}
	public int updateQuick() {
		return update(-1);
	}
	
	public boolean isOpen() {
		return isOpen;		
	}
	private void setOpen(boolean open) {
		isOpen = open;	
		
		if (!open){
			for (int i = 0; i < childs.size(); i++) {
				childs.get(i).setOpen(open);			
			}
		}		
	}	
	public void expand() {
		setOpen(true);
		
		owner.update();	
	}	
	public void collapse() {
		setOpen(false);
		
		owner.update();	
	}	
	public void toggle() {
		setOpen(!isOpen);
		
		owner.update();	
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
		if (MoveDoneEvent != null) {
			MoveDoneEvent.run();			
		}
	}

}
