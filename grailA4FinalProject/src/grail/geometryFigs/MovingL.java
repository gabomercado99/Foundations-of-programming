package grail.geometryFigs;

import java.io.IOException;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags(Comp301Tags.ROTATING_LINE)
@PropertyNames({"X", "Y", "Angle", "Radius", "XH", "YH", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})

public interface MovingL extends BoundedShape {
	
	//public void setX(int newX);
	//public void setY(int newY);
	//public int getX();
	//public int getY();
	public double getRadius();
	public double getAngle();
	public void setRadius(double newR);
	public void setAngle(double newAng) throws IOException;
	public void rotate(int units);
	public void move(int newX, int newY);
	public MovingL clone();

}
