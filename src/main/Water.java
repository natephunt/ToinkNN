package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Water {

	//fields area
	int x, y, w, h;
	
	
	
	//advanced fields
	double vx, vy;
	
	double y_raw;
	
	BufferedImage img;
	
	
	
	HitBox hb;
	
	// begin
	public Water (int x, int y) {
		
		this.x = x;
		this.y = y;
		
		this.y_raw = this.y;
				
		this.w = 39;
		this.h = 52;
		
		this.img = Loader.waterDrop;
		
		this.vx = 0;
		this.vy = 1;
		
		
		this.hb = new HitBox('C', this.x, this.y + 12);
		this.hb.setRad(this.w);
		
		
		
	//end of the water constuctor	
	}
	public void update() {
		
		this.vy*=1.014;
		
		this.y_raw += this.vy;
		
		this.x += this.vx;
		this.y = (int) (this.y_raw);
	
		this.hb.setPos(this.x, this.y + 12);
	
	}
	
	
	
	
	
	public void draw(Graphics g) {
		
		g.drawImage(this.img, this.x, this.y, this.w, this.h, null);
		
		//g.fillOval(this.x, this.y, this.w, this.w);
		
		//this.hb.draw(g);
		
	}
	
	
// end of water 	
}
