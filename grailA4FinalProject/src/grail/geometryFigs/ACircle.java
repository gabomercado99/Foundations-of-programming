package grail.geometryFigs;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})

public class ACircle extends RotatingLine implements CircleFig{
	
	public ACircle(double initRad, double initAng, int initx, int inity) {
		x = initx;
		y = inity;
		radius = initRad;
		angle = initAng;
		lowerRC = new PolarPoint(radius, angle);
		height = lowerRC.getYH();
		width = lowerRC.getXH();
	}
	@Override
	public void move(int newX, int newY) {
		int oldHorizontal = x;
		int oldVertical = y;
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVertical,
				newY));
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldHorizontal,
				newX));
	}
}
