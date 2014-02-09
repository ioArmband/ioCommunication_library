package org.tse.pri.ioarmband.io.message;

import java.awt.Image;



public class TextMessageAppMessage extends Message   {
	private static final long serialVersionUID = 6745634928545223211L;

	String message;
	String author;

	public TextMessageAppMessage(String author, String message, Image image) {
		super("text_message_app");
		this.message = message;
		this.author = author;
	}
	public TextMessageAppMessage(String author, String message) {
		super("text_message_app");
		//this(author, message, null);
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


}
