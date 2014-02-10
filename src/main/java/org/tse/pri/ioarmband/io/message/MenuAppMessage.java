package org.tse.pri.ioarmband.io.message;

public class MenuAppMessage extends Message{
	private static final long serialVersionUID = 7506273557010786819L;
	
	private Integer appIndex;
	private Boolean isLast;
	private String appName;
	
	public MenuAppMessage(Integer appIndex, Boolean isLast, String appName) {
		super("menu_app");
		this.appIndex = appIndex;
		this.isLast = isLast;
		this.appName = appName;
	}

	public MenuAppMessage(Integer appIndex, Boolean isLast) {
		this(appIndex, isLast, "");
	}
	
	public Integer getAppIndex() {
		return appIndex;
	}
	
	public void setAppIndex(Integer appIndex) {
		this.appIndex = appIndex;
	}


	public Boolean getIsLast() {
		return isLast;
	}
	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		return "MenuAppMessage [appIndex=" + appIndex + ", isLast=" + isLast
				+ ", appName=" + appName + "]";
	}

	
	

}
