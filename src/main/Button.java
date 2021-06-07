package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button {

	int x, y, w, h;
	BufferedImage img;
	
	public Button(int x, int y, int w, int h, BufferedImage img) {
		
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.img=img;
		
		
		
	}
	
	public boolean pointVsRect( int x, int y, Button b) {
		
		boolean xAxis = (x > b.x) && ((b.x + b.w) > x);
		boolean yAxis = (y > b.y) && ((b.y + b.h) > y);
		
		return xAxis && yAxis; 
	// end of the checkCol
	}
	
	void draw(Graphics g){
		
		g.drawImage(img, x, y, w, h, null);
		
		
	}
	
	
}
