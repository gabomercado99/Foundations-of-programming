package grail.geometryFigs;

import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.models.PropertyListenerRegisterer;
import grail.MVC.AnObservableHelper;
import grail.MVC.ObservableHelp;
import grail.compositeFigs.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags(Comp301Tags.LOCATABLE)
@PropertyNames({"X", "Y"})
@EditablePropertyNames({"X", "Y"})


public abstract class Alocatable implements Locatable {
	
	int x;
	int y;
	ObservableHelp propertySupport = BridgeSceneFactory.helperFactoryMethod();
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setX(int newX) {
		int oldX = getX();
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX,
				newX));
	}
	@Override
	public void setY(int newY) {
		int oldY = getY();
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY,
				newY));
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {	 
		propertySupport.add(aListener);
	}
	@Override
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.getPropertyChangeListenerList();
	}

}
