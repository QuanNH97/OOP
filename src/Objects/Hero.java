package Objects;
import Main.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Hero extends GameObjectDinamic {
	private int dx; 
	private int dy;
	private int level=1;
    private List<Fire> fires ;       
    private int moving ;  
    private final int shoot_force = 50;
    public Hero(int x,int y,int width,int height,Image image) { 
         super(x,y,width,height,image);
         fires = new ArrayList<>();  
    }
    @Override
	public void move() { 
    	x +=dx;
    	y +=dy;
    	if (x<1) {x=1;} 
    	if (y<1) {y=1;}
    	this.getImageDimension();
    	if (x>Board.getSizeX()-this.width) {x=Board.getSizeX()-this.width;}
    	if (y>Board.getSizeY()-this.height) {y=Board.getSizeY()-this.height;}
    	if(!Board.m.checkMapLeft(x,y,this.width,this.height)) {
    		x=x+1;
    	}
    	if(!Board.m.checkMapRight(x,y,this.width,this.height)) {
    		x=x-1;
    	}
    	if(!Board.m.checkMapUp(x,y,this.width,this.height)) {
    		y=y+1;
    	}
    	if(!Board.m.checkMapDown(x,y,this.width,this.height)) {
    		y=y-1;
    	}
    }
    public List<Fire> getFires(){ // get mảng fires
    	return fires;
    }
    public void tofire() {
    	ImageIcon img= new ImageIcon("src/images/fire.png");
    	Fire fire_new=new Fire(x+width/2, y+height/2,10,10,img.getImage());
    	fire_new.setDirect(getDirect()); 
    	fires.add(fire_new); 
    }
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
	   if (key == KeyEvent.VK_SPACE) { tofire();} 
	   if (key == KeyEvent.VK_LEFT)  { 
			  		dx = -1; loadImage("src/images/l0.png") ; setDirect(-1);
	   }
	   if (key == KeyEvent.VK_RIGHT) { 
			   dx =  1; loadImage("src/images/r0.png") ; setDirect(1) ;
	   }
	   if (key == KeyEvent.VK_UP)    { 
			   dy = -1; loadImage("src/images/u0.png") ; setDirect(2) ;
	   } 
	   if (key == KeyEvent.VK_DOWN)  { 
			   dy =  1; loadImage("src/images/d0.png") ; setDirect(-2);
	   }    	
    }
    public void keyReleased(KeyEvent e) {
	   int key = e.getKeyCode(); 
	   if (key == KeyEvent.VK_SPACE) { }
	   if (key == KeyEvent.VK_LEFT)  { dx = 0; }
	   if (key == KeyEvent.VK_RIGHT) { dx = 0; }
	   if (key == KeyEvent.VK_UP)    { dy = 0; }
	   if (key == KeyEvent.VK_DOWN)  { dy = 0; }
    }
    public void setLevel (int a) {
    	this.level=a;
    }
    public int getLevel() {
    	return this.level;
    }
	public int getShoot_force() {
		return shoot_force;
	}
} 
