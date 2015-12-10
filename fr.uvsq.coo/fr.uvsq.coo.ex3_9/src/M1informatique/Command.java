package M1informatique;

import java.util.Stack;

public abstract class Command implements Cloneable {
	public abstract void execute () ;
	public abstract void undo () ;
	
	public Command clone(){
		try {
			return (Command) super.clone();
		}catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
	
class Undo extends Command {
	protected Stack history ;
	public Undo(Stack h) { history = h ; }
	@Override
	public void execute ( ) {
		( (Command) history.pop()).undo ( ) ; 
	}
	@Override
	public void undo () {}

}

class Quit extends Command {

	@Override
	public void execute() {}

	@Override
	public void undo() {}
	
}

abstract class CalculatorCommand extends Command {
	public abstract void execute () ;
	public void undo (){} ;
	protected Stack valueStack;
}


class Plus extends CalculatorCommand {
	Plus (Stack h)
	{
		valueStack = h;
	}
	@Override
	public void execute() {
		if (valueStack.size() == 1 || valueStack.empty())
		{
			System.out.println("Command incorrect");
		}
		else {
			int val1 = (int) valueStack.pop();
			int val2 = (int) valueStack.pop();
			valueStack.push(val1+val2);
		}
	}
	
}

class Min extends CalculatorCommand {
	Min (Stack h)
	{
		valueStack = h;
	}

	@Override
	public void execute() {
		if (valueStack.size() == 1 || valueStack.empty())
		{
			System.out.println("Command incorrect");
		}
		else {
			int val1 = (int) valueStack.pop();
			int val2 = (int) valueStack.pop();
			valueStack.push(val1-val2);
		}
	}
	
}

class Mul extends CalculatorCommand {
	Mul (Stack h)
	{
		valueStack = h;
	}
	@Override
	public void execute() {
		if (valueStack.size() == 1 || valueStack.empty())
		{
			System.out.println("Command incorrect");
		}
		else {
			int val1 = (int) valueStack.pop();
			int val2 = (int) valueStack.pop();
			valueStack.push(val1*val2);
		}
	}
	
}

class Div extends CalculatorCommand {
	Div (Stack h)
	{
		valueStack = h;
	}
	@Override
	public void execute() {
		if (valueStack.size() == 1 || valueStack.empty())
		{
			System.out.println("Command incorrect");
		}
		else {
			int val1 = (int) valueStack.pop();
			int val2 = (int) valueStack.pop();
			valueStack.push(val1/val2);
		}
	}
	
}

class Accept extends CalculatorCommand {
	Accept(Stack h)
	{
		valueStack = h;
	}
	@Override
	public void execute() {
		for(int i = 0; i < valueStack.size(); i++)
		{
			System.out.println(valueStack.get(i));
		}
	}
	
}

