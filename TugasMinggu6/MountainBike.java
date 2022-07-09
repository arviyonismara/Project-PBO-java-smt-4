public class MountainBike extends Bicycle {
	int seatHeight;

	public void setHeight(int newValue) {
		seatHeight = newValue;
		System.out.println("Seat height = " + seatHeight);
	}

	public static void main(String[] args) {
		MountainBike mb = new MountainBike();
		mb.speedUp(10); // method dari superClass
		mb.ChangeGear(2); // method dari SuperClass
		mb.setHeight(20); // method dia sendiri/ subclass
	}
}
