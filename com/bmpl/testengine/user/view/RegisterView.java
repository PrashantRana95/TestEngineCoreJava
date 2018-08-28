package com.bmpl.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengine.common.dto.CommonConstants;
import com.bmpl.testengine.common.dto.MessageDTO;
import com.bmpl.testengine.quiz.view.Test;
import com.bmpl.testengine.user.dto.UserDTO;
import com.bmpl.testengine.user.helper.UserHelper;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//All the Registration related stuff is done here 
public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	//private JTextField textField_3;
	JLabel weakStronglbl = new JLabel("");
	int maxChars = 10;
	JTextField textField_3 = new JTextField();
	int leftChar = maxChars;
	JLabel leftnumbers = new JLabel("10");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		RegisterView frame = new RegisterView();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setLocationRelativeTo(null);
	
		setResizable(false);
		setTitle("Register Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRegister = new JLabel("");
		lblRegister.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/Register-Button-PNG-Photos.png")));
		lblRegister.setBounds(169, 22, 262, 65);
		contentPane.add(lblRegister);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblUserid.setBounds(71, 153, 46, 20);
		contentPane.add(lblUserid);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblNewLabel.setBounds(71, 218, 65, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(257, 151, 150, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				weakStrongPasswordCheck();
			}
		});
		passwordField.setBounds(257, 223, 150, 28);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/reg-icon.png")));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRegister();
			}
		});
		btnRegister.setBounds(96, 592, 139, 58);
		contentPane.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/resetB.png")));
		btnReset.setBounds(339, 592, 139, 58);
		contentPane.add(btnReset);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblGender.setBounds(71, 280, 65, 28);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(302, 280, 57, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(432, 280, 75, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblPerson = new JLabel("Person");
		lblPerson.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblPerson.setBounds(71, 349, 46, 14);
		contentPane.add(lblPerson);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/People.png")));
		lblNewLabel_1.setBounds(169, 138, 46, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/pass.png")));
		lblNewLabel_2.setBounds(169, 204, 46, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/People.png")));
		label.setBounds(257, 265, 46, 43);
		contentPane.add(label);
		
		JLabel pwderror = new JLabel("");
		pwderror.setForeground(Color.RED);
		pwderror.setBounds(257, 201, 193, 14);
		contentPane.add(pwderror);
		
		
		weakStronglbl.setForeground(Color.GREEN);
		weakStronglbl.setBounds(410, 230, 125, 14);
		contentPane.add(weakStronglbl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher"}));
		comboBox.setBounds(260, 344, 111, 25);
		contentPane.add(comboBox);
		
		JLabel lblEnrollnoteacherId = new JLabel("EnrollNo/ID");
		lblEnrollnoteacherId.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblEnrollnoteacherId.setBounds(71, 407, 85, 35);
		contentPane.add(lblEnrollnoteacherId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 412, 185, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(257, 476, 185, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblMobileNo.setBounds(71, 540, 65, 20);
		contentPane.add(lblMobileNo);
		
		JLabel label_1 = new JLabel("+91");
		label_1.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		label_1.setBounds(228, 540, 30, 20);
		contentPane.add(label_1);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				computeNoOfCharLeft();
			}
		});
		
		
		textField_3.setBounds(258, 538, 153, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		leftnumbers.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		leftnumbers.setBounds(432, 541, 46, 19);
		contentPane.add(leftnumbers);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/female.png")));
		lblNewLabel_3.setBounds(385, 265, 46, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblRegisteredEmailId = new JLabel("Email ID");
		lblRegisteredEmailId.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblRegisteredEmailId.setBounds(71, 475, 65, 26);
		contentPane.add(lblRegisteredEmailId);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/mobile.png")));
		label_2.setBounds(169, 531, 46, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/happy.png")));
		label_3.setBounds(169, 344, 46, 35);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/Gender.png")));
		label_4.setBounds(169, 273, 46, 35);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/Email.png")));
		label_5.setBounds(169, 469, 46, 35);
		contentPane.add(label_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(RegisterView.class.getResource("/com/bmpl/testengine/images/rollno.png")));
		lblNewLabel_4.setBounds(169, 407, 46, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel useriderror = new JLabel("");
		useriderror.setForeground(Color.RED);
		useriderror.setBounds(257, 126, 150, 14);
		contentPane.add(useriderror);
	}
	
	
	//This method is used for counting no of characters
		private void computeNoOfCharLeft(){
			if(leftChar>0){
			 leftChar = maxChars - textField_3.getText().length();
			 leftnumbers.setText(String.valueOf(leftChar));
			}
			if(leftChar==0){
				textField_3.setEnabled(false);
			}
			
		}
		
		//This method is used to check the strong weak password
		private void weakStrongPasswordCheck(){
			//using this we will get passwordfield data
			String data = passwordField.getText();
			//This will check the length of data
			if(data.length()<5){
				weakStronglbl.setText("Weak");
			}
			if(data.length()>=5 && data.length()<=10){
				weakStronglbl.setText("Average");
			}
			if(data.length()>10){
				weakStronglbl.setText("Strong");
			}
		}
		
		
	//This will register the users
	private void doRegister(){
		String userid = textField.getText();
		String pwd = passwordField.getText();
		//Takes object from userDTO
		UserDTO userDTO = new UserDTO();
		//UserDTO will set the value retrieves from the userid and password
		userDTO.setUserid(userid);
		userDTO.setPassword(pwd);
		//UserDTO is sending its message to the userHelper
		UserHelper userHelper = new UserHelper();
		try {
			//If it is registered messageDTO will send the success message 
			MessageDTO msgDTO = userHelper.isRegister(userDTO);
			if(msgDTO.getStatus()==CommonConstants.SUCCESS){
				JOptionPane.showMessageDialog(this, msgDTO.getMessage());
				this.setVisible(false);
				this.dispose();
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this, msgDTO.getMessage());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
