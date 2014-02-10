package org.tse.pri.ioarmband.io.connection.manager;


public abstract class ConnectThread extends Thread {
	  
	   @Override
	   public abstract void run();
	   
	   public abstract void cancel();

	}