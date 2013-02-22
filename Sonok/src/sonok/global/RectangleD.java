package sonok.global;

import java.awt.Rectangle;

public class RectangleD {
	public double x,y,w,h;
	public RectangleD() {
		x = 0;
		y = 0;
		w = 0;
		h = 0;
	}	
	public RectangleD(double X, double Y, double W, double H) {
		x = X;
		y = Y;
		w = W;
		h = H;
	}
	public RectangleD(Rectangle r){
		setRectangle(r);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)Math.round(x),(int)Math.round(y),(int)Math.round(w),(int)Math.round(h));
	}			
	public void setRectangle(Rectangle r){
		x = r.x;
		y = r.y;
		w = r.width;
		h = r.height;
	}

	public void add(RectangleD r) {
		x += r.x;
		y += r.y;
		w += r.w;
		h += r.h;
	}
	public void add(Rectangle r) {
		add(new RectangleD(r));
	}
}
