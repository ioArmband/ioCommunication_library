package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.component.GenericContainer;

public class GenericAppMessage extends Message{
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
	
	@Override
	public String toString() {
		return "GenericAppMessage [name=" + name + ", mainView=" + mainView
				+ "]";
	}
	
	
}
