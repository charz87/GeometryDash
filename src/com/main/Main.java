package com.main;

import dashy.Window;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window window = Window.getWindow();
		window.init();
		
		Thread mainThread = new Thread(window);
		mainThread.start();

	}

}
