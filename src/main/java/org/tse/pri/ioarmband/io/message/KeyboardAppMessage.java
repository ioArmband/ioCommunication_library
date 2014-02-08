package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.message.enums.KeyboardType;
import static org.tse.pri.ioarmband.io.message.AppMessage.AppStd.*;

public class KeyboardAppMessage  extends AppMessage{
	private static final long serialVersionUID = 4679425979414404587L;
	public KeyboardAppMessage(String type) {
		super(KEYBOARD.name(), type);
	}
	public KeyboardAppMessage() {
		super(KEYBOARD_NUM);
	}


	
}
