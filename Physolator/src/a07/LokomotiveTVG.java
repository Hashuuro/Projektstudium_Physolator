package a07;

import static de.physolator.usr.tvg.Shape.*;
import static java.lang.Math.*;
import de.physolator.usr.tvg.TVG;
import de.physolator.usr.util.Colors;
import de.physolator.usr.util.parameter.Parameter;
import de.physolator.usr.util.parameter.Slider;

public class LokomotiveTVG extends TVG {
	
	private Lokomotive lokomotive;
	
	public LokomotiveTVG(Lokomotive lokomotive) {
		
		this.lokomotive = lokomotive;
		
		geometry.setRim(20, 20, 20, 20);
		geometry.setUserArea(-2, 10, -1, 5);
		scalesStyle.visible = true;
	}
	
	@Parameter
	@Slider(min = 0, max = 10, step=0.01, width = 200)
	public double x = 0;
	@Parameter
	@Slider(min = 0, max = 10, step=0.01, width = 200)
	public double y = 0;
	@Parameter
	@Slider(min = 0, max = 360, width = 200)
	public int alpha = 0;
	@Parameter
	@Slider(min = 0, max = 360, width = 200)
	public int beta = 0;
	
	public void paint() {
		
		//double t = lokomotive.getSimInfo().getActualFrameData().simulationTime;
		style.useUCS = true;
		style.strokeWidth = 3;
		style.strokeColor = Colors.black;
		style.fillColor = Colors.aquamarine4;//----> doesnt work
		
		zeichneLokomotive(x,y,alpha,beta);
		
	}
	
	/*public void drawchimneys(double x1, double y1, double x2, double y2)
	{
		drawRectangle(x1,y1,3.2,y2);
		drawRectangle(x1,y1,4.2,y2);
		drawRectangle(x1*2.07,y1,6.8,y2*1.29);	
	}*/
	
	public void drawaxis(double x1, double y1,double gamma, double r )
	{
		for(double i = 0;i<=10;i++) {
			
			 double angle = ((360/10)*i)+gamma;
			
			double radians = -1*(angle * (Math.PI / 180));
			
		drawLine(x1,y1,x1-cos(radians)*r,y1-sin(radians)*r);
		
		}
	}
	
	public void zeichneLokomotive(double x, double y, double alpha, double beta) 
	{
		
				//chimneys
				drawRectangle(2.8+x,2.6+y,3.2+x,3.1+y);
				drawRectangle(3.8+x,2.6+y,4.2+x,3.1+y);
				drawRectangle(5.8+x,2.6+y,6.8+x,4+y);
				//corpus
				drawRectangle(2.1+x,0.9+y,7.6+x,2.6+y);
				//cabin
				drawRectangle(0.5+x,0.9+y,2.1+x,3.4+y);
				//steps
				drawRectangle(0.25+x,0.6+y,1+x,0.9+y);
				drawRectangle(0+x,0.3+y,0.7+x,0.6+y);
				//roof
				drawRectangle(0+x,3.4+y,2.6+x,3.7+y);
				//cylinder
				drawRectangle(4.8+x,0.5+y,6.7+x,0.9+y);
				//window
				drawRectangle(0.8+x,2.2+y,1.8+x,3.2+y);
				//circles
				double radians = -1*(alpha * (Math.PI / 180));
				drawCircle((2-cos(radians)*0.5)+x,(0.7-sin(radians)*0.5)+y, 0.15);
				drawCircle((3.7-cos(radians)*0.5)+x,(0.7-sin(radians)*0.5)+y, 0.15);
				//square
				drawRectangle(5.4-0.5*cos(radians)+x,0.55+y,5.7-0.5*cos(radians)+x,0.9+y);
				//connectionLines
				drawLine((2-cos(radians)*0.5)+x,(0.7-sin(radians)*0.5)+y,(3.7-cos(radians)*0.5)+x,(0.7-sin(radians)*0.5)+y);
				
				drawLine((3.7-cos(radians)*0.5)+x,(0.7-sin(radians)*0.5)+y,(5.4+((5.7-5.4)/2))-0.5*cos(radians)+x,(0.55+((0.9-0.55)/2)+y));
				//wheels
				style.strokeWidth = 2;
				drawCircle(2+x,0.7+y,0.7);
				drawaxis(2+x,0.7+y,alpha,0.7);
				drawCircle(3.7+x,0.7+y,0.7);
				drawaxis(3.7+x,0.7+y,alpha,0.7);
				drawCircle(7.5+x,0.4+y,0.45);
				drawaxis(7.5+x,0.4+y,beta,0.45);
		
		}
	
}

