package sonok.global;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class guiMenuNode extends guiComponent {

	guiMenu owner;
	private ArrayList<guiMenuNode> childs = new ArrayList<guiMenuNode>();
	private String caption;
	Image icon;
	Image image;
	
	Thread MoveDoneEvent;
		
	private boolean isOpen = false;
	private boolean isActive = true;
	private TimerTask Scroll = null;
	
	private int state = 0;
	private int margin = 4;
	private int openSize = 32;
	private int defaultSize = 32;	
	private int textWidth = 0;
	private int textpos;
	
	public int getElementSize() {
		return isOpen ? openSize : defaultSize;
	}
	public void setElementSize(int size) {
		this.defaultSize = size;
		this.openSize = size;
	}
	public void setDefaultSize(int size) {
		this.defaultSize = size;
	}
	public void setOpenSize(int size) {
		this.openSize = size;
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

		setForeground(Color.DARK_GRAY);

		if (cap != null)
			setCaption(cap);
		else
			setCaption("");
		image = img;
		icon = ico;

	}
	public guiMenuNode(String cap, String ico, String img) {
		super();

		setForeground(Color.DARK_GRAY);

		if (cap != null)
			caption = cap;
		else
			setCaption("");
		
		if ((img != null) && (img != ""))
			try {
				image = new CImage(img).getImage();
			} catch (Exception e) {
				image = null;
			}
		else
			image = null;
			
		if ((ico != null) && (ico != ""))
			try {
				icon = new CImage(ico).getImage();
			} catch (Exception e) {
				icon = null;
			}
		else
			icon = null;

	}
	public guiMenuNode(String cap, Image ico) {
		super();

		setForeground(Color.DARK_GRAY);

		image = null;
		icon = ico;
		setCaption(cap);
	}
	public guiMenuNode(String cap, String ico) {
		super();

		setForeground(Color.DARK_GRAY);		

		if (cap != null)
			setCaption(cap);
		else
			setCaption("");
		image = null;
		if ((ico != null) && (ico != ""))
			icon = new CImage(ico).getImage();
		else
			icon = null;
	}
	public guiMenuNode(String cap){
		super();

		setForeground(Color.DARK_GRAY);

		icon = null;
		image = null;
		setCaption(cap);
	}
	public guiMenuNode() {
		super();

		setForeground(Color.DARK_GRAY);

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
				
		final Color color;
		boolean press = false;

		switch (state) {
			case 1:
				color = new Color(0, 128, 255);	
				break;
			case 2:
				color = new Color(255, 128, 0);
				press = true;
				break;
			default:
				color = getForeground();
				break;
		}
		
	 //draw
		
		if (isActive) {	

			if (image != null) {
				g.drawImage(image, 0, 0, w, h, null);			
			}

			g.setColor(color);
			
			g.setFont(getFont());
			g.drawString(caption, textpos,(int) Math.round(h * 0.6));		
			
			if (!isOpen && childs.size() > 0) {
				g.drawString("+"+Integer.toString(childs.size()), w-50, h);				
			}	
			
			if (icon != null) {
				g.drawImage(icon, margin, margin, h-margin*2, h-margin*2, null);
			}
		}

		g.draw3DRect(0, 0, w, h, !press);
	}
	//Methoden
	@Deprecated
	public int getTotalHeight() {
		int result = getElementSize();
		
		if (isOpen) {
			for (int i = 0; i < childs.size(); i++) {
				result += childs.get(i).getTotalHeight();		
			}
		}
		
		return result;
	}
	
	private void updateElement() {
		final boolean scrolls = (textWidth > getBounds().width - ((icon != null) ? getElementSize()+10 : 0));	
		
		if (isActive && (Scroll == null) && scrolls){
			textpos = (icon != null) ? getElementSize()+10 : 10;
			Scroll = new TimerTask() {
				
				@Override
				public void run() {
					textpos -= 2;
					repaint();
					
					if (textpos <= -textWidth) {
						Scroll = null;
						update();
						cancel();
					}
				}
			};
			
			new Timer(true).scheduleAtFixedRate(Scroll, 3000, 20);
		} else if (Scroll == null){
			textpos = (icon != null) ? getElementSize()+10 : 10;
		}
		
	}
	
	public int update(final int speed) {
		final	int width = getBounds().width;
		final	int y = getBounds().y;			
		final 	int cx = (int) (getBounds().x+Math.round(width*0.1));
				int cy = getBounds().height;
		final 	int cw = (int) Math.round(width*0.9);
		
		for (int i = 0; i < childs.size(); i++) {
			final guiMenuNode c = childs.get(i);

			if (isOpen) {
				c.moveTo(cx, y + cy, cw , c.getElementSize(), speed);	
				cy += c.update(speed);
				c.setActive(true);
			} else {
				c.moveTo(this.getBounds(),speed);	
				c.update(speed);
				c.MoveDoneEvent = new Thread(){
					@Override
					public void run() {
						super.run();

						c.setActive(false);
					};
				};
			}	
		}	
		
		updateElement();
				
		return cy;
	}
	public int update() {
		return update(3);
	}
	public int updateQuick() {
		return update(-1);
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
		final FontMetrics fontMetrics = getFontMetrics(getFont());
		textWidth = fontMetrics.stringWidth(caption);
	}
	public String getCaption() {
		return caption;
	}
	
	@Override
	public Font getFont() {
		return new Font("Arial",(state == 1) ? Font.BOLD : Font.PLAIN,getElementSize()/2);
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
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
		if (isActive) {
			//setVisible(true);
			updateElement();
		} else {
			//setVisible(false);
			if (Scroll != null) {
				Scroll.cancel();
				updateElement();
				Scroll = null;
			}
		}
	}
	public boolean isActive() {
		return isActive;
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
			MoveDoneEvent = null;
		}
	}

}
