package furumaresort.Models;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import furumaresort.Models.Services;
public class Customer {
	public String customerName;
	public String birthday;
	public String gender;
	public int identityNumber;
	public int phoneNumber;
	public String email;
	public String customerType;
	public String address;

	private Services serviceUsed;

	public Customer() {
	}

	public Customer(String customerName, String birthday, String gender, int identityNumber,
					int phoneNumber, String email, String customerType,
					String address) {
		this.customerName = customerName;
		this.birthday = birthday;
		this.gender = gender;
		this.identityNumber = identityNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.customerType = customerType;
		this.address = address;

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(int identityNumber) {
		this.identityNumber = identityNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Services getUseService() {
		return serviceUsed;
	}

	public void setUseService(Services useService) {
		this.serviceUsed = useService;
	}

	public class NameException extends Exception {
		public NameException(String message) {
			super(message);
		}
	}

	public class EmailException extends Exception {
		public EmailException(String message) {
			super(message);
		}
	}

	public class GenderException extends Exception {
		public GenderException(String message) {
			super(message);
		}
	}

	public class IdCardException extends Exception {
		public IdCardException(String message) {
			super(message);
		}
	}

	public class BirthdayException extends Exception {
		public BirthdayException(String message) {
			super(message);
		}
	}
	public void showInfor() {
		System.out.println("Full Name: " + customerName);
		System.out.println("Date of Birth: " + birthday);
		System.out.println("Gender: " + gender);
		System.out.println("ID Card Number: " + identityNumber);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Email: " + email);
		System.out.println("Customer Type: " + customerType);
		System.out.println("Address: " + address);

	}
//	public void payFee() {
//		// ...
//		System.out.println("1. Spa");
//		System.out.println("2. Karaoke");
//		System.out.println("3. Massage");
//		System.out.print("Chọn dịch vụ đã sử dụng (1-3): ");
//		int serviceChoice = scanner.nextInt();
//
//		switch (serviceChoice) {
//			case 1:
//				serviceUsed = new Services("Spa", 100000);
//				break;
//			case 2:
//				serviceUsed = new Services("Karaoke", 50000);
//				break;
//			case 3:
//				serviceUsed = new Services("Massage", 80000);
//				break;
//			default:
//				System.out.println("Lựa chọn không hợp lệ!");
//		}
//
//	}
	public void inputData() {
		Scanner scanner = new Scanner(System.in);
		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				System.out.print("Nhập tên khách hàng: ");
				String name = scanner.nextLine();
				if (!name.matches("^[A-Za-zÀ-ỹ][a-zà-ỹ]*([\s][A-Za-zÀ-ỹ][a-zà-ỹ]*)*$")) {
					throw new NameException("Tên khách hàng phải in hoa kí tự đầu tiên của mỗi từ");
				}
				this.customerName = name;

				System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
				String birthday = scanner.nextLine();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date birthDate = dateFormat.parse(birthday);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(birthDate);
				int birthYear = calendar.get(Calendar.YEAR);
				int currentYear = Calendar.getInstance().get(Calendar.YEAR);
				if (currentYear - birthYear < 18 || birthYear < 1900) {
					throw new BirthdayException("Năm sinh phải >1900 và nhỏ hơn năm hiện tại" +
						"18 năm, đúng định dạng,dd,mm,yyyy");
				}
				this.birthday = birthday;

				System.out.print("Nhập giới tính (Male/Female/Unknown): ");
				String gender = scanner.nextLine();
				gender = gender.toLowerCase().trim();
				if (!gender.equals("male") && !gender.equals("female") && !gender.equals("unknown")) {
					throw new GenderException("giới tính phải là Male/Female/Unknown");
				}
				if (gender.equals("male")) {
					gender = "Male";
				} else if (gender.equals("female")) {
					gender = "Female";
				} else {
					gender = "Unknown";
				}
				this.gender = gender;

				System.out.print("Nhập số chứng minh thư (XXX XXX XXX): ");
				String idNumber = scanner.nextLine();
				if (!idNumber.matches("\\d{3} \\d{3} \\d{3}")) {
					throw new IdCardException("Số chứng minh thư phải có 9 số và đúng định dạng" +
						"XXX XXX XXX");
				}
				try {
					NumberFormat format = NumberFormat.getInstance();
					this.identityNumber = format.parse(idNumber).intValue();
				} catch (ParseException e) {
					throw new IdCardException("Số chứng minh thư không hợp lệ");
				}

				System.out.print("Nhập số điện thoại: ");
				this.phoneNumber = scanner.nextInt();
				scanner.nextLine();


				System.out.print("Nhập email: ");
				String email = scanner.nextLine();
				if (!email.matches("\\w+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?")) {
					throw new EmailException("Email phải đúng định dạng abc@abc.abc");
				}
				this.email = email;

				System.out.print("Nhập loại khách hàng (Diamond/Platinum/Gold/Silver/Member): ");
				String customerType = scanner.nextLine();
				this.customerType = customerType;

				System.out.print("Nhập địa chỉ: ");
				String address = scanner.nextLine();
				this.address = address;

				isValidInput = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}



	public String toCsvString() {
		return String.format("%s,%s,%s,%d,%d,%s,%s,%s",
			this.customerName, this.birthday, this.gender, this.identityNumber,
			this.phoneNumber, this.email, this.customerType, this.address);
	}


}
