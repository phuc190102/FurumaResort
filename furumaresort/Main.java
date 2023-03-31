package furumaresort;

import furumaresort.Models.House;
import furumaresort.Models.Room;
import furumaresort.Models.Villa;
import furumaresort.Controllers.MainController;
public class Main {

	public static void main(String[] args) {

		Villa villa = new Villa();
		House house = new House();
		Room room = new Room();
		villa.setId("1");
		villa.showInfor();
		house.setId("2");
		house.showInfor();
		room.setId("3");
		room.setHireFee(2000);
		room.showInfor();

	}
}
