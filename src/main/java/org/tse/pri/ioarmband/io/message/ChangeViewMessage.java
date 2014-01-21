package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.component.GenericContainer;
import org.tse.pri.ioarmband.io.message.enums.ViewAnimation;
import org.tse.pri.ioarmband.io.message.enums.ViewChangeMode;

public class ChangeViewMessage extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3370679331491559705L;

	private ViewAnimation animation;
	private ViewChangeMode changeMode;
	private GenericContainer container;
	
	public ViewAnimation getAnimation() {
		return animation;
	}
	public void setAnimation(ViewAnimation animation) {
		this.animation = animation;
	}
	public ViewChangeMode getChangeMode() {
		return changeMode;
	}
	public void setChangeMode(ViewChangeMode changeMode) {
		this.changeMode = changeMode;
	}
	public GenericContainer getContainer() {
		return container;
	}
	public void setContainer(GenericContainer container) {
		this.container = container;
	}
	@Override
	public String toString() {
		return "ChangeViewMessage [animation=" + animation + ", changeMode="
				+ changeMode + ", container=" + container + "]";
	}
	

	
	
}
