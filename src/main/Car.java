/* 
* all code in main folder (this is) created by nathan h
* implementation of ai also
*/


package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.evo.NEAT.Genome;

// created by nathan h

public class Car {

	double x, y, vx, vy;
	
	int w, h;
	
	int reloadCount;

	boolean reloadpos;
	int damage;
	int burstTime;
	int lifeSteal; 
	
	public int score;
	int lives;
	
	int maxBullets;
	int maxLives;
	
	int aimOff;
	int burstSpeed;
	int reloadTime;
	
	int bounces;
	public ArrayList <Shoots> shooties = new ArrayList<Shoots>();
	
	BufferedImage img;
	
	double angle = 0;
	double topSpeed = 8; // km per hour >> not now lol
	double mass = 1499.8;// Nascar kilograms
	double speed = 2; // kilometers per hour
	double momentum = 0; // mass * velocity
	
	public boolean ded;
	
	int bullets;
	
	HitBox hb;
	HitBox rightBox;
	HitBox leftBox;
	
	Color color;
	boolean forwardDown = false;
	boolean leftDown = false;
	boolean backDown = false;
	boolean rightDown = false;
	boolean shootDown = false;
	boolean redDot = false;
	boolean homing = false;
	boolean bomb;
	boolean on;

	public float output[] = new float[1];

	Genome gene;

	public float inputs[] = new float[2];

	boolean doot;
	
	// VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
	public Car(int x, int y, Genome gene, boolean on) {
		if (Game.random){
			this.x=Math.random()*(Game.windowWidth-30);
			this.y=Math.random()*(Game.windowHeight-30);
			this.angle=Math.random()*360;
		}else{
			this.x =x;
			this.y =y;
		}
		this.on = on;
		this.inputs = inputs;

		this.gene = gene;

		this.color=Color.red;
		this.score=0;
		
		this.bomb=true;
		this.damage=10;
		
		this.doot=false;
		this.vx = 12;
		this.vy = 0;
		
		this.output = gene.evaluateNetwork(this.inputs);

		this.h = 32;
		this.w = 32;
		
		this.bounces = 0;
		this.homing=false;
		this.redDot=false;
		this.aimOff=0;
		this.lifeSteal=0;
		this.maxBullets = 1;
		this.reloadTime=150;
		this.shootDown = true;
		
		this.ded=false;
		
		this.lives = 10;
		this.maxLives = 10;
		
		this.shooties = new ArrayList<Shoots>();
		
		this.burstTime = 0;
		this.reloadCount= 0;
		this.reloadpos= true;
		this.burstSpeed= 7;
		
		this.bullets = 1;
		
		this.img = Loader.TD_Car_0;
		


		this.hb = new HitBox('C', (int)this.x, (int)this.y );
		this.hb.setRad(this.w-10);
		this.rightBox = new HitBox('C', (int)this.x, (int)this.y );
		this.rightBox.setRad(1200);
		this.leftBox = new HitBox('C', (int)this.x, (int)this.y );
		this.leftBox.setRad(1200);

		for (int i =0; i<200; i++) {
			accelerate();
		}

	}
	
	

	void setForwardDown(boolean forwardDown) {
		this.forwardDown = forwardDown;
	}
	void setLeftDown(boolean leftDown) {
		this.leftDown = leftDown;
	}
	void setBackDown(boolean backDown) {
		this.backDown = backDown;
	}
	void setRightDown(boolean rightDown) {
		this.rightDown = rightDown;
	}
	void setShootDown(boolean shootDown) {
		this.shootDown = shootDown;
	}
	
	void accelerate() {
		
		//this.speed+=0.1;
		//handleVel();
		//handleImage();
		
		if (speed >= topSpeed) {
			speed = topSpeed;
			return;
		}
		
		
		this.momentum+=14;
		this.speed= this.momentum/ this.mass;
		this.handleVel();
	}
	
	double degToRad() {
		return (this.angle*Math.PI)/180;
	}
	
	
	void handleVel() {
		this.vy= -1* Math.sin((this.angle *Math.PI)/180) * this.speed;
		this.vx=Math.cos((this.angle*Math.PI)/180)*this.speed;
	}
	
	void update(Car enemy) {
		
		
		checkAim(enemy);
		
		

		//float[] output = gene.evaluateNetwork(this.inputs);
		
		if (output[0]<0.3f&&on){
			setLeftDown(true);
			setRightDown(false);
		}else if (output[0]<0.7f&&on){
			setRightDown(true);
			setLeftDown(false);
		}else{
			setRightDown(false);
			setLeftDown(false);
		}
		
		if(bullets<1) {
			reloadpos=true;
		}
		
		if(reloadpos) {
			reloadCount++;
		}
		
		if(reloadCount>150) {
			reloadpos=false;
			bullets=maxBullets;
			reloadCount=0;
		}
		
		this.x+=this.vx;
		this.y+=this.vy;
		
		hb.setPos((int)this.x + this.w/8, (int)this.y + this.h/8);
		rightBox.setPos((int)( this.x + (-1* Math.cos(((this.angle+240)*Math.PI)/180)*600)), 
		                (int)( this.y + 1* Math.sin(((this.angle +240) *Math.PI)/180)*600));

		leftBox.setPos((int)(this.x + (-1* Math.cos(((this.angle+120)*Math.PI)/180)*600)), 
		                (int)(this.y + 1* Math.sin(((this.angle +120) *Math.PI)/180)*600));
		
		if (this.x>Game.windowWidth-25) {
			this.x-=5;
			this.angle= 180-this.angle;
			if ( this.angle<0) {
				this.angle = 360 + this.angle;
			}
			handleImage();
			handleVel();
		}
		if(this.x<0){
			this.x+=5;
			this.angle= 180-this.angle;
			if ( this.angle<0) {
				this.angle = 360 + this.angle;
			}
			handleImage();
			handleVel();
		}
		
		if (this.y>Game.windowHeight-50) {
			this.y-=5;
			this.angle = 360-this.angle;
			if ( this.angle<0) {
				this.angle = 360 + this.angle;
			}
			handleImage();
			handleVel();
		}
		if(this.y<0){
			this.y+=5;
			this.angle = 360-this.angle;
			if ( this.angle<0) {
				this.angle = 360 + this.angle;
			}
			handleImage();
			handleVel();
		}
		if (shootDown) {
			burstTime++;
		}
		if (rightDown) {
			handleAngle(2);
		}
		if (leftDown) {
			handleAngle(-2);
		}
		if (backDown) {
			decelerate();
		}
		if (forwardDown) {
			accelerate();
		}
		if (burstTime>burstSpeed) {
			shoot(enemy);
			burstTime=0;
		}
		
		
	}
	void handleAngle( int delta) {
		this.angle+=delta;
		
		this.angle%= 360;
		
		if ( this.angle<0) {
			this.angle = 360 + this.angle;
			
		}
		this.handleVel();
		this.handleImage();
	}
	
	void decelerate() {
		
		this.speed*=0.83;
		this.momentum*=0.83;
		
		handleVel();
		handleImage();
	}
	
	void checkAim(Car enemy){
		if(Loader.hit(this.rightBox, enemy.hb)){
			inputs[0] = 1;     // should be 2 for xy included
			//System.out.println("boio seen");      
		}else{
			inputs[0] = 0;   // should be 2
		}
		if(Loader.hit(this.leftBox, enemy.hb)){
			inputs[1] = 1;  // should be 3 for xy included
			//System.out.println("boio seen");
		}else{
			inputs[1] = 0;  // should be 3
			
		}
		/*   >>> too complecc?

		if(Loader.hit(enemy.leftBox, this.hb)){
			inputs[6] = 1;
			//ystem.out.println("ive been seen");
		}else{
			inputs[6] = 0;
		}
		if(Loader.hit(enemy.rightBox, this.hb)){
			inputs[7] = 1;
			//System.out.println("ive been seen");
		}else{
			inputs[7] = 0;
		}
		*/
	}

	void checkDed(Car enemy) {
		for (int i = 0; i < enemy.shooties.size(); i++) {
			
			HitBox H = enemy.shooties.get(i).hb;
			
			if (Loader.hit(this.hb, H)){
			
				
				//System.out.println("Hit");
				
				
				
				this.lives-=enemy.damage;
				
				enemy.lives+= (10*enemy.lifeSteal)/2;
				
				
				
				if(enemy.lives>enemy.maxLives) {
					enemy.lives=maxLives;
				}
				
				if (lives <= 0) {
					
					//System.out.println("ded: " +this);
					
					this.img= Loader.boom;
					
					enemy.score++;
					
					Game.ded = true;	
					
					this.ded= true;
					
				}
				enemy.shooties.remove(i);
				break;
				
			}
		}
	}
	
	void shoot(Car enemy) {
		//System.out.println("\n\nShottts vx: " + vx + " vy: " + vy);
		if (speed>0.1&&bullets>0&&aimOff>0) {
			new Shoots(this.x + this.w/8, this.y + this.h/8, this.vx*4+(Math.random()*this.aimOff-5), this.vy*4+(Math.random()*this.aimOff-5), this, enemy);
			bullets--;
			System.out.println("Shoted WARD");
			
			
		}else if(speed>0.1&&bullets>0) {
			new Shoots(this.x + this.w/8, this.y + this.h/8, this.vx*4, this.vy*4, this, enemy);
			bullets--;
			//System.out.println("shootedNormal");
		}
		
	}
	
	void handleImage() {
		//int quantizedAngle = (int) (this.angle/45);
		if(!Game.ded) {
			int i = 0;
			
			if (this.angle > 337.5 && this.angle <= 22.5) {
				i = 0;
			}
			
			else if (this.angle > 22.5 && this.angle <= 67.5) {
				i = 1;
			}
			else if (this.angle > 67.5 && this.angle <= 112.5) {
				i = 2;
			}
			else if (this.angle > 112.5 && this.angle <= 157.5) {
				i = 3;
			}
			else if (this.angle > 157.5 && this.angle <= 202.5) {
				i = 4;
			}
			else if (this.angle > 202.5 && this.angle <= 247.5) {
				i = 5;
			}
			else if (this.angle > 247.5 && this.angle <= 292.5) {
				i = 6;
			}
			else if (this.angle > 292.5 && this.angle <= 337.5) {
				i = 7;
			}
			
			this.img = Loader.car_0_imgs[i];
		}
	}
	

	public double roundto10th(double bi) {
		
		double boi =0;
		
		bi *= 10;
		
		bi = Math.round(bi);
		
		boi = bi /= 10;
		
		return boi;
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(this.img, (int)(this.x),(int) (this.y), this.w, this.h, null);
		
		if(!Game.ded) {
			this.leftBox.draw(g);
			this.rightBox.draw(g);

			g.setColor(Color.BLACK);
			g.drawLine((int)(this.x+this.w/2 + this.vx*2), (int)(this.y+this.h/2 +this.vy*2), (int) (this.x+this.w/2 + vx*3), (int)(this.y+this.h/2 +vy*3));
			
			g.drawString("     x, y: " + roundto10th(this.x) +", "+ roundto10th(this.y),    (int)this.x -10, (int)this.y -112);
			g.drawString("    Angle: " + roundto10th(this.angle), (int)this.x -10, (int)this.y -100);
			g.drawString("    speed: " + roundto10th(this.speed), (int)this.x -10, (int)this.y -64);
			g.drawString("       vx: " + roundto10th(this.vx),    (int)this.x -10, (int)this.y -88);
			g.drawString("       vy: " + roundto10th(this.vy),    (int)this.x -10, (int)this.y -76);
			g.drawString("   output: " + roundto10th(this.output[0]),    (int)this.x -10, (int)this.y -124);
			g.drawString("    input: " + this.inputs[0] + ", " + inputs[1], (int)this.x -10, (int)this.y -136);
			if (this.reloadpos) {
				g.setColor(this.color);
			}else {
				g.setColor(Color.black);
			}

			g.drawString("Reloading: " +            reloadpos,     (int)this.x -10, (int)this.y -52);
			
			g.setColor(this.color);
			g.fillRect((int)this.x -10, (int)this.y -46, 2*lives, 10);
			
			if(redDot) {
				g.setColor(Color.red);
				g.drawLine((int)(this.x+this.w/2), (int)(this.y+this.h/2), (int)(this.x+this.w/2+this.vx*500), (int)(this.y+this.h/2+this.vy*500));
			}

			//g.drawOval((int)(-600+this.w/2+this.x + (-1* Math.cos(((this.angle+120)*Math.PI)/180)*600)), 
			//            (int)(-600+this.h/2+this.y + 1* Math.sin(((this.angle +120) *Math.PI)/180)*600), 1200, 1200);
			//g.drawOval((int)(-600+this.w/2+this.x + (-1* Math.cos(((this.angle+240)*Math.PI)/180)*600)), 
			//            (int)(-600+this.h/2+this.y + 1* Math.sin(((this.angle +240) *Math.PI)/180)*600), 1200, 1200);

			if (!reloadpos||bullets>0) {
				g.setColor(Color.orange);
				g.fillRect((int)this.x -10, (int)this.y -34, (60/maxBullets)*bullets, 10);
			}else {
				g.setColor(Color.orange);
				g.fillRect((int)this.x -10, (int)this.y -34, (int)(0.39*reloadCount), 10);
			}
			
			
		}
		
		
	}
}
