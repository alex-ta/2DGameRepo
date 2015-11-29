package logic;

import java.awt.Component;

import clock.CallInterface;

public class GameClock implements CallInterface{

	private Component comp;
	
	public GameClock(Component comp){
		this.comp = comp;
	}
	
	@Override
	public void call() {
		comp.repaint();
	}
	
}
