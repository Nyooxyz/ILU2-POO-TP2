package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder verifOK = new StringBuilder();
			verifOK.append("Bonjour ");
			verifOK.append(nomVendeur);
			verifOK.append(" je vais regarder si je peux vous trouver un �tal.");
			System.out.println(verifOK.toString());
						
			if (controlPrendreEtal.dejaInstalle(nomVendeur)) {
				StringBuilder deso1 = new StringBuilder();
				deso1.append("D�sol�e ");
				deso1.append(nomVendeur);
				deso1.append(" vous occup� deja un �tal.");
				System.out.println(deso1.toString());
				
			} else if(controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);
			} else {
				StringBuilder deso = new StringBuilder();
				deso.append("D�sol�e ");
				deso.append(nomVendeur);
				deso.append(" je n'ai plus d'�tal qui ne soit pas d�j� occup�");
				System.out.println(deso.toString());
			}
			
		} else {
			StringBuilder verifNO = new StringBuilder();
			verifNO.append("Je suis d�sol�e ");
			verifNO.append(nomVendeur);
			verifNO.append(" vous n'appartenez pas au village.");
			System.out.println(verifNO.toString());
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous!");
		System.out.println("Il me faudrait quelques renseignements: ");
		System.out.println("Quel produit souhaitez-vous vendre? ");
		String produit = scan.next();
		
		System.out.println("Combien souhaitez-vous en vendre?");
		int nbProduit = scan.nextInt();
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if(numeroEtal != -1) {
			StringBuilder prendreString = new StringBuilder();
			prendreString.append("Le vendeur ");
			prendreString.append(nomVendeur);
			prendreString.append(" s'est install� � l'�tal");
			prendreString.append(numeroEtal);
			System.out.println(prendreString.toString());
		}
	}
}
