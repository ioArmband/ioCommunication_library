package org.ioarmband.net.connection.manager;

import java.util.UUID;

public abstract class DiscoveryManager {

	public static UUID CLIENT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
	 
	public abstract void startdiscoveryDevice();
	
}
