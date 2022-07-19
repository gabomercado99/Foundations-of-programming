package grail.geometryFigs;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;


@PropertyNames({"X", "Y", "Angle", "Radius", "XH", "YH"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius"})

public interface Point extends Locatable {
	
	
	public int getXH();
	
	public int getYH();
	
	public double getAngle();
	public double getRadius();
	public void setRadius(double newR);
	public void setAngle(double newAng);

}
