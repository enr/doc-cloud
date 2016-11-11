package com.concretepage.model;

import java.io.Serializable;

public class Tag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2334865226098424715L;
	private String key;
	private String desc;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
