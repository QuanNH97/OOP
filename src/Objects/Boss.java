package Objects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Main.*;
public class Boss extends Monster implements Boss_Interface{
	private final double STEP = 1; 
    private List<Fire> fires ;
    private int delay=0;
    private final int HP_MAX=1000;
    private int hp;
	public Boss(int x, int y,int width,int height,Image img) {
		super(x, y,width,height,img);
        initBoss();
	}
	private void initBoss() {
		getImageDimension();
        fires = new ArrayList<>();  
        setDirect(1);
        this.hp=HP_MAX;
        loadImage("src/images/monster-left.png");
	}
	public boolean inRange(int heroX,int heroY) {
		if((heroX-this.getX())*(heroX-this.getX())+(heroY-this.getY())*(heroY-this.getY()) <= 10000)
		return true;
		return false;
	}
	  public List<Fire> getFires(){ // 
	    	return fires;
	    }
	 @Override
	public void tofire() {
	    	delay--;
	    	if(delay <= 0) {
	    	ImageIcon img= new ImageIcon("src/images/fire.png");
	    	Fire fire_new=new Fire(x+width/2, y+height/2,10,10,img.getImage());
	    	fire_new.setDirect(getDirect()); 
	    	fires.add(fire_new); 
	    	delay=50;
	    }
	  }
	 
	 public void move(int heroX,int heroY) {
			int colDistance = 0;
			int rowDistance = 0;
			colDistance = this.getX()-heroX;
			rowDistance = this.getY()-heroY;
			if(colDistance==0&&rowDistance==0) return;
			if(this.inRange(heroX,heroY))  { tofire();return;}
			else {
				
			if(colDistance > 0 && rowDistance >0) {
		  		  if(colDistance <= rowDistance)
		  			  { x -= STEP;setDirect(-1); loadImage("src/images/monster-left.png");}
		  		  else { y += STEP;setDirect(-2); loadImage("src/images/monster-face.png");}
		  	  }
		  	  if(colDistance < 0 && rowDistance < 0) {
		  		  if(colDistance <= rowDistance)
		  		 { y += STEP;setDirect(-2);loadImage("src/images/monster-face.png");}
		  		  else  { x -= STEP;setDirect(-1); loadImage("src/images/monster-left.png");}
		  	  }
		  	  if(colDistance < 0 && rowDistance > 0) {
		  		  if(colDistance + rowDistance <=0)
		  			  {y-=STEP;setDirect(2); loadImage("src/images/monster-back.png");}
		  		  else {x+=STEP;setDirect(1); loadImage("src/images/monster-right.png");}

		  	  }
		  	  if(colDistance>0 && rowDistance<0) {
		  		  if(colDistance+rowDistance<=0)
		  		 { x -= STEP;setDirect(-1); loadImage("src/images/monster-left.png");}
		  		  else  { y += STEP;setDirect(-2);loadImage("src/images/monster-face.png");}
		  	  }
	 	  if(colDistance == 0 ) {
	 		  if(rowDistance > 0)
	 		 {y-=STEP;setDirect(2); loadImage("src/images/monster-back.png");}
	 		  else
	 		 { y += STEP;setDirect(-2);loadImage("src/images/monster-face.png");}
	 	  }
	 	 
	 	  if(rowDistance == 0) {
	 		  if(colDistance > 0)
	 		 { x -= STEP;setDirect(-1); loadImage("src/images/monster-left.png");}
	 		  else
	 		{x+=STEP;setDirect(1); loadImage("src/images/monster-right.png");}
	 	  }
	  	if (x<1) {x=1;} // ko cho di chuyển tràn khung
		if (y<1) {y=1;}
		this.getImageDimension();
		if (x>Board.getSizeX()-this.width) {x=Board.getSizeX()-this.width;}
		if (y>Board.getSizeY()-this.height) {y=Board.getSizeY()-this.height;}
	  	 
		}
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}

