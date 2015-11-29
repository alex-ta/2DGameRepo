package gui;

import java.awt.Component;

public interface WindowInterface {

	public abstract int getWidth();
	public abstract void setWidth(int width);
	public abstract int getHeight();
	public abstract void setHeight(int height);
	public abstract void setTitle(String title);
	public abstract void repaint();
	
}
