package org.tse.pri.ioarmband.io.message;

import java.io.Serializable;

import org.tse.pri.ioarmband.io.component.GenericContainer;
import org.tse.pri.ioarmband.io.message.enums.ViewAnimation;
import org.tse.pri.ioarmband.io.message.enums.ViewChangeMode;

public class ChangeViewMessage implements Serializable{
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
	

	
	
}
