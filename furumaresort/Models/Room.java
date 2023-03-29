package furumaresort.Models;

import furuma.Models.Services;

public class Room extends Services {
	public String freeService;
	public void showInfor(){
		System.out.println("Id: "+this.getId());
		System.out.println("Tên dịch vụ: "+this.serviceName);
		System.out.println("Diện tích sử dụng: "+this.usedArea);
		System.out.println("Chi phí thuê: "+this.hireFee);
		System.out.println("Số lượng người tối đa: "+this.maxCustomer);
		System.out.println("Kiểu thuê: "+this.hireType);
		System.out.println("Dịch vụ miễn phí đi kèm: "+this.freeService);
	}

}
