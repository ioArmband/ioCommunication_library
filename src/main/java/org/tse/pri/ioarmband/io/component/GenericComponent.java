package org.tse.pri.ioarmband.io.component;

import java.io.Serializable;
import java.util.Set;

import org.tse.pri.ioarmband.io.message.enums.GestureType;

public abstract class GenericComponent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742422542323936577L;
	
	Set<GestureType>  gestureTypes;
	
	
	
}
