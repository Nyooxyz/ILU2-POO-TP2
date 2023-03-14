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
				System.out.print("Chez quel commerçant voulez-vous acheter des ");
				System.out.print(produit);
				System.out.println(" ?");
				
				System.out.println(controlAcheterProduit.afficherMarchands(produit));
				int vendeur = scan.nextInt();
				String vendeurNom = controlAcheterProduit.choisirMarchand(vendeur, produit);
				
				if(vendeurNom != null) {
					System.out.print(nomAcheteur);
					System.out.print(" se déplace jusqu'à l'etal du vendeur ");
					System.out.println(vendeurNom);
					System.out.print("Combien de ");
					System.out.print(produit);
					System.out.println(" voulez-vous acheter ?");
					
					int nbProduit = scan.nextInt();
					
					while(nbProduit <= 0) {
						System.out.println("Veuillez entrer une quantité valide.");
						nbProduit = scan.nextInt();
					}
					
					if(controlAcheterProduit.trouverProduitQuant(vendeurNom) >= nbProduit) {
						int quantiteAcheter = controlAcheterProduit.acheterProduit(vendeurNom,nbProduit);

						
						System.out.print(nomAcheteur);
						System.out.print(" a acheté ");
						System.out.print(quantiteAcheter);
						System.out.print(" ");
						System.out.print(produit);
						System.out.print(" à ");
						System.out.println(vendeurNom);
					} else {
						System.out.println("Mais il ne reste pas assez de "+ produit + " à cet étal ou la quantité n'est pas valide.");
					}
				} else {
					System.out.println("Veuillez séléctionner le vendeur avec son chiffre correspondant.");
				}
			} else {
				System.out.println("Il n'y a aucun vendeur proposant ce produit.");
			}
			
		} else {
			System.out.println("Navré mais vous ne faites pas parti du village. ");
		}
		
		
		
	}
}
