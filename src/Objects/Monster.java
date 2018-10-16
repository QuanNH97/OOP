package Objects;

import java.awt.Image;
import java.util.Random;

import Main.Board;

public class Monster extends GameObjectDinamic {
	Random rd = new Random();
	private int timez=0;
	private static final int MONSTER_SPEED =10;
	public Monster(int x, int y,int width,int height,Image image) {
		super(x, y, height, height, image);
        initMonster();
	}
    private void initMonster() {
    	loadImage("src/images/monster_r.png");
    	getImageDimension();
    }
	@Override
	public void move() {
        if (getDirect() == 1 ) { x+=1 ;loadImage("src/images/monster_r.png");}
        else if (getDirect() == -1 ) { x-=1; loadImage("src/images/monster_l.png");}
        else if (getDirect() == 2 )  { y-=1; loadImage("src/images/monster_u.png");}
        else if (getDirect() == -2 ) { y+=1; loadImage("src/images/monster_d.png");}
        timez+=1; 
        if (timez==100) { //
           setDirect(rd.nextInt(5)-2); // 
        }
    	if (x<1) {x=1;} // ko cho di chuyển tràn khung
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
}
