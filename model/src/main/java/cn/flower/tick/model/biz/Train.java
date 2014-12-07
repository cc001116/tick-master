package cn.flower.tick.model.biz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import cn.flower.tick.model.BaseModel;

@Entity
public class Train extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402373154645989633L;
	@Column(nullable = false, unique = true)
	private String number;
	private String startingStation;
	private String destination;
	private Integer roomNum;
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Room> rooms = new HashSet<Room>();
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
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
