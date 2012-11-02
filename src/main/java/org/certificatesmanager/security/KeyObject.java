package org.certificatesmanager.security;

import java.util.Date;

public class KeyObject {
	
	public String alias;
	public String issuerName;
	public Date startDate;
	public Date endDate;
	public String algorithm;
	
	public KeyObject(String alias, String issuerName, Date startDate, Date endDate, String algorithm){
		this.alias = alias;
		this.issuerName = issuerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.algorithm = algorithm;
	}
	
	public KeyObject(){
		this.issuerName = null;
		this.startDate = null;
		this.endDate = null;
		this.algorithm = null;
	}

}
