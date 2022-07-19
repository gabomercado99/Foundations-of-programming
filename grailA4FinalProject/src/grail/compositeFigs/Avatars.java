package grail.compositeFigs;

import java.beans.PropertyChangeListener;

import grail.geometryFigs.ImageShapes;
import grail.geometryFigs.MovingL;
import grail.geometryFigs.StringShape;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.AVATAR)

public interface Avatars {
	
	public StringShape getStringShape();
	public ImageShapes getHead();
	public AngleShapes getArms();
	public AngleShapes getLegs();
	public MovingL getTorso();
	public void combineFigs(int commonX, int commonY);
	public void moveAvatar(int newX, int newY);
	public void move(int newX, int newY);
	public void scale(double scaleBy);
	public void armLegMiniFact();
	public static void addPropertyChangeListener(Avatars anAvatar, PropertyChangeListener aListener) {
		AngleShapes.addPropertyChangeListener(anAvatar.getArms(), aListener);
		AngleShapes.addPropertyChangeListener(anAvatar.getLegs(), aListener);
		anAvatar.getTorso().addPropertyChangeListener(aListener);
		anAvatar.getHead().addPropertyChangeListener(aListener);
		anAvatar.getStringShape().addPropertyChangeListener(aListener);
	}
	

}
