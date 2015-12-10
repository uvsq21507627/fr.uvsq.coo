package M1Infomatique;

public class Employe {
	private final String nom;
	private final String adresse;
	
	public Employe (String n, String a)
	{
		nom=n;
		adresse=a;
	}
	
	public String getNom() {return nom;}
	public String getAdresse() {return adresse;}
}
