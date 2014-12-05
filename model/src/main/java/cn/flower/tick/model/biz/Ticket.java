package cn.flower.tick.model.biz;

import java.util.Date;

import cn.flower.tick.model.BaseModel;

public class Ticket extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7128118258844334520L;
	
	private Seat seat;
	private Passenger passenger;
	private Date startDate;
	private Order order;
	
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}


