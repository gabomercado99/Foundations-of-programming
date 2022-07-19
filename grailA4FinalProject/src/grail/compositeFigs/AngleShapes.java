package grail.compositeFigs;

import java.beans.PropertyChangeListener;

import grail.geometryFigs.MovingL;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.ANGLE)

public interface AngleShapes {
	
	public MovingL getLeftLine();
	public MovingL getRightLine();
	public void moveLimbs(int newX, int newY);
	public static void addPropertyChangeListener(AngleShapes anAngle, PropertyChangeListener aListener) {
		anAngle.getLeftLine().addPropertyChangeListener(aListener);
		anAngle.getRightLine().addPropertyChangeListener(aListener);
	}

}
