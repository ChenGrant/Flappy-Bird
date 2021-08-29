import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String[] args) {
		int JFrameW = 1200;
		int JFrameH = 700;
		Panel p = new Panel(JFrameW, JFrameH);
		JFrame jF = new JFrame("Flappy Bird");
		JOptionPane.showMessageDialog(null, "Press space to keep the bird flying, the bird naturally falls. Avoid touching the ground and pipes.");
		jF.add(p);
		jF.setSize(JFrameW, JFrameH);
		jF.setResizable(false);
		jF.setVisible(true);
		jF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
