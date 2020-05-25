import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class premiereFenetre{

	private JPanel contentPane;
	public JFrame frame;
	public int nombreDeLignes;
    public int nombreDeColonnes;
    public int nombreDeBombes;
    public boolean selected=false;
    
    JComboBox comboBox = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();
    JComboBox comboBox_2 = new JComboBox();

	
	
	public premiereFenetre() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		JLabel lblNewLabel = new JLabel("Nombre de lignes :");
		lblNewLabel.setBounds(63, 48, 114, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de colonnes : ");
		lblNewLabel_2.setBounds(63, 101, 143, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		comboBox.setBounds(216, 44, 86, 22);
		frame.getContentPane().add(comboBox);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17","18","19","20","21","22","23","24","25"}));
		comboBox_1.setBounds(216, 97, 86, 22);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreDeLignes =Integer.parseInt((String) comboBox.getSelectedItem());
				nombreDeColonnes =Integer.parseInt((String) comboBox_1.getSelectedItem());
				nombreDeBombes =Integer.parseInt((String) comboBox_2.getSelectedItem());
				selected=true;
			  
			}
		});
		
		btnNewButton.setBounds(155, 205, 120, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de bombes :");
		lblNewLabel_3.setBounds(63, 146, 143, 14);
		frame.getContentPane().add(lblNewLabel_3);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"--","1"}));
		for(int i=2;i<=100;i++) {
			comboBox_2.addItem(Integer.toString(i));
		}
		comboBox_2.setBounds(216, 142, 86, 22);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("                   Personnaliser votre jeu !");
		lblNewLabel_4.setBounds(92, 11, 252, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
	}
	
	
}
