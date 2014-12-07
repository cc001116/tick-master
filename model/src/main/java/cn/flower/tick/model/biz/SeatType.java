package cn.flower.tick.model.biz;


import javax.persistence.Entity;

import cn.flower.tick.model.BaseModel;

@Entity
public class SeatType extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3130755423303708073L;
	
	private String typeName;
	private String Description;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
