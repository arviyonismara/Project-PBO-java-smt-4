public class ClockDemo {
	public static void main(String[] args) {
		ClockDisplay cd = new ClockDisplay();

		System.out.println(cd.displayString);

		cd.setTime(11, 56);
		System.out.println("After setTime = " + cd.displayString);
		cd.timeTick();
		System.out.println("After timeTick = " + cd.displayString);
		System.out.println("");

		ClockDisplay cd1 = new ClockDisplay(12, 60);

		cd1 = ClockDisplay(12, 60);

		cd1.setTime(11, 59);
		System.out.println("After setTime = " + cd1.displayString);
		cd1.timeTick();
		System.out.println("After timeTick #1 = " + cd1.displayString);
		cd1.timeTick();
		System.out.println("After timeTick #2 = " + cd1.displayString);
		System.out.println("");
	}
}
