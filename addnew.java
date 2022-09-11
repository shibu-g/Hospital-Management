package testo1;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class addnew extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addnew frame = new addnew();
					frame.setLocation(350,0);
					frame.setSize(550,623);
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
	public addnew() {
		setTitle("ADD NEW PATIENT");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//setBounds(0, 0, 1366, 768);
		setLocation(550,0);
		setSize(512,623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ok = new JButton("ADD PATIENT");
		ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=text.getText();
				String age=text1.getText();
				String mobile_no=text2.getText();
				String blood_group=text3.getText();
				String gender=text4.getText();
				String address=text5.getText();
				String problem=text6.getText();
				
				try{
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
		        Statement st=con.createStatement();
		        PreparedStatement pst=con.prepareStatement("INSERT INTO patient_record(name,age,mobile_no,blood_group,gender,address,problem) VALUES(?,?,?,?,?,?,?)");
		        pst.setString(1, name);
		        pst.setString(2, age);
		        pst.setString(3, mobile_no);
		        pst.setString(4, blood_group);
		        pst.setString(5, gender);
		        pst.setString(6, address);
		        pst.setString(7, problem);
		        pst.executeUpdate();
		        //int ss=st.executeUpdate("INSERT INTO new_table(name) VALUES(?)");//EXCCECUTE QUERY
		       // ss.setString(1,id);
		        ResultSet sse=st.executeQuery("SELECT last_insert_id()");
		        sse.next();
		        String last_id=sse.getString(1);
		        JOptionPane.showMessageDialog(null,"Successfully updated! \n New Patient ID is " + last_id + ".");
		        setVisible(false);
		        new addnew().setVisible(true);
		        }
		    catch(Exception er){

	            JOptionPane.showMessageDialog(null,"Enter values in correct format");
			}
			}
		});
		ok.setBounds(24, 535, 183, 40);
		contentPane.add(ok);
		
		JButton btnNewButton_1 = new JButton("CANCLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Close?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0)
		            setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(258, 535, 171, 40);
		contentPane.add(btnNewButton_1);
		
		text = new JTextField();
		text.setBounds(246, 123, 183, 40);
		contentPane.add(text);
		text.setColumns(20);
		text.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text1 = new JTextField();
		text1.setBounds(246, 187, 183, 40);
		contentPane.add(text1);
		text1.setColumns(10);
		text1.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text2 = new JTextField();
		text2.setBounds(246, 238, 183, 40);
		contentPane.add(text2);
		text2.setColumns(10);
		text2.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text3 = new JTextField();
		text3.setBounds(246, 289, 183, 40);
		contentPane.add(text3);
		text3.setColumns(10);
		text3.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text4 = new JTextField();
		text4.setBounds(246, 340, 183, 40);
		contentPane.add(text4);
		text4.setColumns(10);
		text4.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text5 = new JTextField();
		text5.setBounds(246, 391, 183, 40);
		contentPane.add(text5);
		text5.setColumns(10);
		text5.setFont(new Font ("ARIEL",Font.BOLD,25));
		
		text6 = new JTextField();
		text6.setFont(new Font("Dialog", Font.BOLD, 25));
		text6.setColumns(10);
		text6.setBounds(246, 447, 183, 40);
		text6.setFont(new Font ("ARIEL",Font.BOLD,25));
		contentPane.add(text6);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setForeground(new Color(0, 255, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(40, 122, 200, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setForeground(new Color(0, 255, 64));
		lblNewLabel_2.setBounds(40, 186, 217, 40);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE NO");
		lblNewLabel_3.setForeground(new Color(0, 255, 64));
		lblNewLabel_3.setBounds(42, 238, 215, 40);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BLOOD GROUP");
		lblNewLabel_4.setForeground(new Color(0, 255, 64));
		lblNewLabel_4.setBounds(40, 289, 217, 35);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GENDER");
		lblNewLabel_5.setForeground(new Color(0, 255, 64));
		lblNewLabel_5.setBounds(40, 339, 217, 40);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_2 = new JLabel("PROBLEM");
		lblNewLabel_5_2.setForeground(new Color(0, 255, 64));
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_2.setBounds(40, 446, 217, 40);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("ADDDRESS");
		lblNewLabel_5_3.setForeground(new Color(0, 255, 64));
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_3.setBounds(35, 390, 205, 40);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_6 = new JLabel("ADD NEW PATIENT");
		lblNewLabel_6.setForeground(new Color(255, 0, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_6.setBounds(108, 11, 425, 51);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 512, 623);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shibu Gope\\Downloads\\pexels-james-wheeler-417074 (1).jpg"));
		contentPane.add(lblNewLabel);
		lblNewLabel.setLabelFor(ok);
	}
}
