package a03;

import de.physolator.usr.*;

public class Haus extends PhysicalSystem {
	
	
	public void initGraphicsComponents(GraphicsComponents g) {
		
		g.addTVG(new HausTVG());
		
	}
	
	public static void main (String args[]) {
		
		start();
		
	}
}
