package furumaresort.Controllers;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {
	private final String villaFile = "Data/Villa.csv";
	private final String houseFile = "Data/House.csv";
	private final String roomFile = "Data/Room.csv";
	Scanner scanner = new Scanner(System.in);
	public void displayMainMenu() {
		int choice;


		System.out.println("Our Services: ");
		System.out.println("1.Add New Services");
		System.out.println("2.Show Services");
		System.out.println("3.Add New Customer");
		System.out.println("4.Show Information Of Customer");
		System.out.println("5.Add New Booking");
		System.out.println("6.Show Information Of Employee");
		System.out.println("7.Exit");
		System.out.print("Mời bạn lựa chọn");
		choice = scanner.nextInt();
		switch (choice){
			case 1:
				addNewServices();
				break;

//			case 2:
//				showServices();
//				break;
//			case 3:
//				addNewCustomer();
//				break;
//			case 4:
//				showInforMationOfCustomer();
//				break;
//			case 5:
//				addNewBooking();
//				break;
//			case 6:
//				showInformationOfEmployee();
//				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Retry");
		}
	}

	public void addNewServices() {

		int choice;
		do {
			System.out.println("1. Add New Villa");
			System.out.println("2. Add New House");
			System.out.println("3. Add New Room");
			System.out.println("4. Back to menu");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					addNewVilla();
					break;
				case 2:
					addNewHouse();
					break;
				case 3:
					addNewRoom();
					break;
				case 4:
					return;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (true);
	}

	public void addNewVilla() {
		Scanner scanner = new Scanner(System.in);
		try {
			FileWriter writer = new FileWriter(villaFile, true);

			System.out.println("===== ADD NEW VILLA =====");
			System.out.print("Enter id: ");
			String id = scanner.nextLine();

			System.out.print("Enter Service Name: ");
			String serviceName = scanner.nextLine();

			System.out.print("Enter usedArea: ");
			float usedArea = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire Type: ");
			String hireType = scanner.nextLine();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter max number of people: ");
			int maxCustomer = scanner.nextInt();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire fee: ");
			float hireFee = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter room standard: ");
			String roomStandard = scanner.nextLine();

			System.out.print("Enter pool area: ");
			double poolArea = scanner.nextDouble();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter number of floors: ");
			int floor = scanner.nextInt();
			scanner.nextLine(); // consume the '\n' character

			System.out.println("Enter the description: ");
			String description = scanner.nextLine();
			writer.write(String.format("%s,%s,%.2f,%s,%d,%.2f,%s,%.2f,%d,%s%n",
				id, serviceName, usedArea, hireType, maxCustomer, hireFee,
				roomStandard, poolArea, floor, description));

			writer.close();
			System.out.println("Add new villa successfully.");
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + e.getMessage());
		}
	}
	public void addNewHouse() {

		try {
			FileWriter writer = new FileWriter(villaFile, true);

			System.out.println("===== ADD NEW VILLA =====");
			System.out.print("Enter id: ");
			String id = scanner.nextLine();

			System.out.print("Enter Service Name: ");
			String serviceName = scanner.nextLine();

			System.out.print("Enter usedArea: ");
			float usedArea = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire Type: ");
			String hireType = scanner.nextLine();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter max number of people: ");
			int maxCustomer = scanner.nextInt();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire fee: ");
			float hireFee = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter room standard: ");
			String roomStandard = scanner.nextLine();



			System.out.print("Enter number of floors: ");
			int floor = scanner.nextInt();
			scanner.nextLine(); // consume the '\n' character

			System.out.println("Enter the description: ");
			String description = scanner.nextLine();
			writer.write(String.format("%s,%s,%.2f,%s,%d,%.2f,%s,%d,%s%n",
				id, serviceName, usedArea, hireType, maxCustomer, hireFee,
				roomStandard, floor, description));

			writer.close();
			System.out.println("Add new villa successfully.");
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + e.getMessage());
		}
	}
	public void addNewRoom() {

		try {
			FileWriter writer = new FileWriter(villaFile, true);

			System.out.println("===== ADD NEW VILLA =====");
			System.out.print("Enter id: ");
			String id = scanner.nextLine();

			System.out.print("Enter Service Name: ");
			String serviceName = scanner.nextLine();

			System.out.print("Enter usedArea: ");
			float usedArea = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire Type: ");
			String hireType = scanner.nextLine();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter max number of people: ");
			int maxCustomer = scanner.nextInt();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter hire fee: ");
			float hireFee = scanner.nextFloat();
			scanner.nextLine(); // consume the '\n' character

			System.out.print("Enter room standard: ");
			String freeService = scanner.nextLine();

			writer.write(String.format("%s,%s,%.2f,%s,%d,%.2f,%s%n",
				id, serviceName, usedArea, hireType, maxCustomer, hireFee,
				freeService));

			writer.close();
			System.out.println("Add new villa successfully.");
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + e.getMessage());
		}
	}
}

