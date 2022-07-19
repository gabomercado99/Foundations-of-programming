package grail.geometryFigs;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "XH", "YH", "Height", "Width", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width", "ImageFileName"})

public interface ImageShapes extends MovingL {
	
 	//public int getWidth();
	//public void setWidth(int newVal);
	//public int getHeight();
	//public void setHeight(int newVal);
 	public String getImageFileName();
	public void setImageFileName(String newVal);
}
