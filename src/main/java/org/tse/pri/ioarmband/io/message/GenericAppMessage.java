package org.tse.pri.ioarmband.io.message;

import java.io.Serializable;

import org.tse.pri.ioarmband.io.component.GenericContainer;

public class GenericAppMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6745639794184982795L;
	
	private String name;
	private GenericContainer mainView;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GenericContainer getMainView() {
		return mainView;
	}
	public void setMainView(GenericContainer mainView) {
		this.mainView = mainView;
	}
	
	
}
