package cn.flower.tick.model.biz;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.flower.tick.model.BaseModel;
import cn.flower.tick.model.system.User;

@Entity
public class Passenger extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254796046917704845L;
	
	private String name;
	
	@Column(unique = true, nullable = false)
	private String idCard;
	private String phone;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	private User createUser;
	private Date createDate;
	private Integer status;
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer isStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
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
