package AnimationMethods;

import grail.compositeFigs.Avatars;

public class BridgeSceneGuardAnimation implements Runnable {

	Avatars anAvatar;
	BridgeSceneAnimator anAnimator;
	
	
	public BridgeSceneGuardAnimation(Avatars montyAvatar, BridgeSceneAnimator montyAnimator) {
		anAvatar = montyAvatar;
		anAnimator = montyAnimator;
	}
	@Override
	public void run() {
		anAnimator.animateGuard(anAvatar);

	}

}
