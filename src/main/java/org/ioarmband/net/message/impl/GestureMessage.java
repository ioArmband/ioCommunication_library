package org.ioarmband.net.message.impl;

import org.ioarmband.net.message.Message;
import org.ioarmband.net.message.enums.GestureType;

public class GestureMessage extends Message{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5753387335427689229L;
	
	private GestureType type;
	private String sourceName;
	
	
	public GestureMessage() {
		super("gesture");
	}

	
	public GestureMessage(GestureType type,	String sourceName) {
		super("gesture");
		this.type = type;
		this.sourceName = sourceName;
	}


	public GestureType getType() {
		return type;
	}
	public void setType(GestureType type) {
		this.type = type;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
	@Override
	public String toString() {
		return "GestureMessage [type=" + type + ", sourceName=" + sourceName
				+ "]";
	}
}
