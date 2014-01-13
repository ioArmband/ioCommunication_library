package org.tse.pri.ioarmband.io.connection;

import org.tse.pri.ioarmband.io.message.Command;

public interface IConnection {
	public void close();
	public void sendCommand(Command command);
	public void addConnectionListener(IConnectionListener listener);
	public void removeConnectionListener(IConnectionListener listener);
}
