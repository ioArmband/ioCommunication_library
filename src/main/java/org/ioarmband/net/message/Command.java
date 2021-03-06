package org.ioarmband.net.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Command implements Serializable{
	private static final long serialVersionUID = 3752115578936340428L;
	
	private static final Logger logger = LoggerFactory.getLogger(Command.class);
	private String clazz;
	private Message message;
	
	public Command(Message message) {
		this.setMessage(message);
		setClazz(message.getClass().getName());
	}
	
	public static void serialize(Command command, OutputStream output) throws IOException{
		logger.info("Serializing - " + command);
		ObjectOutputStream oos = new ObjectOutputStream(output);
		oos.writeObject(command);
	}
	
	public static Command deserialize(InputStream input) throws IOException{
		logger.info("Deserialization - begin");
		ObjectInputStream ois = new ObjectInputStream(input);
		Command command = null;
		try {
			command = (Command) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error("Error when deserializing objet", e);
		}
		logger.info("Deserializing - " + command);
		return command;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Command [clazz=" + clazz + ", message=" + message + "]";
	}

}
