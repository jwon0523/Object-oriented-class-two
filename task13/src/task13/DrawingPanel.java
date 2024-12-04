package task13;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JComponent;

public class DrawingPanel extends JComponent {
	static final int CIRCLE = 50, SQUARE = 100;
	private int selectedShapeType;
	private ArrayList<Shape> shapes = new ArrayList<>();
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private BufferedInputStream bis = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private BufferedOutputStream bos = null;
	
	public DrawingPanel() {
		this.selectedShapeType = 1;
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				
				switch(selectedShapeType) {
				case 1:
					shapes.add(new Circle(x, y, CIRCLE));
					repaint();
					break;
				case 2:
					shapes.add(new Square(x, y, SQUARE, SQUARE));
					repaint();
					break;
				}
			}
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for(Shape shape: shapes) {
			if(shape != null) {
				shape.draw(g);
			}
		}
		
	}

	void setSelectedShapeType(int shapeType) {
		this.selectedShapeType = shapeType;
	}
	
	void clear() {
		shapes.clear();
		repaint();
	}
	
	void saveToFile(String filePath) {
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(shapes);
			System.out.println("저장된 도형 리스트: " + shapes);
			repaint();
		} catch(FileNotFoundException fnfe) {
			System.err.print(fnfe.getMessage());
			System.err.println("저장 취소합니다!");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
    	if(fos != null | oos != null | bos != null) {
    		try {
    			oos.close();
    			bos.close();
    			fos.close();
    		} catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
	}
	
	void loadFromFile(String filePath) {
    try {
    	fis = new FileInputStream(filePath);
    	bis = new BufferedInputStream(fis);
      ois = new ObjectInputStream(bis);
      shapes = (ArrayList<Shape>) ois.readObject();
      System.out.println("복원된 도형 리스트: " + shapes);
      repaint();
    } catch(ClassNotFoundException | FileNotFoundException e){
    	System.err.print(e.getMessage());
			System.err.println("불러오기 취소합니다!");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
    	if(fis != null | ois != null | bis != null) {
    		try {
    			ois.close();
    			bis.close();
    			fis.close();
    		} catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
	}
}
