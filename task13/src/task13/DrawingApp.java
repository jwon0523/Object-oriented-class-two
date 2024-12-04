package task13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.*;

public class DrawingApp {
	DrawingPanel drawingPanel;
	JFrame frame;
	
	public DrawingApp() {
		frame = new JFrame();
		
		buildGUI();
		
		frame.setSize(500, 500);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(
						frame, 
						"정말 종료하시겠습니까?",
						"확인",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE
				);
				
				if(result == JOptionPane.YES_OPTION) {
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(
							frame, 
							"종료가 취소되었습니다.",
							"알림",
							JOptionPane.OK_OPTION
					);
				}
			}
		});
		
		frame.setVisible(true);
	}
	
	private void buildGUI() {
		drawingPanel = new DrawingPanel();
		frame.setJMenuBar(createMenuBar());
		frame.add(drawingPanel);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createShapeMenu());
		
		return menuBar;
	}
	
	private JMenu createFileMenu() {
		String[] items = {"New", "Load", "Save"};
		JMenu menu = new JMenu("File");
		JMenuItem item;
		item = new JMenuItem(items[0]);
		menu.add(item);
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawingPanel.clear();
			}
			
		});
		menu.addSeparator();
		for(int i = 1; i < items.length; i++) {
			item = new JMenuItem(items[i]);
			menu.add(item);
			
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					File selectedFile = null;
					String filePath = null;
					File desktopPath = new File(System.getProperty("user.home"), "Desktop");
					fileChooser.setCurrentDirectory(desktopPath);
					int returnValue = 0;
					fileChooser.showOpenDialog(null);
					if(returnValue == JFileChooser.APPROVE_OPTION) {
						selectedFile = fileChooser.getSelectedFile();
						filePath = selectedFile.getAbsolutePath();
						if(items[1].equals(e.getActionCommand())) {
							drawingPanel.loadFromFile(filePath);
						} else if(items[2].equals(e.getActionCommand())){
							drawingPanel.saveToFile(filePath);
						}
					} else {
						System.out.println("cancle file");
					}
				}
				
			});
		}
		
		return menu;
	}
	
	private JMenu createShapeMenu() {
		String[] items = {"Circle", "Square"};
		JMenu menu = new JMenu("Shape");
		for(int i = 0; i < items.length; i++) {
			JCheckBoxMenuItem item = new JCheckBoxMenuItem(items[i]);
			menu.add(item);
			
			int shapeType = i + 1;
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					drawingPanel.setSelectedShapeType(shapeType);
				}
				
			});
		}
		return menu;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		new DrawingApp();
	}

}
