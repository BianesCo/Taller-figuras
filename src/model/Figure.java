package model;

import java.awt.Point;

public abstract class Figure implements ActionFigure {
	protected Point point;
	protected String color = "blue";
	protected boolean isVisible = true;

	public Figure(Point point) {
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void makeVisible(boolean isVidible) {
		isVisible = true;
		draw();
	}

	public void makeInvisible() {
		erase();
		isVisible = false;
	}

	public void chanceColor(String newColor) {
		color = newColor;
		draw();
	}

	public void erase() {
		if (isVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.erase(this);
		}

	}

	public void moveVertical(int distance) {
		erase();
		point.y += distance;
		draw();
	}

	public void moveHorizontal(int distance) {
		erase();
		point.x += distance;
		draw();
	}

	public void slowMoveHorizontal(int distance) {
		int delta;

		if (distance < 0) {
			delta = -1;
			distance = -distance;
		} else {
			delta = 1;
		}

		for (int i = 0; i < distance; i++) {
			point.x += delta;
			draw();
		}
	}
	
	public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            point.y += delta;
            draw();
        }
    }

}
