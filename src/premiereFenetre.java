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

public class premiereFenetre extends JFrame {

	private JPanel contentPane;
	
   static int  nombreDeLignes;
    static int nombreDeColonnes;
    static int nombreDeBombes;
    
    
    JComboBox comboBox = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();
    JComboBox comboBox_2 = new JComboBox();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					premiereFenetre frame = new premiereFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public premiereFenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("mybackground.jpg")).getImage();
		
		JLabel lblNewLabel = new JLabel("Nombre de lignes :");
		lblNewLabel.setBounds(63, 48, 114, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de colonnes : ");
		lblNewLabel_2.setBounds(63, 101, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
		comboBox.setBounds(216, 44, 86, 22);
		contentPane.add(comboBox);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
		comboBox_1.setBounds(216, 97, 86, 22);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Jouer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				window wind = new window();
				wind.setVisible(true);
				
			}
		});
		
		btnNewButton.setBounds(190, 216, 120, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de bombes :");
		lblNewLabel_3.setBounds(63, 146, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
		comboBox_2.setBounds(216, 142, 86, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("                   Personnaliser l'application");
		lblNewLabel_4.setBounds(92, 11, 252, 14);
		contentPane.add(lblNewLabel_4);
		
		
	}
	
	// la reaction des comboBox(s)
	public void ItemStateChanged(ItemEvent event)
	{
		if(event.getSource() == comboBox)
		{
			nombreDeLignes = (int) comboBox.getSelectedItem();
		}
		if(event.getSource() == comboBox_1)
		{
			nombreDeColonnes = (int) comboBox_1.getSelectedItem();
		}
		if(event.getSource()==comboBox_2)
		{
			nombreDeBombes = (int) comboBox_2.getSelectedItem();
		}
	}
	
	
}
