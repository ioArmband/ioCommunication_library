package org.tse.pri.ioarmband.io.message;

import java.io.Serializable;

import org.tse.pri.ioarmband.io.message.enums.GestureType;

public class GestureMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5753387335427689229L;
	
	private GestureType type;
	private String SourceName;
	
	public GestureType getType() {
		return type;
	}
	public void setType(GestureType type) {
		this.type = type;
	}
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}
	
}
