package testo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class log_in extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log_in frame = new log_in();
					frame.setVisible(true);

			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public log_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1386, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setForeground(new Color(0, 255, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel_1.setBackground(new Color(255, 0, 128));
		lblNewLabel_1.setBounds(391, 241, 289, 64);
		contentPane.add(lblNewLabel_1);
		
		text = new JTextField();
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(690, 253, 270, 42);
		contentPane.add(text);
		text.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 20));
		pass.setBounds(690, 344, 270, 42);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=text.getText();
				String pas=pass.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					PreparedStatement psst=con.prepareStatement("SELECT * FROM inventory.log_in_info WHERE user_name =?");
					psst.setString(1, id);
					ResultSet rst=psst.executeQuery();
					if(rst.next()) {
						if(rst.getString("pass").equals(pas)) {
							 new main_new().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
							text.setText("");
							pass.setText("");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
						text.setText("");
						pass.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					text.setText("");
					pass.setText("");
					//System.out.print(e1);
					e1.printStackTrace();
				}
				/* if(text.getText().equals("shibu") && pass.getText().equals("shibu123")){
		            setVisible(false); // for Login Page
		           new main_new().setVisible(true);
			}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				}*/
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(430, 475, 210, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Exit ?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0) {
		            System.exit(0);
		            
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(736, 475, 210, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 128));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel_1_1.setBackground(new Color(255, 0, 128));
		lblNewLabel_1_1.setBounds(391, 330, 289, 64);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Create New Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new create_new().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setBounds(1006, 22, 347, 57);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shibu Gope\\Downloads\\pexels-julius-silver-753626.jpg"));
		lblNewLabel.setBounds(0, 0, 1366, 730);
		contentPane.add(lblNewLabel);
	}
}
