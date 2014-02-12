package org.ioarmband.net.message.impl;

import org.ioarmband.net.message.Message;

public class CastingRequestMessage extends Message{
	
	private static final long serialVersionUID = -428276193811850125L;
	
	public Integer delay;
	public Integer width;
	public Integer height;
	
	public CastingRequestMessage() {
		super("casting_request");
	}
	
	public CastingRequestMessage(Integer delay, Integer width, Integer height) {
		super("casting_request");
		this.delay = delay;
		this.width = width;
		this.height = height;
	}
	
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	public Integer getDelay() {
		return delay;
	}
	
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
}
