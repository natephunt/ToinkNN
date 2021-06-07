/*
 * makes a curular, rectangular, or square hit box
 * 
 */


package main;

import java.awt.Color;
import java.awt.Graphics;

public class HitBox {
	
	char style;
	
	int x, y, w, h, r;
	
	public HitBox(char style, int x, int y) {
		
		this.style = style;
		this.x = x;
		this.y = y;
		
		
		this.w = 0;
		this.h = 0;
		this.r = 0;
		
		
		
		
		
		
		
	// end of the hitBox constructor	
	}
	
	public void setRad(int r) {
		this.r = r;
	}
	
	public void setWH(int w, int h) {

		this.w = w;
		this.h = h;
	
	}
	
	public void setPos(int x, int y) {

		this.x = x;
		this.y = y;
	
	}
	public void draw(Graphics g) {
		
		
		g.setColor(Color.magenta);
		g.fillOval(this.x, this.y, this.r, this.r);
		
	}
}
