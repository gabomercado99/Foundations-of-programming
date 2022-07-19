package grail.MVCDelegate;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)
@SuppressWarnings("serial")
public class ObservableScenePainter extends Component implements ObservableBridgeScene {

	List<PaintListener> paintListeners = new ArrayList<PaintListener>();
	int size = 0;
	
	public ObservableScenePainter() {
		
	}
	@Override
	public void repaint() {
		super.repaint();
	}
	@Override
	public void add(PaintListener listener) {
		paintListeners.add(listener);
		size++;
	}
	@Override
	public List<PaintListener> getPaintListeners() {
		return paintListeners;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		callingPaint(g2);
		
	}
	private void callingPaint(Graphics2D g) {
		int i = 0;
		while (i < size) {
			paintListeners.get(i).paint(g);
			i++;
		}
	}
	//@Override
	//public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	//}

}
