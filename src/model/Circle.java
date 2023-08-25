package model;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {
	private int diameter;

	public Circle(Point point, int diameter) {
		super(point);
		this.point = point;
		this.diameter = diameter;
	//	this.isVisible = isVisible;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if (isVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.draw(this, color, new Ellipse2D.Double(point.x, point.y, diameter, diameter));
			canvas.wait(10);

		}
	}


	
	public void newSize(int newDiameter) {
		erase();
		diameter = newDiameter;
		draw();
	}

	@Override
	public void newSize(int hight, int with) {
		// TODO Auto-generated method stub
		
	}

	


}