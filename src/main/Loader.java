// Nathan's dodge water 
//loader

package main;

import java.awt.image.BufferedImage;

public class Loader {

	public static BufferedImage waterDrop         = Resources.loadImage("water_drop.png");
	public static BufferedImage bat               = Resources.loadImage("bat.png");
	public static BufferedImage garden_background = Resources.loadImage("garden_background.png");
	public static BufferedImage cloud             = Resources.loadImage("cloud.png");
	public static BufferedImage healthBar         = Resources.loadImage("health_bar.png");
	public static BufferedImage boom              = Resources.loadImage("Booom.png");
	public static BufferedImage moreHealth        = Resources.loadImage("MoreHealth.png");
	public static BufferedImage redDot            = Resources.loadImage("RedDot.png");
	public static BufferedImage buckShot          = Resources.loadImage("BuckShot.png");
	public static BufferedImage lifeSteal         = Resources.loadImage("LifeSteal.png");
	public static BufferedImage TD_Car_0          = Resources.loadImage("TD_Car_0.png");
	public static BufferedImage TD_Car_1          = Resources.loadImage("TD_Car_1.png");
	public static BufferedImage TD_Car_2          = Resources.loadImage("TD_Car_2.png");
	public static BufferedImage TD_Car_3          = Resources.loadImage("TD_Car_3.png");
	public static BufferedImage TD_Car_4          = Resources.loadImage("TD_Car_4.png");
	public static BufferedImage TD_Car_5          = Resources.loadImage("TD_Car_5.png");
	public static BufferedImage TD_Car_6          = Resources.loadImage("TD_Car_6.png");
	public static BufferedImage TD_Car_7          = Resources.loadImage("TD_Car_7.png");
	public static BufferedImage machine           = Resources.loadImage("Machine.png");
	public static BufferedImage homing            = Resources.loadImage("Homing.png");
	public static BufferedImage bomb              = Resources.loadImage("Bomb.png");
	public static BufferedImage bounce            = Resources.loadImage("Bounce.png");
	public static BufferedImage aimless           = Resources.loadImage("aimless.png");
	
	public static BufferedImage car_0_imgs[] = 
		{ TD_Car_0, TD_Car_1, TD_Car_2, TD_Car_3, TD_Car_4, TD_Car_5, TD_Car_6,
		TD_Car_7};
	
	public static boolean hit(HitBox A, HitBox B) { 
		
		int R = (A.r + B.r)/2;
		
		int xDist = Math.abs(A.x - B.x);
		int yDist = Math.abs(A.y - B.y);
		
		return xDist < R && yDist < R;
		
		
		
		
		
	}
	
	
//end of loader	
}
