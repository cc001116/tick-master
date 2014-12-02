package cn.flower.tick.model.system;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.flower.tick.model.BaseModel;

@Entity
public class Passenger extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254796046917704845L;
	
	private String name;
	private String idCard;
	private User createUser;
	private Date createDate;
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(unique = true, nullable = false)
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@ManyToOne(targetEntity = User.class)
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
