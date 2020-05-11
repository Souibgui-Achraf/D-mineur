import java.util.concurrent.TimeUnit;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nb_bombs;
		int lignes;
		int colonnes;
		premiereFenetre fenetre = new premiereFenetre();
		while (!premiereFenetre.selected) {
			sleep(200);
		}
		lignes=fenetre.nombreDeLignes;
	    colonnes= fenetre.nombreDeColonnes;
	    nb_bombs= fenetre.nombreDeBombes;
		
		fenetre.frame.dispose();
		System.out.println(lignes);

		System.out.println(colonnes);

		System.out.println(nb_bombs);
		window w =new window(nb_bombs,lignes,colonnes) ;
	}
	static void sleep(int x) {//timer sleeps for x ms
		try {
		    TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}

}
