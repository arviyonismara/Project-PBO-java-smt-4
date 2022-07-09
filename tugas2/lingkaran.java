public class lingkaran {
	double jari_jari = 15;
	double phi = 3.14;
	public static int jumlahLingkaran = 0;

	// konstruktor
	lingkaran() {
		jumlahLingkaran++;
	}

	lingkaran(double jari_jari_baru) {
		jari_jari = jari_jari_baru;
		jumlahLingkaran++;
	}

	// method
	double getLuas() {
		return phi * jari_jari * jari_jari;
	}

	double getKeliling() {
		return 2 * phi * jari_jari;
	}

	static int getJumlahLingkaran() {
		return jumlahLingkaran;
	}

}