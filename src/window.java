import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class window {
	private JFrame frame;
	 //private int nb_bombs;
	static JLabel [][] labels;
	boolean fin=false;
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
		frame.setSize(colonnes*w+17+200, lignes*w +40);
		//frame.setBounds(10,10, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		for(int i=0;i<lignes;i++) {//jlabel tab
			for(int j=0;j<colonnes;j++) {
				labels[i][j]=new JLabel();
				labels[i][j].setBounds(j*w,i*w, w, w);
				frame.getContentPane().add(labels[i][j]);
				setIcon(i,j,new ImageIcon(window.class.getResource("/void 44.jpg")));
				
			}
		 }
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				test_mouse(e.getX(),e.getY(),e);
			}
		});
		
		/*JPanel panel = new JPanel();
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
		textField_2.setColumns(10);*/
		
	}
	
	public void test_mouse(int x,int y,MouseEvent e) {
		int i=y/w;//lignes
		int j=x/w;//colonnes
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
	public static void setIcon(int i,int j,ImageIcon img) {
		labels[i][j].setIcon(img);
	}
}
