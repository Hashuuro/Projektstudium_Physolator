package a07;

import de.physolator.usr.*;

public class Lokomotive extends PhysicalSystem {
	
	public void initGraphicsComponents(GraphicsComponents g) {
		
		g.addTVG(new LokomotiveTVG(this));
		
	}
	
	public static void main (String args[]) {
		
		start();
		
	}
}
