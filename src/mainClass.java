import java.util.concurrent.TimeUnit;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nb_bombs;
		int lignes;
		int colonnes;
		boolean fin=false;
		while(true) {
			premiereFenetre fenetre = new premiereFenetre();
			while (!fenetre.selected) {
				sleep(200);
			}
			lignes=fenetre.nombreDeLignes;
		    colonnes= fenetre.nombreDeColonnes;
		    nb_bombs= fenetre.nombreDeBombes;
		    
		    if(nb_bombs>(int) (((double)colonnes)*((double)lignes)*3/5))
		    	nb_bombs=(int) (((double)colonnes)*((double)lignes)*3/5);
			fenetre.frame.dispose();
			while(true) {
				window w =new window(nb_bombs,lignes,colonnes) ;
				while(!w.fin) {
					sleep(200);
				}
				sleep(2000);
				
				resultat r;
				
				if(w.won) {
					r=new resultat("won");
				}
				else r=new resultat("lost");
				
				while(!r.selected){
					sleep(200);
				}
				w.frame.dispose();
				r.frame.dispose();
				if(r.playagain) continue;
				else break;
				
			}
		}
	}
	static void sleep(int x) {//timer sleeps for x ms
		try {
		    TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
}
