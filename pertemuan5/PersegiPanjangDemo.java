public class PersegiPanjangDemo {
	// Main method
	public static void main(String[] args) {
		System.out.println("Sebelum membuat objek\nJumlah objek = " + PersegiPanjang.jumlahObjek);
		// objek
		PersegiPanjang persegiPanjang1 = new PersegiPanjang();
		// memanggi konstruktor pertama
		PersegiPanjang persegiPanjang2 = new PersegiPanjang(8, 5);
		// memanggi konstruktor kedua yang memiliki parameter inputan

		System.out.println("Luas Persegi panjang 1 = " + persegiPanjang1.panjang + " x " + persegiPanjang1.lebar + " = "
				+ persegiPanjang1.getLuas() + "\n");
		System.out.println("Luas Persegi panjang 2 = " + persegiPanjang2.panjang + " x " + persegiPanjang2.lebar + " = "
				+ persegiPanjang2.getLuas() + "\n");
		System.out.print("\nSetelah membuat objek\njumlah objek = " + PersegiPanjang.getJumlajObjek()); // method
	}
}
