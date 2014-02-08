package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.message.enums.GestureType;

public class GestureMessage extends Message{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5753387335427689229L;
	
	private GestureType type;
	private String SourceName;
	
	
	public GestureMessage() {
		super("gesture");
	}

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
	
	@Override
	public String toString() {
		return "GestureMessage [type=" + type + ", SourceName=" + SourceName
				+ "]";
	}
}
