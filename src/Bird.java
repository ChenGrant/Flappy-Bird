import java.awt.*;
import javax.swing.*;

public class Bird {
	Image image = new ImageIcon("src\\Bird.png").getImage();
	double x;
	double y;
	double dy;
	double maxY;
	double imageW;
	double imageH;
	
	public Bird(int maxW, int maxH, int groundLineH) {
		x = maxW/10;
		y = 0;
		dy=0;
		maxY = groundLineH;
		imageW = 75;
		imageH =50;
	}
	
	public void move() {
			y+=dy;
			accelerateDownY();
		if (y<0) {
			y=0;
			dy=0;
			accelerateDownY();
		}
	}
	
	public void accelerateDownY () {
		dy +=0.01;
	}
	
	public Rectangle bounds() {
		return (new Rectangle ((int)x, (int)y, (int)imageW, (int)imageH));
	}
	
}
