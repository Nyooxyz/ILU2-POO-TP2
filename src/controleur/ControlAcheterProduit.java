package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public String afficherMarchands(String produit) {
		StringBuilder res = new StringBuilder();
		
		if (village.rechercherVendeursProduit(produit) == null) return "";
		for (int i=0;i<village.rechercherVendeursProduit(produit).length;i++) {
			res.append(i+1);
			res.append(" - ");
			res.append(village.rechercherVendeursProduit(produit)[i].getNom());
			res.append("\n");
		}
		
		return res.toString();
	}
	
	public Boolean idVerif(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String choisirMarchand(int idMarchand, String produit) {
		for(int i=0;i<village.rechercherVendeursProduit(produit).length;i++) {
	
			if(idMarchand == i+1) return village.rechercherVendeursProduit(produit)[i].getNom(); 
		}
		return null;
	}
	
	public int trouverProduitQuant(String vendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).getQuantite();
	}
	
	public int acheterProduit(String vendeur, int nbProduit) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).acheterProduit(nbProduit);
	}

}
