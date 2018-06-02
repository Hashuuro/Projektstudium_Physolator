package a08;

import static java.lang.Math.*;
import mechanics.tvg.MechanicsTVG;
import de.physolator.usr.*;
import de.physolator.usr.components.*;
import de.physolator.usr.tvg.Shape;
import de.physolator.usr.util.Colors;

public class Satellit extends PhysicalSystem {
	
	
	
	
	@V(unit = "m")
	public double r;
	
	@V(unit = "m³/(kg*s²)")
	public double G = 6.67408e-11;

	@V(unit = "kg")
	public double ms = 100 ;

	@V(unit = "kg")
	public double me = 5.974e24;

	@V(unit = "N")
	public double Fg;
	
	@V(unit = "N")
	public double Ffugal;
	
	
	@V(unit="m", derivative = "vx")
	public double x = 4e7;
			
	@V(unit="m", derivative = "vy")
	public double y = 0;
			
	@V(unit="m/s", derivative = "ax")
	public double vx = 0;
			
	@V(unit="m/s", derivative = "ay")
	public double vy = 4e3;
	
	@V(unit="m/s")
	public double v;
	
	@V(unit="m/s^2")
	public double ax;
	
	@V(unit="m/s^2")
	public double ay;

	
	public void initGraphicsComponents(GraphicsComponents g, Structure s, Recorder r,SimulationParameters sp) 
	{
		MechanicsTVG t = new MechanicsTVG(this, s, r) {
			
			public void paint() {
				
				super.paint();
				style.fillColor = Colors.grey;
				drawCircle(0,0,6.370e6, Shape.POLYGON);
			}
		};
		
		double p = 2e8;
		t.geometry.setUserArea(-p, p, -p, p);
		t.showPaths = true;
		t.showVelocity = false;
		t.showAcceleration = false;
		t.showLabels = false;
		t.addPointMass("x", "y", "vx", "vy", "ax", "ay");//------> bei Initialisierung stürzt ab. Variabeln nicht definiert.
		g.addTVG(t);
	}
	
	public void initSimulationParameters(SimulationParameters s) {
		
		s.fastMotionFactor = 20000;
	
	}
	
	@Override
	public void f(double t, double h)
	{
		r = sqrt(x*x+y*y);
		Fg = G*((me*ms)/(r*r));
		double a = Fg/ms;
		ax = -x*a/r;
		ay = -y*a/r;
		
	}
	
	//public ThresholdTrigger tr1 = new ThresholdTrigger(() -> r > 4e7 )//-----------> wie aufbauen? Wenn Anfangswert, dann nur ein Event!!
		//	.setName("Umrundung").setInfo(() ->  "x="+x + " y="+y).setDoPrint(true);
	
	public static void main (String args[]) {
		
		start();
		
	}
}

