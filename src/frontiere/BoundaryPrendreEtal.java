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
			verifOK.append(" je vais regarder si je peux vous trouver un étal.");
			if(controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);			
			} else {
				StringBuilder deso = new StringBuilder();
				deso.append("Désolée ");
				deso.append(nomVendeur);
				deso.append(" je n'ai plus d'étal qui ne soit pas déjà occupé");
				deso.toString();
			}
			
		} else {
			StringBuilder verifNO = new StringBuilder();
			verifNO.append("Je suis désolée ");
			verifNO.append(nomVendeur);
			verifNO.append(" vous n'appartenez pas au village.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous!");
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
			prendreString.append(" s'est installé à l'étal");
			prendreString.append(numeroEtal);
			prendreString.toString();
		}
	}
}
