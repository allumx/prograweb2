package ar.edu.uces.pw2.business.domain;

import java.util.Date;

public class FilterDate {
	private Date from;
	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	private Date to;
	
	public FilterDate() {
		
	}

}
