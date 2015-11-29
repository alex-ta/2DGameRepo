package io;

import console.ConsoleInterface;
import console.GameConsole;

public class Console implements ConsoleInterface{

	public Console(){
		GameConsole.addConsole(this);
	}
	
	@Override
	public void print(String msg) {
		System.out.println(msg);
	}
	
}
