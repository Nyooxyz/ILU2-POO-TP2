package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		
		if(Boolean.TRUE.equals(controlAcheterProduit.idVerif(nomAcheteur))) {
			System.out.println("Quel produit voulez-vous acheter? ");
			String produit = scan.next();
			

			if(!controlAcheterProduit.afficherMarchands(produit).isEmpty()) {
				System.out.print("Chez quel commer�ant voulez-vous acheter des ");
				System.out.print(produit);
				System.out.println(" ?");
				
				System.out.println(controlAcheterProduit.afficherMarchands(produit));
				int vendeur = scan.nextInt();
				String vendeurNom = controlAcheterProduit.choisirMarchand(vendeur, produit);
				
				if(vendeurNom != null) {
					System.out.print(nomAcheteur);
					System.out.print(" se d�place jusqu'� l'etal du vendeur ");
					System.out.println(vendeurNom);
					System.out.print("Combien de ");
					System.out.print(produit);
					System.out.println(" voulez-vous acheter ?");
					
					int nbProduit = scan.nextInt();
					
					while(nbProduit <= 0) {
						System.out.println("Veuillez entrer une quantit� valide.");
						nbProduit = scan.nextInt();
					}
					
					if(controlAcheterProduit.trouverProduitQuant(vendeurNom) >= nbProduit) {
						int quantiteAcheter = controlAcheterProduit.acheterProduit(vendeurNom,nbProduit);

						
						System.out.print(nomAcheteur);
						System.out.print(" a achet� ");
						System.out.print(quantiteAcheter);
						System.out.print(" ");
						System.out.print(produit);
						System.out.print(" � ");
						System.out.println(vendeurNom);
					} else {
						System.out.println("Mais il ne reste pas assez de "+ produit + " � cet �tal ou la quantit� n'est pas valide.");
					}
				} else {
					System.out.println("Veuillez s�l�ctionner le vendeur avec son chiffre correspondant.");
				}
			} else {
				System.out.println("Il n'y a aucun vendeur proposant ce produit.");
			}
			
		} else {
			System.out.println("Navr� mais vous ne faites pas parti du village. ");
		}
		
		
		
	}
}
