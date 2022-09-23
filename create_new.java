package testo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class create_new extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create_new frame = new create_new();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public create_new() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(800, 40, 500, 600);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblNewLabel_1.setBounds(20, 93, 173, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblNewLabel_2.setBounds(20, 153, 162, 43);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 27));
		textField.setBounds(235, 86, 221, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		textField_1.setBounds(235, 148, 221, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN ID");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblNewLabel_2_1.setBounds(20, 216, 162, 43);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		textField_2.setColumns(10);
		textField_2.setBounds(235, 211, 221, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 27));
		textField_3.setColumns(10);
		textField_3.setBounds(235, 280, 221, 38);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ADMIN PASS");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblNewLabel_2_1_1.setBounds(20, 285, 173, 43);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminid=textField_2.getText();
				String adminpass=textField_3.getText();
				String a=textField.getText();
				String b=textField_1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					PreparedStatement psst=con.prepareStatement("SELECT * FROM inventory.log_in_info WHERE user_name =?");
					psst.setString(1, adminid);
					ResultSet rst=psst.executeQuery();
					if(rst.next()) {
						if(rst.getString("pass").equals(adminpass)) {
							 PreparedStatement ps2=con.prepareStatement("INSERT INTO inventory.log_in_info VALUES(?,?)");
							 ps2.setString(1, a);
							 ps2.setString(2, b);
							 ps2.executeUpdate();
							 JOptionPane.showMessageDialog(null,"Admin Id Succesfully created");
						}
						else {
							JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					System.out.print(e1);
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnNewButton.setBounds(20, 394, 187, 52);
		contentPane.add(btnNewButton);
		
		JButton btnCancle = new JButton("CANCLE");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 setVisible(false);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnCancle.setBounds(246, 394, 187, 52);
		contentPane.add(btnCancle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\MY PHONE\\HD Wallpapers\\Image_62399_1547282991.jpeg"));
		lblNewLabel.setBounds(0, 0, 500, 600);
		contentPane.add(lblNewLabel);
	}
}
