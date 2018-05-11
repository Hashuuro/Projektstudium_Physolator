package a06;

import static java.lang.Math.*;

import mechanics.tvg.MechanicsTVG;

import de.physolator.usr.*;
import de.physolator.usr.components.*;


public class SchieferWurf extends PhysicalSystem {

	
	//Konstanten
		
		@V(unit="m/s^2")
		public double g = 9.81;
		
	/*	@V(unit="m/s")
		public double v0 = 28;
		
		@V(unit="")
		public double cw = 0.4;
		
		@V(unit="kg/m^3")
		public double phi = 1.2041;
		
		@V(unit="Grad")
		public double phiWinkel = 37;
		
		@V(unit="kg")
		public double m = 0.1;
		
		@V(unit="m")
		public double r = 0.1;*/
		
		//Zustandsvariabeln
		@V(unit="Positionx", derivative = "vx")
		public double x = 0;
		
		@V(unit="Positiony", derivative = "vy")
		public double y = 10;
		
		@V(unit="m/s", derivative = "ax")
		public double vx = 20;
		
		@V(unit="m/s", derivative = "ay")
		public double vy = 20;
		
		
		//abhängige Variabeln
		
		@V(unit="m/s^2")
		public double ax;
		
		@V(unit="m/s^2")
		public double ay;
		
	/*	@V(unit="N")
		public double Flx;
		
		@V(unit="N")
		public double Fly;
		
		@V(unit="m^2")
		public double A;*/
		
		
		@Override
		public void f(double t, double h) {
			//A = pow(r, 2)*PI;
			//Flx = (0.5*A*cw*phi*pow(vx,2))*(-signum(vx));
			//Fly = (0.5*A*cw*phi*pow(vy,2))*(-signum(vy));
			
			ax = 0;
			ay = -g;
			
		  // vx = v0*cos(toRadians(phiWinkel));
		  // vy = v0*sin(toRadians(phiWinkel))-(g*t);

		}

	
	@Override
	public void initPlotterDescriptors(PlotterDescriptors r) {
		
		r.add("y,vx,vy", 50, -100, 100);
		
	}
	
	
	
	public void initGraphicsComponents(GraphicsComponents g, Structure s, Recorder r,
			SimulationParameters sp) {
		
		MechanicsTVG t = new MechanicsTVG(this, s, r);
		
		t.geometry.setUserArea(0, 150, 0, 50);
		t.showPaths = true;
		t.showVelocity = true;
		t.showAcceleration = true;
		t.velocityScaling = 1;
		t.accelerationScaling = 1;
		t.showLabels = false;
		t.addPointMass("x", "y", "vx", "vy", "ax", "ay");
		g.addTVG(t);
	}
	/*public ThresholdTrigger tr1 = new ThresholdTrigger(() -> vy < 0)
			.setName("Hochpunkt").setInfo(() ->  "x="+x + " y="+y).setDoPrint(true);
	
	public ThresholdTrigger tr2 = new ThresholdTrigger(() -> y < 0)
			.setName("Strecke").setInfo(() ->  "x="+x + " y="+y).setDoPrint(true);
	
	public TimeTrigger tr3 = new TimeTrigger(0.27134)
			.setName("Zeitpunkt 1").setInfo(() -> "x=" + x + " y=" + y).setDoPrint(true);
	
	public TimeTrigger tr4 = new TimeTrigger(0.27134, 0.4525, 1.273)
			.setInfo(() -> "x=" + x + " y=" + y).setDoPrint(true);*/
	
	public static void main(String[] args) {
		start();

		
		
	}
}
