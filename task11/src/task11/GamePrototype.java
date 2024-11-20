package task11;

import javax.swing.JFrame;

public class GamePrototype extends JFrame {
	
	public GamePrototype() {
		super("2인용 게임 Version 1");
		
		buildGUI();
		
		this.setSize(500, 500);
		this.setResizable(false); // 화면 크기 변경 고정
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		GameScreen gs =  new GameScreen();
		this.add(gs);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GamePrototype();
	}

}
