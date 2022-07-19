package grail.compositeFigs;

import java.io.IOException;

import grail.geometryFigs.MovingL;
import grail.geometryFigs.RestrictedLine;
import grail.geometryFigs.RotatingLine;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.LEGS)
public class RealisticLegs extends ArmsAndLegs implements RealLegs {
	static final double
	MIN_1 = Math.PI/2,
	MAX_1 = Math.PI,
	MIN_2 = 0,
	MAX_2 = Math.PI/2;
	
		
	public RealisticLegs() {
		leftLine = new RotatingLine();
		rightLine = new RotatingLine();
	}
	public RealisticLegs(double rad, double ang,double radR, double angR, int valX, int valY)  {
		leftLine = new RestrictedLine(rad, ang, valX, valY, MAX_2, MIN_2);
		rightLine = new RestrictedLine(radR, angR, valX, valY, MAX_1, MIN_1);
	}

//	@Override
//	public MovingL getLeftLine() {
//		return leftLine;
//	}
//	@Override
//	public MovingL getRightLine() {
//		return rightLine;
//	}
//	@Override
//	public void moveLimbs(int newX, int newY) {
//		leftLine.setX(leftLine.getX() + newX);
//		leftLine.setY(leftLine.getY() + newY);
//		rightLine.setX(rightLine.getX() + newX);
//		rightLine.setY(rightLine.getY() + newY);
//
//	}
	
	
}
