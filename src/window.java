import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JSlider;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;


public class window {
	

	private JFrame frame;
	int w=44;
	int lignes=8;
	int colonnes=8;
	int nb_bombs=15;
	boolean fin=false;
	piece[][] c_table;
	JLabel [][] labels;
	Random r=new Random();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public window() {
		create(nb_bombs);
		show();

	}
	
	public void test_mouse(int x,int y,MouseEvent e) {
		int i=y/w;//lignes
		int j=x/w;//colonnes
		if(e.getButton()==1) {//left button
			
			if(c_table[i][j].has_bomb) {
				fin=true;
				reveal_all(i,j);
			}
			else if(!c_table[i][j].is_revealed) {
				labels[i][j].setIcon(c_table[i][j].icon);
				c_table[i][j].reveal();
			}
			
		}
		else if(e.getButton()==3) {
			if(!c_table[i][j].is_revealed ) {
				if( !c_table[i][j].is_flagged) {
					c_table[i][j].is_flagged=true;
					labels[i][j].setIcon(new ImageIcon(window.class.getResource("/flag 44.jpg")));
				}else {
					c_table[i][j].is_flagged=false;
					labels[i][j].setIcon(new ImageIcon(window.class.getResource("/void 44.jpg")));
				}
			}
		}
	}
	void reveal_all(int x,int y) {//x lignes , y colonnes
		for(int i=0;i<lignes;i++) {
			for(int j=0;j<colonnes;j++) {
				piece p=c_table[i][j];
				p.is_revealed=true ;
				if(p.has_bomb) {
					if(i==x && j==y) 
						p.icon=new ImageIcon(window.class.getResource("/bombed 44.jpg"));
					if(p.is_flagged ) 
						p.icon=new ImageIcon(window.class.getResource("/isbombed 44.jpg"));
				}
				else if(p.is_flagged && !p.has_bomb) 
					 p.icon=new ImageIcon(window.class.getResource("/wrongflag 44.jpg"));
			labels[i][j].setIcon(p.icon);
			}
		}
	}
	
	
	private void show() {
		
		frame = new JFrame();
		frame.setSize(colonnes*w+17+200, lignes*w +40);
		//frame.setBounds(10,10, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), null, null, null));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(406, 0,147, 352);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 28, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton start = new JButton("New button");
		start.setActionCommand("start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		start.setBounds(30, 169, 89, 23);
		panel.add(start);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(30, 270, 89, 23);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 69, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(30, 107, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		for(int i=0;i<lignes;i++) {//jlabel tab
			for(int j=0;j<colonnes;j++) {
				
				frame.getContentPane().add(labels[i][j]);
			}
		 }
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				test_mouse(e.getX(),e.getY(),e);
			}
		});
	}
	private void create(int nb) {
		
		 c_table=new piece[lignes][colonnes];

		 labels=new JLabel[lignes][colonnes];//conteneur des images
		 int nb_bomb=0;
		 do { //case bombs first
			int r_l=r.nextInt(lignes);
			int r_c=r.nextInt(colonnes);
			if(c_table[r_l][r_c]==null) {
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
					labels[i][j]=new JLabel();
					labels[i][j].setIcon(new ImageIcon(window.class.getResource("/void 44.jpg")));
					labels[i][j].setBounds(j*w,i*w, w, w);
				}
			 }
	}
	
	
	class piece{
		boolean is_revealed=false;
		boolean is_flagged=false;
		boolean has_bomb=false;
		int close_bombs=0;
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
				labels[i][j].setIcon(this.icon);
				if(this.close_bombs==0	) {
					for(int k=this.i-1;k<=this.i+1;k++) {
						for(int h=this.j-1;h<=this.j+1;h++) {
							if(!(k==this.i && h==this.j) && k>=0 && k<lignes && h>=0 && h<colonnes) {
								c_table[k][h].reveal();
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
					if(!this.has_bomb && !(k==this.i && h==this.j) && k>=0 && k<lignes && h>=0 && h<colonnes) {
						if (c_table[k][h].has_bomb) this.close_bombs++;
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
}
