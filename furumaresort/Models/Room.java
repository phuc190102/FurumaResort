package furumaresort.Models;

import furumaresort.Models.Services;

import java.util.Scanner;

public class Room extends Services {
	public String freeService;
	public void showInfor(){
		System.out.println("Id: "+this.id);
		System.out.println("Tên dịch vụ: "+this.serviceName);
		System.out.println("Diện tích sử dụng: "+this.usedArea);
		System.out.println("Chi phí thuê: "+this.hireFee);
		System.out.println("Số lượng người tối đa: "+this.maxCustomer);
		System.out.println("Kiểu thuê: "+this.hireType);
		System.out.println("Dịch vụ miễn phí đi kèm: "+this.freeService);
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

		System.out.print("Enter Free Service: ");
		this.freeService = scanner.nextLine();

	}
	public String toCsvString() {
		return String.format("%s,%s,%.1f,%s,%d,%.1f,%s",
			this.id, this.serviceName, this.usedArea, this.hireType, this.maxCustomer,
			this.hireFee, this.freeService);
	}

}
