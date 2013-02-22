package sonok.global;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class guiMenuNode extends guiComponent {
	
	Image icon;
	String caption;
	
	ArrayList<guiMenuNode> childs = new ArrayList<guiMenuNode>();

	public guiMenuNode(Image icon, String caption) {
		super();

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
