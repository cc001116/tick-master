package cn.flower.tick.model.biz;

import cn.flower.tick.model.BaseModel;

public class Price extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -334845444867349741L;
	private Train train;
	private SeatType seatType;
	private Integer amount;
	
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
