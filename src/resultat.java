import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class resultat {
	boolean selected=false;
	boolean newgame=false;
	boolean playagain=false;
	public JFrame frame;

	public resultat(String s) {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(121, 123, 127));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 550);
		frame.getContentPane().setLayout(null);
		
		
		frame.setLocationRelativeTo(null);
		
		
		JLabel lb1 = new JLabel();
		lb1.setBounds(10, 11, 391, 102);
		frame.getContentPane().add(lb1);
		lb1.setIcon(new ImageIcon(window.class.getResource("/"+s+".png")));
		
		JLabel lb2 = new JLabel();
		lb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected=true;
				playagain=true;
			}
		});
		lb2.setBounds(106, 169, 223, 68);
		frame.getContentPane().add(lb2);
		lb2.setIcon(new ImageIcon(window.class.getResource("/playagain.png")));
		
		JLabel lb3 = new JLabel();
		lb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected=true;
				newgame=true;
			}
		});
		lb3.setBounds(104, 265, 227, 68);
		frame.getContentPane().add(lb3);
		lb3.setIcon(new ImageIcon(window.class.getResource("/newgame.png")));
		
		JLabel lb = new JLabel();
		lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lb.setBounds(150, 425, 139, 68);
		frame.getContentPane().add(lb);
		lb.setIcon(new ImageIcon(window.class.getResource("/exit.png")));
	}

}
