package grail.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;

public class BridgeSceneMouseController  implements MouseController {
	
	static final String AVATAR_SAY = "I did it!";

	int newX;
	int newY;
	FiveAvatars aBridgeScene;
	
	public BridgeSceneMouseController() {
	
	}
	
//	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.print("mouse clicked");
		newX = e.getX();
		newY = e.getY();
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	


}
	


