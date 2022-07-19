package grail.compositeFigs;
import bus.uigen.OEFrame;

import bus.uigen.ObjectEditor;
import grail.compositeFigs.Gorges;

import grail.geometryFigs.MovingL;
import grail.geometryFigs.Point;
import grail.geometryFigs.RotatingLine;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class GorgeWithBridge implements Gorges {
	
	static final int 
		GORGE_RX = 850,
		GORGE_X = 600,
		GORGE_Y = 0,
		ROTATE = -16,
		BRIDGE_WIDTH = 60;
	static final double
		ANGLE_GORGE = (Math.PI/2),
		GORGE_R = 1000;
	
	
	//Point topLine;
	MovingL leftLine;
	MovingL rightLine;
	MovingL bridgeUpperLine;
	MovingL bridgeLowerLine;
	
	public GorgeWithBridge(){
		leftLine = new RotatingLine(GORGE_R, ANGLE_GORGE, GORGE_X, GORGE_Y);
		rightLine = leftLine.clone();
		rightLine.move(GORGE_RX, 0);
		bridgeUpperLine = new RotatingLine(GORGE_RX - GORGE_X, GORGE_Y, GORGE_X, (int)GORGE_R/2);
		bridgeLowerLine = bridgeUpperLine.clone();
		bridgeLowerLine.move(GORGE_X, bridgeUpperLine.getY()+ BRIDGE_WIDTH);
	}
	
	@Override
	public MovingL getleftLine() {return leftLine;}
	@Override
	public MovingL getrightLine() {return rightLine;}
	@Override
	public MovingL getbridgeULine() {return bridgeUpperLine;}
	@Override
	public MovingL getbridgeLLine() {return bridgeLowerLine;}
	@Override
	public void moveBridge(int horizontal, int vertical) {
		leftLine.move(leftLine.getX() + horizontal, leftLine.getY() + vertical);
		rightLine.move(rightLine.getX() + horizontal, rightLine.getY() + vertical);
		bridgeUpperLine.move(bridgeUpperLine.getX() + horizontal, bridgeUpperLine.getY() + vertical);
		bridgeLowerLine.move(bridgeLowerLine.getX() + horizontal, bridgeLowerLine.getY() + vertical);
		
	}
	
	

	

}
