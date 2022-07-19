package AnimationMethods;

import grail.compositeFigs.Avatars;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.COORDINATED_ANIMATING_COMMAND)
public class SceneLockedAnimatingCommand extends BridgeSceneAnimationCommand {

	public SceneLockedAnimatingCommand(Avatars montyAvatar, BridgeSceneAnimator montyAnimator, boolean waitCommand) {
		super(montyAvatar, montyAnimator, waitCommand);
	}

}
