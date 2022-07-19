package grail.geometryFigs;

import java.beans.PropertyChangeListener;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.LOCATABLE)
@PropertyNames({"X", "Y"})
@EditablePropertyNames({"X", "Y"})

public abstract interface Locatable extends PropertyListenerRegisterer {

	public int getX();
	public int getY();
	public void setX(int newX);
	public void setY(int newY);
	public void addPropertyChangeListener(PropertyChangeListener aListener);
	public List<PropertyChangeListener> getPropertyChangeListeners();
}
