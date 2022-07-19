package AnimationMethods;

import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.ANIMATING_COMMAND)

public class BridgeSceneAnimationCommand implements Runnable {
	
	Avatars anAvatar;
	BridgeSceneAnimator anAnimator;
	boolean waitState = false;
	ClearanceManager manager;
	
	
	public BridgeSceneAnimationCommand(Avatars montyAvatar, BridgeSceneAnimator montyAnimator, boolean waitCommand) {
		anAvatar = montyAvatar;
		//anAnimator = new ABridgeSceneAnimator();
		anAnimator = montyAnimator;
		waitState = waitCommand;
		manager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
	}
	

	@Override
	public void run() {
		if(waitState) {
			manager.waitForProceed();
			anAnimator.animateAvatar(anAvatar);
		}
		else{anAnimator.animateAvatar(anAvatar);}
	}

}
