package a07;

import static de.physolator.usr.tvg.Shape.*;
import static java.lang.Math.*;
import de.physolator.usr.tvg.TVG;
import de.physolator.usr.util.Colors;

public class LokomotiveTVG extends TVG {
	
	private Lokomotive lokomotive;
	
	public LokomotiveTVG(Lokomotive lokomotive) {
		
		this.lokomotive = lokomotive;
		
		geometry.setRim(20, 20, 20, 20);
		geometry.setUserArea(-2, 10, -1, 5);
		scalesStyle.visible = true;
	}
	
	public void paint() {
		
		style.useUCS = true;
		style.strokeWidth = 3;
		style.strokeColor = Colors.black;
		style.fillColor = Colors.aquamarine4;//----> doesnt work
		//chimneys
		drawRectangle(2.8,2.6,3.2,3.1);
		drawRectangle(3.8,2.6,4.2,3.1);
		drawRectangle(5.8,2.6,6.8,4);
		//corpus
		drawRectangle(2.1,0.9,7.6,2.6);
		//cabin
		drawRectangle(0.5,0.9,2.1,3.4);
		//steps
		drawRectangle(0.25,0.6,1,0.9);
		drawRectangle(0,0.3,0.7,0.6);
		//roof
		drawRectangle(0,3.4,2.6,3.7);
		//cylinder
		drawRectangle(4.8,0.5,6.7,0.9);
		//wheels
		style.strokeWidth = 2;
		drawCircle(2,0.7,0.7);
		drawaxis(2,0.7,0.7);
		drawCircle(3.7,0.7,0.7);
		drawaxis(3.7,0.7,0.7);
		drawCircle(7.5,0.4,0.45);
		drawaxis(7.5,0.4,0.45);
		//window
		style.strokeWidth = 3;
		drawRectangle(0.8,2.2,1.8,3.2);
		//circles
		double angle = ((360/10)*5)+90;
		double radians = angle * (Math.PI / 180);
		drawCircle(2-cos(radians)*0.5,0.7-sin(radians)*0.5, 0.15);
		drawCircle(3.7-cos(radians)*0.5,0.7-sin(radians)*0.5, 0.15);
		//square
		drawRectangle(5.4,0.55,5.7,0.9);
		//connectionLines
		drawLine(2-cos(radians)*0.5,0.7-sin(radians)*0.5,3.7-cos(radians)*0.5,0.7-sin(radians)*0.5);
		drawLine(3.7-cos(radians)*0.5,0.7-sin(radians)*0.5,5.4+((5.7-5.4)/2),0.55+((0.9-0.55)/2));
	}
	
	public void drawaxis(double x1, double y1, double r )
	{
		for(double i = 0;i<=10;i++) {
			
			 double angle = ((360/10)*i)+90;
			
			double radians = angle * (Math.PI / 180);
			
		drawLine(x1,y1,x1-cos(radians)*r,y1-sin(radians)*r);
		
		}
	}
	
}

