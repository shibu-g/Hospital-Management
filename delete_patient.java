package testo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class delete_patient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lbl1;
	JButton btn;
	JLabel lbl2;
	JLabel lbl3 ;
	JButton btn1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_patient frame = new delete_patient();
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
	public delete_patient() {
		setUndecorated(true);
		setTitle("Delete Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550,20,512,623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("Delete A Patient");
		lbl1.setForeground(new Color(255, 0, 0));
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl1.setBounds(98, 0, 296, 68);
		contentPane.add(lbl1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 23));
		textField.setBounds(37, 90, 238, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("Search");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				int a=Integer.parseInt(id);
				//System.out.println(id);
				int quiry;
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					//ResultSet rs=st.executeQuery("");
					PreparedStatement pst=con.prepareStatement("SELECT * FROM inventory.patient_record WHERE id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					pst.setString(1, id);
					ResultSet ss=pst.executeQuery();
					
					//quiry=ss.getInt(1);
					ss.next();
					//System.out.print(ss.first());
					if(ss.first()) {
						textField.setEditable(false);
						lbl2.setText(ss.getString(2));
						lbl2.setVisible(true);
						lbl3.setText(ss.getString(4));
						lbl3.setVisible(true);
						btn1.setVisible(true);
						
					}else {
						lblNewLabel_1.setForeground(Color.RED);
						lblNewLabel_1.setText("Wrong ID");
					}

					pst.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//System.out.print(e1);
					JOptionPane.showMessageDialog(null,"Please Fill All the necessory Field");
				}
			}
		});
		btn.setFont(new Font("Tahoma", Font.BOLD, 26));
		btn.setBounds(344, 84, 142, 51);
		contentPane.add(btn);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(new Color(0, 255, 64));
	
		lbl2.setVisible(false);
		lbl2.setFont(new Font("Sitka Text", Font.BOLD, 28));
		lbl2.setBounds(84, 203, 285, 35);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setForeground(new Color(0, 255, 64));
		lbl3.setVisible(false);
		lbl3.setFont(new Font("Sitka Small", Font.BOLD, 28));
		lbl3.setBounds(84, 249, 296, 35);
		contentPane.add(lbl3);
		
		btn1 = new JButton("Delete Patient");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE ?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0) {
				String id=textField.getText();
				//int a=Integer.parseInt(id);
				//System.out.println(id);
				int quiry;
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					//ResultSet rs=st.executeQuery("");
					PreparedStatement pst=con.prepareStatement("DELETE FROM inventory.patient_record WHERE id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Succesfully Deleted From Record");
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.print(e1);
				//JOptionPane.showMessageDialog(null,"Please Enter id NO");
			}
			}
			}
		});
		btn1.setVisible(false);
		btn1.setForeground(new Color(255, 0, 0));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 37));
		btn1.setBounds(96, 337, 298, 57);
		contentPane.add(btn1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(98, 145, 206, 44);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Close?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0)
		            setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnNewButton.setBounds(98, 446, 296, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setIcon(new ImageIcon("G:\\MY PHONE\\HD Wallpapers\\Image_134919_1544161910.jpeg"));
		lblNewLabel.setBounds(0, 0, 512, 612);
		contentPane.add(lblNewLabel);
	}
}
