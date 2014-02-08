package org.tse.pri.ioarmband.io.message;

import java.awt.Image;

public class ImageViewerApp extends Message{

	Image image;
	
	public ImageViewerApp() {
		super("image_viewer_app");
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

}
