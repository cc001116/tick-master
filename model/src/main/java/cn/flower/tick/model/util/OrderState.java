package cn.flower.tick.model.util;

public enum OrderState {
	UNCOMPLETE(1),
	COMPLETED(0);
	
	public int value;
	
	private OrderState(int value) {
		this.value = value;
	}
}
