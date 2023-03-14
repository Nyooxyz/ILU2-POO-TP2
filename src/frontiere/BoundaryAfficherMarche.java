package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		
		if(infosMarche.length == 0) {
			System.out.println("Le  marché est vide, revenez plus tard");
		}else {
			System.out.print(nomAcheteur);
			System.out.println(" ,vous trouverez au marché : ");
			StringBuilder marcheAff = new StringBuilder();
			for(int i = 0; i<infosMarche.length-1;i++) {
				
		
				
				marcheAff.append("- ");
				marcheAff.append(infosMarche[i]);
				i++;
				
				marcheAff.append(" qui vend ");
				marcheAff.append(infosMarche[i]);
				i++;
				
				marcheAff.append(" ");
				marcheAff.append(infosMarche[i]);
				marcheAff.append("\n");
			
				
				
			}
			System.out.println(marcheAff.toString());
		}
	}
}
