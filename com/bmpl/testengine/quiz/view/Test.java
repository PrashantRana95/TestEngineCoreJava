package com.bmpl.testengine.quiz.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengine.user.view.RegisterView;

public class Test extends JFrame {

	private JPanel contentPane;
	private Timer timer;
	int maxTime=30;
	private JTextField textField;
	JLabel option1 = new JLabel("A:");
	JLabel option2 = new JLabel("B:");
	JLabel option3 = new JLabel("C:");
	JLabel option4 = new JLabel("D.");
	
	/**
	 * Create the frame.
	 */
	public Test(String message) {
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTestStart = new JLabel("Test Start "+message);
		lblTestStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestStart.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblTestStart.setForeground(Color.RED);
		lblTestStart.setBackground(Color.ORANGE);
		lblTestStart.setBounds(175, 39, 385, 89);
		contentPane.add(lblTestStart);
		
		JLabel quesLbl = new JLabel("Question 1");
		quesLbl.setBounds(47, 131, 660, 107);
		contentPane.add(quesLbl);
		
		JLabel lblTimeleft = new JLabel("TimeLeft");
		lblTimeleft.setBounds(646, 11, 84, 44);
		contentPane.add(lblTimeleft);
		
		JLabel label = new JLabel("30:00");
		label.setBounds(752, 12, 46, 43);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(47, 437, 530, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmitAnswer = new JButton("Submit Answer");
		btnSubmitAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitAnswer();
			}
		});
		btnSubmitAnswer.setBounds(642, 437, 156, 50);
		contentPane.add(btnSubmitAnswer);
		
		JButton btnTestCompleted = new JButton("Test Completed");
		btnTestCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCompleted();
			}
		});
		btnTestCompleted.setBounds(642, 77, 156, 51);
		contentPane.add(btnTestCompleted);
		
		JButton btnPreviousQuestion = new JButton("Previous Question");
		btnPreviousQuestion.setBounds(87, 527, 147, 50);
		contentPane.add(btnPreviousQuestion);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.setBounds(587, 527, 156, 50);
		contentPane.add(btnNextQuestion);
		
		option4.setBounds(47, 380, 567, 14);
		contentPane.add(option4);
		
		option3.setBounds(47, 337, 46, 14);
		contentPane.add(option3);
		
		option2.setBounds(47, 303, 46, 14);
		contentPane.add(option2);
		
		option1.setBounds(47, 261, 46, 14);
		contentPane.add(option1);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
//		g.drawOval(50, 10, 30, 30);
		g.setColor(Color.RED);
		g.fillOval(100, 75, 15, 15);
		g.fillOval(140, 75, 15, 15);
		g.fillOval(180, 75, 15, 15);
	}
	
	private void submitAnswer(){
		
		
	}
	
	private void testCompleted(){
		
		
	}
}