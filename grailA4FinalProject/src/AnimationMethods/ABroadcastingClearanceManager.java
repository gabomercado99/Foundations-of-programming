package AnimationMethods;

import util.annotations.ComponentWidth;
import util.annotations.Row;

public class ABroadcastingClearanceManager extends AClearanceManager 
					implements BroadcastingClearanceManager {
	static final int WIDTH = 150,
					ROW = 1;
	@Row(ROW)
	@ComponentWidth(WIDTH)
	@Override
	public synchronized void proceedAll() {
		notifyAll(); // not notify, hover over the method and see Java's explanation for it		
		System.out.println( Thread.currentThread()  + ": after notifyAll");

	}
}
