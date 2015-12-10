package M1informatique;

public class MoteurRPN extends Interpreter {
	
	MoteurRPN()
	{
		set.put("+", new Plus(history));
		set.put("-", new Min(history)); 
		set.put("*" , new Mul(history));
		set.put("/", new Div(history));
		set.put("accept", new Accept(history));
	}
	
	protected Command getNewCommand () {
		String s = sc.nextLine();
		while ( !set.containsKey(s) && isInteger(s) ) {
			if (isInteger(s) ){
				history.push(Integer.parseInt(s));
				System.out.println("Command suivante stp :");
			}
			else System.out.println("Not a valid command; try again!") ;
			s = sc.nextLine() ;
		}
		return ((Command)set.get(s)).clone();
	}

	public static boolean isInteger(String s) {
	    return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
}
