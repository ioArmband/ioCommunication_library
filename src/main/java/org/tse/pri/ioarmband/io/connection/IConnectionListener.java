package org.tse.pri.ioarmband.io.connection;

import org.tse.pri.ioarmband.io.message.Command;

public interface IConnectionListener {
	public void onCommandReiceved(Command command);
	public void onConnectionClose();
}
