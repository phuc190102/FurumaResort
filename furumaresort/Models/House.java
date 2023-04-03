package furumaresort.Models;

import furumaresort.Models.Services;

import java.util.Scanner;

public class House extends Services {
	public String roomStandard;
	public String description;
	public int floor;

	public House() {
	}
	public House(String id, String serviceName, float usedArea, String hireType,
				 int maxCustomer, float hireFee, String roomStandard,
				 String description, int floor) {
		this.id = id;
		this.serviceName = serviceName;
		this.usedArea = usedArea;
		this.hireType = hireType;
		this.maxCustomer = maxCustomer;
		this.hireFee = hireFee;
		this.roomStandard = roomStandard;
		this.description = description;
		this.floor = floor;
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}



	public void showInfor(){
		System.out.println("Id: "+this.id);
		System.out.println("Tên dịch vụ: "+this.serviceName);
		System.out.println("Diện tích sử dụng: "+this.usedArea);
		System.out.println("Chi phí thuê: "+this.hireFee);
		System.out.println("Số lượng người tối đa: "+this.maxCustomer);
		System.out.println("Kiểu thuê: "+this.hireType);
		System.out.println("Mô tả tiện nghi khác: "+this.description);
		System.out.println("Số tầng: "+this.floor);
	}
	public void inputData(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== ADD NEW VILLA =====");
		System.out.print("Enter id: ");
		this.id = scanner.nextLine();

		System.out.print("Enter Service Name: ");
		this.serviceName = scanner.nextLine();

		System.out.print("Enter usedArea: ");
		this.usedArea = scanner.nextFloat();
		scanner.nextLine(); // consume the '\n' character

		System.out.print("Enter hire Type: ");
		this.hireType = scanner.nextLine();


		System.out.print("Enter max number of people: ");
		this.maxCustomer = scanner.nextInt();
		scanner.nextLine(); // consume the '\n' character

		System.out.print("Enter hire fee: ");
		this.hireFee = scanner.nextFloat();
		scanner.nextLine(); // consume the '\n' character

		System.out.print("Enter room standard: ");
		this.roomStandard = scanner.nextLine();


		System.out.print("Enter number of floors: ");
		this.floor = scanner.nextInt();
		scanner.nextLine(); // consume the '\n' character

		System.out.print("Enter the description: ");
		this.description = scanner.nextLine();
	}
	public String toCsvString() {
		return String.format("%s,%s,%.1f,%s,%d,%.1f,%s,%s,%d",
			this.id, this.serviceName, this.usedArea, this.hireType, this.maxCustomer,
			this.hireFee, this.roomStandard, this.description, this.floor);
	}
}
