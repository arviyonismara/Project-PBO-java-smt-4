public class lingkaranDemo {
	public static void main(String[] args) {
		lingkaran lingkaran1 = new lingkaran();// tanpa inisialisasi jari2
		lingkaran lingkaran2 = new lingkaran();// inisialisasi jari2 dari property
		lingkaran lingkaran3 = new lingkaran(25);// inisialisasi jari2 dari konstruktor

		System.out.println("== lingkaran tanpa inisialisasi jari2 ==");
		System.out.println("Luas lingkaran 1 = " + lingkaran1.getLuas());
		System.out.println("keliling lingkaran 1 = " + lingkaran1.getKeliling() + "\n");
		System.out.println("== lingkaran dengan inisialisasi jari2 dari property ==");
		System.out.println("Luas lingkaran 2 = " + lingkaran2.getLuas());
		System.out.println("keliling lingkaran 2 = " + lingkaran2.getKeliling() + "\n");
		System.out.println("== lingkaran dengan inisialisasi jari2 dari konstruktor ==");
		System.out.println("Luas lingkaran 3 = " + lingkaran3.getLuas());
		System.out.println("keliling lingkaran 3 = " + lingkaran3.getKeliling() + "\n");
		System.out.println("== jumlah Lingkaran ==");
		System.out.println("jumlah Lingkaran = " + lingkaran.getJumlahLingkaran());
	}
}
