package org.tse.pri.ioarmband.io.message;

import java.awt.Image;

public class ImageViewerApp extends Message{
	private static final long serialVersionUID = 6745634928545223211L;
	Image image;
	
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

}
