package a04;

import de.physolator.usr.tvg.TVG;
import de.physolator.usr.util.parameter.Parameter;
import de.physolator.usr.util.parameter.Slider;

public class HausKonfiguratorTVG extends TVG {
	
	public HausKonfiguratorTVG() {
		
		geometry.setUserArea(-1, 16, -1, 11);
		
		geometry.setRim(30, 30, 30, 30);
		
		scalesStyle.visible = true;
	}
	
	@Parameter
	@Slider(min=7, max=20, step=0.1, width=200)
	public double d=9;
	
	@Parameter
	@Slider(min=1, max=10, width=200)
	public int m=8;
	
	@Parameter
	@Slider(min=1, max=10, width=200)
	public int n=6;
	
	
	public void paint() {
		
		style.useUCS = true;
		
		style.strokeWidth = 3;
		
		zeichneHaus(10, 5, 5, 1, 1, 0.5, 0, 0);
		
	}
	
	//------> umständlich geschrieben. Wie vereinfachen?
	private void zeichneHaus(double b, double h1, double h2, double d, double sh, double sb, double x, double y) {
		
		
		int door_height = 2;
		int window_height = 1;
		int window_toFloor = 1;
		double door_width = (2/15)*b;
		double window_width = (1/5)*b;
		double groundFloor_x = (1/3)*b;
		double groundFloor_middle = groundFloor_x/2;
		
		
		
		//Hauswand
		drawLine(0+x,0+y,7.5+x,0+y);
		drawLine(0+x,0+y,0+x,3+y);
		drawLine(7.5+x,0+y,7.5+x,3+y);
		
		//Tür
		double door_leftside_x1 = 
		double door_leftside_x2 =
		double door_leftside_y1 =
		double door_leftside_y2 =
		
		drawLine(0.8+x,0+y,0.8+x,door_height+y);
		drawLine(0.8+x,door_height+y,1.8+x,door_height+y);
		drawLine(1.8+x,0+y,1.8+x,door_height+y);
		
		//Fenster1
		drawLine(3+x,1+y,3+x,2+y);
		drawLine(3+x,2+y,4.5+x,2+y);
		drawLine(4.5+x,2+y,4.5+x,1+y);
		drawLine(3+x,1+y,4.5+x,1+y);
		
		//Fenster 2
		drawLine(5.5+x,1+y,5.5+x,2+y);
		drawLine(5.5+x,2+y,7+x,2+y);
		drawLine(7+x,2+y,7+x,1+y);
		drawLine(5.5+x,1+y,7+x,1+y);
		
		//Fenster 3
		drawCircle(3.8+x, 3.9+y, 0.6);
		
		//Dach
		drawLine(-0.5+x,2.6+y,3.8+x,6+y);
		drawLine(8+x,2.6+y,3.8+x,6+y);
		
		//Kamin
		drawLine(5.2+x,4.8+y,5.2+x,5.6+y);
		drawLine(5.2+x,5.6+y,6+x,5.6+y);
		drawLine(6+x,5.6+y,6+x,4.2+y);
	}
	
}