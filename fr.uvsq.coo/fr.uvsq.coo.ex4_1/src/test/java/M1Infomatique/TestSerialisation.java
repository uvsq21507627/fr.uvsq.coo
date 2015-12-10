package M1Infomatique;

import java.time.LocalDate;
import java.util.ArrayList;

import M1informatique.*;
import junit.framework.TestCase;

public class TestSerialisation extends TestCase{
	
	
	public static void test_serialisation() throws Exception
	{
		Personnel p1;
		Personnel p2;
		Annuaire a;
		
		ArrayList<NumeroTelephone> num = new ArrayList<NumeroTelephone>();
		num.add(new NumeroTelephone(0,1,6,0,4,3,1,5,6,0));
		ArrayList<String> fonction = new ArrayList<String>();
		fonction.add("Etudiant"); 
		p1 = new Personnel.Builder("Tutu", "Yutu", LocalDate.parse("1990-12-30")).Telephone(num).Fonction(fonction).build(); 
		p2 = new Personnel.Builder("Tes", "Teunitaire", LocalDate.parse("1993-03-15")).Telephone(num).Fonction(fonction).build(); 
		ArrayList<Organisation> e = new ArrayList<Organisation>();
		e.add(p1);
		e.add(p2);
		a = new Annuaire("M1",e);
		
		p2.save();
		a.save();
		
		//On est obligé de lire les objet dans l'ordre dans lequel on les a enregistrés.
		//Ajouté des fonctions pour choisir l'objet.
		
		try{
			//Personnel p1_save = (Personnel) p1.load();//On aurait pu rendre la fonction static mais en prevision d'amelioration on laisse tel quel.
			//assertEquals(p1_save,p1);
			Personnel p2_save = (Personnel) p2.load();
			//p2.afficher(0);
			//p2_save.afficher(0);
			
			
			Annuaire a_save = (Annuaire) a.load();
			//a_save.afficher(0);
			
			assertTrue(p2_save.getNom().equals(p2.getNom()));
			assertTrue(a.getLibele().equals(a_save.getLibele()));
		}
		catch(Exception ex){
			System.out.println("Probleme chargement " + ex);
			assertEquals(0,1);
		}
		
	}	

}
