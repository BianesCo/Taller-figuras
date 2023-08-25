package presenter;

import java.awt.Point;

import model.Circle;
import model.Figure;
import model.Square;
import model.Star;
import model.Triangle;

public class Presenter {
	
   
	public Figure getFigure(String name){
		
		if (name.equals("circle") ){
			Figure circle = new Circle (new Point (170,150), 100);
			
			return circle;
		}else if (name.equals("square")) {
			Figure square = new Square(new Point(170,150),100);
			//square.draw();
			return square;
			
		}else if (name.equals("triangle")) {
			Figure triangle= new Triangle(new Point (170,150),120,120);
			//triangle.draw();
			return triangle;
		}else if (name.equals("star")) {
			Figure star = new Star (new Point (170,150),120,120);
			//star.draw();
			return star;
		}else {
			
		}
		
		return null;
	}
	
}

