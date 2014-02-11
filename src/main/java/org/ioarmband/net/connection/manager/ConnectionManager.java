package org.ioarmband.net.connection.manager;

import java.util.Stack;

import org.ioarmband.net.connection.IConnectionListener;
import org.ioarmband.net.connection.StreamedConnection;
import org.ioarmband.net.message.Command;
import org.ioarmband.net.message.Message;
import org.ioarmband.net.message.impl.CloseAppMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ConnectionManager {

	protected static final Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
	
	protected StreamedConnection streamConnection;

	private Stack<ServiceConnection> serviceConnections;

	public abstract void newConnectionComplementary(Object obj);
	public abstract void LauchDiscovery();
	public abstract void closeConnectionComplementary();
	
	public  void newConnection(Object obj)
	{
		newConnectionComplementary(obj);
		
		dispatchStartedConnection();
		dispatchWinConnector();
	}
	
	public  void closeConnection()
	{
		if(isConnected())
		{
			streamConnection.close();
			streamConnection = null;
			
			closeConnectionComplementary();
			
			for (ServiceConnection serviceConnection : serviceConnections) {
				removeServiceConnection(serviceConnection);
				serviceConnection.onConnectionClose();
			}
			
		}
	}
	
	public ConnectionManager()
	{
		super();
		streamConnection = null;
		serviceConnections = new Stack<ServiceConnection>();
	}
	
	public boolean isServiceConnectionExist(ServiceConnection serviceConnection)
	{
		for (ServiceConnection serviceConnectionTemp : serviceConnections) {
			if(serviceConnection.equals(serviceConnectionTemp))
			{
				return true;
			}
		}
		return false;
	}
	
	public void useConnection(ServiceConnection serviceConnection)
	{	
		logger.info("useConnection "+serviceConnection.getClass());
		if(!isCurrentServiceControl(serviceConnection))
		{
			logger.info("serviceConnection is not CurrentServiceControl");
			if(isServiceConnectionExist(serviceConnection))
			{
				logger.info("serviceConnection exist in ServiceConnection");
				moveServiceConnection(serviceConnection);
			}else
			{
				logger.info("serviceConnection not exist in ServiceConnection");
				addServiceConnection(serviceConnection);
			}

			if(!isConnected())
			{
				logger.info("serviceConnection not connect => LauchDiscovery()");
				LauchDiscovery();
			}
		}
	}

	public void removeUseConnection(ServiceConnection serviceConnection) {
		logger.info("removeUseConnection "+serviceConnection.getClass());
		removeServiceConnection(serviceConnection);
		
		if (serviceConnections.isEmpty()) {
			CloseAppMessage msg = new CloseAppMessage();
			sendMessage(msg);
			closeConnection();
		} 
	}
	
	private void removeServiceConnection(ServiceConnection serviceConnection) {
		boolean isCurrentServiceControlTemp = isCurrentServiceControl(serviceConnection);

		serviceConnections.remove(serviceConnection);
		if (isCurrentServiceControlTemp) {
			serviceConnection.onLoseControl();
			dispatchWinConnector();
		}
	}
	private void addServiceConnection(ServiceConnection serviceConnection)
	{
		if (!serviceConnections.isEmpty())
		{
			getCurrentServiceConnection().onLoseControl();
		}
		
		serviceConnections.push(serviceConnection);
		if(isConnected())
		{
			serviceConnection.onConnectionStarted();
			serviceConnection.onWinControl();
			
		}
	}
	private void moveServiceConnection(ServiceConnection serviceConnection)
	{
		if (!serviceConnections.isEmpty())
		{
			getCurrentServiceConnection().onLoseControl();
		}
		
		serviceConnections.remove(serviceConnection);
		serviceConnections.push(serviceConnection);
		
		serviceConnection.onWinControl();
		
	}

	private ServiceConnection getCurrentServiceConnection()
	{
		if (!serviceConnections.isEmpty())
			return serviceConnections.peek();
		else
			return null;
		 
	}

	


	public boolean isConnected() {
		return streamConnection != null;
	}
	
	public boolean isCurrentServiceControl(ServiceConnection serviceConnection) {
		return serviceConnection.equals(getCurrentServiceConnection());
	}


	
	public void sendMessage(Message message)
	{
		if(streamConnection != null)
		{
			streamConnection.sendCommand(new Command(message));
		}
	}
	
	
	protected IConnectionListener connection = new IConnectionListener() {

		@Override
		public void onConnectionClose() {
			dispatchCloseConnection();
		}

		@Override
		public void onCommandReiceved(Command command) {
			if(!serviceConnections.empty())
			{
				ServiceConnection currentserviceConnection = getCurrentServiceConnection();
				currentserviceConnection.onCommandReiceved(command);
			}
		}
	};
	
	
	

	
	//DISPATCH 
	
	private void dispatchStartedConnection(){
		// dispatch LoseConnector to all serviceConnections 
		for (ServiceConnection serviceConnection : serviceConnections) {
			serviceConnection.onConnectionStarted();
		}
	}
	
	private void dispatchCloseConnection(){
		for (ServiceConnection serviceConnection : serviceConnections) {
			serviceConnection.onConnectionClose();
		}
	}
	
	private void dispatchWinConnector(){
		// dispatch WinConnector to current ServiceConnections
		if(!serviceConnections.empty())
		{
			ServiceConnection currentserviceConnection = getCurrentServiceConnection();
			currentserviceConnection.onWinControl();
		}
	}
	
	/*private void dispatchLoseConnector(){
		// dispatch LoseConnector to all serviceConnections whithout current ServiceConnections
		for (int i = 0; i < serviceConnections.size()-1; i++) {
			serviceConnections.get(i).onLoseControl();
		}
	}*/
}
