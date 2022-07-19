package grail.geometryFigs;

import java.beans.PropertyChangeEvent;


import java.beans.PropertyChangeListener;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.BOUNDED_SHAPE)
@PropertyNames({"X", "Y", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Height", "Width"})

public abstract class ABoundedShape extends Alocatable implements BoundedShape {// , PropertyListenerRegisterer{

	int height;
	int width; 
	//AnObserver propertySupport2 = new AnObserver();
	
	@Override
	public int getHeight() {
		return height;
	}
	@Override
	public void setHeight(int newH) {
		int oldH = getHeight();
		y = newH;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldH,
				newH));
	}
	@Override
	public int getWidth() {
		return width;
	}
	@Override
	public void setWidth(int newW) {
		int oldW = getWidth();
		y = newW;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldW,
				newW));
	}
	
	//public void addPropertyChangeListener(PropertyChangeListener aListener) {
		 
	//	propertySupport.add(aListener);
	//}

}
