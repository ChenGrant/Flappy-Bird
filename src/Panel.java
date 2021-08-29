import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements KeyListener {
	Image sky;
	Image ground;
	boolean collision;
	boolean reset = true;
	boolean win = false;
	int maxW;
	int maxH;
	int groundLineH;
	int score;
	Bird bird;
	Pipe bottomPipe;
	Pipe topPipe;
	Image winImg;

	Panel(int maxW, int maxH) {
		collision = false;
		this.maxW = maxW;
		this.maxH = maxH;
		groundLineH = (4 * maxH) / 5;
		winImg = new ImageIcon("src\\Win.png").getImage();
		sky = new ImageIcon("src\\Sky.png").getImage();
		ground = new ImageIcon("src\\Ground.png").getImage();
		bird = new Bird(maxW, maxH, groundLineH);
		bottomPipe = new Pipe("src\\BottomPipe.png", maxW);
		topPipe = new Pipe("src\\TopPipe.png", maxW);
		this.setFocusable(true);
		this.requestFocusInWindow();
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		collisions();
		if (!collision &&!win) {
			bird.move();
			bottomPipe.move();
			topPipe.move();
			updateScore();
			checkWin();
		}
		g.drawImage(sky, 0, 0, maxW, maxH, this);
		g.drawImage(bottomPipe.img, (int) bottomPipe.x, (int) bottomPipe.y, (int) bottomPipe.imgW,
				(int) bottomPipe.imgH, this);
		g.drawImage(topPipe.img, (int) bottomPipe.x, 0, topPipe.imgW, (int) (bottomPipe.y - bird.imageH - 100), this);
		g.drawImage(ground, 0, groundLineH, maxW, maxH - groundLineH, this);// draw ground above pipes
		g.drawImage(bird.image, (int) bird.x, (int) bird.y, (int) bird.imageW, (int) bird.imageH, this);
		g.drawImage(ScoreImage(score), 50, 0, 100, 100, this);
		if (win)
			g.drawImage(winImg,-100,0, maxW, maxH, this);
		repaint();

	}

	public Image ScoreImage(int score) {
		String str = "src\\Score" + score + ".png";
		Image img = new ImageIcon(str).getImage();
		return img;
	}

	public void updateScore() {
		if (bird.x > bottomPipe.x + bottomPipe.imgW && reset) {
			score++;
			reset = false;
		}
		if (bottomPipe.x == maxW)
			reset = true;
	}

	public void collisions() {
		Rectangle rect1 = bird.bounds();
		Rectangle rect2 = new Rectangle((int) bottomPipe.x, 0, topPipe.imgW, (int) (bottomPipe.y - bird.imageH - 100));
		Rectangle rect3 = bottomPipe.bounds();
		if (rect1.intersects(rect2) || rect1.intersects(rect3) || (bird.y) + bird.imageH > groundLineH)
			collision = true;
	}

	public void checkWin() {
		if (score == 10)
			win = true;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_SPACE: {
				bird.dy = -1;
				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

}
