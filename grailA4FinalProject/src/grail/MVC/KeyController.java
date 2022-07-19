package grail.MVC;

import java.awt.event.KeyListener;

import javax.swing.JButton;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)

public interface KeyController extends KeyListener {

	JButton getPassed();

	JButton getSay();

	JButton getFailed();

	JButton getApproach();

}
