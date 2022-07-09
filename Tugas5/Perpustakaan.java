import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class Perpustakaan {
	public static void main(String[] args) {
		Set<String> kartun = new TreeSet<String>();

		System.out.println("Daftar Buku:");
		// Masukkan value
		kartun.add("Dilan 1990");
		kartun.add("Laskar Pelangi");
		kartun.add("Mahaguru");
		kartun.add("Mengejar Matahari");
		kartun.add("Dilan 1991");
		kartun.add("Milea");
		kartun.add("Perahu Kertas");
		kartun.add("Laskar Pelangi");
		kartun.add("Perahu Kertas");

		// Tampilkan value menggunakan Iterator
		for (Iterator<String> iterator = kartun.iterator(); iterator.hasNext();) {
			for (int i = 1; i <= kartun.size(); i++) {
				String string = (String) iterator.next();
				System.out.println(i + ". " + string);
			}
		}

		// cek buku
		String buku;
		Scanner sc = new Scanner(System.in);
		System.out.print("judul buku: ");
		buku = sc.nextLine();

		if (kartun.contains("Mahaguru")) {
			System.out.println("Buku Mahaguru ada");
			// remove Mahaguru
			kartun.remove("Mahaguru");
		}

		// cetak
		for (Iterator<String> iterator = kartun.iterator(); iterator.hasNext();) {
			for (int i = 1; i <= kartun.size(); i++) {
				String string = (String) iterator.next();
				System.out.println(i + ". " + string);
			}
		}

	}
}