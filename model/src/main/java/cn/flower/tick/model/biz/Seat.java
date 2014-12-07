package cn.flower.tick.model.biz;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cn.flower.tick.model.BaseModel;

@Entity
public class Seat extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962237384123437550L;
	@ManyToOne(targetEntity = Room.class, fetch= FetchType.EAGER)
	private Room room;
	private Integer seatNo;
	@ManyToOne(targetEntity = SeatType.class, fetch = FetchType.EAGER)
	private SeatType seatType;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
}
