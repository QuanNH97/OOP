package Objects;

import java.awt.Image;

import Main.Board;

public class Fire extends GameObjectDinamic{
    private final int fire_length =200; 
    private final int fire_speed  =3;    
    private int fly=0;
    public Fire(int x, int y,int width,int height,Image image) {
    	super(x,y,width,height,image);
    }
    @Override
	public void move() {
    	if (getDirect() == 1) {
    		for(int i=0;i<fire_speed;i++) {
    			if(!Board.m.checkMapRight(x,y,6,6)){
        			this.x =this.x- 1;
        			setTontai(false);
        		}
        		else {
        			this.x += 1;
        		}
    		} 
    	}
    	else if (getDirect() == 2) {
        	for(int i=0;i<fire_speed;i++) {
        		if(!Board.m.checkMapUp(x,y,6,6)){
        			this.y =this.y+ 1;
        			setTontai(false);
        		}
        		else {
        			this.y -= 1;
        		}
        	}
        }
    	else if (getDirect() ==-1) {
        	for(int i=0;i<fire_speed;i++) {
        		if(!Board.m.checkMapLeft(x,y,6,6)){
        			this.x =this.x+ 1;
        			setTontai(false);
        		}
        		else {
        			this.x -= 1;
        		}
        	}
        }
    	else if (getDirect() ==-2) {
        	for(int i=0;i<fire_speed;i++) {
        		if(!Board.m.checkMapDown(x,y,6,6)){
        			this.y =this.y- 1;
        			setTontai(false);
        		}
        		else {
        			this.y += 1;
        		}
        	}
        }
        fly += fire_speed; 
        if (fly>fire_length) {
        	setTontai(false);
        }
        
    }
} 

