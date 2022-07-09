public class Piramida {
	int tinggi;

	// konstruktor
	Piramida() {

	}

	Piramida(int newTinggi) {
		tinggi = newTinggi;
	}

	// method
	void getPiramida(int newTinggi) {
		tinggi = newTinggi;
		for (int i = 1; i <= tinggi; i++) {
			for (int j = i; j <= tinggi; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= (i * 2) - 2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
