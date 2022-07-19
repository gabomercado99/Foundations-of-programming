package grail.geometryFigs;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})

public interface CircleFig extends MovingL {
	
	public void move(int newX, int newY);
}
