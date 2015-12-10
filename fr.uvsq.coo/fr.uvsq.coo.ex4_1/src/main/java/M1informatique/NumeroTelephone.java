package M1informatique;

import java.io.Serializable;

public class NumeroTelephone implements Serializable {
	private String num;//Le numero est conserver dans une Sting
	
	public NumeroTelephone
	(
			//Les dix numero
			int un,
			int deux,
			int trois,
			int quatre,
			int cinq,
			int six,
			int sept,
			int huit,
			int neuf,
			int dix
	) throws Exception //On verifie que les numeros sont corrects
	{
		num="";
		Exception bad_num = null;
		if (
				(0<=un && 9>=un)
				&&
				(0<=deux && 9>=deux)
				&&
				(0<=trois && 9>=trois)
				&&
				(0<=quatre && 9>=quatre)
				&&
				(0<=cinq && 9>=cinq)
				&&
				(0<=six && 9>=six)
				&&
				(0<=sept && 9>=sept)
				&&
				(0<=huit && 9>=huit)
				&&
				(0<=neuf && 9>=neuf)
				&&
				(0<=dix && 9>=dix)
			)
		{
			num= num + Integer.toString(un);
			num= num + Integer.toString(deux);
			num= num + Integer.toString(trois);
			num= num + Integer.toString(quatre);
			num= num + Integer.toString(cinq);
			num= num + Integer.toString(six);
			num= num + Integer.toString(sept);
			num= num + Integer.toString(huit);
			num= num + Integer.toString(neuf);
			num= num + Integer.toString(dix);
		}
		else throw bad_num;
	}
	
	public String getNum()
	{
		return num;
	}
}
