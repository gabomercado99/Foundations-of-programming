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

public class SceneBackground implements PaintListener{
	
	FiveAvatars bridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
	ObservableBridgeScene observable = BridgeSceneFactory.observableBridgeScenePainterFactoryMethod();
	
	public SceneBackground() {
		Avatars arthur = bridgeScene.getArthur();
		Avatars.addPropertyChangeListener(arthur, this);
		
	}
	@Override
	public void paint(Graphics2D g) {
		ovalPainter(g, bridgeScene.getKnightArea());
		ovalPainter(g, bridgeScene.getGuardArea());
		linePainter(g, bridgeScene.getGorge().getbridgeLLine());
		linePainter(g, bridgeScene.getGorge().getbridgeULine());
		linePainter(g, bridgeScene.getGorge().getleftLine());
		linePainter(g, bridgeScene.getGorge().getrightLine());
		
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		observable.repaint();
		
	}

//	@Override
//	public void addPaintListener() {
//		observable.add(this);
//		
//	}
	
	
	private void linePainter(Graphics g, MovingL line) {
		g.drawLine(line.getX(), line.getY(), line.getX() + line.getWidth(), line.getY() + line.getHeight());
	}
	
	private void ovalPainter(Graphics g, MovingL avatarZone) {
		g.drawOval(avatarZone.getX(), avatarZone.getY(), avatarZone.getWidth(), avatarZone.getHeight());
	}
	

}
