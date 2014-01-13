package org.tse.pri.ioarmband.io.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while(running){
				String input = br.readLine();
				extractCommand(input);
			}

		} catch (IOException e) {
			logger.error("Problem while running StreamedConnection", e);
		}
	}
	
	private synchronized void extractCommand(String input){
		
		Command command = null;
		
		//TODO: command dezerializer and analyser
		
		dispatchCommandReceived(command);
	}
	
	public void sendCommand(Command command) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String output = null;
			//TODO: Command serializer
			
			bw.write(output);
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
