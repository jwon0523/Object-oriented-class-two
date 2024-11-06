package task9;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class RegMember {
	JFrame frame;
	
	public RegMember() {
		frame = new JFrame("사원 등록");
		
		buildGUI();
		
		frame.setSize(350, 420);
		frame.setLocation(500,300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void buildGUI() {
		frame.add(textFieldLayout(), BorderLayout.NORTH);
		frame.add(inputLayout(), BorderLayout.CENTER);
		frame.add(buttonLayout(), BorderLayout.SOUTH);
	}
	
	private JPanel textFieldLayout() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		
		panel.add(inputNameAndGender());
		panel.add(inputResidentNumber());
		panel.add(inputPanel("주	          소", 22));
		panel.add(inputPanel("부    서    명", 8));
		panel.add(inputPanel("취	          미", 22));
	
		return panel;
	}
	
	private JPanel inputLayout() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("자기소개");
		JTextArea text = new JTextArea();
		text.setLineWrap(true);
		
		panel.add(label, BorderLayout.NORTH);
		panel.add(text, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel buttonLayout() {
		JPanel panel = new JPanel();
		JButton btn1 = new JButton("저장");
		JButton btn2 = new JButton("종료");
		
		panel.add(btn1);
		panel.add(btn2);
		
		return panel;
	}
	
	private JPanel inputNameAndGender() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("성	          명");
		JTextField text = new JTextField(8);
		JLabel label2 = new JLabel("성     별");
		JTextField text2 = new JTextField(3);
		
		panel.add(label);
		panel.add(text);
		panel.add(label2);
		panel.add(text2);
		
		return panel;
	}
	
	private JPanel inputResidentNumber() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("주민등록번호");
		JTextField text = new JTextField(6);
		JLabel label2 = new JLabel(" - ");
		JTextField text2 = new JTextField(7);
		
		panel.add(label);
		panel.add(text);
		panel.add(label2);
		panel.add(text2);
		
		return panel;
	}
	
	private JPanel inputPanel(String title, int textFieldSize) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel(title);
		JTextField text = new JTextField(textFieldSize);
		
		panel.add(label);
		panel.add(text);
		
		return panel;
	}
}
