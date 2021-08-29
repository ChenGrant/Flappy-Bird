import java.awt.*;
import javax.swing.*;

public class Pipe {
	Image img;
	double x;
	double y;
	double dx;
	int maxW;
	int imgH = 500;
	int imgW = 100;
	
	public Pipe(String imageFile, int maxW){
		img = new ImageIcon(imageFile).getImage();
		this.maxW = maxW;
		x = maxW;
		y = randomY();
		dx = -2;
	}
	
	public void move() {
		x+=dx;
		if (x<-imgW) {
			x = maxW;
			y = randomY();
		}
	}
	
	public Rectangle bounds() {
		return (new Rectangle((int)x, (int)y, (int)imgW, (int)imgH));
	}
	
	public int randomY() {
		return (int)(300*Math.random()+200);//200, 
	}
}
