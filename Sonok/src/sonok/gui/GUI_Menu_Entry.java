package sonok.gui;

import sonok.global.guiMenuNode;

public class GUI_Menu_Entry extends guiMenuNode {
	private Thread OnClickEvent = null;

	public void setOnClickEvent(Thread onClickEvent) {
		OnClickEvent = onClickEvent;
	}
	public Thread getOnClickEvent() {
		return OnClickEvent;
	}


	public GUI_Menu_Entry(String Caption, String IconName, String ImageName, int size, int sizeOpen, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "",
						(ImageName != "") ? "./data/icon/"+ImageName+".png" : "");
		OnClickEvent = onClickEvent;
		
		final boolean hasSizeClosed = (size > 0);
		final boolean hasSizeOpen = (sizeOpen > 0);
		
		if (hasSizeOpen && hasSizeClosed){
			setDefaultSize(size);
			setOpenSize(sizeOpen);
		} else if (hasSizeOpen && !hasSizeClosed) {
			setElementSize(sizeOpen);
		} else if (!hasSizeOpen && hasSizeClosed) {
			setElementSize(size);
		}
	}
	public GUI_Menu_Entry(String Caption, String IconName, String ImageName, int size, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "",
						(ImageName != "") ? "./data/icon/"+ImageName+".png" : "");
		OnClickEvent = onClickEvent;
			
		setElementSize(size);
	}	
	public GUI_Menu_Entry(String Caption, String IconName, String ImageName, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "",
				(ImageName != "") ? "./data/icon/"+ImageName+".png" : "");
		OnClickEvent = onClickEvent;
	}
	public GUI_Menu_Entry(String Caption, String IconName, int size, int sizeOpen, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "");
		OnClickEvent = onClickEvent;
		
		final boolean hasSizeClosed = (size > 0);
		final boolean hasSizeOpen = (sizeOpen > 0);

		if (hasSizeOpen && hasSizeClosed){
			setDefaultSize(size);
			setOpenSize(sizeOpen);
		} else if (hasSizeOpen && !hasSizeClosed) {
			setElementSize(sizeOpen);
		} else if (!hasSizeOpen && hasSizeClosed) {
			setElementSize(size);
		}
	}
	public GUI_Menu_Entry(String Caption, String IconName, int size, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "");
		OnClickEvent = onClickEvent;
			
		setElementSize(size);
	}
	public GUI_Menu_Entry(String Caption, String IconName, Thread onClickEvent) {
		super(Caption,	(IconName != "") ? "./data/icon/"+IconName+".png" : "");
		OnClickEvent = onClickEvent;
	}	
	public GUI_Menu_Entry(String Caption, int size, Thread onClickEvent) {
		super(Caption);
		OnClickEvent = onClickEvent;
		setElementSize(size);
	}	
	public GUI_Menu_Entry(String Caption, Thread onClickEvent) {
		super(Caption);
		OnClickEvent = onClickEvent;
	}	
	public GUI_Menu_Entry(Thread onClickEvent) {
		super();
		OnClickEvent = onClickEvent;
	}
	public GUI_Menu_Entry(String Caption) {
		super(Caption);
	}
	public GUI_Menu_Entry(int size) {
		super();
		
		setElementSize(size);
	}	
	public GUI_Menu_Entry() {
		super();
	}
	
	@Override
	public void onClick(int button) {						
		if (OnClickEvent != null) {
			OnClickEvent.run();
		}		
				
		toggle();
	}
	
	public GUI_Menu_Entry addChild(GUI_Menu_Entry e) {
		if (super.addChild(e))
			return e;
		else 
			return null;
	}
}
