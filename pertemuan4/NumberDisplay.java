public class NumberDisplay {
	// atribut, properti, atau variabel
	private int limit;
	private int value;

	// method
	public NumberDisplay(int rollOverLimit) {
		limit = rollOverLimit;
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int replacementValue) {
		if (replacementValue >= 0 && replacementValue < limit) {
			value = replacementValue;
		}
	}

	public String getDisplayValue() {
		if (value < 10) {
			return "0" + value;
		} else {
			return "" + value;
		}
	}

	public void increment() {
		value = (value + 1) % limit;
		// value, kasus jam 12, lalu incremment
		// limit = 12
		// value = (12+1)%12
		// value = 1
	}
}