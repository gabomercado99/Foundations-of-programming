package AnimationMethods;

import util.models.ListenableVector;
import util.models.PropertyListenerRegisterer;

public interface ClearanceManager extends PropertyListenerRegisterer{
	public void proceed();
	public void waitForProceed();
	ListenableVector getWaitingThreads();	
	

}
