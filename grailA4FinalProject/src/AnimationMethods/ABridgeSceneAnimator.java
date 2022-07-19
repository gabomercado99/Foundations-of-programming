package AnimationMethods;

import grail.compositeFigs.Avatars;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.misc.ThreadSupport;
@Tags(Comp301Tags.ANIMATOR)
public class ABridgeSceneAnimator implements BridgeSceneAnimator {
	static final int START = 0,
					MOVE_BY = 10,
					GUARD_CLAP = 10,
					ROTATE = 7,
					MARCH_TIME = 250;
	@Override
	public synchronized void animateAvatar(Avatars anAvatar) {
		int i = START;
    	while (i < MOVE_BY) {
    	anAvatar.moveAvatar(MOVE_BY, START);   
    	ThreadSupport.sleep(MARCH_TIME);
    	i++;
    	}
	}
	
	@Override
	public void animateGuard(Avatars anAvatar) {
		int i = START;
    	while (i < GUARD_CLAP) {
    		if(i%2 == 0) {	
		    	anAvatar.getArms().getRightLine().rotate(-ROTATE);
		    	anAvatar.getArms().getLeftLine().rotate(ROTATE);
		    	ThreadSupport.sleep(MARCH_TIME);
		    	i++;
    			}
    		else{
	    	anAvatar.getArms().getRightLine().rotate(ROTATE);
	    	anAvatar.getArms().getLeftLine().rotate(-ROTATE);
	    	ThreadSupport.sleep(MARCH_TIME);
	    	i++;}
    	}
	}

}
