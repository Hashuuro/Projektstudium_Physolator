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
	
	@V(unit="m^2")
	public double A;
	
	@V(unit=" ")
	public double cw = 0.4;
	
	@V(unit="kg/m^3")
	public double phi = 1.2041;
	
	@V(unit="")
	public double k = 0.7;
	
	@V(unit="Position")
	public double wand= 3.5;
	
	//Zustandsvariabeln
	@V(unit="m", derivative="v")
	public double x= 0;
	
	@V(unit="m/s", derivative="a")
	public double v= 2.3;
	
	@V(unit="")
	public boolean rechtsbewegung = true;
	
	//abhängige Variabeln
	
	@V(unit="m/s^2")
	public double a;
	
	@V(unit="m/s")
	public double w= v/r;
	
	@V(unit="s")
	public double T= v/r;
	
	@V(unit="m/s")
	public double kv;
	
	@V(unit=" ")
	public double Kx;
	
	@V(unit=" ")
	public double Ky;
	
	@V(unit="N")
	public double Fl;
	
	
	@Override
	public void f(double t, double h) {
		
		a = (Fr+Fl) / m;
		
		T = (2*PI)/w;
		
		A = pow(r, 2)*PI;
		
		Kx = -(r*sin(w*x));
				
		Ky = -(r*cos(w*x));
		
		Fl = (0.5*A*cw*phi*pow(v,2))*(-signum(v));
		
		kv = -k*v;
		
		
			}


	@Override
	public void initPlotterDescriptors(PlotterDescriptors r) {
		r.add("x,v,Fr,Fl", 20, -10, 10);
		
	}
	
	public void initGraphicsComponents(GraphicsComponents g) {
		g.addTVG(new RollenderBallTVG(this));
		}
	
	public void g(double t, AfterEventDescription afterEventDescription) {
		
		
		if (x > (wand-r) )
			afterEventDescription.reportEvent(() -> {
			v = kv;
			Fr = m*g*cr;
			rechtsbewegung = false;
			});
		
		if( rechtsbewegung == true) {
			
			if (v < 0)
				afterEventDescription.reportEvent(() -> {
					Fr = 0;
					v = 0;
				});
		}
		else if(rechtsbewegung == false) {
			
			if (v > 0)
				afterEventDescription.reportEvent(() -> {
					Fr = 0;
					v = 0;
				});				
		}
		
		
		}

	public static void main(String[] args) {
		start();

		
		
	}
	

}

