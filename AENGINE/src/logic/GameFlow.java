package logic;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import clock.Clock;
import console.GameConsole;
import gui.Container;
import gui.Window;
import gui.WindowInterface;
import io.Console;
import menu.Menu;
import menu.MenuListener;

public class GameFlow {
	
	private final Window gamewindow;
	private final Menu menu;
	private final ArrayList<Container> game;
	private final Clock clock;
	private final Dimension dim;
	
	public GameFlow(int width, int height){
		new Console();
		clock = new Clock();
		new Thread(clock).start();
		gamewindow = new Window();
		dim = new Dimension(width,height);
		menu = new Menu(dim, new MenuListener(){
			@Override
			public void call(String option){
				System.out.println(option);
			}
		});
		
		game = new ArrayList<Container>();
		game.add(new Container(width,height));
	}
	
	public void init(){
		menu.setLayout(new GridBagLayout());
		menu.addEntries("New Game", "Save", "Return", "Configuration", "Help");
		gamewindow.init(menu);
	}
	
	public WindowInterface getGamewindow() {
		return gamewindow;
	}

	public Menu getMenu() {
		return menu;
	}

	public ArrayList<Container> getGame() {
		return game;
	}
	
}


