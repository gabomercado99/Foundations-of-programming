package grail.compositeFigs;

import java.awt.Component;

import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import AnimationMethods.ABroadcastingClearanceManager;
import AnimationMethods.BroadcastingClearanceManager;
import grail.MVC.AnObservableHelper;
import grail.MVC.BridgePaintView;
import grail.MVC.BridgeSceneController;
import grail.MVC.ConsoleSceneView;
import grail.MVC.CustomView;
import grail.MVC.KeyController;
import grail.MVC.ObservableHelp;
import grail.MVC.SceneView;
import grail.MVCDelegate.DelegatingScene;
import grail.MVCDelegate.DelegatingScenes;
import grail.MVCDelegate.ObservableBridgeScene;
import grail.MVCDelegate.ObservableScenePainter;
import grail.extras.Buttons;
import grail.extras.MapStringToObject;
import grail.extras.PanelButton;
import grail.extras.Tables;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.FACTORY_CLASS)
public class BridgeSceneFactory { 
	static FiveAvatars scene;
	static SceneView sceneView;
	static Tables<Avatars> avatarAndObject;
	static CustomView sceneView2;
	static KeyController bridgeController;
	static ObservableBridgeScene delegateScene;
	static DelegatingScenes sceneShowed;
	static BroadcastingClearanceManager clearanceManager;
	static PanelButton sceneButtons;

	
	public synchronized static FiveAvatars bridgeSceneFactoryMethod(){
	   if (scene == null) {
			 scene = new FiveChars();
	   } 
	   return scene;		
	}
	
	
	public synchronized  static AngleShapes legsFactoryMethod(double rad, double ang,double radR, double angR, int valX, int valY) {
		return new RealisticLegs(rad, ang, radR, angR, valX, valY);
//		return new ArmsAndLegs(rad, ang, radR, angR, valX, valY);
	}
	
	public synchronized  static SceneView consoleSceneViewFactoryMethod() {
		if (sceneView == null) {
			sceneView = new ConsoleSceneView();
		}
		return sceneView;
	}
	public synchronized static ObservableHelp helperFactoryMethod() {
		return new AnObservableHelper();
	}
	
	public synchronized  static Tables<Avatars> avatarTableFactoryMethod(){
		if (avatarAndObject == null) {
			avatarAndObject = new MapStringToObject<Avatars>();
		}
		return avatarAndObject;
	}
	
	public synchronized  static CustomView inheritingBridgeScenePainterFactoryMethod() {
		if (sceneView2 == null) {
			sceneView2 = new BridgePaintView();
		}
		return sceneView2;
	}
	public synchronized  static PanelButton bridgeSceneButtonsFactoryMethod() {
		if(sceneButtons == null) {
			sceneButtons = new Buttons();
		}
		return sceneButtons;
	}
	public synchronized  static KeyController bridgeSceneControllerFactoryMethod(){
		if (bridgeController == null) {
			bridgeController = new BridgeSceneController((Component)inheritingBridgeScenePainterFactoryMethod());
		}
		return bridgeController;
		
	}
	public synchronized  static ObservableBridgeScene observableBridgeScenePainterFactoryMethod() {
		if (delegateScene == null) {
			delegateScene = new ObservableScenePainter();
		}
		return delegateScene;
	}
	public synchronized  static DelegatingScenes delegatingBridgeSceneViewFactoryMethod(){
		if (sceneShowed == null) {
			sceneShowed = new DelegatingScene();
		}
		return sceneShowed;
	}
	
	public synchronized static BroadcastingClearanceManager broadcastingClearanceManagerFactoryMethod() {
		if (clearanceManager == null) {
			clearanceManager = new ABroadcastingClearanceManager();
		}
		return clearanceManager;
		
	}
	

}
