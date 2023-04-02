package furumaresort.Controllers;

import furumaresort.Models.House;
import furumaresort.Models.Room;
import furumaresort.Models.Villa;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {
	private final String villaFile = "D:/Aphucdeptrai/furumaresort/Data/Villa.csv";
	private final String houseFile = "D:/Aphucdeptrai/furumaresort/Data/House.csv";
	private final String roomFile = "D:/Aphucdeptrai/furumaresort/Data/Room.csv";
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
		System.out.print("Mời bạn lựa chọn: ");
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
					addNewServices();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (true);
	}

	public void addNewVilla() {

		Villa villa = new Villa();
		villa.inputData();
		writeVillaToFile(villa);
		System.out.println("New villa has been added successfully!");
	}

	public void addNewHouse() {
		House house = new House();
		house.inputData();
		writeHouseToFile(house);
		System.out.println("New house has been added successfully!");


	}
	public void addNewRoom() {
		Room room = new Room();
		room.inputData();
		writeRoomToFile(room);
		System.out.println("New room has been added successfully!");


	}
	private void writeVillaToFile(Villa villa) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(villaFile, true))) {
			writer.println(villa.toCsvString());
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + villaFile);
		}
	}
	private void writeHouseToFile(House house) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(houseFile, true))) {
			writer.println(house.toCsvString());
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + houseFile);
		}
	}
	private void writeRoomToFile(Room room) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(roomFile, true))) {
			writer.println(room.toCsvString());
		} catch (IOException e) {
			System.out.println("Failed to write to file: " + roomFile);
		}
	}
}

