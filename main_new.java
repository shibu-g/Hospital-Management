package testo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class main_new extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_new frame = new main_new();
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
	public main_new() {
		setTitle("MAIN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Patient");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

        		new addnew().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 27));
		btnNewButton.setBounds(38, 108, 389, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Patient Record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new update_patient().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		btnNewButton_1.setBounds(38, 186, 389, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("AddDiagnosisInformation");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new add_diagonosis().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		btnNewButton_1_1.setBounds(38, 259, 389, 45);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("FullHistoryOfPatients");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new patient_history().setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Segoe UI", Font.BOLD, 27));
		btnNewButton_1_2.setBounds(38, 334, 389, 45);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("LOG OUT");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "DO YOU WANT TO Log Out ?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0) {
		            setVisible(false);
		            new log_in().setVisible(true);
		        }
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnNewButton_1_3.setBounds(38, 481, 389, 41);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_2_1 = new JButton("Delete Patient Record");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new delete_patient().setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		btnNewButton_1_2_1.setBounds(38, 407, 389, 45);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("G:\\html\\bay_10-wallpaper-1366x768.jpg"));
		lblNewLabel.setBounds(0, 0, 1366, 768);
		contentPane.add(lblNewLabel);
	}
}
