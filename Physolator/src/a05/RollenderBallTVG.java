package a05;

import de.physolator.usr.tvg.TVG;
import de.physolator.usr.tvg.Shape;

import static java.lang.Math.*;


	public class RollenderBallTVG extends TVG {
		private RollenderBall rb;
		
		public RollenderBallTVG(RollenderBall rollenderBall) {
			rb = rollenderBall;
			geometry.setUserArea(-1, 6, -0.5, 1.3);
			geometry.setRim(30, 30, 30, 30);
			scalesStyle.visible = true;
		}
		
		public void paint() {
			style.useUCS = true;
			style.strokeWidth = 3;
		
			drawCircle(rb.x, rb.r, rb.r, Shape.POLYGON_LINE_LOOP);
			
			style.strokeWidth = 5;
		
			drawLine(rb.x,rb.r,rb.x+(rb.Kx),rb.r+(rb.Ky));
			
			style.strokeWidth = 3;
			
			drawRectangle(rb.wand, 0, rb.wand+0.5, 1, Shape.POLYGON_LINE_LOOP);
			
			
		}
}