package dashy;

import java.awt.*;
import javax.swing.JFrame;

import util.Constants;
import util.Time;

public class Window extends JFrame implements Runnable{
	
	public MListener mouseListener;
	public KListener keyListener;
	private static Window window = null;
	private boolean isRunning = true;
	private Scene currentScene = null;
	private Image doubleBufferImage = null;
	private Graphics doubleBufferGraphics = null;
	
	public Window()
	{
		this.mouseListener = new MListener();
		this.keyListener = new KListener();
		this.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyListener);
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		this.setLocationRelativeTo(null);
	}
	
	public void init()
	{
		changeScene(0);
	}
	
	public void changeScene(int scene)
	{
		switch(scene)
		{
		case 0:
			currentScene = new LevelEditorScene("Level Editor");
			break;
		default:
			System.out.println("Do not know where this scene is");
			currentScene = null;
			break;
		
		
		}
		
	}
	
	public static Window getWindow()
	{
		if(Window.window == null)
		{
			Window.window = new Window();
		}
		
		return Window.window;
	}
	
	public void update(double deltatime)
	{
		currentScene.update(deltatime);
		draw(getGraphics());
		
	}
	
	public void draw(Graphics g)
	{
		if(doubleBufferImage == null)
		{
			doubleBufferImage = createImage(getWidth(), getHeight());
			doubleBufferGraphics = doubleBufferImage.getGraphics();
		}
		
		renderOffscreen(doubleBufferGraphics);
		
		g.drawImage(doubleBufferImage,0,0,getWidth(),getHeight(),null);
	}
	
	public void renderOffscreen(Graphics g)
	{
		Graphics2D g2D = (Graphics2D)g;
		currentScene.draw(g2D);
	}
	
	@Override
	public void run() 
	{
		double lastFrameTime = 0.0;
		try 
		{
			while(isRunning) 
			{
				double time = Time.getTime();
				double deltaTime = time - lastFrameTime;
				lastFrameTime = time;
				
				update(deltaTime);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
