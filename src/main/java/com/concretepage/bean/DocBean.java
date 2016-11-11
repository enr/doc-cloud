package com.concretepage.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.concretepage.service.DocService;

@ManagedBean
@RequestScoped
public class DocBean {
	
	private String user;
	private String psw;
	
	
	@ManagedProperty(value="#{docservice}")
	public DocService docService;

	public DocService getDocService() {
		return docService;
	}

	public void setDocService(DocService docService) {
		this.docService = docService;
	}
	
	
	
}
