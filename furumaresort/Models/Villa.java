package furumaresort.Models;

import furumaresort.Models.Services;

public class Villa extends Services {
	public String roomStandard;
	public String description;
	public float poolArea;
	public int floor;

	public Villa() {
	}

	public String getRoomStandard() {
		return roomStandard;
	}

	public void setRoomStandard(String roomStandard) {
		this.roomStandard = roomStandard;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPoolArea() {
		return poolArea;
	}

	public void setPoolArea(float poolArea) {
		this.poolArea = poolArea;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public void showInfor(){
		System.out.println("Id: "+this.getId());
		System.out.println("Tên dịch vụ: "+this.serviceName);
		System.out.println("Diện tích sử dụng: "+this.usedArea);
		System.out.println("Chi phí thuê: "+this.hireFee);
		System.out.println("Số lượng người tối đa: "+this.maxCustomer);
		System.out.println("Kiểu thuê: "+this.hireType);
		System.out.println("Mô tả tiện nghi khác: "+this.description);
		System.out.println("Tiêu chuẩn phòng: "+this.roomStandard);
		System.out.println("Diện tích hồ bơi: "+this.poolArea);
		System.out.println("Số tầng: "+this.floor);

	}
}
