
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spr1Zad2 extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300); 
			int whichTransform = transformSelect.getSelectedIndex();
			 switch (whichTransform) {
             case 0:
                 break;

             case 1:
                 g2.scale(0.5, 0.5);
                 break;

             case 2:
            	 g2.scale(1.5, 1.5);
                 g2.rotate(0.6);
                 break;

             case 3:
                 g2.scale(0.5, 0.8);
                 g2.rotate(Math.PI/2);
                 break;

             case 4:
                 g2.shear(0.30, 0);
                 break;

             case 5:
                 g2.scale(1.2, 0.3);
                 g2.translate(0, -900);
                 break;

             case 6:
            	 g2.scale(1.2, 1.6);
                 g2.shear(0, -0.6);
                 g2.rotate(Math.PI / 2);
                 break;

             case 7:
                 g2.scale(0.5, 1);
                 g2.rotate(Math.PI);
                 break;

             case 8:
                 g2.rotate(Math.toRadians(30));
                 g2.scale(1.4, 0.3);
                 g2.translate(10, 500);
                 break;

             case 9:
                 g2.translate(160, 0);
                 g2.shear(0, 0.25);
                 g2.rotate(Math.PI);
                 break;
         }

	            int[] PointsX = new int[11];
	            int[] PointsY = new int[11];
	            
	            for (int i = 1; i < 12; i++) 
	            {
	                PointsX[i - 1] = (int)(150 * Math.cos((2 * Math.PI / 11) * i));
	            }

	            for (int i = 1; i < 12; i++) 
	            {
	                PointsY[i - 1] = (int)(150 * Math.sin((2 * Math.PI / 11) * i));
	            }

	            Polygon eleven = new Polygon(PointsX, PointsY, 11);
	            g2.setColor(Color.BLUE);
	            g2.fillPolygon(eleven);
		}
	}

	private Display display;
	private JComboBox<String> transformSelect;

	public Spr1Zad2() throws IOException {
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Spr1Zad2());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}