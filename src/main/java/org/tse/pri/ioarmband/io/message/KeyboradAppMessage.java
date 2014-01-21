package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.message.enums.KeyboardType;

public class KeyboradAppMessage  extends Message{
	@Override
	public String toString() {
		return "KeyboradAppMessage [keyboardType=" + keyboardType + "]";
	}

	private static final long serialVersionUID = 4679425979414404587L;

	KeyboardType keyboardType;

	public KeyboardType getKeyboardType() {
		return keyboardType;
	}

	public void setKeyboardType(KeyboardType keyboardType) {
		this.keyboardType = keyboardType;
	}
	
}
