package furumaresort.Controllers;

import furumaresort.Models.House;
import furumaresort.Models.Room;
import furumaresort.Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
		switch (choice) {
			case 1:
				addNewServices();
				break;

			case 2:
				showServices();
				break;
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
					displayMainMenu();
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

	public void showServices() {

		int choice;
		do {
			System.out.println("1. Show All Villa");
			System.out.println("2. Show All House");
			System.out.println("3. Show All Room");
			System.out.println("4. Show All Name Villa Not Duplicate");
			System.out.println("5. Show All Name House Not Duplicate");
			System.out.println("6. Show All Name Room Not Duplicate");
			System.out.println("7.Back To Menu ");
			System.out.println("8.Exit! ");

			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					showAllVilla();
					break;
				case 2:
					showAllHouse();
					break;
				case 3:
					showAllRoom();
					break;
				case 4:

					break;
				case 5:

				case 6:

					break;
				case 7:
					displayMainMenu();
					break;
				case 8:
					System.exit(0);
				default:
					System.exit(0);
					System.out.println("Invalid choice. Please try again.");
			}
		} while (true);
	}

	public void showAllVilla() {

		ArrayList<Villa> villas = new ArrayList<>();
		try {
			BufferedReader br =
				new BufferedReader(new FileReader("D:/Aphucdeptrai/furumaresort/Data/Villa.csv"));
			String line;
			while ((line= br.readLine())  != null) {
				String[] fields = line.split(",");
				Villa villa =
					new Villa(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], Integer.parseInt(fields[4])
						, Float.parseFloat(fields[5]), fields[6], Float.parseFloat(fields[7]),
						fields[8], Integer.parseInt(fields[9]));
				villas.add(villa);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = 1;
		for (Villa villa : villas) {
			System.out.println("Villa number "+count);
			System.out.println("========================================");
			villa.showInfor();
			count++;
			System.out.println("========================================");
		}
	}
	public void showAllHouse(){


		ArrayList<House> houses = new ArrayList<>();
		try {
			BufferedReader br =
				new BufferedReader(new FileReader("D:/Aphucdeptrai/furumaresort/Data/House.csv"));
			String line;
			while ((line= br.readLine())  != null) {
				String[] fields = line.split(",");
				House house = new House(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
					Integer.parseInt(fields[4]),
					Float.parseFloat(fields[5]), fields[6], fields[7], Integer.parseInt(fields[8]));


				houses.add(house);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = 1;
		for (House house : houses) {

			System.out.println("House number "+count);
			System.out.println("===========================================");
			house.showInfor();
			count++;
			System.out.println("===========================================");

		}

	}
	public void showAllRoom(){
		ArrayList<Room> rooms = new ArrayList<>();
		try {
			BufferedReader br =
				new BufferedReader(new FileReader("D:/Aphucdeptrai/furumaresort/Data/Room.csv"));
			String line;
			while ((line= br.readLine())  != null) {
				String[] fields = line.split(",");
				Room room = new Room(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3],
					Integer.parseInt(fields[4]), Float.parseFloat(fields[5]), fields[6]);
				rooms.add(room);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = 1;
		for (Room room : rooms) {

			System.out.println("Room number "+count);
			System.out.println("===========================================");
			room.showInfor();
			count++;
			System.out.println("===========================================");

		}
	}
}


