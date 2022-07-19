package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

import AnimationMethods.ABridgeSceneAnimator;
import AnimationMethods.BridgeSceneAnimator;
import bus.uigen.OEFrame;

import bus.uigen.ObjectEditor;
import gradingTools.comp301ss21.assignment2.testcases.factory.BridgeSceneFactoryMethodDefined;
import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;
import grail.compositeFigs.FiveChars;
import grail.compositeFigs.GorgeWithBridge;
import grail.compositeFigs.MontyAvatar;
import grail.extras.Buttons;
import grail.extras.PanelButton;
import grail.extras.Tables;
import grail.geometryFigs.RotatingLine;
import grail.geometryFigs.MovingL;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.misc.ThreadSupport;

//@Tags(Comp301Tags.ROTATING_LINE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
//@Tags(Comp301Tags.BRIDGE_SCENE)

		
public class Assignment4 {
	
	static final double
			RADIUS = 400,
			ANGLE = Math.PI/4,
			SCALE_BY = 2.5;
	static final int
			SLEEP_TIME = 200,
			MARCH_T = 1000,
			X = 0,
			Y = 0,
			X_2 = 50,
			Y_2 = 100,
			ROTATE_BY = 8,
			IMPOSIBLE_ANGLE = 9,
			ARM_ROT = 3,
			MOVE_BY = 20,
			TALK_LENGTH = 6,
			ROB_Y = 60,
			FRAME_WIDTH = 2000,
			FRAME_HEIGHT = 800;
	static final String
			KNIGHTS = "We Beat the Guard!!",
			GUARD = "Damn it!!",
			ARTHUR_NAME = "Arthur",
			GALAHAD_NAME = "Galahad",
			GUARD_NAME = "Guard",
			LANCELOT_NAME = "Lancelot",
			ROBIN_NAME = "Robin";
			

	public static void main(String[] args) {
		//animateLine();
		demonstrateBridgeScene();
	}
	public static void animateLine() {
		MovingL line1 = new RotatingLine(RADIUS, ANGLE, X, Y);
		OEFrame aFrame = ObjectEditor.edit (line1);
		line1.rotate(ROTATE_BY);
		aFrame.refresh();
		//line1.setX(X_2);
		//line1.setY(Y_2);
		aFrame.refresh();
	}
	public static void demonstrateBridgeScene() {
		FiveAvatars montyChars = BridgeSceneFactory.bridgeSceneFactoryMethod();
		JFrame frame = new JFrame("Monty Scene");
		PanelButton buttonCommand = BridgeSceneFactory.bridgeSceneButtonsFactoryMethod();
		frame.add((Component) BridgeSceneFactory.inheritingBridgeScenePainterFactoryMethod(), BorderLayout.CENTER);
		frame.add((Component) buttonCommand, BorderLayout.NORTH);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		Tables<Avatars> aCollection = BridgeSceneFactory.avatarTableFactoryMethod();
		aCollection.put(ARTHUR_NAME, montyChars.getArthur());
		aCollection.put(GALAHAD_NAME, montyChars.getGalahad());
		aCollection.put(GUARD_NAME, montyChars.getGuard());
		aCollection.put(LANCELOT_NAME, montyChars.getLancelot());
		aCollection.put(ROBIN_NAME, montyChars.getRobin());
		System.out.println(aCollection.get(ARTHUR_NAME));
		BridgeSceneFactory.inheritingBridgeScenePainterFactoryMethod();
		BridgeSceneFactory.bridgeSceneControllerFactoryMethod();
		montyChars.getArthur().getLegs().getLeftLine().rotate(IMPOSIBLE_ANGLE);
		KeyEvent key = new KeyEvent(frame, 0, 0, 0, 0, 'o');
		montyChars.approach(montyChars.getLancelot());
		montyChars.say(KNIGHTS);
		ThreadSupport.sleep(SLEEP_TIME);
		montyChars.say(KNIGHTS);
		ThreadSupport.sleep(SLEEP_TIME);
    	montyChars.passed();
    	montyChars.approach(montyChars.getArthur());
    	ThreadSupport.sleep(SLEEP_TIME);
    	montyChars.failed();
    	BridgeSceneFactory.bridgeSceneControllerFactoryMethod().keyTyped(key);
    	ThreadSupport.sleep(SLEEP_TIME);
		montyChars.waitingArthur();
    	montyChars.waitingGalahad();
    	montyChars.waitingLancelot();
    	montyChars.waitingRobin();
    	montyChars.startAnimation();
    	BridgeSceneFactory.bridgeSceneControllerFactoryMethod().keyTyped(key);
    	ThreadSupport.sleep(SLEEP_TIME);
    	montyChars.asynchronousArthur();
    	montyChars.asynchronousGalahad();
    	montyChars.asynchronousLancelot();
    	montyChars.asynchronousRobin();
    	montyChars.asynchronousGuard();
    	BridgeSceneFactory.bridgeSceneControllerFactoryMethod().keyTyped(key);
    	ThreadSupport.sleep(SLEEP_TIME);
		montyChars.lockstepArthur();
		montyChars.lockstepGalahad();
		montyChars.lockstepLancelot();
		montyChars.lockstepRobin();
		montyChars.lockstepGuard();
		ThreadSupport.sleep(SLEEP_TIME);
		BridgeSceneFactory.bridgeSceneControllerFactoryMethod().keyTyped(key);
    	
    	
	}
	

}
