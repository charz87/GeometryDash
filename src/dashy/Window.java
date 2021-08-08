package dashy;

import javax.swing.JFrame;

import util.Time;

public class Window extends JFrame implements Runnable{
	
	private static Window window = null;
	private boolean isRunning = true;
	static final int SCREEN_WIDTH = 1280;
	static final int SCREEN_HEIGHT = 720;
	
	public Window()
	{
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setTitle("Geometry Dash");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public void init()
	{
		
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
		System.out.println(deltatime);
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
				
				update(time);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
