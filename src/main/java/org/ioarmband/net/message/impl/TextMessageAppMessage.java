package org.ioarmband.net.message.impl;

import org.ioarmband.net.message.Message;

public class TextMessageAppMessage extends Message   {
	private static final long serialVersionUID = 6745634928545223211L;

	String source;
	String message;
	String author;
	String encodedImage;

	public TextMessageAppMessage( String source, String author, String message, String encodedImage) {
		super("text_message_app");
		this.source = source;
		this.message = message;
		this.author = author;
		this.encodedImage = encodedImage;
	}
	public TextMessageAppMessage( String source, String author, String message) {
		this(source, author, message, null);
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getEncodedImage() {
		return encodedImage;
	}
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}
