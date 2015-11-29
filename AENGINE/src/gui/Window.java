package gui;

import java.awt.Component;

import javax.swing.JFrame;

public class Window extends JFrame implements WindowInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 19112015L;

	public Window(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init(Component...components){
		for(Component c: components){
			this.add(c);
		}
		this.pack();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void setWidth(int width) {
		super.setSize(width, this.getHeight());
	}

	@Override
	public void setHeight(int height) {
		super.setSize(this.getWidth(), height);
	}

}
