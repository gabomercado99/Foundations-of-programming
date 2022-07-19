package AnimationMethods;

import grail.compositeFigs.Avatars;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.ANIMATOR)
public interface BridgeSceneAnimator {
	
	public void animateAvatar(Avatars anAvatar);

	public void animateGuard(Avatars anAvatar);

}
