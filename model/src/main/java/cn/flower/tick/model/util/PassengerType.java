package cn.flower.tick.model.util;

public enum PassengerType {
	STUDENT(1),
	ORDINARY(0);
	
	public int value;
	
	private PassengerType(int value) {
		this.value = value;
	}
}
