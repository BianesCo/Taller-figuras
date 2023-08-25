package model;

import java.awt.Point;
import java.awt.Rectangle;

public class Square extends Figure {
	private int side;

	public Square(Point point, int side) {
		super(point);
		this.point = point;
		this.side = side;
		//this.isVisible = isVisible;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void draw() {
		if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,new Rectangle(point.x, point.y, side, side));
            canvas.wait(10);
        }
		
	}

	
	public void newSize(int newDiameter) {
		erase();
		side = newDiameter;
		draw();
	}


	@Override
	public void newSize(int hight, int with) {
		// TODO Auto-generated method stub
		
	}




}