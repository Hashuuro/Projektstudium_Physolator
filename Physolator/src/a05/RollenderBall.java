package a05;

import de.physolator.usr.*;
import static java.lang.Math.*;

public class RollenderBall extends PhysicalSystem {

	//Konstanten
	@V(unit="kg")
	public double m= 5;
	
	@V(unit="m")
	public double r= 0.4;
	
	@V(unit="m/s^2")
	public double g= 9.81;
		
	@V(unit=" ")
	public double cr = 0.05;
	
	@V(unit="N")
	public double Fr = -m*g*cr;
	
	@V(unit="m")
	public double U = 2*PI*r;
	
	
	//Zustandsvariabeln
	@V(unit="m", derivative="v")
	public double x= 0;
	
	@V(unit="m/s", derivative="a")
	public double v= 2.3;
	
	@V(unit="m/s")
	public double w= v/r;
	
	@V(unit="s")
	public double T= v/r;
	
	//abhängige Variabeln
	
	@V(unit="m/s^2")
	public double a;
	
	
	@Override
	public void f(double t, double h) {
		
		a = Fr / m;
		
		T = (2*PI)/w;
		
		
			}


	@Override
	public void initPlotterDescriptors(PlotterDescriptors r) {
		r.add("x,v,Fr", 20, -10, 10);
		
	}
	
	public void initGraphicsComponents(GraphicsComponents g) {
		g.addTVG(new RollenderBallTVG(this));
		}
	
	public void g(double t, AfterEventDescription afterEventDescription) {
		if (v < 0)
		afterEventDescription.reportEvent(() -> {
		Fr = 0;
		v = 0;
		});
		}

	public static void main(String[] args) {
		start();

		
		
	}
	

}

