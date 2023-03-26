import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class Spra1Zad1 extends JPanel {
	private Graphics2D g2; // A copy of the graphics context from paintComponent.

	void resetTransform() {
		g2.setTransform(new AffineTransform());
	}

	private void square() {
		g2.fillRect(-50, -50, 100, 100);
	}

	private void triangle() {
		g2.fillPolygon(new int[] { -50, 50, 0 }, new int[] { -50, -50, 50 }, 3);
	}

	// ------------------------------------------------------------------------------

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.translate(300, 300);
		g2.scale(2, 1);
		g2.setColor(Color.blue);
		square();
		resetTransform();
		g2.translate(300, 200);
		triangle();
		resetTransform();
		g2.translate(300, 400);
		g2.rotate(Math.PI);
		triangle();
		resetTransform();
	}

	// --------------------------------------------------------------------------------------

	public Spra1Zad1() {
		setPreferredSize(new Dimension(600, 600));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new Spra1Zad1());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screen.width - window.getWidth()) / 2, (screen.height - window.getHeight()) / 2);
		window.setVisible(true);
	}
}