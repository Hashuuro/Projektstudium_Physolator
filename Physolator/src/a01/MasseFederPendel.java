package a01;

import de.physolator.usr.*;
import static java.lang.Math.*;

public class MasseFederPendel extends PhysicalSystem {

	//Konstanten
	@V(unit="kg")
	public double m= 0.25;
	
	@V(unit="N/m")
	public double D= 1.5;
	
	@V(unit="m")
	public double d= 4;
	
	@V(unit="m/s^2")
	public double g= 9.81;
	
	@V(unit="m")
	public double r= 0.15;
	
	@V(unit=" ")
	public double cw = 0.4;
	
	@V(unit="kg/m^3")
	public double phi = 1.2041;
	
	//Zustandsvariabeln
	@V(unit="m", derivative="v")
	public double x= 1.8;
	
	@V(unit="m/s", derivative="a")
	public double v= 0;
	
	//abhängige Variabeln
	@V(unit="N")
	public double F;
	
	@V(unit="m/s^2")
	public double a;
	
	@V(unit="N")
	public double Fl;
	
	@V(unit="m^2")
	public double A;
	
	@Override
	public void f(double t, double h) {
		F = ((d - x) * D - m * g)+Fl;
		a = F / m;
		A = pow(r, 2)*PI;
		Fl = (0.5*A*cw*phi*pow(v,2))*(-signum(v));
	}


	@Override
	public void initPlotterDescriptors(PlotterDescriptors r) {
		r.add("x,v", 20, -10, 10);
		
	}


	public static void main(String[] args) {
		start();

		
		
	}
	

}

