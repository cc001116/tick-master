package cn.flower.tick.model.biz;

import java.util.Date;
import java.util.List;

import cn.flower.tick.model.BaseModel;

public class Order extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3293780065451975993L;
	private List<Ticket> tickets;
	private Date date;
	private Double account;
	private Integer state;	//状态是否付费；
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	
}
