package AnimationMethods;

import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.COORDINATING_ANIMATING_COMMAND)
public class SceneLockedAnimationCommand extends BridgeSceneGuardAnimation {
	
	boolean waitState = false;
	ClearanceManager manager;

	public SceneLockedAnimationCommand(Avatars montyAvatar, BridgeSceneAnimator montyAnimator, boolean waitType) {
		super(montyAvatar, montyAnimator);
		waitState = waitType;
		manager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
		
	}
	@Override
	public void run() {
		anAnimator.animateGuard(anAvatar);
	}
	

}
