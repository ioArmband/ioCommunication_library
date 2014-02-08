package org.tse.pri.ioarmband.io.message;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Message  implements Serializable{
	private static final long serialVersionUID = 7529035990603487780L;
	private String commandName;
	private static final Logger logger = Logger.getLogger(Message.class);

	public Message(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public Map<String, String> extractParams(){
		HashMap<String, String> out = new HashMap<String, String>();

		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(this.getClass());

			PropertyDescriptor[] propDescriptors =  beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor propDescriptor : propDescriptors) {
				Method getter = propDescriptor.getReadMethod();
				if(getter != null){
					logger.debug("extractParams() - access to method :" + propDescriptor.getName());
					out.put(propDescriptor.getName(), ((Object) getter.invoke(this)).toString());
				}
			}
			return out;
			
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null;
	}
}
