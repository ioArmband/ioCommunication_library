package org.ioarmband.net.connection.manager;


public abstract class ConnectThread extends Thread {
	  
	   @Override
	   public abstract void run();
	   
	   public abstract void cancel();

	}