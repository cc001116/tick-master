package cn.flower.tick.model.biz;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cn.flower.tick.model.BaseModel;

@Entity
public class Ticket extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7128118258844334520L;
	
	@Column(unique = true, nullable = false)
	private String serialCode;
	@ManyToOne(targetEntity= Seat.class, fetch = FetchType.EAGER)
	private Seat seat;
	@ManyToOne(targetEntity = Passenger.class, fetch = FetchType.EAGER)
	private Passenger passenger;
	private Date startDate;
	@ManyToOne(targetEntity = Price.class, fetch = FetchType.EAGER)
	private Price price;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	private Date createDate;
	
	public String getSerialCode() {
		return serialCode;
	}
	public void setSerialCode(String serialCode) {
		this.serialCode = UUID.randomUUID().toString();
	}
	
	/*public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}*/
	
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}


