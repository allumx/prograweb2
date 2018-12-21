package ar.edu.uces.pw2.business.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITIES")
public class Authority implements Serializable {

	private static final long serialVersionUID = 8216311236174053090L;

	@Id
	@GeneratedValue
	private int id;
	@Column(name="authority", unique=true)
	private String authority;

	public Authority() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
