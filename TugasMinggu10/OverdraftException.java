public class OverdraftException extends Exception {
	// eksepsi sendiri
	private double deficit;

	public OverdraftException(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}
}
