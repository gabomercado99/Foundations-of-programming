package grail.compositeFigs;


import java.beans.PropertyChangeListener;
import java.io.IOException;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.extras.Tables;
import grail.geometryFigs.CharHeads;
import grail.geometryFigs.ImageShapes;
import grail.geometryFigs.MontyString;
import grail.geometryFigs.MovingL;
import grail.geometryFigs.RotatingLine;
import grail.geometryFigs.StringShape;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags(Comp301Tags.AVATAR)


public class MontyAvatar implements Avatars {
	
	static final double
		INITIAL_LIMB_RAD = 20,
		USUAL_LLINE_ANG = (Math.PI/4),
		USUAL_RLINE_ANG = 3*(Math.PI/4),
		TORSO_ANGLE = Math.PI/2,
		TORSO_LENGTH = 50;
		;
	static final int
		ORIG_X = 0,
		ORIG_Y = 0;
	static final String AVATAR_SAYS = "Lets Go";
	
	StringShape textSpoken;
	ImageShapes character;
	AngleShapes arms;
	AngleShapes legs;
	MovingL torso;
	
	public MontyAvatar(ImageShapes newHead) {
		character = newHead;
		int attachPointX = character.getX() + ((character.getWidth())/2);
		int attachPointY = character.getY() + (character.getHeight());
		armLegMiniFact();
		torso = new RotatingLine(TORSO_LENGTH, TORSO_ANGLE, ORIG_X, ORIG_Y);
		textSpoken = new MontyString(ORIG_X, ORIG_Y, AVATAR_SAYS);
		this.combineFigs(attachPointX, attachPointY);
		int stringX = character.getX() + character.getWidth();
		int stringY = character.getY();
		textSpoken.setX(stringX);
		textSpoken.setY(stringY);
	}
	@Override
	public void armLegMiniFact() {
		arms = new ArmsAndLegs(INITIAL_LIMB_RAD,USUAL_LLINE_ANG,INITIAL_LIMB_RAD,USUAL_RLINE_ANG, ORIG_X, ORIG_Y);
//		try {
//			legs = new RealisticLegs(INITIAL_LIMB_RAD,USUAL_LLINE_ANG,INITIAL_LIMB_RAD,USUAL_RLINE_ANG, ORIG_X, ORIG_Y);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		legs = BridgeSceneFactory.legsFactoryMethod(INITIAL_LIMB_RAD,USUAL_LLINE_ANG,INITIAL_LIMB_RAD,USUAL_RLINE_ANG, ORIG_X, ORIG_Y);
	}
	@Override
	public StringShape getStringShape() {
		return textSpoken;
	}
	@Override
	public ImageShapes getHead() {
		return character;
	}
	@Override
	public AngleShapes getArms() {
		return arms;
	}
	@Override
	public AngleShapes getLegs() {
		return legs;
	}
	@Override
	public MovingL getTorso() {
		return torso;
	}
	@Override
	public void combineFigs(int comunX, int comunY) {
			
		arms.getLeftLine().setX(comunX);
		arms.getLeftLine().setY(comunY);
		arms.getRightLine().setX(comunX);
		arms.getRightLine().setY(comunY);
		
		torso.setX(comunX);
		torso.setY(comunY);
		
		int lowTorsoY = comunY + torso.getHeight();
		int lowTorsoX = comunX + torso.getWidth();
		legs.getLeftLine().setX(lowTorsoX);
		legs.getLeftLine().setY(lowTorsoY);
		legs.getRightLine().setX(lowTorsoX);
		legs.getRightLine().setY(lowTorsoY);
		
		
	}
	@Override
	public void moveAvatar(int newX, int newY) {
		int newAttachX = arms.getLeftLine().getX() + newX;
		int newAttachY = arms.getLeftLine().getY() + newY;
		combineFigs(newAttachX, newAttachY);
		int newPicLocX = character.getX() + newX;
		int newPicLocY = character.getY() + newY;
		character.setX(newPicLocX);
		character.setY(newPicLocY);
		int stringX = character.getX() + character.getWidth();
		int stringY = character.getY();
		textSpoken.setX(stringX);
		textSpoken.setY(stringY);
	}
	@Override
	public void move(int newX, int newY) {
		//int newAttachX = arms.getLeftLine().getX() + newX;
		//int newAttachY = arms.getLeftLine().getY() + newY;
		combineFigs(newX, newY);
		//int newPicLocX = character.getX() + newX;
		//int newPicLocY = character.getY() + newY;
		character.setX(newX - (character.getWidth())/2);
		character.setY(newY - character.getHeight());
		int stringX = character.getX() + character.getWidth();
		int stringY = character.getY();
		textSpoken.setX(stringX);
		textSpoken.setY(stringY);
	}
	
	
	@Override
	public void scale(double scaleBy) {
		double newRadL = arms.getLeftLine().getRadius()*scaleBy;
		double newRadR = arms.getRightLine().getRadius()*scaleBy;
		double newRadTo = torso.getRadius()*scaleBy;
		int legAttach = (int) ((torso.getRadius()*scaleBy)- torso.getRadius());
		double newRadLegL = legs.getLeftLine().getRadius()*scaleBy;
		double newRadLegR = legs.getRightLine().getRadius()*scaleBy;
		int newHeadHeight = (int)(character.getHeight()*scaleBy);
		int newHeadWidth = (int) (character.getWidth()*scaleBy);
		character.setHeight(newHeadHeight);
		character.setWidth(newHeadWidth);
		int attachPointX = character.getX() + ((character.getWidth())/2);
		int attachPointY = character.getY() + (character.getHeight());
		arms.getLeftLine().setRadius(newRadL);
		arms.getRightLine().setRadius(newRadR);
		legs.getLeftLine().setRadius(newRadLegL);
		legs.getRightLine().setRadius(newRadLegR);
		torso.setRadius(newRadTo);
		legs.moveLimbs(ORIG_X, legAttach);
		this.combineFigs(attachPointX, attachPointY);
		int stringX = character.getX() + character.getWidth();
		int stringY = character.getY();
		textSpoken.setX(stringX);
		textSpoken.setY(stringY);
	}
	
	//public static void addPropertyChangeListener(Avatars anAvatar, PropertyChangeListener aListener) {
	//	anAvatar.getArms().ad
	//}
	
	
	
}
