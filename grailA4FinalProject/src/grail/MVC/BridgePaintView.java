package grail.MVC;

import java.beans.PropertyChangeEvent;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import grail.compositeFigs.AngleShapes;
import grail.compositeFigs.Avatars;
import grail.compositeFigs.BridgeSceneFactory;
import grail.compositeFigs.FiveAvatars;
import grail.geometryFigs.CircleFig;
import grail.geometryFigs.ImageShapes;
import grail.geometryFigs.MovingL;
import grail.geometryFigs.RotatingLine;
import grail.geometryFigs.StringShape;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER)

@SuppressWarnings("serial")
public class BridgePaintView extends Component implements CustomView {
		FiveAvatars scene;
		
	
	public BridgePaintView() {
		scene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		//FiveAvatars.addPropertyChangeListener(this);
		scene.addPropertyChangeListenerMine(this);
		setFocusable(true);
		/*scene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		scene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		scene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		scene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		scene.getGalahad().getHead().addPropertyChangeListener(this);
		scene.getGalahad().getTorso().addPropertyChangeListener(this);
		scene.getArthur().getStringShape().addPropertyChangeListener(this);
		scene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		scene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		scene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		scene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		scene.getArthur().getHead().addPropertyChangeListener(this);
		scene.getArthur().getTorso().addPropertyChangeListener(this);
		scene.getArthur().getStringShape().addPropertyChangeListener(this);
		scene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		scene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		scene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		scene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		scene.getRobin().getHead().addPropertyChangeListener(this);
		scene.getRobin().getTorso().addPropertyChangeListener(this);
		scene.getRobin().getStringShape().addPropertyChangeListener(this);
		scene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		scene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		scene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		scene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		scene.getLancelot().getHead().addPropertyChangeListener(this);
		scene.getLancelot().getTorso().addPropertyChangeListener(this);
		scene.getLancelot().getStringShape().addPropertyChangeListener(this);
		setFocusable(true);
		*/
		//scene.getGorge().getbridgeLLine().addPropertyChangeListener(null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		imagePainter(g, scene.getGalahad());
		linePainter(g, scene.getGalahad().getTorso());
		limbsPainter(g, scene.getGalahad().getArms(), scene.getGalahad().getLegs());
		stringPainter(g, scene.getGalahad().getStringShape());
		ovalPainter(g, scene.getKnightArea());
		ovalPainter(g, scene.getGuardArea());
		imagePainter(g, scene.getArthur());
		linePainter(g, scene.getArthur().getTorso());
		limbsPainter(g, scene.getArthur().getArms(), scene.getArthur().getLegs());
		stringPainter(g, scene.getArthur().getStringShape());
		imagePainter(g, scene.getRobin());
		linePainter(g, scene.getRobin().getTorso());
		limbsPainter(g, scene.getRobin().getArms(), scene.getRobin().getLegs());
		stringPainter(g, scene.getRobin().getStringShape());
		imagePainter(g, scene.getLancelot());
		linePainter(g, scene.getLancelot().getTorso());
		limbsPainter(g, scene.getLancelot().getArms(), scene.getLancelot().getLegs());
		stringPainter(g, scene.getLancelot().getStringShape());
		imagePainter(g, scene.getGuard());
		linePainter(g, scene.getGuard().getTorso());
		limbsPainter(g, scene.getGuard().getArms(), scene.getGuard().getLegs());
		stringPainter(g, scene.getGuard().getStringShape());
		linePainter(g, scene.getGorge().getbridgeLLine());
		linePainter(g, scene.getGorge().getbridgeULine());
		linePainter(g, scene.getGorge().getleftLine());
		linePainter(g, scene.getGorge().getrightLine());
		

		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
		System.out.println(evt);
	}
	
	
	
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
	private void ovalPainter(Graphics g, MovingL avatarZone) {
		g.drawOval(avatarZone.getX(), avatarZone.getY(), avatarZone.getWidth(), avatarZone.getHeight());
	}
	private void limbsPainter(Graphics g, AngleShapes arms, AngleShapes legs) {
		linePainter(g, arms.getLeftLine());
		linePainter(g, arms.getRightLine());
		linePainter(g, legs.getLeftLine());
		linePainter(g, legs.getRightLine());
	}
	
	//public static void main(String[] args) {
	//	FiveAvatars montyChars = BridgeSceneFactory.bridgeSceneFactoryMethod();
	//	JFrame frame = new JFrame("Monty Scene");
	//	frame.add((Component) BridgeSceneFactory.inheritingBridgeScenePainterFactoryMethod());
	//	frame.setSize(2000, 800);
	//	frame.setVisible(true);}
}
