package M1informatique;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		//on initialize les variables via le terminal
		ArrayList<NumeroTelephone> num = new ArrayList<NumeroTelephone>();
		ArrayList<String> fonction = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Votre nom :");
		String nom = sc.nextLine();
		System.out.println("Votre prenom :");
		String prenom = sc.nextLine();
		System.out.println("Votre date de naissance (aaaa-mm-dd):");
		LocalDate naissance = java.time.LocalDate.parse(sc.nextLine());
		System.out.println("Voulez vous donnez un numero de telephone (o, y, O, Y pour oui, nom sinon");
		char rep = sc.next().charAt(0);
		while (rep == 'o' || rep == 'O' || rep == 'y' || rep == 'Y')
		{
			System.out.println("Votre numero : ");
			int[] n = new int[10];
			for (int i=0;i<10;i++)
			{
				System.out.println("Saisissez un chiffre et validez : ");
				n[i] = sc.nextInt();
			}
			try {
				num.add(new NumeroTelephone(n[0],n[1],n[2],n[3],n[4],n[5],n[6],n[7],n[8],n[9]));
			}catch(Exception bad_num)
			{
				System.out.println("Numero erronne");
			}
			System.out.println("Voulez vous donnez un numero de telephone (o, y, O, Y pour oui, nom sinon");
			rep = sc.next().charAt(0);
		}
		System.out.println("Voulez vous donnez une fonction (o, y, O, Y pour oui, nom sinon");
		rep = sc.next().charAt(0);
		while (rep == 'o' || rep == 'O' || rep == 'y' || rep == 'Y')
		{
			System.out.println("Votre fonction :");
			fonction.add(sc.next());
			System.out.println("Voulez vous donnez une fonction (o, y, O, Y pour oui, nom sinon");
			rep = sc.next().charAt(0);
		}
		sc.close();
		Personnel p1 = new Personnel.Builder(nom, prenom, naissance).Telephone(num).Fonction(fonction).build();
		
		p1.afficher(0);
		
		
	}
}
