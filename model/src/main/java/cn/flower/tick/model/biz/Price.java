package cn.flower.tick.model.biz;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cn.flower.tick.model.BaseModel;

@Entity
public class Price extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4258002586641001402L;
	
	private String departureTime; // 出发时间
	private String departureStation;// 出发站
	private String arrivalStation; // 到达站
	private Integer price; // 价格
	@ManyToOne(targetEntity = Train.class, fetch = FetchType.EAGER)
	private Train train;
	@ManyToOne(targetEntity = SeatType.class, fetch = FetchType.EAGER)
	private SeatType seatType;

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

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

}
