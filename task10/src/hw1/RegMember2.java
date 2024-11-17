package hw1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegMember2 {
	private JFrame frame;
	private JTextField nameField, residentField1, residentField2, addressField;
	private JRadioButton maleButton, femaleButton;
	private JComboBox<String> departmentBox;
	private JCheckBox movieCheckBox, musicCheckBox, photoCheckBox, sportCheckBox;
	private JTextArea textArea;

	public RegMember2() {
		frame = new JFrame("RegMember2");

		buildGUI();

		frame.setSize(350, 420);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void buildGUI() {
		frame.add(textFieldLayout(), BorderLayout.NORTH);
		frame.add(inputLayout(), BorderLayout.CENTER);
		frame.add(buttonLayout(), BorderLayout.SOUTH);
	}

	private JPanel textFieldLayout() {
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(inputNameAndGender());
		panel.add(inputResidentNumber());
		panel.add(inputPanel("주	          소", 22));
		panel.add(comboBoxPanel());
		panel.add(checkBoxPanel());

		return panel;
	}

	private JPanel inputLayout() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("자기소개");
		textArea = new JTextArea();
		textArea.setLineWrap(true);

		panel.add(label, BorderLayout.NORTH);
		panel.add(textArea, BorderLayout.CENTER);

		return panel;
	}

	private JPanel buttonLayout() {
		JPanel panel = new JPanel();
		JButton btn1 = new JButton("저장");
		JButton btn2 = new JButton("종료");

		panel.add(btn1);
		panel.add(btn2);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveData();
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return panel;
	}

	private JPanel inputNameAndGender() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("성	          명");
		nameField = new JTextField(8);
		JLabel label2 = new JLabel("성     별");

		ButtonGroup bg = new ButtonGroup();
		maleButton = new JRadioButton("남", true);
		femaleButton = new JRadioButton("여");
		bg.add(maleButton);
		bg.add(femaleButton);

		panel.add(label);
		panel.add(nameField);
		panel.add(label2);
		panel.add(maleButton);
		panel.add(femaleButton);

		return panel;
	}

	private JPanel inputResidentNumber() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("주민등록번호");
		residentField1 = new JTextField(6);
		JLabel label2 = new JLabel(" - ");
		residentField2 = new JTextField(7);

		panel.add(label);
		panel.add(residentField1);
		panel.add(label2);
		panel.add(residentField2);

		return panel;
	}

	private JPanel inputPanel(String title, int textFieldSize) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel(title);
		addressField = new JTextField(textFieldSize);

		panel.add(label);
		panel.add(addressField);

		return panel;
	}

	private JPanel comboBoxPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("부    서    명");
		String[] data = { "총무부", "회계부", "마케팅" };
		departmentBox = new JComboBox<>(data);

		panel.add(label);
		panel.add(departmentBox);

		return panel;
	}

	private JPanel checkBoxPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("취	          미");
		movieCheckBox = new JCheckBox("영화");
		musicCheckBox = new JCheckBox("음악감상");
		photoCheckBox = new JCheckBox("사진");
		sportCheckBox = new JCheckBox("운동");

		panel.add(label);
		panel.add(movieCheckBox);
		panel.add(musicCheckBox);
		panel.add(photoCheckBox);
		panel.add(sportCheckBox);

		return panel;
	}

	private void saveData() {
		StringBuilder sb = new StringBuilder();

		sb.append("성명: ").append(nameField.getText()).append("\n");
		sb.append("성별: ").append(maleButton.isSelected() ? "남" : "여").append("\n");

		sb.append("주민등록번호: ").append(residentField1.getText()).append("-").append(residentField2.getText()).append("\n");

		sb.append("주소: ").append(addressField.getText()).append("\n");

		sb.append("부서명: ").append(departmentBox.getSelectedItem()).append("\n");

		sb.append("취미: ");
		if (movieCheckBox.isSelected())
			sb.append("영화 ");
		if (musicCheckBox.isSelected())
			sb.append("음악감상 ");
		if (photoCheckBox.isSelected())
			sb.append("사진 ");
		if (sportCheckBox.isSelected())
			sb.append("운동 ");
		sb.append("\n\n");

		textArea.setText(sb.toString());
	}

	public static void main(String[] args) {
		new RegMember2();
	}
}