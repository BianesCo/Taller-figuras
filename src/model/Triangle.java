package model;

import java.awt.Point;
import java.awt.Polygon;

public class Triangle extends Figure {
	private int width;
	private int height;

	public Triangle(Point point,int width,int heigh) {
		super(point);
		this.width=width;
		this.height=heigh;
	}

	@Override
	public void draw() {
		if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { point.x, point.x + (width/2), point.x - (width/2) };
            int[] ypoints = { point.y, point.y + height, point.y + height };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
		
	}
	
	
    public void newSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

	@Override
	public void newSize(int newDiameter) {
		// TODO Auto-generated method stub
		
	}


}
