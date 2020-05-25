import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class window {
	public JFrame frame;
	 //private int nb_bombs;
	static JLabel [][] labels;
	boolean fin=false;
	boolean won=false;
	boolean start=false;
	int lignes;
	int colonnes;
	int nb_bombs;
	//zone Zone;
	int w=44;
	public window(int nb,int i,int j) {
		this.lignes=i;
		this.colonnes=j;
		this.nb_bombs=nb;
		labels=new JLabel[lignes][colonnes];//conteneur des images
		
		show();

	}
	private void show() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(48, 53, 59));
		frame.setSize(colonnes*w+17+20, lignes*w +40+20);
		//frame.setBounds(10,10, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		for(int i=0;i<lignes;i++) {//jlabel tab
			for(int j=0;j<colonnes;j++) {
				labels[i][j]=new JLabel();
				labels[i][j].setBounds(j*w+10,i*w+10, w, w);
				frame.getContentPane().add(labels[i][j]);
				setIcon(i,j,new ImageIcon(window.class.getResource("/void 44.jpg")));
				
			}
		 }
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				if(x>=10 && y>=10 && x<=(10+w*colonnes)&&y<=(10+w*lignes)) {
					test_mouse(x,y,e);
					int nb=test_won(lignes,colonnes);
					if (nb==nb_bombs) {
						zone.reveal_all(-1,-1);
						won=true;
						fin=true;
					}
				}
			}
		});
		
	}
	
	public void test_mouse(int x,int y,MouseEvent e) {
		int i=(y-10)/w;//lignes
		int j=(x-10)/w;//colonnes
		if(e.getButton()==1) {//left button
			if(!start) {
				zone Zone=new zone(nb_bombs ,lignes,colonnes,i,j);
				start=true;
			}
			if(!zone.c_table[i][j].is_flagged) {
			
					if(zone.c_table[i][j].has_bomb) {
						zone.reveal_all(i,j);
						fin=true;
					}
					else if(!zone.c_table[i][j].is_revealed ) {
						setIcon(i,j,zone.c_table[i][j].icon);
						zone.c_table[i][j].reveal();
					}
				}
		}
		else if(e.getButton()==3) {
				if(!zone.c_table[i][j].is_revealed ) {
					if( !zone.c_table[i][j].is_flagged) {
						zone.c_table[i][j].is_flagged=true;
						labels[i][j].setIcon(new ImageIcon(window.class.getResource("/flag 44.jpg")));
					}else {
						zone.c_table[i][j].is_flagged=false;
						labels[i][j].setIcon(new ImageIcon(window.class.getResource("/void 44.jpg")));
					}
				}
			}
	}
	public static int test_won(int l,int c) {
		int nb=0;
		for(int i=0;i<l;i++) {
			for(int j=0;j<c;j++) {
				if(!zone.c_table[i][j].is_revealed) {
					nb++;
				}
			}
		}
		return nb;
	}
	public static void setIcon(int i,int j,ImageIcon img) {
		labels[i][j].setIcon(img);
	}
}
