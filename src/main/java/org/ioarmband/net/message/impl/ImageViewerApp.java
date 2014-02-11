package org.ioarmband.net.message.impl;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import org.ioarmband.net.message.Message;

public class ImageViewerApp extends Message{
	private static final long serialVersionUID = 6745634928545223211L;
	transient Image image;

	public ImageViewerApp(Image image) {
		super("image_viewer_app");
		this.image = image;
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
