package org.tse.pri.ioarmband.io.connection.manager;

import org.tse.pri.ioarmband.io.connection.IConnectionListener;

public interface ServiceConnection extends IConnectionListener{


	public void onWinControl();
	public void onLoseControl();
	
	public void onConnectionStarted(); 
	
	
}
