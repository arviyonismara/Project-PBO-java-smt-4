public class Bicycle {
	int speed = 0;
	int gear = 0;

	void ChangeGear(int newValue) {
		gear = gear + newValue;
		System.out.println("Gear = " + gear);
	}

	void speedUp(int increment) {
		speed = speed + increment;
		System.out.println("Speed  = " + speed);
	}

	public static void main(String[] args) {

	}
}
