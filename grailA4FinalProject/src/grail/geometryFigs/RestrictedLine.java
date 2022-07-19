package grail.geometryFigs;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

import grail.compositeFigs.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.RESTRICTED_LINE)
public class RestrictedLine extends RotatingLine implements RealisticLine {
	
	
	double maxAngle;
	double minAngle;

	public RestrictedLine(int initx, int inity) {
		x = initx;
		y = inity;
	}
	public RestrictedLine(double initRad, double initAng, int initx, int inity, double topAngle, double lowAngle) {
		x = initx;
		y = inity;
		maxAngle = topAngle;
		minAngle = lowAngle;
		radius = initRad;
		try {
			lowerRC = new PolarPoint(radius, angle);
			setAngle(initAng);
		} catch (IOException e) {
			System.out.println("Angle Out of Range");
			e.printStackTrace();
		}
		
		height = lowerRC.getYH();
		width = lowerRC.getXH(); 
	}
	
	@Override
	public void setAngle (double newAngle) throws IOException {
		if (maxAngle < newAngle || newAngle < minAngle) {
			throw new ImpossibleAngleException("Angle out of range");
		}
		double oldAngle = angle;
		angle = newAngle;
		lowerRC.setAngle(newAngle);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldAngle,
				newAngle));
	}

}
