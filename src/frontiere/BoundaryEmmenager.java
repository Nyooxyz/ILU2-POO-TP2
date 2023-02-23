package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force = -1;
					StringBuilder nomString = new StringBuilder();
					nomString.append("Bienvenu villageois ");
					nomString.append(nomVisiteur);
					nomString.append(" Quelle est votre force ?");
					force = Clavier.entrerEntier(nomString.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force = -1;
		int effetPotionMin = -1;
		int effetPotionMax = -2;
		StringBuilder nomDruideString = new StringBuilder();
		nomDruideString.append("Bienvenu druide ");
		nomDruideString.append(nomVisiteur);
		nomDruideString.append(" Quelle est votre force ?");
		force = Clavier.entrerEntier(nomDruideString.toString());
		
		while(effetPotionMin > effetPotionMax) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			if(effetPotionMin > effetPotionMax) System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
