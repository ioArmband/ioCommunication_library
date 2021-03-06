package org.ioarmband.net.connection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

import org.ioarmband.net.message.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamedConnection implements IConnection, Runnable{


	private static final Logger logger = LoggerFactory.getLogger(StreamedConnection.class);
	protected InputStream in;
	protected OutputStream out;
	protected Thread communicationThread;
	protected boolean running;
	

	public StreamedConnection(InputStream in, OutputStream out) {
		super();
		open(in, out);
	}

	public void close() {
		if(running == false){
			return;
		}
		running = false;
		try {
			if(in != null){
				in.close();
			}
			if(out != null){
				out.close();
			}
		} catch (IOException e) {
			logger.error("StreamedConnection.close(): error while closing connection",e);
		}
		in = null;
		out = null;
		dispatchConnectionClose();
	}
	
	public void open(InputStream in, OutputStream out) {
		if(running){
			logger.warn("Try to open a connection already open, please use close() before.");
			return;
		}
		
		this.in = in;
		this.out = out;
		running = true;
		communicationThread = new Thread(this);
		communicationThread.start();
		logger.info("Connection - Begin");
	}


	
	public void run() {
		try {
			while(running){
				extractCommand(in);
			}

		} catch (IOException e) {
			logger.info("Connection closed");
			close();
		}
	}
	
	private synchronized void extractCommand(InputStream input) throws IOException{
		Command command = null;
		command = Command.deserialize(input);
		dispatchCommandReceived(command);
	}
	
	public void sendCommand(Command command) {
		logger.info("sending: " + command);
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			Command.serialize(command, out);
			bw.flush();
			
		} catch (IOException e) {
			logger.error("failed to send command " + command, e);
			e.printStackTrace();
		}
	}
	
	Set<IConnectionListener> connectionListeners = new HashSet<IConnectionListener>();
	public void addConnectionListener(IConnectionListener listener) {
		connectionListeners.add(listener);
	}
	public void removeConnectionListener(IConnectionListener listener) {
		connectionListeners.remove(listener);
	}
	private void dispatchConnectionClose(){
		for (IConnectionListener listener : connectionListeners) {
			listener.onConnectionClose();
		}
	}
	private void dispatchCommandReceived(Command command){
		logger.info("Connection - Command Received");
		for (IConnectionListener listener : connectionListeners) {
			listener.onCommandReiceved(command);
		}
	}
}
