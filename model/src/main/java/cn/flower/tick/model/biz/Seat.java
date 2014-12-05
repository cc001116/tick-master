package cn.flower.tick.model.biz;

import cn.flower.tick.model.BaseModel;

public class Seat extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962237384123437550L;
	private Train train;
	private String room;
	private Integer seatNo;
	private SeatType seatType;
	
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
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
