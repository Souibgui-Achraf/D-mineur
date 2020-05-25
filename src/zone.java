import java.util.Random;

import javax.swing.ImageIcon;

public class zone {
	public static piece[][] c_table;
	static int lignes;
	static int colonnes;
	int nb_bombs;
	public zone(int nb,int l,int c,int startx,int starty) {
		zone.lignes=l;
		zone.colonnes=c;
		c_table=new piece[lignes][colonnes];
		this.nb_bombs=nb;
		 int nb_bomb=0;
		 Random r=new Random();
		 do { //case bombs first
			int r_l=r.nextInt(lignes);
			int r_c=r.nextInt(colonnes);
			if(c_table[r_l][r_c]==null && !(r_l==startx && r_c==starty)) {
				c_table[r_l][r_c]=new piece(r_l,r_c);
				c_table[r_l][r_c].has_bomb=true;
				nb_bomb++;
			} 
		 }while(nb_bomb<nb);
		
		 for(int i=0;i<lignes;i++) {//reste des cases (initialisation)
			for(int j=0;j<colonnes;j++) {
				
				if (c_table[i][j]==null) {
					c_table[i][j]=new piece(i,j);
				}
			}
		 }
		 
		
		 for(int i=0;i<lignes;i++) {//modification finales des pieces (nb bombs et image)
			for(int j=0;j<colonnes;j++) {
					c_table[i][j].set_piece();
				}
			 }
		 
		 for(int i=0;i<lignes;i++) {//jlabel tab
				for(int j=0;j<colonnes;j++) {
					
					
				}
			 }
	}
	static void reveal_all(int x,int y) {//x lignes , y colonnes
		for(int i=0;i<lignes;i++) {
			for(int j=0;j<colonnes;j++) {
				piece p=c_table[i][j];
				p.is_revealed=true ;
				if(p.has_bomb) {
					if(p.is_flagged || x==-1) 
						p.icon=new ImageIcon(window.class.getResource("/isbombed 44.jpg"));
					else if(i==x && j==y) 
						p.icon=new ImageIcon(window.class.getResource("/bombed 44.jpg"));
				}
				else if(p.is_flagged && !p.has_bomb) 
					 p.icon=new ImageIcon(window.class.getResource("/wrongflag 44.jpg"));
			window.setIcon(i,j,p.icon);
			}
		}
	}
}
