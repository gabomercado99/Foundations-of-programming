package grail.geometryFigs;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Angle", "Radius", "Text"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Text"})


public class MontyString extends RotatingLine implements StringShape, PropertyListenerRegisterer {
	
	String text;
	
	public MontyString(int newX, int newY, String newText) {
		x = newX;
		y = newY;
		text = newText;
	}
	
	@Override
	public String getText() {
		return text;
	}
	@Override
	public void setText(String newVal) {
		String oldtext = new String(getText());
		text = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", true, false));//oldtext, newVal));	
	}
		

}
