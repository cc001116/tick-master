package cn.flower.tick.model.system;

import java.util.Date;

import javax.persistence.Entity;

import cn.flower.tick.model.BaseModel;

@Entity
public class User extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8963385763043535808L;

	private String username;
	private String password;
	private Date registerDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
