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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;

public class patient_history extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_history frame = new patient_history();
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
	public patient_history() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(450, 10, 753, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full History Of Patient");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(190, 11, 483, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter patient ID");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblNewLabel_2.setBounds(74, 82, 254, 35);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(274, 82, 277, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBounds(21, 145, 533, 187);
		//table.set
		table.setBackground(Color.WHITE);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Exit?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0)
		            setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(564, 275, 166, 35);
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id=textField.getText();
				
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","shibu7462");
					Statement st=con.createStatement();
					//ResultSet rs=st.executeQuery("");
					PreparedStatement pst=con.prepareStatement("SELECT id FROM inventory.patient_record WHERE id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					pst.setString(1, id);
					ResultSet ss=pst.executeQuery();
					ss.next();
					if(ss.first()) {
						//System.out.print("hi");
					//Statement sts=con.createStatement();
					PreparedStatement psst=con.prepareStatement("SELECT p.id as id,p.name as NAME,p.age AS AGE,p.problem AS PROBLEM,u.symptom AS SYMPTOM,u.diagonosis AS DIAGONOSIS,u.medecine AS MEDECINE FROM inventory.patient_record P JOIN update_record u USING(id)",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					//psst.setString(1, id);
					ResultSet rs=psst.executeQuery();
				    rs.next();
				    table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				    table.setModel(DbUtils.resultSetToTableModel(rs));
				   //table.setmo
					}
					else {
						JOptionPane.showMessageDialog(null,"Enter Currect Id!!!");
					}
				}
				catch (SQLException e1) {
					System.out.print(e);
					//JOptionPane.showMessageDialog(null,"Connection Problem");
				}
			}
				
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.setBounds(561, 82, 166, 35);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\godafoss_waterfall_iceland_2-wallpaper-1366x768.jpg"));
		lblNewLabel.setBounds(0, 0, 753, 382);
		contentPane.add(lblNewLabel);
	}
}
