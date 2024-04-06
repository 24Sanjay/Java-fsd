package Phase1Project;

import java.util.Scanner;

public class CameraMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("+----------------------------------------+");
		System.out.println("|         WELCOME TO CAMERA RENTAL APP          |");
		System.out.println("|   Capture your Beautiful Moments |");
		System.out.println("+----------------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		System.out.println("USERNAME ");
		String s1 = scanner.nextLine();
		System.out.println("PASSWORD ");
		String s2 = scanner.nextLine();

		CameraRent rentalApp = new CameraRent();
		rentalApp.addcamera(new Camera("Canon    ", "EOS R5 ", 4000));
		rentalApp.addcamera(new Camera("Sony     ", "A7 III ", 3000));
		rentalApp.addcamera(new Camera("SAMSUNG  ", "DS123 ", 1200));
		rentalApp.addcamera(new Camera("SONY     ", "DSLR	", 7700));
		rentalApp.addcamera(new Camera("Panasonic", "ANOTHER", 1050));
		rentalApp.addcamera(new Camera("SAMSUNG  ", "SM12	", 1400));
		rentalApp.addcamera(new Camera("SONY     ", "CT	", 1500));
		rentalApp.addcamera(new Camera("Panasonic", "HD ", 2500));
		rentalApp.addcamera(new Camera("SAMSUNG  ", "ModelX ", 3000));
		rentalApp.addcamera(new Camera("SONY     ", "HD-012 ", 7000));
		rentalApp.addcamera(new Camera("NIKON    ", "DIGITAL", 1500));
		rentalApp.addcamera(new Camera("LG       ", "ModelX ", 1000));
		while (true) {
			System.out.println("1.MY CAMERA");
			System.out.println("2.RENT A CAMERA");
			System.out.println("3.VIEW ALL CAMERAS");
			System.out.println("4.MY WALLET");
			System.out.println("5.EXIT");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("1.ADD");
				System.out.println("2.REMOVE");
				System.out.println("3.VIEW MY CAMERAS");
				System.out.println("4.GO TO PREVIOUS MENU");
				int st = scanner.nextInt();
				switch (st) {
				case 1:
					System.out.print("Enter the brand of the new camera: ");

					String brand = scanner.next();
					System.out.print("Enter the model of the new camera: ");
					String model = scanner.next();
					System.out.print("Enter the per-day rental amount: ");
					double rentalAmount = scanner.nextDouble();
					rentalApp.addcamera(new Camera(brand, model, rentalAmount));
					System.out.println("New camera added successfully.");
					break;
				case 2:
					rentalApp.displayAvailableCameras();
					System.out.println("Enter the camera ID to remove - ");
					int id = scanner.nextInt();
					rentalApp.removeCamera(id);
					break;
				case 3:
					rentalApp.displayAvailableCameras();
					
				case 4:
					break;

				}
				break;
			case 2:
				System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERAS");
				rentalApp.displayAvailableCameras();
				System.out.print("Enter the Camera ID you want to rent: ");
				int CameraIndex = scanner.nextInt();
				rentalApp.rentCamera(CameraIndex);
				break;

			case 3:
				rentalApp.displayAvailableCameras();
				break;
			case 4:
				double balance = rentalApp.checkWalletBalance();
				System.out.println("Current wallet balance: " + balance);
				System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET ?(1.YES 2.NO)");
				int ans = scanner.nextInt();
				if (ans == 1) {
					System.out.print("Enter the amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					rentalApp.depositMoney(depositAmount);
				}
				break;
			case 5:
				System.out.println("THANK YOU FOR USING");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				break;
			}
		}
	}

}
