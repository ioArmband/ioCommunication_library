package org.ioarmband.net.message.impl;

import org.ioarmband.net.component.GenericContainer;
import org.ioarmband.net.message.Message;
import org.ioarmband.net.message.enums.ViewAnimation;
import org.ioarmband.net.message.enums.ViewChangeMode;

public class ChangeViewMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370679331491559705L;

	private ViewAnimation animation;
	private ViewChangeMode changeMode;
	private GenericContainer container;
	
	public ChangeViewMessage() {
		super("change_view");
	}
	
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
