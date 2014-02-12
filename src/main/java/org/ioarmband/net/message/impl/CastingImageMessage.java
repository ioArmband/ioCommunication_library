package org.ioarmband.net.message.impl;

import org.ioarmband.net.message.Message;

public class CastingImageMessage extends Message {
	private static final long serialVersionUID = 4146474021541087077L;
	
	String encodedImage;
	
	public CastingImageMessage(String encodedImage) {
		super("casting_image");
		this.encodedImage = encodedImage;
	}
	
	public CastingImageMessage() {
		super("casting_image");
	}
	
	public String getEncodedImage() {
		return encodedImage;
	}
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
}
