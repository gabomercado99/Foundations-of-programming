package grail.compositeFigs;

import grail.geometryFigs.MovingL;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public interface Gorges {
	
	
	public MovingL getleftLine();
	
	public MovingL getrightLine();
	
	public MovingL getbridgeULine();
	
	public MovingL getbridgeLLine();
	
	public void moveBridge(int horizontal, int vertical);

}
