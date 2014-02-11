package org.ioarmband.net.connection;

import org.ioarmband.net.message.Command;

public interface IConnection {
	public void close();
	public void sendCommand(Command command);
	public void addConnectionListener(IConnectionListener listener);
	public void removeConnectionListener(IConnectionListener listener);
}
