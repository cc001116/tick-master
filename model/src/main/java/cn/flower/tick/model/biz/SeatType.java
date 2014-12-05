package cn.flower.tick.model.biz;

import cn.flower.tick.model.BaseModel;

public class SeatType extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3130755423303708073L;
	private String typeName;
	private String typeCode;
	private String discount;
	private String description;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
