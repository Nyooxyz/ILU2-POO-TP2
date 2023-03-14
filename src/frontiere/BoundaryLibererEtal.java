package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		
		
		if(Boolean.TRUE.equals(vendeurReconnu)) {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
		
			if(donneesEtal[0].equals("true")) {
				StringBuilder venduString = new StringBuilder();
				venduString.append("Vous avez vendu ");
				venduString.append(donneesEtal[4]);
				venduString.append(" sur ");
				venduString.append(donneesEtal[3]);
				venduString.append(" ");
				venduString.append(donneesEtal[2]);
				venduString.append(". ");
				venduString.append("Au revoir ");
				venduString.append(nomVendeur);
				venduString.append(", passez une bonne journée.");
				System.out.println(venduString.toString());
			}
		}else {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
	}

}
