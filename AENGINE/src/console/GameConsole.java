package console;
import java.util.ArrayList;

public class GameConsole {
	
	private static ArrayList<ConsoleInterface> consols= new ArrayList<ConsoleInterface>();
	
	public static void print(String msg){
		for(ConsoleInterface c : consols){
			c.print(msg);
		}
	}
	
	public static void addConsole(ConsoleInterface c){
		consols.add(c);
	}
	public static void removeConsole(ConsoleInterface c){
		consols.remove(c);
	}
}
