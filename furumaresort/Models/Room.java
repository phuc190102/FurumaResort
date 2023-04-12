package furumaresort.Models;

import furumaresort.Models.Services;

import java.util.Scanner;

public class Room extends Services {
	public String freeService;

	public Room() {
	}

	public Room(String id, String serviceName, float usedArea, String hireType,
				int maxCustomer, float hireFee, String freeService) {
		this.id = id;
		this.serviceName = serviceName;
		this.usedArea = usedArea;
		this.hireType = hireType;
		this.maxCustomer = maxCustomer;
		this.hireFee = hireFee;
		this.freeService = freeService;
	}

	public String getFreeService() {
		return freeService;
	}

	public void setFreeService(String freeService) {
		this.freeService = freeService;
	}

	public void showInfor(){
		System.out.println("Id: "+this.id);
		System.out.println("Tên dịch vụ: "+this.serviceName);
		System.out.println("Diện tích sử dụng: "+this.usedArea);
		System.out.println("Chi phí thuê: "+this.hireFee);
		System.out.println("Số lượng người tối đa: "+this.maxCustomer);
		System.out.println("Kiểu thuê: "+this.hireType);
		System.out.println("Dịch vụ miễn phí đi kèm: "+this.freeService);
	}
	public class Validation {
		public static boolean isValidId(String id) {
			return id.matches("^SVRO-\\d{4}$");
		}

		public static boolean isValidName(String name) {
			return name.matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$");
		}

		public static boolean isValidArea(float area) {
			return area > 0;
		}

		public static boolean isValidHireType(String hireType) {
			return hireType.matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$");
		}

		public static boolean isValidMaxCustomer(int maxCustomer) {
			return maxCustomer > 0 && maxCustomer < 20;
		}

		public static boolean isValidHireFee(float hireFee) {
			return hireFee > 0;
		}

		public static boolean isValidFreeService(String freeService) {
			return freeService.matches("^(Massage|Karaoke|Food|Drink|Car)$");
		}
	}
	public void inputData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== ADD NEW ROOM =====");

		do {
			System.out.print("Enter id: ");
			this.id = scanner.nextLine();
			if (!Room.Validation.isValidId(this.id)) {
				System.out.println("Invalid input. Please enter a valid ID.");
			}
		} while (!Validation.isValidId(this.id));

		do {
			System.out.print("Enter Service Name: ");
			this.serviceName = scanner.nextLine();
			if (!Room.Validation.isValidName(this.serviceName)) {
				System.out.println("Invalid input. Please enter a valid serviceName.");
			}
		} while (!Validation.isValidName(this.serviceName));

		do {
			System.out.print("Enter usedArea: ");
			this.usedArea = scanner.nextFloat();
			scanner.nextLine();
			if (!Room.Validation.isValidArea(this.usedArea)) {
				System.out.println("Invalid input. Please enter a valid usedArea.");
			}
		} while (!Validation.isValidArea(this.usedArea));

		do {
			System.out.print("Enter hire Type: ");
			this.hireType = scanner.nextLine();
			if (!Room.Validation.isValidHireType(this.hireType)) {
				System.out.println("Invalid input. Please enter a valid hireType.");
			}
		} while (!Validation.isValidHireType(this.hireType));

		do {
			System.out.print("Enter max number of people: ");
			this.maxCustomer = scanner.nextInt();
			scanner.nextLine();
			if (!Room.Validation.isValidMaxCustomer(this.maxCustomer)) {
				System.out.println("Invalid input. Please enter a valid maxCustomer.");
			}
		} while (!Validation.isValidMaxCustomer(this.maxCustomer));

		do {
			System.out.print("Enter hire fee: ");
			this.hireFee = scanner.nextFloat();
			scanner.nextLine();
			if (!Room.Validation.isValidHireFee(this.hireFee)) {
				System.out.println("Invalid input. Please enter a valid hireFee.");
			}
		} while (!Validation.isValidHireFee(this.hireFee));

		do {
			System.out.print("Enter free service: ");
			this.freeService = scanner.nextLine();
			if (!Room.Validation.isValidFreeService(this.freeService)) {
				System.out.println("Invalid input. Please enter a valid freeService.");
			}
		} while (!Validation.isValidName(this.freeService));


	}

	public String toCsvString() {
		return String.format("%s,%s,%.1f,%s,%d,%.1f,%s",
			this.id, this.serviceName, this.usedArea, this.hireType, this.maxCustomer,
			this.hireFee, this.freeService);
	}

}
