package org.ioarmband.net.component;

import java.io.Serializable;
import java.util.Set;

import org.ioarmband.net.message.enums.GestureType;

public abstract class GenericComponent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742422542323936577L;
	
	Set<GestureType>  gestureTypes;
	
	
	
}
