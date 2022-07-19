package grail.compositeFigs;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import AnimationMethods.ABridgeSceneAnimator;
import AnimationMethods.ABridgeSceneLockedAnimator;
import AnimationMethods.BridgeSceneAnimationCommand;
import AnimationMethods.BridgeSceneAnimator;
import AnimationMethods.BridgeSceneGuardAnimation;
import AnimationMethods.SceneLockedAnimatingCommand;
import AnimationMethods.SceneLockedAnimationCommand;
import grail.MVC.AnObservableHelper;
import grail.MVC.ObservableHelp;
import grail.extras.Tables;
import grail.geometryFigs.ACircle;
import grail.geometryFigs.CharHeads;
import grail.geometryFigs.CircleFig;
import grail.geometryFigs.ImageShapes;
import grail.geometryFigs.MovingL;
import grail.geometryFigs.RotatingLine;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;
import util.models.PropertyListenerRegisterer;


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags(Comp301Tags.BRIDGE_SCENE)

public class FiveChars implements FiveAvatars, PropertyListenerRegisterer {
	
	static final String
		ARTHUR = "images/arthur.jpg",
		GALAHAD = "images/galahad.jpg",
		GUARD = "images/guard.jpg",
		LANCELOT = "images/lancelot.jpg",
		ROBIN = "images/robin.jpg",
		ARTHUR_NAME = "Arthur",
		GALAHAD_NAME = "Galahad",
		GUARD_NAME = "Guard",
		LANCELOT_NAME = "Lancelot",
		ROBIN_NAME = "Robin";
	static final int
		ZERO_EXTRA = 0,
		HEAD_WIDTH = 40,
		HEAD_HEIGHT = 45,
		ARTHUR_X = 40,
		ARTHUR_Y = 500,
		GALAHAD_X = 40,
		GALAHAD_Y = 660,
		GUARD_X = 500,
		GUARD_Z_X = 480,
		GUARD_Z_Y = 495,
		GUARD_Y = 410,
		LANCE_X = 100,
		LANCE_Y = 500,
		ROBIN_X = 100,
		ROBIN_Y = 660,
		GORGE_X = 270,
		GORGE_Y = -200,
		OFF_SET = 20,
		SLEEP_TIME = 50,
		PASSED_KNIGHT = 500,
		KNIGHTS_X = 380;
	static final double
	ZONE_RAD = 80,
	ZONE_ANGLE = Math.PI/6;
	
	
	Avatars arthur;
	Avatars galahad;
	Avatars guard;
	Avatars lancelot;
	Avatars robin;
	Gorges bridgeGorge;
	CircleFig knightZone;
	CircleFig guardZone;
	boolean occupationState = false;
	Avatars avatarInZone;
	boolean knightsTurn = false;
	//List<PropertyChangeListener> contents = new ArrayList<PropertyChangeListener>();
	ObservableHelp helper = BridgeSceneFactory.helperFactoryMethod();
	BridgeSceneAnimator arthurAnimator; 
	BridgeSceneAnimator galahadAnimator;
	BridgeSceneAnimator lancelotAnimator; 
	BridgeSceneAnimator robinAnimator; 
	
	public FiveChars() {
		ImageShapes arthurHead = new CharHeads(ARTHUR_X, ARTHUR_Y, HEAD_WIDTH, HEAD_HEIGHT, ARTHUR);
		ImageShapes galahadHead = new CharHeads(GALAHAD_X, GALAHAD_Y, HEAD_WIDTH, HEAD_HEIGHT, GALAHAD);
		ImageShapes guardHead = new CharHeads(GUARD_X, GUARD_Y, HEAD_WIDTH, HEAD_HEIGHT, GUARD);
		ImageShapes lancelotHead = new CharHeads(LANCE_X, LANCE_Y, HEAD_WIDTH, HEAD_HEIGHT, LANCELOT);
		ImageShapes robinHead = new CharHeads(ROBIN_X, ROBIN_Y, HEAD_WIDTH, HEAD_HEIGHT, ROBIN);
		knightZone = new ACircle(ZONE_RAD, ZONE_ANGLE, KNIGHTS_X, ARTHUR_Y ); 
		guardZone = new ACircle(ZONE_RAD, ZONE_ANGLE, GUARD_Z_X, GUARD_Z_Y ); 
		Tables<Avatars> aCollection = BridgeSceneFactory.avatarTableFactoryMethod();
		arthur = new MontyAvatar(arthurHead);
		aCollection.put(ARTHUR_NAME, arthur);
		galahad = new MontyAvatar(galahadHead);
		aCollection.put(GALAHAD_NAME, galahad);
		guard = new MontyAvatar(guardHead);
		aCollection.put(GUARD_NAME, guard);
		lancelot = new MontyAvatar(lancelotHead);
		aCollection.put(LANCELOT_NAME, lancelot);
		robin = new MontyAvatar(robinHead);
		aCollection.put(ROBIN_NAME, robin);
		bridgeGorge = new GorgeWithBridge();
//		arthurAnimator = new BridgeSceneAnimationCommand(arthur, new ABridgeSceneAnimator() , false);
//		galahadAnimator = new BridgeSceneAnimationCommand(galahad, new ABridgeSceneAnimator() , false);
//		lancelotAnimator = new BridgeSceneAnimationCommand(lancelot, new ABridgeSceneAnimator() , false);
//		robinAnimator = new BridgeSceneAnimationCommand(robin, new ABridgeSceneAnimator() , false);
		arthurAnimator = new ABridgeSceneAnimator();
		galahadAnimator =  new ABridgeSceneAnimator();
		lancelotAnimator =  new ABridgeSceneAnimator();
		robinAnimator = new ABridgeSceneAnimator();
		
	}
	
	@Override
	public Avatars getArthur() {
		return arthur;
	}
	@Override
	public Avatars getGalahad() {
		return galahad;
	}
	@Override
	public Avatars getGuard() {
		return guard;
	}
	@Override
	public Avatars getLancelot() {
		return lancelot;
	}
	@Override
	public Avatars getRobin() {
		return robin;
	}
	@Override
	public Gorges getGorge() {
		return bridgeGorge;
	}
	@Override
	public MovingL getGuardArea() {
		return guardZone;
		
	}
	@Override
	public MovingL getKnightArea() {
		return knightZone;
	}
	@Override
	
	public void newOccupation(boolean newState) {
		occupationState = newState;
		helper.notifyAllListeners(new PropertyChangeEvent (this, "this", "approach", !newState));
		helper.notifyAllListeners(new PropertyChangeEvent (this, "this", "say", newState));
		if (!knightsTurn){helper.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", newState));}
		helper.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", newState));
		
	}
	@Override
	public void updateSpeakTurn(boolean newTurn) {
		knightsTurn = newTurn;
		if(occupationState) {helper.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", !newTurn));}
	}
	@Override
	public boolean preApproach() {
		System.out.println("in precondition");
		//boolean condition1 = (occupationState == false);
		return !occupationState;
	}
	@Override
	public void approach(Avatars anAvatar) {
		assert preApproach() : "AREA OCCUPIED";
		//if (occupationState) {return;}
		anAvatar.moveAvatar(KNIGHTS_X + OFF_SET - anAvatar.getLegs().getLeftLine().getX(), ARTHUR_Y + OFF_SET - anAvatar.getLegs().getLeftLine().getY());
		newOccupation(true);
		avatarInZone = anAvatar;
	}
	@Override
	public void approach(String name) {
		Avatars avatar = BridgeSceneFactory.avatarAndObject.get(name);
		approach(avatar);
	}
	@Override
	public boolean preSay() {
		boolean condition = (occupationState);
		return condition;
	}
	@Override
	public void say(String question) {
		assert preSay();
		//if(!occupationState) {return;}
		if(!knightsTurn) {
			avatarInZone.getStringShape().setText("");
			guard.getStringShape().setText(question);
			updateSpeakTurn(true);
		}
		else {
			guard.getStringShape().setText("");
			avatarInZone.getStringShape().setText(question);
			updateSpeakTurn(false);	
			}
	}
	@Override
	@Visible(false)
	public boolean getOccupied() {
		return occupationState;
	}
	@Override
	@Visible(false)
	public boolean getKnightTurn() {
		return knightsTurn;
	}
	@Override
	@Visible(false)
	public Avatars getInteractingKnight() {
		if (occupationState) {return avatarInZone;} 
		return null;
	}
	
	@Override
	public boolean prePassed() {
		boolean condition = !knightsTurn && occupationState;
		return condition;
	}
	
	@Override
	public void passed() {
		assert prePassed();
		if (!knightsTurn && occupationState) {
			avatarInZone.moveAvatar(PASSED_KNIGHT, ZERO_EXTRA);
			newOccupation(false);
			//avatarInZone = null;
		}
	
	}
	
	@Override
	public boolean preFailed() {
		boolean condition1 = occupationState;
		return condition1;
		
	}
	@Override
	public void failed() {
		assert preFailed();
		if (!knightsTurn){ //&& occupationState) {
			avatarInZone.moveAvatar(GORGE_X, GORGE_Y);
			newOccupation(false);
		}
		else { //&& occupationState) {
			guard.moveAvatar(GORGE_X, GORGE_Y);
		}
	}
	
	@Override
	public void scroll(int moveInX, int moveInY) {
		arthur.moveAvatar(moveInX, moveInY);
		galahad.moveAvatar(moveInX, moveInY);
		guard.moveAvatar(moveInX, moveInY);
		lancelot.moveAvatar(moveInX, moveInY);
		robin.moveAvatar(moveInX, moveInY);
		bridgeGorge.moveBridge(moveInX, moveInY);
		int oldKnightZonex = knightZone.getX();
		int oldKnightZoney = knightZone.getY();
		int oldGuardZonex = guardZone.getX();
		int oldGuardZoney = guardZone.getY();
		knightZone.move( oldKnightZonex + moveInX, oldKnightZoney + moveInY);
		guardZone.move(oldGuardZonex + moveInX, oldGuardZoney + moveInY);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		helper.add(aListener);
	}
	
	@Override
	public void addPropertyChangeListenerMine(PropertyChangeListener aListener) {
		FiveAvatars bridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		Avatars.addPropertyChangeListener(bridgeScene.getArthur(), aListener);
		Avatars.addPropertyChangeListener(bridgeScene.getGalahad(), aListener);
		Avatars.addPropertyChangeListener(bridgeScene.getLancelot(), aListener);
		Avatars.addPropertyChangeListener(bridgeScene.getRobin(), aListener);
		Avatars.addPropertyChangeListener(bridgeScene.getGuard(), aListener);
	}
	@Override
	public void asynchronousArthur() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(arthur, arthurAnimator, false));
		aThread.start();
//		ThreadSupport.sleep(SLEEP_TIME);
	} 
	
	@Override
	public void asynchronousGalahad() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(galahad, galahadAnimator, false));
		aThread.start();
//		ThreadSupport.sleep(SLEEP_TIME);
	}
	
	@Override
	public void asynchronousLancelot() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(lancelot, lancelotAnimator, false));
		aThread.start();
//		ThreadSupport.sleep(SLEEP_TIME);
	}
	
	@Override
	public void asynchronousRobin() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(robin, robinAnimator, false));;
		aThread.start();
//		ThreadSupport.sleep(SLEEP_TIME);
	}
	
	@Override
	public void asynchronousGuard() {
		Thread aThread = new Thread(new BridgeSceneGuardAnimation(guard, new ABridgeSceneAnimator()));
		aThread.start();
//		ThreadSupport.sleep(SLEEP_TIME);

	}
	

	@Override
	public void waitingArthur() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(arthur, arthurAnimator, true));
		aThread.start();
		
	} 
	
	
	@Override
	public void waitingGalahad() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(galahad, galahadAnimator, true));
		aThread.start();
	
	}
	
	
	@Override
	public void waitingLancelot() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(lancelot, lancelotAnimator, true));
		aThread.start();
		
	}
	
	
	@Override
	public void waitingRobin() {
		Thread aThread = new Thread(new BridgeSceneAnimationCommand(robin, robinAnimator, true));
		aThread.start();
		
	}
	
	@Override
	public void startAnimation() {
		BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod().proceedAll();
	}
	
	
	
	@Override
	public void lockstepArthur() {
		Thread aThread = new Thread(new SceneLockedAnimatingCommand(arthur, new ABridgeSceneLockedAnimator(), true));
		aThread.start();
	
	} 
	
	

	@Override
	public void lockstepGalahad() {
		Thread aThread = new Thread(new SceneLockedAnimatingCommand(galahad, new ABridgeSceneLockedAnimator(), true));
		aThread.start();
		
	}
	
	
	

	@Override
	public void lockstepLancelot() {
		Thread aThread = new Thread(new SceneLockedAnimatingCommand(lancelot, new ABridgeSceneLockedAnimator(), true));
		aThread.start();
		
	}
	
	

	@Override
	public void lockstepRobin() {
		Thread aThread = new Thread(new SceneLockedAnimatingCommand(robin, new ABridgeSceneLockedAnimator(), true));
		aThread.start();
		
	}
	
	@Override
	public void lockstepGuard() {
		Thread aThread = new Thread(new SceneLockedAnimationCommand(guard, new ABridgeSceneLockedAnimator(), true));
		aThread.start();
		//BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod().proceedAll();
	}
	
	
	
	
	
	
	
	
	
	
}	
