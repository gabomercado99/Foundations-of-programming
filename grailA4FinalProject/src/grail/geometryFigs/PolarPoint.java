package grail.geometryFigs;

import java.beans.PropertyChangeEvent;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@PropertyNames({"X", "Y", "Angle", "Radius", "XH", "YH"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius"})

public class PolarPoint extends Alocatable implements Point {
	
	double radius, angle;

	public PolarPoint() {
		radius = 0;
		angle = 0;
	}
	
	public PolarPoint(double theRadius, double theAngle) {
		radius = theRadius;
		angle = theAngle;
	}
	public PolarPoint(int theX, int theY) {
		radius = Math.sqrt(theX*theX + theY*theY);
		angle = Math.atan((double) theY/theX);
	}

	@Override
	public int getXH() {
		return (int) (radius*Math.cos(angle));
	}
	@Override
	public int getYH() {
		return (int) (radius*Math.sin(angle));
	}
	
	@Override
	public double getAngle() { return angle; } 
	@Override
	public double getRadius() { return radius;}
	
	@Override
	public void setRadius(double newR) { 
		double oldR = getRadius();
		radius = newR;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldR,
				newR));
		}
	
	@Override
	public void setAngle(double newAng) { 
		double oldAng = getAngle();
		angle = newAng;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldAng,
				newAng));
		}

}
