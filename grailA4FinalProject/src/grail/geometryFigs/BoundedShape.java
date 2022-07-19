package grail.geometryFigs;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags(Comp301Tags.BOUNDED_SHAPE)
@PropertyNames({"X", "Y", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Height", "Width"})

public abstract interface BoundedShape extends Locatable {
	
	public int getHeight();
	public int getWidth();
	public void setHeight(int newH);
	public void setWidth(int newW);
	

}
