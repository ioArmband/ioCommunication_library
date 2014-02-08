package org.tse.pri.ioarmband.io.message;

import org.tse.pri.ioarmband.io.message.enums.KeyboardType;

public class AppMessage  extends Message{
	private static final long serialVersionUID = 4679425979414404587L;

	String appName;
	String params;
	
	public AppMessage(String applicationName, String params) {
		super("open_app");
		this.appName = applicationName;
		this.params = params;
	}
	
	public AppMessage(String applicationName){
		this(applicationName, "");
	}
	
	public AppMessage(AppStd appStd){
		this(appStd.name, appStd.params);
	}
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "AppMessage [appName=" + appName + ", params="
				+ params + "]";
	}
	
	
	public enum AppStd{
		KEYBOARD("keyboard"),
		KEYBOARD_ALPHA("keyboard","alphabetic"),
		KEYBOARD_NUM("keyboard","numeric"),
		SLIDE_SWIPER("slider");
		//("slider");
		
		
		String name;
		String params;
		
		AppStd(String name){
			this.name = name; 
			this.params = ""; 
		}
		AppStd(String name, String param){
			this.name = name; 
			this.params = param; 
		}
		public String getName() {
			return name;
		}
		public String getParam() {
			return params;
		}
		
	}
}


