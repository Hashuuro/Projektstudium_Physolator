package a03;

import de.physolator.usr.tvg.TVG;

public class HausTVG extends TVG {
	
	public HausTVG() {
		
		geometry.setUserArea(-1, 80, -1, 60);
		
		geometry.setRim(30, 30, 30, 30);
		
		scalesStyle.visible = true;
	}
	
	
	
	public void paint() {
		
		style.useUCS = true;
		
		style.strokeWidth = 3;
		
		//  Platz für die Zeichenbefehle
		
		//Hauswand
		drawLine(0,0,7.5,0);
		drawLine(0,0,0,3);
		drawLine(7.5,0,7.5,3);
		
		//Tür
		drawLine(0.8,0,0.8,2);
		drawLine(0.8,2,1.8,2);
		drawLine(1.8,0,1.8,2);
		
		//Fenster1
		drawLine(3,1,3,2);
		drawLine(3,2,4.5,2);
		drawLine(4.5,2,4.5,1);
		drawLine(3,1,4.5,1);
		
		//Fenster 2
		drawLine(5.5,1,5.5,2);
		drawLine(5.5,2,7,2);
		drawLine(7,2,7,1);
		drawLine(5.5,1,7,1);
		
		//Fenster 3
		drawCircle(3.8, 3.9, 0.6);
		
		//Dach
		drawLine(-0.5,2.6,3.8,6);
		drawLine(8,2.6,3.8,6);
		
		//Kamin
		drawLine(5.2,4.8,5.2,5.6);
		drawLine(5.2,5.6,6,5.6);
		drawLine(6,5.6,6,4.2);
		
		
		
		for(int m=0;m<8;m++) {
				for(int n=0; n<6;n++) {
					int d = 9;
			zeichneHaus(m*d,n*d);
				}
		}
	}
	
	//------> umständlich geschrieben. Wie vereinfachen?
	private void zeichneHaus(double dx, double dy) {
		
		//Hauswand
		drawLine(0+dx,0+dy,7.5+dx,0+dy);
		drawLine(0+dx,0+dy,0+dx,3+dy);
		drawLine(7.5+dx,0+dy,7.5+dx,3+dy);
		
		//Tür
		drawLine(0.8+dx,0+dy,0.8+dx,2+dy);
		drawLine(0.8+dx,2+dy,1.8+dx,2+dy);
		drawLine(1.8+dx,0+dy,1.8+dx,2+dy);
		
		//Fenster1
		drawLine(3+dx,1+dy,3+dx,2+dy);
		drawLine(3+dx,2+dy,4.5+dx,2+dy);
		drawLine(4.5+dx,2+dy,4.5+dx,1+dy);
		drawLine(3+dx,1+dy,4.5+dx,1+dy);
		
		//Fenster 2
		drawLine(5.5+dx,1+dy,5.5+dx,2+dy);
		drawLine(5.5+dx,2+dy,7+dx,2+dy);
		drawLine(7+dx,2+dy,7+dx,1+dy);
		drawLine(5.5+dx,1+dy,7+dx,1+dy);
		
		//Fenster 3
		drawCircle(3.8+dx, 3.9+dy, 0.6);
		
		//Dach
		drawLine(-0.5+dx,2.6+dy,3.8+dx,6+dy);
		drawLine(8+dx,2.6+dy,3.8+dx,6+dy);
		
		//Kamin
		drawLine(5.2+dx,4.8+dy,5.2+dx,5.6+dy);
		drawLine(5.2+dx,5.6+dy,6+dx,5.6+dy);
		drawLine(6+dx,5.6+dy,6+dx,4.2+dy);
	}
	
}
