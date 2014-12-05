package cn.flower.tick.model.biz;

import java.util.List;

import cn.flower.tick.model.BaseModel;

public class Train extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402373154645989633L;
	private String number;
	private String startingStation;
	private String destination;
	private List<Seat> seats;
	private String description;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStartingStation() {
		return startingStation;
	}
	public void setStartingStation(String startingStation) {
		this.startingStation = startingStation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
