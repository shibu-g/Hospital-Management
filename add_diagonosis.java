package testo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class add_diagonosis extends JFrame {

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
	JComboBox comboBox;
	JCheckBox CheckBox;
	JLabel Label61;
	JLabel Label62;
	boolean ck=false;
	private int n=0;
	int temp=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_diagonosis frame = new add_diagonosis();
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
	public add_diagonosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_2 = new JLabel("Add Diagonosis Information");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(65, 11, 414, 51);
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
							//comboBox.setVisible(true);
							CheckBox.setVisible(true);
							Label61.setVisible(true);
							//Label62.setVisible(true);
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
		
		Label4 = new JLabel("Symptom");
		Label4.setVisible(false);
		Label4.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label4.setForeground(new Color(255, 0, 0));
		Label4.setBounds(42, 225, 180, 42);
		contentPane.add(Label4);
		
		Label5 = new JLabel("Diagnosis");
		Label5.setVisible(false);
		Label5.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label5.setForeground(new Color(255, 0, 0));
		Label5.setBounds(42, 296, 133, 33);
		contentPane.add(Label5);
		
		Label6 = new JLabel("Medicines");
		Label6.setVisible(false);
		Label6.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label6.setForeground(new Color(255, 0, 0));
		Label6.setBounds(42, 368, 154, 33);
		contentPane.add(Label6);
		
		text1 = new JTextField();
		text1.setVisible(false);
		text1.setFont(new Font("Tahoma", Font.BOLD, 20));
		text1.setBounds(206, 225, 273, 42);
		contentPane.add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setVisible(false);
		text2.setFont(new Font("Tahoma", Font.BOLD, 22));
		text2.setBounds(206, 293, 273, 42);
		contentPane.add(text2);
		text2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setVisible(false);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "DULUX", "EXTRA DULUX"}));
		comboBox.setBounds(272, 484, 236, 42);
		contentPane.add(comboBox);
		
		CheckBox = new JCheckBox("YES");
		CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(temp%2==0) {
				comboBox.setVisible(true);
				Label62.setVisible(true);
				ck=true;
				temp++;
			}
			else {
				comboBox.setVisible(false);
				Label62.setVisible(false);
				ck=false;
				temp++;
			}
			}
		});
		//CheckBox.action(null, btnNewButton)
		CheckBox.setVisible(false);
		CheckBox.setFont(new Font("Tahoma", Font.BOLD, 24));
		CheckBox.setBounds(272, 433, 236, 39);
		contentPane.add(CheckBox);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String id=text.getText();
			//Symptom digonosis,digonosis,word tpe
			String ids=text.getText();
			int n2=Integer.parseInt(ids);
			String symptom=text1.getText();
	    	String digonosis=text2.getText();
			String medecine=text3.getText();
			String wordneed="";
			String type=(String) comboBox.getSelectedItem();
			if(ck) wordneed="YES";
			else{
				wordneed="NO";
				type="";
			}
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
				Statement st=con.createStatement();
				PreparedStatement pst=con.prepareStatement("INSERT INTO update_record VALUES(?,?,?,?,?,?)");
				pst.setInt(1, n2);
				pst.setString(2, symptom);
				pst.setString(3,digonosis);
				pst.setString(4, medecine);
				pst.setString(5, wordneed);
				pst.setString(6, type);
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
		text3.setBounds(206, 359, 273, 42);
		//text3.setVisible(false);
		contentPane.add(text3);
		
		
		Label61 = new JLabel("WORD NEED");
		Label61.setVisible(false);
		Label61.setForeground(Color.RED);
		Label61.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label61.setBounds(42, 431, 154, 33);
		contentPane.add(Label61);
		
		Label62 = new JLabel("TYPE OF WORD");
		Label62.setVisible(false);
		Label62.setForeground(Color.RED);
		Label62.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label62.setBounds(42, 488, 206, 33);
		contentPane.add(Label62);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("G:\\MY PHONE\\HD Wallpapers\\Image_356762_1552725005.jpeg"));
		lblNewLabel.setBounds(0, 0, 545, 700);
		contentPane.add(lblNewLabel);
	}
}
