package org.ioarmband.net.connection;

import org.ioarmband.net.message.Command;

public interface IConnectionListener {
	public void onCommandReiceved(Command command);
	public void onConnectionClose();
}
