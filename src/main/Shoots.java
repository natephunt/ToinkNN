/* 
* all code in main created by nathan h (natephunt) with help from tyler j for game making
* implementation of ai all by nathan
*/

package main;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shoots {

	double x, y, vx, vy;
	
	int w, h;
	
	double angle = 0;
	
	double topSpeed = 7; // km per hour >> not now lol
	
	double mass = 1499.8;// Nascar kilograms
	
	double speed =0; // kilometers per hour
	
	double momentum =0; // mass * velocity
	int time;
	int bounces;
	int maxBounces;
	boolean bomb;
	boolean setOff;
	double offset = 0;
	
	Car playie;
	Car enemy;
	
	HitBox hb;

	
	BufferedImage img;
	
	public Shoots(double x, double y, double vx, double vy, Car playie, Car enemy) {
		
		this.x = x;
		this.y = y;
		
		
		this.img = null;
		this.playie=playie;
		this.enemy = enemy;
		
		this.playie.shooties.add(this);
		
		this.setOff=false;
		this.maxBounces=playie.bounces;
		this.bounces=0;
		this.vx = vx;
		this.vy = vy;
		this.bomb=playie.bomb;
		
		this.time=0;
		this.w = 17;
		this.h = 17;
		
		this.hb = new HitBox('C', (int)this.x, (int)this.y + 12);
		this.hb.setRad(this.w);
		
		
		
	}
	// used in player vs player game, not implemented in ai yet
	void home() {
		if(this.x-enemy.x<0) {
			this.vx+=(enemy.x-this.x)/1000;
			//System.out.println("x more");
		}else{
			this.vx+=(enemy.x-this.x)/1000;
			//System.out.println("x less");
		}
		if(this.y-enemy.y<0) {
			this.vy+=(enemy.y-this.y)/1000;
			//System.out.println("y down");
		}else {
			this.vy+=(enemy.y-this.y)/1000;
			//System.out.println("goin up");
		}
	}
	// used in player vs player game, not implemented in ai yet
	void doot() {
		this.vx+=Math.random()*2;
		this.vy+=Math.random()*2;
		this.vx-=Math.random()*2;
		this.vy-=Math.random()*2;
	}
	
	void update() {
		
		this.x+=this.vx;
		this.y+=this.vy;
		
		if(playie.homing) {
			home();
		}
		
		if(playie.doot) {
			home();
			doot();
		}
		
		
		
		time++;
		if(time>600||bounces>maxBounces) {
			
			this.playie.shooties.remove(this);
			//System.out.println("removed, Still: " + this.playie.shooties.size());
			
		}
		
		
		
		hb.setPos((int)(this.x-this.w*offset), (int)(this.y-this.h*offset));
		
		
		bounce();
		
		
	}
	
	// used in player vs player game, not implemented in ai yet
	void bounce(){
		if(this.y>Game.windowHeight-50||this.y<0) {
			this.vy*=-1;
		}
		if(this.x>Game.windowWidth-25||this.x<0) {
			this.vx*=-1;
		}
		
		if((this.x>Game.windowWidth-25||this.x<0||this.y>Game.windowHeight-50||this.y<0)) {
			bounces++;
			
			
		}
	}
	
	void draw(Graphics g) {
		
		
		hb.draw(g);
		
		
		g.setColor(playie.color);
		g.fillOval((int)x, (int)y, w, h);
		g.drawImage(this.img, (int)(this.x),(int) (this.y - 25), this.w*6, this.h*6, null);
		
		
		
	}
	
}
