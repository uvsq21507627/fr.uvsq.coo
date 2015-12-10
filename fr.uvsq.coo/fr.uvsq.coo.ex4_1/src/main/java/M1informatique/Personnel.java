package M1informatique;

import java.io.BufferedOutputStream;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Personnel implements Organisation {

	public Personnel(Builder builder) {
		//Paramètres obligatoires
		nom = builder.b_nom;
		prenom = builder.b_prenom;
		naissance = builder.b_naissance;
		
		//paramètres optionnels
		tel = builder.b_tel;
		fonction = builder.b_fonction;
	}

	private final String nom;
	private final String prenom;
	
	public String getNom(){ return nom; }
	public String getPrenom(){ return prenom; }

	
	private final LocalDate naissance;
	
	private final ArrayList<NumeroTelephone> tel;
	private final ArrayList<String> fonction;
	
	public static class Builder {
		
		//paramètres obligatoires
		private final String b_nom;
		private final String b_prenom;
		private final LocalDate b_naissance;
		
		//paramètres optionnels
		private ArrayList<NumeroTelephone> b_tel = new ArrayList<NumeroTelephone>();
		private ArrayList<String> b_fonction = new ArrayList<String>();
		
		public Builder(String n, String p, LocalDate an)
		{
			b_nom=n;
			b_prenom=p;
			b_naissance=an;
		}
		
		public Builder Telephone(ArrayList<NumeroTelephone> t)
		{
			b_tel=t;
			return this;
		}
		
		public Builder Fonction(ArrayList<String> f)
		{
			b_fonction=f;
			return this;
		}
		
		public Personnel build()
		{
			return new Personnel(this);
		}
		
	}
	
	public void afficher(int mode)
	{
		System.out.println(nom + " " + prenom);
		System.out.println(naissance);
		for (int i = 0; i< tel.size(); i++)
		{
			System.out.println(tel.get(i).getNum());
		}
		for (int i = 0; i< fonction.size(); i++)
		{
			System.out.println(fonction.get(i));
		}
	}
	
	public void save()
	{
		File dataFile = new File("personnel");
		try{
			ObjectOutputStream out = new ObjectOutputStream (
					new BufferedOutputStream (
							new FileOutputStream ( dataFile ) ) );
			out.writeObject(this);
			out.close();
		}catch(Exception e)
		{
			System.out.println("Erreur ecriture !" + e);
		}
	}
	
	public Organisation load() throws Exception{
		File dataFile = new File("personnel");
		Personnel p;
		try{
			ObjectInputStream in = new ObjectInputStream (
					new BufferedInputStream (
							new FileInputStream ( dataFile ) ) );
				
			p = (Personnel)(in.readObject());
			in.close();
		}catch(Exception e)
		{
			throw e;
		}
		return (Organisation)p;
	}
}
