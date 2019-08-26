package driver;

import utilitys.SingletonFrameManager;

public class Driver {


	public static void main(String[] args) {
		
		SingletonFrameManager frameManager = SingletonFrameManager.getInstance();
		
		frameManager.lunchLoginPage();

	}	

}

