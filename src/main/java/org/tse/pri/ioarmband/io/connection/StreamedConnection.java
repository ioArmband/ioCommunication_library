package org.tse.pri.ioarmband.io.connection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.tse.pri.ioarmband.io.message.Command;

public class StreamedConnection implements IConnection, Runnable{


	private static final Logger logger = Logger.getLogger(StreamedConnection.class);
	protected InputStream in;
	protected OutputStream out;
	protected Thread communicationThread;
	protected boolean running;
	
	public StreamedConnection(InputStream in, OutputStream out) {
		super();
		this.in = in;
		this.out = out;
		communicationThread = new Thread(this);
		communicationThread.start();
	}

	public void close() {
		try {
			running = false;
			in.close();
			out.close();
			dispatchConnectionClose();
		} catch (IOException e) {
			logger.error("StreamedConnection.close(): error while closing connection",e);
		}
	}


	
	public void run() {
		try {
			while(running){
				extractCommand(in);
			}

		} catch (IOException e) {
			logger.error("Problem while running StreamedConnection", e);
		}
	}
	
	private synchronized void extractCommand(InputStream input) throws IOException{
		
		Command command = null;
		Command.deserialize(input);
		
		dispatchCommandReceived(command);
	}
	
	public void sendCommand(Command command) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			Command.serialize(command, out);
			bw.newLine();
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
		for (IConnectionListener listener : connectionListeners) {
			listener.onCommandReiceved(command);
		}
	}
}
