package AnimationMethods;

import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags(Comp301Tags.COORDINATING_ANIMATOR)
public class ABridgeSceneLockedAnimator extends ABridgeSceneAnimator {
	
	
	
	@Override
	public synchronized void animateAvatar(Avatars anAvatar) {
		int i = START;
    	while (i < MOVE_BY) {
    	anAvatar.moveAvatar(MOVE_BY, START);   
    	BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod().waitForProceed();
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
    	   	BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod().proceedAll();
    	   	i++;
       		}
        	else{
        	anAvatar.getArms().getRightLine().rotate(ROTATE);
   	    	anAvatar.getArms().getLeftLine().rotate(-ROTATE);
   	    	ThreadSupport.sleep(MARCH_TIME);
   	    	BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod().proceedAll();
   	    	i++;}
        	}
	}

}
