package org.tse.pri.ioarmband.io.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class Command{
	private static final Logger logger = Logger.getLogger(Command.class);
	private String clazz;
	private Message message;
	
	public Command(Message message) {
		this.message = message;
		clazz = message.getClass().getName();
	}
	
	public static void serialize(Command command, OutputStream output) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(output);
		oos.writeObject(command);
	}
	
	public static Command deserialize(InputStream input) throws IOException{
		ObjectInputStream ois = new ObjectInputStream(input);
		Command command = null;
		try {
			command = (Command) ois.readObject();
		} catch (ClassNotFoundException e) {
			logger.error("Error when deserializing objet", e);
		}
		return command;
	}

}
