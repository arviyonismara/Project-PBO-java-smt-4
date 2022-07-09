public class ClockDisplay {
	// variable class
	private NumberDisplay hours;
	private NumberDisplay minutes;
	public String displayString;

	public ClockDisplay() {
		hours = new NumberDisplay(24);
		minutes = new NumberDisplay(60);
		updateDisplay();
	}

	public ClockDisplay(int hour, int minute) {
		hours = new NumberDisplay(hour);
		minutes = new NumberDisplay(minute);
		updateDisplay();
	}

	public void timeTick() {
		minutes.increment();
		if (minutes.getValue() == 0) {
			hours.increment();
		}
		updateDisplay();
		// misal 10.59 --> 11.00
	}

	public void setTime(int hour, int minute) {
		hours.setValue(hour);
		minutes.setValue(minute);
		updateDisplay();
	}

	public void updateDisplay() {
		displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
	}
}
