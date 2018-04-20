package a04;

import de.physolator.usr.*;

public class HausKonfigurator extends PhysicalSystem {
	
	
	public void initGraphicsComponents(GraphicsComponents g) {
		
		g.addTVG(new HausKonfiguratorTVG());
		
	}
	
	public static void main (String args[]) {
		
		start();
		
	}
}
