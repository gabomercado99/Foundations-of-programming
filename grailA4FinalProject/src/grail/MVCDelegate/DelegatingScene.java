package grail.MVCDelegate;

import grail.compositeFigs.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.DELEGATING_BRIDGE_SCENE_VIEW)
public class DelegatingScene implements DelegatingScenes {
	
	public DelegatingScene() {
		ObservableBridgeScene newScene = BridgeSceneFactory.observableBridgeScenePainterFactoryMethod();
		PaintListener arthur = new AvatarArthur();
		PaintListener galahad = new AvatarGalahad();
		PaintListener robin = new AvatarRobin();
		PaintListener lancelot = new AvatarLancelot();
		PaintListener guard = new AvatarGuard();
		PaintListener background = new SceneBackground();
		newScene.add(background);
		newScene.add(arthur);
		newScene.add(galahad);
		newScene.add(robin);
		newScene.add(lancelot);
		newScene.add(guard);
	}

}
