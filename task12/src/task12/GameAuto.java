package task12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import task12.GameScreen;

public class GameAuto extends JFrame {
	
	public GameAuto() {
		super("2인용 게임 Version 2");
		
		buildGUI();
		
		this.setSize(GameScreen.FRAME_WIDTH, GameScreen.FRAME_HEIGHT);
		this.setResizable(false); // 화면 크기 변경 고정
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		GameScreen gameScreen =  new GameScreen();
		this.add(gameScreen);
		this.add(createButtonPanel(gameScreen), BorderLayout.SOUTH);
	}
	
	private JPanel createButtonPanel(GameScreen gameScreen) {
		JPanel p = new JPanel(new GridLayout(1, 0));
		JButton startBtn = new JButton("start");
		JButton stopBtn = new JButton("stop");
		
		ActionListener handler = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// e.getActionCommand();
				Object src = e.getSource(); // Object 타입이므로 모든 객체에서 사용 가능
				if(src == startBtn) {
					gameScreen.start();
				} else {
					gameScreen.stop();
				}
			}
			
		};
		
		startBtn.addActionListener(handler);
		stopBtn.addActionListener(handler);
		
		p.add(startBtn);
		p.add(stopBtn);
;		
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameAuto();
	}

}
