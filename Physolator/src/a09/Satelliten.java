package a09;

import static java.lang.Math.*;
import mechanics.tvg.MechanicsTVG;
import de.physolator.usr.*;
import de.physolator.usr.components.*;
import static de.physolator.usr.components.VectorMath.*;

public class Satelliten extends PhysicalSystem {
	
	@V(unit = "m^3/kg s^2")
	double G = 6.67428e-11;
	
	@V(unit = "N")
	public double Fg;
	
	public Himmelskoerper erde = new Himmelskoerper(0, 0, 0, 0, 0, 0, 5.974E24);
	public Himmelskoerper satellit = new Himmelskoerper(4e7, 0, 0, 4000, 0, 0, 100);
	
	public void f(double t, double h) {
		double r = abs(satellit.r);
		Fg = G*((erde.m*satellit.m)/(r*r));
		
		double a = Fg/satellit.m;
		
		ax = -x*a/r;
		ay = -y*a/r;
		
	}
	
	public void initGraphicsComponents(GraphicsComponents g, Structure s, Recorder r,
	 SimulationParameters sp) {
	
		MechanicsTVG t = new MechanicsTVG(this, s, r);
		double p = 1.2e8;
		t.geometry.setUserArea(-p, p, -p, p);
		t.showPaths = true;
		t.showVelocity = false;
		t.showAcceleration = false;
		t.showLabels = true;
		g.addTVG(t);
	}
	public void initSimulationParameters(SimulationParameters s) {
	s.fastMotionFactor = 20000;
	}
	
	public static void main (String args[]) {
		
		start();
		
	}
}