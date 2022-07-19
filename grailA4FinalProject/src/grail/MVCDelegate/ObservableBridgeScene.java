package grail.MVCDelegate;

import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)

public interface ObservableBridgeScene { //extends PropertyChangeListener {

	//void propertyChange(PropertyChangeEvent evt);
	public void add(PaintListener listener);
	public List<PaintListener> getPaintListeners();
	public void repaint();
	
}
