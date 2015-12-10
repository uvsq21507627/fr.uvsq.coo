package M1informatique;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.*;
import java.util.ArrayList;

public class Annuaire implements Organisation {
	ArrayList<Organisation> Contenue;
	String Libele;
	
	public Annuaire(String l, ArrayList<Organisation> c)
	{
		Contenue = c;
		Libele = l;
	}
	
	public String getLibele(){return Libele;}
	
	//Pour le parcour en largeur
	//La fonction n'est pas fini
	/*private ArrayList<Organisation> getContenue()
	{
		
		return Contenue;
	}*/
	
	public void afficher(int mode) {
		if (mode == 0)
		{
			afficher_profondeur();
		}
		else
		{
			if (mode == 1)
			{
				afficher_largeur(Contenue);
			}
			else
			{
				System.out.println(Libele);
			}
		}
	}
	
	//pas teste mais l'algo est bon
	public void afficher_profondeur(){
		System.out.println(Libele);
		for (int i = 0; i < Contenue.size(); i++)
		{
			Contenue.get(i).afficher(0);
		}
	}
	
	//pas fini ne fonctionne pas
	public void afficher_largeur(ArrayList<Organisation> voisin)
	{
		System.out.println(Libele);
		for (int i = 0; i < Contenue.size(); i++)
		{
			voisin.get(i).afficher(2);
		}
		for (int j = 0; j < voisin.size(); j++)
		{
			
		}
	}
	
	public void save()
	{
		File dataFile = new File("annuaire");
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
		File dataFile = new File("annuaire");
		Annuaire a;
		try{
			ObjectInputStream in = new ObjectInputStream (
					new BufferedInputStream (
							new FileInputStream ( dataFile ) ) );
				
			a = (Annuaire)(in.readObject());
			in.close();
		}catch(Exception e)
		{
			throw e;
		}
		return (Organisation)a;
	}
	
}
