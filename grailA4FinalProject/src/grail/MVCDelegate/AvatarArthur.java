package grail.MVCDelegate;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import grail.compositeFigs.AngleShapes;
import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;
import grail.geometryFigs.ImageShapes;
import grail.geometryFigs.MovingL;
import grail.geometryFigs.StringShape;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)

public class AvatarArthur implements PaintListener {

	FiveAvatars bridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
	ObservableBridgeScene observable = BridgeSceneFactory.observableBridgeScenePainterFactoryMethod();
	
	public AvatarArthur() {
		Avatars arthur = bridgeScene.getArthur();
		Avatars.addPropertyChangeListener(arthur, this);
		
	}
	@Override
	public void paint(Graphics2D g) {
		imagePainter(g, bridgeScene.getArthur());
		linePainter(g, bridgeScene.getArthur().getTorso());
		limbsPainter(g, bridgeScene.getArthur().getArms(), bridgeScene.getArthur().getLegs());
		stringPainter(g, bridgeScene.getArthur().getStringShape());
	
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		observable.repaint();	
	}

	//@Override
	//public void addPaintListener() {
	//	observable.add(this);
		
	//}
	private void imagePainter(Graphics g, Avatars avatarHead) {
		ImageShapes headImage = avatarHead.getHead();
		BufferedImage newImage = null;
		try {
			newImage = ImageIO.read(new File(headImage.getImageFileName()));
		} catch (IOException e) {}
		g.drawImage(newImage, headImage.getX(), headImage.getY(), headImage.getWidth(), headImage.getHeight(), null);
	}
	
	private void linePainter(Graphics g, MovingL line) {
		g.drawLine(line.getX(), line.getY(), line.getX() + line.getWidth(), line.getY() + line.getHeight());
	}
	private void stringPainter(Graphics g, StringShape quote) {
		g.drawString(quote.getText(), quote.getX(), quote.getY());
	}
	
	private void limbsPainter(Graphics g, AngleShapes arms, AngleShapes legs) {
		linePainter(g, arms.getLeftLine());
		linePainter(g, arms.getRightLine());
		linePainter(g, legs.getLeftLine());
		linePainter(g, legs.getRightLine());
	}

}
