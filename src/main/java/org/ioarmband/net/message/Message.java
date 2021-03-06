package org.ioarmband.net.message;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.openbeans.BeanInfo;
import com.googlecode.openbeans.IntrospectionException;
import com.googlecode.openbeans.Introspector;
import com.googlecode.openbeans.PropertyDescriptor;

public class Message  implements Serializable{
	private static final long serialVersionUID = 7529035990603487780L;
	private String commandName;
	private static final Logger logger = LoggerFactory.getLogger(Command.class);
	
	public Message() {}
	
	public Message(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public Map<String, Object> extractParams(){
		HashMap<String, Object> out = new HashMap<String, Object>();

		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(this.getClass());

			PropertyDescriptor[] propDescriptors =  beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor propDescriptor : propDescriptors) {
				Method getter = propDescriptor.getReadMethod();
				if(getter != null){
					logger.debug("extractParams() - access to method :" + propDescriptor.getName());
					out.put(propDescriptor.getName(), ((Object) getter.invoke(this)));
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
