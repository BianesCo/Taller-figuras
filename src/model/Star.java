package model;

import java.awt.Point;
import java.awt.Polygon;


public class Star extends Figure {

	private int height;
	private int width;

	public Star(Point point, int height, int width) {
		super(point);
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
	    if (isVisible) {
	        Canvas canvas = Canvas.getCanvas();
	        double angle = Math.PI / 5; // Ángulo entre los vértices
	        int[] xpoints = new int[10];
	        int[] ypoints = new int[10];

	        for (int i = 0; i < 10; i++) {
	            if (i % 2 == 0) { // Puntos pares (vértices externos)
	                xpoints[i] = point.x + (int) (width * Math.cos(i * angle));
	                ypoints[i] = point.y - (int) (height * Math.sin(i * angle));
	            } else { // Puntos impares (vértices internos)
	                xpoints[i] = point.x + (int) ((width * 0.5) * Math.cos(i * angle));
	                ypoints[i] = point.y - (int) ((height * 0.5) * Math.sin(i * angle));
	            }
	        }

	        canvas.draw(this, color, new Polygon(xpoints, ypoints, 10));
	        canvas.wait(10);
	    }
	}
	
		
	

	@Override
	public void newSize(int newDiameter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newSize(int hight, int with) {
		 erase();
	        height =hight;
	        width = with;
	        draw();
		
	}
	




	

}
