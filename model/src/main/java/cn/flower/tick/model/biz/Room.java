package cn.flower.tick.model.biz;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.flower.tick.model.BaseModel;

@Entity
public class Room extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798861242951986928L;

	@ManyToOne(targetEntity = Train.class, fetch = FetchType.EAGER)
	private Train train;
	private String name;
	@OneToMany(mappedBy="room", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Seat> seats;
	private Integer seatNum;
	@ManyToOne(targetEntity = SeatType.class, fetch = FetchType.EAGER)
	private SeatType seatType;
	
	
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
}
