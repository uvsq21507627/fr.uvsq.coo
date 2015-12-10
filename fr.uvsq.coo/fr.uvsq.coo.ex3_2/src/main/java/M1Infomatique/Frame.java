package M1Infomatique;

public class Frame {
	
	private Roll un;
	private Roll deux;
	
	public int score ()
	{
		return un.getPins() + deux.getPins();
	}

}
