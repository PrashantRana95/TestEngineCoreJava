package com.bmpl.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import com.bmpl.testengine.common.dto.CommonConstants;
import com.bmpl.testengine.common.dto.MessageDTO;
import com.bmpl.testengine.quiz.view.Test;
import com.bmpl.testengine.user.dao.UserDAO;
import com.bmpl.testengine.user.dto.UserDTO;
import com.bmpl.testengine.user.helper.UserHelper;
import com.bmpl.testengine.user.helper.UserValidation;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

//All the designing is done here
//All the login design is done here
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel useriderror = new JLabel("");
	JLabel pwderror = new JLabel("");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginScreen = new JLabel("");
		lblLoginScreen.setIcon(new ImageIcon(LoginView.class.getResource("/com/bmpl/testengine/images/Staff-Login.png")));
		lblLoginScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginScreen.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblLoginScreen.setBounds(94, 0, 248, 82);
		contentPane.add(lblLoginScreen);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblUserid.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserid.setBounds(74, 107, 53, 24);
		contentPane.add(lblUserid);
		
		textField = new JTextField();
		textField.setBounds(198, 106, 132, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 17));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(74, 169, 62, 22);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 168, 132, 25);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(LoginView.class.getResource("/com/bmpl/testengine/images/access_key-512.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//On the click of login button the action will be performed 
			checkUserAuth();
			}
		});
		btnLogin.setBounds(68, 234, 132, 52);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(LoginView.class.getResource("/com/bmpl/testengine/images/resetB.png")));
		btnReset.setBounds(239, 234, 132, 52);
		contentPane.add(btnReset);
		
		useriderror.setForeground(Color.RED);
		useriderror.setBounds(198, 87, 132, 14);
		contentPane.add(useriderror);
		
		pwderror.setForeground(Color.RED);
		pwderror.setBounds(197, 148, 224, 14);
		contentPane.add(pwderror);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/com/bmpl/testengine/images/People.png")));
		lblNewLabel.setBounds(138, 98, 35, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/com/bmpl/testengine/images/pass.png")));
		lblNewLabel_1.setBounds(140, 163, 35, 41);
		contentPane.add(lblNewLabel_1);
	}
	
	
	//This method is for login checks if user is authenticate user or not
	private void checkUserAuth(){
		//This is used to get the user id with the help of get text method to get the text from the textField
		String userid=textField.getText();
		//This is used to get the password in the password field using get text
		String pwd=passwordField.getText();
		
		//This isValidationFail will tell us weather or not validation checks or not
		boolean isValidationFail = false;
		//This will take the isBlank method from the UserValidation class..as for static method they do not require the object creation
		if(UserValidation.isBlank(userid)){
			//We would then print this in the user id error label
			useriderror.setText("UserID Can't be Blank");
			//Then isValidaton is sets to true
			isValidationFail = true;
		}
		//else condition checks that if above fails then login must have some data so false then blank field
		else{
			useriderror.setText("");
		}
		//This will check for the password
		if(UserValidation.checkMinLength(pwd, 4)){
			pwderror.setText("Password must be 8 characters each");
			isValidationFail = true;
		}
		else
		{
			pwderror.setText("");
		}
		if(isValidationFail){
			return ;
		}
		
		
		//UserDTO is basically used to transfer the multiple objects 
		//This UserDTO is used to check the validation and send the user id and password..used to transfer the objects
		UserDTO userDTO = new UserDTO();
		//Will calls the setters here..sets the user id and password that we are taking from the screen
		userDTO.setUserid(userid);
		userDTO.setPassword(pwd);
		
		/*
		//Now the data from here on will pass to userDAO
		//UserDAO is used because to send the data from dto to userdao
		UserDAO userDAO = new UserDAO();
		//The userDTo will pass on to the userDAO that will validate from file..as userDTO is data transfer object
		userDAO.checkUserExist(userDTO);
		*/
		
		//View will send its user DTO to helper and helper will again send this to dao 
		//This userHelper is used here so that it can now send the messages to the userDAO
		UserHelper userHelper = new UserHelper();
		//Now this will calls the isCheckExists
		MessageDTO messageDTO = null;
		try {
			messageDTO = userHelper.isCheckExist(userDTO);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Exception Raised...."+e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Exception Raised...."+e);
		}
		
		//Now here we will check for the messages from the helper and redirect to Test
		if(messageDTO.getStatus()==CommonConstants.SUCCESS){
			//Upon Welcome Visible the Test
			Test test = new Test(messageDTO.getMessage());
			test.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
		//else this condition fails then returns message fails with the date on which it fails
		else 
		if(messageDTO.getStatus()==CommonConstants.FAIL){
			JOptionPane.showMessageDialog(this, messageDTO.getMessage()+""+messageDTO.getDate());
		}
			
	}
}
