package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Objects.*;

public class Map {
	
	private final int mapHeight = 20;
	private final int mapWidth = 20;
	private Scanner m;
	private Wall wall;
	private Tree tree;
	private String Map[] = new String[20];
	
	public String getMap (int x,int y) {
		
		String index=Map[y].substring(x, x+1);
		return index;
		
	}
	
	public boolean checkMapLeft(int x,int y,int width,int height) {
		
		x=x-1;
		for(int i=0;i<height;i++) {
			
			if(getMap(x/30,y/30).equals("2")) return false;
			else if (getMap(x/30,y/30).equals("1")) return false;
			else {
				y=y+1;
			}
			
		}
		return true;
	}
	public boolean checkMapRight(int x,int y,int width,int height) {		
		
		x=x+width+1;
		for(int i=0;i<height;i++) {		
			if(getMap(x/30,y/30).equals("2")) return false;
			else if (getMap(x/30,y/30).equals("1")) return false;
			else {
				y=y+1;
			}
		}
		return true;
	}
	public boolean checkMapUp(int x,int y,int width,int height) {
		
		y=y-1;
		for(int i=0;i<width;i++) {
			
			if(getMap(x/30,y/30).equals("2")) return false;
			else if (getMap(x/30,y/30).equals("1")) return false;
			else {
				x=x+1;
			}
			
		}
		return true;
	}
	public boolean checkMapDown(int x,int y,int width,int height) {
		
		y=y+height+1;
		for(int i=0;i<width;i++) {
			
			if(getMap(x/30,y/30).equals("2")) return false;
			else if (getMap(x/30,y/30).equals("1")) return false;
			else {
				x=x+1;
			}
			
		}
		return true;
	}
	
	
	public Map(String s) {
		
		openFile(s);
		readFile();
		closeFile();
		
	}
	public void openFile(String s ) {
		
		try {
			m= new Scanner(new File("src/data/"+s));
		} catch (FileNotFoundException e) {
			System.out.println("File not found !");
		}
		
	}
	
	public void readFile() {
		
		while(m.hasNext()) {
			for(int i=0;i<20;i++) {
				Map[i]=m.next();
			}
		}
		
	}
	
	public void closeFile( ) {
		
		m.close();
		
	}
	
}
