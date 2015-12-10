package M1informatique;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter {
	protected Stack history = new Stack ();
	protected Hashtable set = new Hashtable () ;
	protected static Scanner sc;
	public void session ( ) {
		set.put("exit", new Quit());
		set.put("undo", new Undo(history));
		sc = new Scanner(System.in);
		while ( true ) {
			Command command = getNewCommand ();
			if (command instanceof Quit) {
				sc.close();
				return ;
			} else {
				command . execute ( ) ;
			}
		}
	}
	protected Command getNewCommand () {
		String s = sc.nextLine();
		while ( !set.containsKey(s) ) {
			System.out.println("Not a valid command; try again!") ;
			s = sc.nextLine() ;
		}
		return ((Command)set.get(s)).clone();
	}
}
