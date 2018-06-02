package a09;

import de.physolator.usr.V;
import de.physolator.usr.components.Vector2D;

	public class Himmelskoerper {

		@V(unit = "kg")
		public double m = 5.974E24;

		@V(unit = "m", derivative = "v")
		public Vector2D r = new Vector2D(0, 0);

		@V(unit = "m/s", derivative = "a")
		public Vector2D v = new Vector2D(0, 0);

		@V(unit = "m/s^2")
		public Vector2D a = new Vector2D(0, 0);
		
		public Himmelskoerper(double x, double y, double vx, double vy, double ax, double ay,double m) 
		{
			r.set(x,y);
			v.set(vx,vy);
			a.set(ax,ay);
			this.m = m;
		}
}
