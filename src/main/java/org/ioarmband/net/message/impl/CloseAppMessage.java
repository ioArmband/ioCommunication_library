package org.ioarmband.net.message.impl;

import org.ioarmband.net.message.Message;

public class CloseAppMessage extends Message {
	private static final long serialVersionUID = 9160259164919338892L;

	public CloseAppMessage() {
		super("close_app");
	}
}
