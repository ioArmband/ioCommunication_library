package org.ioarmband.net.connection.manager;

import org.ioarmband.net.connection.IConnectionListener;

public interface ServiceConnection extends IConnectionListener{


	public void onWinControl();
	public void onLoseControl();
	
	public void onConnectionStarted(); 
	
	
}
