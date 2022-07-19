package grail.geometryFigs;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;

import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.compositeFigs.FiveAvatars;
import grail.compositeFigs.FiveChars;
import grail.compositeFigs.ImpossibleAngleException;
import tags301.Comp301Tags;


@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags(Comp301Tags.ROTATING_LINE)
@PropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Angle", "Radius", "Height", "Width"})

public class RotatingLine extends ABoundedShape implements MovingL {
	
	//protected int x;
	//protected int y;		
	protected Point lowerRC;
	protected double radius, angle;
	//int height;
	//int width;
	
	
	
	public RotatingLine() {
		lowerRC = new PolarPoint(radius, angle);
	}
	public RotatingLine(int initx, int inity) {
		x = initx;
		y = inity;
	}
	public RotatingLine(double initRad, double initAng, int initx, int inity) {
		x = initx;
		y = inity;
		radius = initRad;;
		try {
			lowerRC = new PolarPoint(radius, angle);
			setAngle(initAng);
		} catch (IOException e) {
			System.out.println("Angle out of range");
			e.printStackTrace();
		}
		height = lowerRC.getYH();
		width = lowerRC.getXH(); 
	}
	
	@Override
	public void rotate(int units) {
		double radianUn = units*(Math.PI/32);
		double newAngle = radianUn + angle;
		try {
			setAngle(newAngle);
		} catch (IOException e) {
			System.out.println("Angle out of range");
			e.printStackTrace();
		}
		//this.setAngle(newAngle);
		height = lowerRC.getYH();
		width = lowerRC.getXH();
	}
	@Override
	public void move(int newX, int newY) {
		int oldHorizontal = x;
		int oldVertical = y;
		x = newX;
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVertical,
				newY));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldHorizontal,
				newX));
	}
	@Override
	public double getRadius() {
		return radius;
	}
	@Override
	public double getAngle() {
		return angle;
	}
	@Override
	public MovingL clone() {
		double newR = this.getRadius();
		double newAng = this.getAngle();
		int newx = this.getX();
		int newy = this.getY();
		MovingL twinLine = new RotatingLine(newR, newAng, newx, newy);
		return twinLine;
	}
	@Override
	public void setRadius(double newR) {
		double oldRadius = radius;
		radius = newR;
		lowerRC.setRadius(newR);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldRadius,
				newR));
		
	}
	@Override
	public void setAngle(double newAng) throws IOException {
		double oldAngle = angle;
		angle = newAng;
		lowerRC.setAngle(newAng);
		height = lowerRC.getYH();
		width = lowerRC.getXH();
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldAngle,
				newAng));
	}
	
	

}
