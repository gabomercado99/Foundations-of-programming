package grail.extras;

import java.util.ArrayList;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags(Comp301Tags.TABLE)

public class MapStringToObject<T> implements Tables<T> {
	
	List<String> keys = new ArrayList<String>();
	List<T> values = new ArrayList<T>();
	int size = 0;
	
	public MapStringToObject(){}
	
	@Override
	public void put(String key, T val) {
		if (keys.contains(key)) {
			int pairIndex = keys.indexOf(key);
			values.add(pairIndex, val);
			return;
		}
		else if (key == null || val == null) {
			return;
		}
		keys.add(size, key);
		values.add(size, val);
		size ++;

	}

	@Override
	public T get(String key) {
		if (!keys.contains(key)) {
			return null;
		}
		int pairIndex = keys.indexOf(key);
		return values.get(pairIndex);
		
	}
	@Override
	public int size() {
		return size;
	}

}
