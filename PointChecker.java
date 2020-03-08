import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class pc extends JPanel implements MouseMotionListener, ActionListener{
	private static final long serialVersionUID = 1L;
	static int[] x = new int[1000], y = new int[1000];
	int mx, my;
	static int num = 50;
	Timer t = new Timer(1, this);
	JLabel jl = new JLabel("");
	JButton newPoly = new JButton("Generate Polygon");
	static Random rr = new Random();
	static Polygon r;
	Graphics g;
	
	public void newPolygon() {
		
		for (int z = 0; z < 50; z++) {
			x[z] = rr.nextInt(800);
			y[z] = (rr.nextInt(500))+(50);
		}
		
	}
	
	public pc() {
		t.start();
		
		newPoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPolygon();
			}});
		
		addMouseMotionListener(this);
		add(jl);
		add(newPoly);
	}
	
	public void mouseDragged(MouseEvent m) {}
	
	public void mouseMoved(MouseEvent m) {
        mx = m.getX();
        my = m.getY();
        Point p = new Point(mx, my);
       
        if (r.contains(p)) {
			jl.setText("Inside Polygon " + "(" + mx + ", " + my + ")");
		}
		
        else {
			jl.setText("Outside Polygon " + "(" + mx + ", " + my + ")");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		r = new Polygon(x, y, num);
		g.fillPolygon(r);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}

public class PointChecker extends JFrame {
	private static final long serialVersionUID = 1L;
	static PointChecker point = new PointChecker();
	
	public PointChecker() {
		setTitle("Moving Graphics");
		add(new pc());
		setSize(800, 600);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		point.setVisible(true);
	}
}