package sonok.global;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

@SuppressWarnings("serial")
abstract class guiComponent extends JPanel {
	private TimerTask move = null;
	private static RectangleD tarbounds = null;
  //Constructor
	public guiComponent() {
		Init();
	}	
	private void Init() {
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(true);
		
		addMouseListener(new MouseAdapter(){   		    
		      @Override
		      public void mousePressed(MouseEvent e)
		      {
		        onMouseDown(e);
		      }
		      
			  @Override
			  public void mouseReleased(MouseEvent e)
			  {
			    onMouseUp(e);
			  }
		      @Override
			  public void mouseEntered(MouseEvent e) {
		    	  onMouseEntered(e);
			  }
		      @Override
		      public void mouseExited(MouseEvent e) {
		    	onMouseExited(e);
		      }
		    });
	    addMouseMotionListener(new MouseMotionListener() {  
		    @Override
		    public void mouseMoved(MouseEvent e){     
		      onMouseMove(e);
		    }   
		    @Override
		    public void mouseDragged(MouseEvent e){      
			  onMouseDrag(e);   
		    }    
		 });
	    addMouseWheelListener(new MouseWheelListener() {
	    	@Override
	    	public void mouseWheelMoved(MouseWheelEvent e)
	    	{
	    		onMouseWheel(e);        
	    	}
	    });
		addKeyListener(new KeyListener() {			
			@Override
			public void keyTyped(KeyEvent e) {
				onKey(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				onKeyUp(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				onKeyDown(e);
			}
		});    
		addComponentListener(new ComponentListener() {			
			@Override
			public void componentShown(ComponentEvent e) {
				onShow(e);
			}			
			@Override
			public void componentResized(ComponentEvent e) {
				onResize(e);
			}			
			@Override
			public void componentMoved(ComponentEvent e) {
				onMove(e);
			}			
			@Override
			public void componentHidden(ComponentEvent e) {
				onHide(e);				
			}
		});
	}
  //Input-Events
	abstract void onMouseDown(MouseEvent e);
	abstract void onMouseUp(MouseEvent e);
	abstract void onMouseEntered(MouseEvent e);
	abstract void onMouseExited(MouseEvent e);
	abstract void onMouseMove(MouseEvent e);
	abstract void onMouseDrag(MouseEvent e);
	abstract void onMouseWheel(MouseEvent e);
	abstract void onKey(KeyEvent e);
	abstract void onKeyUp(KeyEvent e);
	abstract void onKeyDown(KeyEvent e);
  //Panel-Events
	abstract void onResize(ComponentEvent e);
	abstract void onMove(ComponentEvent e);
	abstract void onShow(ComponentEvent e);
	abstract void onHide(ComponentEvent e);
	abstract void onMoveDone();
  //Getter & Setter
	public void moveTo(final Rectangle Bounds, final int acceleration) {
		if (move != null) {
			move.cancel();
			onMoveDone();
		}
		final RectangleD target = new RectangleD(Bounds);		
		tarbounds = target;
		
		move = new TimerTask() {
			RectangleD curbounds = new RectangleD(getBounds());
			RectangleD spdbounds = new RectangleD();
			RectangleD tarbounds = target;
			
			@Override
			public void run() {		
			  //wenn Beschleunigung < 0 oder	
			  //Geschwindigkeit und Abstand <= 1	
			  //dann ende.
				if ((acceleration < 0) ||
					((Math.abs(curbounds.x-tarbounds.x)<=1 &&
					 Math.abs(curbounds.y-tarbounds.y)<=1 &&
					 Math.abs(curbounds.w-tarbounds.w)<=1 &&
					 Math.abs(curbounds.h-tarbounds.h)<=1 ) && 
					 (Math.abs(spdbounds.x)<=1 &&
					 Math.abs(spdbounds.y)<=1 &&
					 Math.abs(spdbounds.w)<=1 &&
					 Math.abs(spdbounds.h)<=1 ))
					)
				{	
					setBounds(tarbounds.getRectangle());	
					onMoveDone();
					cancel();
					move = null;

					return;
				} else {	
				  //Beschleunigung
					RectangleD accbounds = new RectangleD(
						(tarbounds.x - curbounds.x) * acceleration / 1000,
						(tarbounds.y - curbounds.y) * acceleration / 1000,
						(tarbounds.w - curbounds.w) * acceleration / 1000,
						(tarbounds.h - curbounds.h) * acceleration / 1000
					);
					spdbounds.add(accbounds);
				  //Verschiebung
					RectangleD movbounds = new RectangleD(
						(tarbounds.x - curbounds.x) / 20,
						(tarbounds.y - curbounds.y) / 20,
						(tarbounds.w - curbounds.w) / 20,
						(tarbounds.h - curbounds.h) / 20
					);
					movbounds.add(spdbounds);									
					curbounds.add(movbounds);					
				  //Pos Aktualisieren
					setBounds(curbounds.getRectangle());	
				}
			}
		};
		//TODO	100 sollte 0 sein (verzögerung bis anfang)
		//		aber die Verzögerung verhindert dass die
		//		Elemente verschwinden		
			new Timer(true).scheduleAtFixedRate(move, 100, 10);
	}
	public void moveTo(int x, int y, int w, int h, int acceleration) {
		moveTo(new Rectangle(x,y,w,h),acceleration);
	}
	public void moveTo(int x, int y, int w, int h) {
		moveTo(new Rectangle(x,y,w,h));		
	}
	public void moveTo(final Rectangle Bounds) {
		moveTo(Bounds,5);
	}
	
//Overrides
	@Override
	public Rectangle getBounds() {
		if (move != null) {
			return tarbounds.getRectangle();
		} else {
			return super.getBounds();
		}
	}
}
