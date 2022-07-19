package grail.geometryFigs;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "Text"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Text"})

public interface StringShape extends MovingL {
	
	
	public String getText(); 
	public void setText(String newVal);
	

}
