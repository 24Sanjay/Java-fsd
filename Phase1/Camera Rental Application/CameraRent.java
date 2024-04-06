package Phase1Project;

import java.util.ArrayList;
import java.util.List;

public class CameraRent {

	private List<Camera> availableCameras;
	private Wallet userWallet;

	public CameraRent() {

		availableCameras = new ArrayList<>();
		userWallet = new Wallet();
	}

	public void addcamera(Camera Camera) {
		availableCameras.add(Camera);
	}

	public void removeCamera(int CameraIndex) {
		if (CameraIndex >= 1 && CameraIndex <= availableCameras.size()) {
			availableCameras.remove(CameraIndex - 1);
			System.out.println("Camera removed successfully.");
		} else {
			System.out.println("Invalid camera selection.");
		}
	}

	public void displayAvailableCameras() {
		if (availableCameras.isEmpty()) {
			System.out.println("No Data Present at This Moment.");
		} else {
			System.out.println("Available Cameras:");
			System.out.println(" 	");
			System.out.println(" 	");
			for (int i = 0; i < availableCameras.size(); i++) {
				Camera Camera = availableCameras.get(i);

				System.out.println((i + 1) + ".	Brand: " + Camera.getBrand() + "	Model: " + Camera.getModel()
						+ "	Rental Amount: $" + Camera.getRentalAmount() + "	per day " + checkAvailability(Camera));
			}
			System.out.println(" 	");
			System.out.println(" 	");
		}
	}

	private String checkAvailability(Camera Camera) {

		return Camera.isRented() ? "Rented" : "availavle";
	}

	public void rentCamera(int CameraIndex) {
		if (CameraIndex >= 1 && CameraIndex <= availableCameras.size()) {
			Camera selectedCamera = availableCameras.get(CameraIndex - 1);
			if (userWallet.getBalance() >= selectedCamera.getRentalAmount()) {
				userWallet.setBalance(userWallet.getBalance() - selectedCamera.getRentalAmount());
				selectedCamera.setRented(true);
				System.out.println("Camera rented successfully!");
			} else {
				System.out.println("Insufficient Wallet Amount. Please deposit money.");
			}
		} else {
			System.out.println("Invalid camera selection.");
		}

	}

	public void depositMoney(double amount) {
		userWallet.deposit(amount);
		System.out.println("Deposit successful. Current wallet balance: $" + userWallet.getBalance());
	}

	public double checkWalletBalance() {
		return userWallet.getBalance();
	}

}
