package org.tse.pri.ioarmband.io.message;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

public class TextMessageAppMessage extends Message {
	private static final long serialVersionUID = 6745634928545223211L;
	transient Image image;
	String message;
	String author;

	public TextMessageAppMessage(String author, String message, Image image) {
		super("text_message_app");
		this.message = message;
		this.author = author;
		this.image = image;
	}
	public TextMessageAppMessage(String author, String message) {
		this(author, message, null);
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		ImageIO.write((RenderedImage) image, "jpg", out);
	}
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image = ImageIO.read(in);
    }
}
