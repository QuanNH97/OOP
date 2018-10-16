package Objects;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GameObject {
	protected int x,y,width,height;
	protected Image image;
	
	public GameObject(int x,int y,int width,int height,Image image){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	public void draw(Graphics2D g2d){
			g2d.drawImage(image,x,y,width,height,null);	
	}
	protected void loadImage(String imageName) { 
	      ImageIcon img = new ImageIcon(imageName);
	      image = img.getImage();
	}
	protected void getImageDimension() { 
		  width  = image.getWidth(null);
		  height = image.getHeight(null);
	}  
	public void setImage(Image image) {
		this.image = image;
	}
	public Image getImage() {return image;}
    public int getX() {return x;}
    public void setX(int a) {
    	this.x=a;
    }
    public int getY() {return y;}
    public void setY(int a) {
    	this.y=a;
    }
}