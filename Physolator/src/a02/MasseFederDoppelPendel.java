package a02;

import de.physolator.usr.*;

import static java.lang.Math.*;

public class MasseFederDoppelPendel extends PhysicalSystem {

	//Konstanten
	
	@V(unit="m^2")
	public double A;
	
	@V(unit="kg")
	public double m= 0.125;
	
	@V(unit="N/m")
	public double D= 1.5;
	
	@V(unit="m")
	public double d= 5;
	
	@V(unit="m/s^2")
	public double g= 9.81;
	
	@V(unit="m")
	public double r= 0.15;
	
	@V(unit=" ")
	public double cw = 0.4;
	
	@V(unit="kg/m^3")
	public double phi = 1.2041;
	
	//Zustandsvariabeln
	@V(unit="m", derivative="v1")
	public double x1= 2.8;
	
	@V(unit="m", derivative="v2")
	public double x2= 2;
	
	@V(unit="m/s", derivative="a1")
	public double v1= 0;
	
	@V(unit="m/s", derivative="a2")
	public double v2= 0;
	
	//abhängige Variabeln
	@V(unit="N")
	public double F_f1;
	
	@V(unit="N")
	public double F_f2;
	
	@V(unit="m/s^2")
	public double a1;
	
	@V(unit="m/s^2")
	public double a2;
	
	@V(unit="N")
	public double F_l1;
	
	@V(unit="N")
	public double F_l2;
	
	@V(unit="N")
	public double F_g;
	
	@V(unit="N")
	public double F1;
	
	@V(unit="N")
	public double F2;
	
	
	@Override
	public void f(double t, double h) {
		F_f1 = (d - x1) * D;
		F_f2 = (x1 - x2) * D;
		F_g = -m*g;
		
		F1 = F_f1 - F_f2 + F_g + F_l1;
		F2 = F_f2 + F_g + F_l2;
		
		a1 = F1 / m;
		a2 = F2 / m;
		
		A = pow(r, 2)*PI;
		
		F_l1 = (0.5*A*cw*phi*pow(v1,2))*(-signum(v1));
		F_l2 = (0.5*A*cw*phi*pow(v2,2))*(-signum(v2));
	}


	@Override
	public void initPlotterDescriptors(PlotterDescriptors r) {
		r.add("x1,v1,x2,v2", 20, -10, 10);
		
	}


	public static void main(String[] args) {
		start();

		
		
	}
	

}

