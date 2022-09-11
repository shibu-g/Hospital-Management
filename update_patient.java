package testo1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class update_patient extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel Label4;
	JLabel Label5;
	JLabel Label6;
	JLabel Label61;
	JLabel Label62;
	boolean ck=false;
	private int n=0;
	int temp=0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_patient frame = new update_patient();
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
	public update_patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setUndecorated(true);
		setBounds(500, 5, 545, 700);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(42, 73, 133, 48);
		contentPane.add(lblNewLabel_1);
		
		text= new JTextField();
		text.setFont(new Font("Tahoma", Font.BOLD, 27));
		text.setBounds(206, 81, 180, 42);
		contentPane.add(text);
		text.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Update Patient Record");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(94, 11, 414, 51);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Patient ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(227, 119, 161, 31);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=text.getText();
				int a=Integer.parseInt(id);
				//System.out.println(id);
				int quiry;
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					//ResultSet rs=st.executeQuery("");
					PreparedStatement pst=con.prepareStatement("SELECT id FROM inventory.patient_record WHERE id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					pst.setString(1, id);
					ResultSet ss=pst.executeQuery();
					
					//quiry=ss.getInt(1);
					ss.next();
					//System.out.print(ss.first());
					if(ss.first()) {
						n++;
					     text.setEditable(false);
					     lblNewLabel_3.setForeground(Color.GREEN);
							lblNewLabel_3.setText("Succesfully connected");
							//text.setVisible(true);
							text.setVisible(true);
							text1.setVisible(true);
							text2.setVisible(true);
							text3.setVisible(true);
							lblNewLabel_2.setVisible(true);
							lblNewLabel_3.setVisible(true);
							Label4.setVisible(true);
							Label5.setVisible(true);
							Label6.setVisible(true);
							Label61.setVisible(true);
							Label62.setVisible(true);
							textField.setVisible(true);
							textField_1.setVisible(true);
							textField_2.setVisible(true);
							textField_3.setVisible(true);
							lblNewLabel_4.setVisible(true);
							lblNewLabel_5.setVisible(true);
							lblNewLabel_6.setVisible(true);
							
					}else {
						lblNewLabel_3.setForeground(Color.RED);
						lblNewLabel_3.setText("Wrong ID");
					}

					pst.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Please Fill All the necessory Field");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(407, 87, 101, 30);
		contentPane.add(btnNewButton);
		
		Label4 = new JLabel("Name");
		Label4.setVisible(false);
		Label4.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label4.setForeground(new Color(255, 0, 0));
		Label4.setBounds(27, 185, 180, 42);
		contentPane.add(Label4);
		
		Label5 = new JLabel("Age");
		Label5.setVisible(false);
		Label5.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label5.setForeground(new Color(255, 0, 0));
		Label5.setBounds(27, 243, 133, 33);
		contentPane.add(Label5);
		
		Label6 = new JLabel("Mobile NO");
		Label6.setVisible(false);
		Label6.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label6.setForeground(new Color(255, 0, 0));
		Label6.setBounds(27, 287, 154, 33);
		contentPane.add(Label6);
		
		text1 = new JTextField();
		text1.setVisible(false);
		text1.setFont(new Font("Tahoma", Font.BOLD, 20));
		text1.setBounds(206, 188, 273, 42);
		contentPane.add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setVisible(false);
		text2.setFont(new Font("Tahoma", Font.BOLD, 22));
		text2.setBounds(206, 238, 273, 42);
		contentPane.add(text2);
		text2.setColumns(10);

JButton btnNewButton_1 = new JButton("UPDATE");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	String id=text.getText();
	//Symptom digonosis,digonosis,word tpe
	String ids=text.getText();
	int n2=Integer.parseInt(ids);
	String name=text1.getText();
	String age=text2.getText();
	String mobile=text3.getText();
	String blood_group=textField.getText();
	String gender=textField_1.getText();
	String address=textField_2.getText();
	String problem=textField_3.getText();
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
		Statement st=con.createStatement();
		PreparedStatement pst=con.prepareStatement("UPDATE patient_record SET name=?,age=?,mobile_no=?,blood_group=?,gender=?,address=?,problem=? WHERE id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pst.setString(1, name);
		pst.setString(2, age);
		pst.setString(3, mobile);
		pst.setString(4, blood_group);
		pst.setString(5, gender);
		pst.setString(6, address);
		pst.setString(7, problem);
		pst.setInt(8, n2);
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null,"Successfully updated ");
		setVisible(false);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null,"Enter values in correct format");
	}
	}
});
// btnNewButton_1.setVisible(false);
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 26));
btnNewButton_1.setBounds(47, 566, 149, 48);
contentPane.add(btnNewButton_1);

JButton btnNewButton_2 = new JButton("CANCLE");
//btnNewButton_2.setVisible(false);
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Close?", "Select", JOptionPane.YES_NO_OPTION);
        if(a==0)
            setVisible(false);
	}
});
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 28));
btnNewButton_2.setBounds(291, 566, 171, 48);
contentPane.add(btnNewButton_2);

text3 = new JTextField();
text3.setVisible(false);
text3.setFont(new Font("Tahoma", Font.BOLD, 22));
text3.setColumns(10);
text3.setBounds(206, 291, 273, 42);
//text3.setVisible(false);
contentPane.add(text3);


Label61 = new JLabel("Blood Group");
Label61.setVisible(false);
Label61.setForeground(Color.RED);
Label61.setFont(new Font("Tahoma", Font.BOLD, 22));
Label61.setBounds(21, 344, 154, 33);
contentPane.add(Label61);

Label62 = new JLabel("Gender");
Label62.setVisible(false);
Label62.setForeground(Color.RED);
Label62.setFont(new Font("Tahoma", Font.BOLD, 22));
Label62.setBounds(23, 402, 206, 33);
contentPane.add(Label62);
textField = new JTextField();
textField.setFont(new Font("Tahoma", Font.BOLD, 22));
textField.setVisible(false);
textField.setBounds(206, 344, 273, 42);
contentPane.add(textField);
textField.setColumns(10);
textField_1 = new JTextField();
textField_1.setFont(new Font("Tahoma", Font.BOLD, 22));
textField_1.setVisible(false);
textField_1.setColumns(10);
textField_1.setBounds(206, 393, 273, 42);
contentPane.add(textField_1);
textField_2 = new JTextField();
textField_2.setFont(new Font("Tahoma", Font.BOLD, 22));
textField_2.setVisible(false);
textField_2.setColumns(10);
textField_2.setBounds(206, 446, 273, 42);
contentPane.add(textField_2);
textField_3 = new JTextField();
textField_3.setFont(new Font("Tahoma", Font.BOLD, 22));
textField_3.setVisible(false);
textField_3.setColumns(10);
textField_3.setBounds(206, 499, 273, 42);
contentPane.add(textField_3);
lblNewLabel_4 = new JLabel("Address");
lblNewLabel_4.setVisible(false);
lblNewLabel_4.setForeground(new Color(255, 0, 0));
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
lblNewLabel_4.setBounds(27, 446, 180, 42);
lblNewLabel_5 = new JLabel("Problem");
lblNewLabel_5.setVisible(false);
lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
lblNewLabel_5.setForeground(new Color(255, 0, 0));
lblNewLabel_5.setBounds(27, 505, 133, 30);
contentPane.add(lblNewLabel_5);
lblNewLabel_6 = new JLabel("Address");
lblNewLabel_6.setVisible(false);
lblNewLabel_6.setForeground(new Color(255, 0, 0));
lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
lblNewLabel_6.setBounds(22, 446, 159, 42);
contentPane.add(lblNewLabel_6);

JLabel lblNewLabel = new JLabel("");
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
lblNewLabel.setForeground(new Color(255, 255, 255));
lblNewLabel.setIcon(new ImageIcon("G:\\MY PHONE\\HD Wallpapers\\Image_160793_1549710834.jpeg"));
lblNewLabel.setBounds(0, 0, 545, 700);
contentPane.add(lblNewLabel);
}
}

