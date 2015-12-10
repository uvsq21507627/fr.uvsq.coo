package M1Infomatique;

public class TenthFrame extends Frame {
	
	private Roll trois;
	
	@Override
	public int score ()
	{
		return super.score() + trois.getPins();
	}

}
