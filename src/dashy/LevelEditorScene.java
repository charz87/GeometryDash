package dashy;

import java.awt.*;

import util.Constants;

public class LevelEditorScene extends Scene {
	
	public LevelEditorScene(String name)
	{
		super.Scene(name);
	}
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		System.out.println("In Level Editor");
		
	}

	@Override
	public void draw(Graphics2D g2D) {
		// TODO Auto-generated method stub
		g2D.setColor(Color.BLUE);
		g2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		
	}

}
