package grail.extras;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.TABLE)

public interface Tables<T> {
	
	public void put(String key, T val);
	public T get (String key);
	public int size();

}
