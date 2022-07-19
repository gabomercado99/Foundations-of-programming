package grail.compositeFigs;


import java.beans.PropertyChangeListener;

import grail.geometryFigs.MovingL;
import grail.geometryFigs.RotatingLine;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags(Comp301Tags.ANGLE)

public class ArmsAndLegs implements AngleShapes {
	
	
	MovingL leftLine = new RotatingLine();
	MovingL rightLine = new RotatingLine();
	
	public ArmsAndLegs() {
		leftLine = new RotatingLine();
		rightLine = new RotatingLine();
	}
	public ArmsAndLegs(double rad, double ang,double radR, double angR, int valX, int valY) {
		leftLine = new RotatingLine(rad, ang, valX, valY);
		rightLine = new RotatingLine(radR, angR, valX, valY);
	}

	@Override
	public MovingL getLeftLine() {
		return leftLine;
	}
	@Override
	public MovingL getRightLine() {
		return rightLine;
	}
	@Override
	public void moveLimbs(int newX, int newY) {
		leftLine.setX(leftLine.getX() + newX);
		leftLine.setY(leftLine.getY() + newY);
		rightLine.setX(rightLine.getX() + newX);
		rightLine.setY(rightLine.getY() + newY);

	}	
	

}
