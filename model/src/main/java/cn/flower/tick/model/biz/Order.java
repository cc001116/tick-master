package cn.flower.tick.model.biz;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.flower.tick.model.BaseModel;
import cn.flower.tick.model.system.User;

@Entity
@Table(name = "orders")
public class Order extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3293780065451975993L;
	@OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ticket> tickets = new HashSet<Ticket>();
	private Date createDate;
	private Double account;
	private Integer state;	//状态是否付费；
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	private User createUser;
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getAccount() {
		return account;
	}
	public void setAccount(Double account) {
		this.account = account;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	
}
