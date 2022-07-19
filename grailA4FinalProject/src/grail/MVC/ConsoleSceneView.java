package grail.MVC;

import java.beans.PropertyChangeEvent;

import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)

public class ConsoleSceneView implements SceneView {


	
	public ConsoleSceneView(){
		FiveAvatars scene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		scene.addPropertyChangeListenerMine(this);
		//FiveAvatars.addPropertyChangeListener(this);
		//setFocusable(true);
		//FiveAvatars scene = BridgeSceneFactory.bridgeSceneFactoryMethod();
//		scene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
//		scene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
//		scene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
//		scene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
//		scene.getGalahad().getHead().addPropertyChangeListener(this);
//		scene.getGalahad().getTorso().addPropertyChangeListener(this);
//		scene.getArthur().getStringShape().addPropertyChangeListener(this);
//		scene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
//		scene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
//		scene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
//		scene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
//		scene.getArthur().getHead().addPropertyChangeListener(this);
//		scene.getArthur().getTorso().addPropertyChangeListener(this);
//		scene.getArthur().getStringShape().addPropertyChangeListener(this);
//		scene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
//		scene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
//		scene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
//		scene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
//		scene.getRobin().getHead().addPropertyChangeListener(this);
//		scene.getRobin().getTorso().addPropertyChangeListener(this);
//		scene.getRobin().getStringShape().addPropertyChangeListener(this);
//		scene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
//		scene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
//		scene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
//		scene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
//		scene.getLancelot().getHead().addPropertyChangeListener(this);
//		scene.getLancelot().getTorso().addPropertyChangeListener(this);
//		scene.getLancelot().getStringShape().addPropertyChangeListener(this);
//		//scene.getGorge().getbridgeLLine().addPropertyChangeListener(null);
		

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}

}
