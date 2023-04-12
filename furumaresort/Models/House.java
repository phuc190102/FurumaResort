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
	public class Validation {
		public static boolean isValidId(String id) {
			return id.matches("^SVHO-\\d{4}$");
		}

		public static boolean isValidName(String name) {
			return name.matches("^[A-Z][a-z]*$");
		}

		public static boolean isValidArea(float area) {
			return area > 30;
		}

		public static boolean isValidHireType(String hireType) {
			return hireType.matches("^[A-Z][a-z]*$");
		}
		public static boolean isValidRoomStandard(String hireType) {
			return hireType.matches("^[A-Z][a-z]*$");
		}
		public static boolean isValidMaxCustomer(int maxCustomer) {
			return maxCustomer <= 20 && maxCustomer >= 0;
		}

		public static boolean isValidHireFee(float hireFee) {
			return hireFee > 0;
		}

		public static boolean isValidPoolArea(float poolArea) {
			return poolArea > 30;
		}

		public static boolean isValidFloor(int floor) {
			return floor > 0;
		}
	}
	public void inputData(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== ADD NEW House =====");

		do {
			System.out.print("Enter id: ");
			this.id = scanner.nextLine();
			if (!House.Validation.isValidId(this.id)) {
				System.out.println("Invalid input. Please enter a valid ID.");
			}
		} while (!House.Validation.isValidId(this.id));

		do {
			System.out.print("Enter Service Name: ");
			this.serviceName = scanner.nextLine();
			if (!House.Validation.isValidName(this.serviceName)) {
				System.out.println("Invalid input. Please enter a valid serviceName.");
			}
		} while (!House.Validation.isValidName(this.serviceName));

		do {
			System.out.print("Enter usedArea: ");
			this.usedArea = scanner.nextFloat();
			scanner.nextLine();
			if (!House.Validation.isValidArea(this.usedArea)) {
				System.out.println("Invalid input. Please enter a valid usedArea.");
			}
		} while (!House.Validation.isValidArea(this.usedArea));

		do {
			System.out.print("Enter hire Type: ");
			this.hireType = scanner.nextLine();
			if (!House.Validation.isValidHireType(this.hireType)) {
				System.out.println("Invalid input. Please enter a valid hireType.");
			}
		} while (!House.Validation.isValidHireType(this.hireType));

		do {
			System.out.print("Enter max number of people: ");
			this.maxCustomer = scanner.nextInt();
			scanner.nextLine();
			if (!House.Validation.isValidMaxCustomer(this.maxCustomer)) {
				System.out.println("Invalid input. Please enter a valid maxCustomer.");
			}
		} while (!House.Validation.isValidMaxCustomer(this.maxCustomer));

		do {
			System.out.print("Enter hire fee: ");
			this.hireFee = scanner.nextFloat();
			scanner.nextLine();
			if (!House.Validation.isValidHireFee(this.hireFee)) {
				System.out.println("Invalid input. Please enter a valid hireFee.");
			}
		} while (!House.Validation.isValidHireFee(this.hireFee));

		do {
			System.out.print("Enter room standard: ");
			this.roomStandard = scanner.nextLine();
			if (!House.Validation.isValidRoomStandard(this.roomStandard)) {
				System.out.println("Invalid input. Please enter a valid roomStandard.");
			}
		} while (!House.Validation.isValidRoomStandard(this.roomStandard));



		do {
			System.out.print("Enter number of floors: ");
			this.floor = scanner.nextInt();
			scanner.nextLine();
			if (!House.Validation.isValidFloor(this.floor)) {
				System.out.println("Invalid input. Please enter a valid floor.");
			}
		} while (!House.Validation.isValidFloor(this.floor));

		do {
			System.out.print("Enter the description: ");
			this.description = scanner.nextLine();
			if (!House.Validation.isValidName(this.description)) {
				System.out.println("Invalid input. Please enter a valid description.");
			}
		} while (!House.Validation.isValidName(this.description));
	}
	public String toCsvString() {
		return String.format("%s,%s,%.1f,%s,%d,%.1f,%s,%s,%d",
			this.id, this.serviceName, this.usedArea, this.hireType, this.maxCustomer,
			this.hireFee, this.roomStandard, this.description, this.floor);
	}
}
