package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	
	public Boolean isVendeur(String nomVendeur) {
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null) return true;
		return false;
	}
	public String[] libererEtal(String nomVendeur) {
		String[] res = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).libererEtal();
		return res;
		 
	}

}
