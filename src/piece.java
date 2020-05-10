import javax.swing.ImageIcon;

public class piece {
	public boolean is_revealed=false;
	public boolean is_flagged=false;
	public boolean has_bomb=false;
	public int close_bombs=0;
	ImageIcon icon;
	int i;
	int j;
	public piece(int l,int c){
		this.i=l;
		this.j=c;
	}
	public void reveal() {
		if(!this.is_flagged &&!this.is_revealed) {
			this.is_revealed=true;
			window.setIcon(i, j, this.icon);
			if(this.close_bombs==0	) {
				for(int k=this.i-1;k<=this.i+1;k++) {
					for(int h=this.j-1;h<=this.j+1;h++) {
						if(!(k==this.i && h==this.j) && k>=0 && k<zone.lignes && h>=0 && h<zone.colonnes) {
							zone.c_table[k][h].reveal();
						}
					}
				}
			}
		}
	}
	public void set_piece() {
		calc_bombs();
		set_img();
	}
	public void calc_bombs() {
		for(int k=this.i-1;k<=this.i+1;k++) {
			for(int h=this.j-1;h<=this.j+1;h++) {
				if(!this.has_bomb && !(k==this.i && h==this.j) && k>=0 && k<zone.lignes && h>=0 && h<zone.colonnes) {
					if (zone.c_table[k][h].has_bomb) this.close_bombs++;
				}
			}
		}
	}
	public void set_img() {
		String path;
		if(!this.has_bomb) path="/"+this.close_bombs+" 44.jpg";
		else path="/bomb 44.jpg";
		icon=new ImageIcon(window.class.getResource(path));
	}
	
}

