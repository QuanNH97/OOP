package Objects;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class GameObjectDinamic extends GameObject {
	protected boolean tontai;
	protected int direct=-2;
	
	public GameObjectDinamic(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
		this.tontai=true;
	}
	public boolean getTontai() { return tontai ;}
	public void setTontai(boolean x) {this.tontai = x;} 
	public Rectangle getBounds() { 
		   return new Rectangle(x,y,width,height);
	}
	public int getDirect() { return direct;};
	public void setDirect(int direct) { this.direct = direct;}
	@Override
	protected void loadImage(String imageName) { 
	      ImageIcon img = new ImageIcon(imageName);
	      image = img.getImage();
	}
	protected abstract void move();
}
