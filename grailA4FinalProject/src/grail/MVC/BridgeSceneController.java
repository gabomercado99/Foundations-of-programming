package grail.MVC;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;
import grail.extras.Buttons;
import grail.extras.PanelButton;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)

public class BridgeSceneController extends BridgeSceneMouseController implements KeyController, ActionListener, PropertyChangeListener {
	
	static final int
		ARTHUR_X = 40,
		ARTHUR_Y = 500,
		GALAHAD_X = 40,
		GALAHAD_Y = 660,
		GUARD_X = 500,
		GUARD_Y = 410,
		LANCE_X = 100,
		LANCE_Y = 500,
		ROBIN_X = 100,
		ROBIN_Y = 660;
	
	Component aMontySceneComponent;
//	JButton passed;
//	JButton say;
//	JButton failed;
//	JButton approach;
	PanelButton buttons;
	FiveAvatars aBridgeScene;
	
	
	
	
	public BridgeSceneController(Component sceneComponent) { //PanelButton someButtons) {
		//buttons = someButtons;
		aMontySceneComponent = sceneComponent;
		aBridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		//aBridgeScene = bridgeScene;
		aMontySceneComponent.addKeyListener(this);
		aMontySceneComponent.addMouseListener(this);
		aBridgeScene.addPropertyChangeListener(this);
		buttons = BridgeSceneFactory.bridgeSceneButtonsFactoryMethod();
		buttons.getPassed().addActionListener(this);;
		buttons.getSay().addActionListener(this);;
		buttons.getFailed().addActionListener(this);
		buttons.getApproach().addActionListener(this);	
	}

	

	

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyboard clicked");
		Avatars arthur = aBridgeScene.getArthur();
		Avatars galahad = aBridgeScene.getGalahad();
		Avatars lancelot = aBridgeScene.getLancelot();
		Avatars robin = aBridgeScene.getRobin();
		char keyPressed = e.getKeyChar();
		switch (keyPressed) {
    	case 'a' :
    		arthur.move(newX, newY);
    		break;
    	case 'g':
    		galahad.move(newX, newY);
    		break;
    	case 'l' :
    		lancelot.move(newX, newY);
    		break;
    	case 'r':
    		robin.move(newX, newY);
    		break;
    	case 'o':
    		arthur.move(ARTHUR_X, ARTHUR_Y);
    		
    		galahad.move(GALAHAD_X, GALAHAD_Y);
    		
    		lancelot.move(LANCE_X, LANCE_Y);
    	
    		robin.move(ROBIN_X, ROBIN_Y);
    		aBridgeScene.newOccupation(false);
		} 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getPassed()) {
			aBridgeScene.passed();
		}
		else if (e.getSource() == buttons.getSay()) {
			aBridgeScene.say(AVATAR_SAY);
		}
		else if (e.getSource() == buttons.getFailed()) {
			aBridgeScene.failed();
		}
		else if (e.getSource() == buttons.getApproach()) {
			aBridgeScene.approach(aBridgeScene.getLancelot());
		}
	}
	
	
	@Override
	public JButton getPassed() {
		return buttons.getPassed();
	}
	
	@Override
	public JButton getSay() {
		return buttons.getSay();
	}
	
	@Override
	public JButton getFailed() {
		return buttons.getFailed();
	}
	
	@Override
	public JButton getApproach() {
		return buttons.getApproach();
	}
	

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "this") {
			if(evt.getOldValue().equals("approach")) {
				if(!(Boolean)evt.getNewValue()) {
				buttons.getApproach().setEnabled(false);
				} 
				else{buttons.getApproach().setEnabled(true);}
			}
			else if(evt.getOldValue().equals("passed")) {
				if((Boolean)evt.getNewValue()) {
				buttons.getPassed().setEnabled(true);
				}
				else{buttons.getPassed().setEnabled(false);}
			}
			else if(evt.getOldValue() == "say") {
				if((Boolean)evt.getNewValue()) {
				buttons.getSay().setEnabled(true);
				}
				else{buttons.getSay().setEnabled(false);}
			}
			else if(evt.getOldValue() == "failed") {
				if((Boolean)evt.getNewValue()) {
				buttons.getFailed().setEnabled(true);
				}
				else{buttons.getFailed().setEnabled(false);}
			}
			}
		
	}
	

}
