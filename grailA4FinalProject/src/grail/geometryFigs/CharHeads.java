package grail.geometryFigs;


import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "XH", "YH", "Height", "Width", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width", "ImageFileName"})


public class CharHeads extends RotatingLine implements ImageShapes {
	
	 
	 String imageFileName;
	 
	 
	 public CharHeads(int initx, int inity, int initwidth, int initheight, String newImg) {
		 x= initx;
		 y = inity;
		 width = initwidth;
		 height = initheight;
		 imageFileName = newImg;
	
	 }
	
	
	@Override
 	public String getImageFileName() {return imageFileName;}
	@Override
	public void setImageFileName(String newVal) {
		String oldFile = new String(getImageFileName());
		imageFileName = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldFile, newVal));	
	}
	
	 

}
