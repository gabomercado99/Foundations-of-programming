package grail.compositeFigs;

import java.beans.PropertyChangeListener;

import grail.geometryFigs.MovingL;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags(Comp301Tags.BRIDGE_SCENE)

public interface FiveAvatars {
	
	public Avatars getArthur();
	public Avatars getGalahad();
	public Avatars getGuard();
	public Avatars getLancelot();
	public Avatars getRobin();
	public Gorges getGorge();
	public MovingL getGuardArea();
	public MovingL getKnightArea();
	public void approach(Avatars anAvatar);
	public boolean getOccupied();
	public boolean getKnightTurn();
	public void say(String question);
	public void passed();
	public void failed();
	public void scroll(int moveInX, int moveInY);
	@Visible(false)
	public Avatars getInteractingKnight();
	public boolean prePassed();
	public boolean preSay();
	public boolean preApproach();
	public void approach(String name);
	public boolean preFailed();
	public void updateSpeakTurn(boolean newTurn);
	public  void addPropertyChangeListener(PropertyChangeListener aListener);
	public void newOccupation(boolean newState);
//	public static void addPropertyChangeListener(PropertyChangeListener aListener) {
//		FiveAvatars bridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
//		Avatars.addPropertyChangeListener(bridgeScene.getArthur(), aListener);
//		Avatars.addPropertyChangeListener(bridgeScene.getGalahad(), aListener);
//		Avatars.addPropertyChangeListener(bridgeScene.getLancelot(), aListener);
//		Avatars.addPropertyChangeListener(bridgeScene.getRobin(), aListener);
//		Avatars.addPropertyChangeListener(bridgeScene.getGuard(), aListener);	
//	}
	void asynchronousArthur();
	void asynchronousGalahad();
	void asynchronousLancelot();
	void asynchronousRobin();
	void asynchronousGuard();
	void waitingArthur();
	void waitingGalahad();
	void waitingLancelot();
	void waitingRobin();
	void startAnimation();
	void lockstepArthur();
	void lockstepGalahad();
	void lockstepLancelot();
	void lockstepRobin();
	void lockstepGuard();
	void addPropertyChangeListenerMine(PropertyChangeListener aListener);
}