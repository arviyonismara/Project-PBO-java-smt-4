public class Mahasiswa {
	public String nim;
	public String nama;
	public String alamat;
	public double ipk;

	// konstruktor
	public Mahasiswa() {

	}

	public Mahasiswa(String nim) {
		this.nim = nim;
	}

	public Mahasiswa(String nimBaru, String namaBaru, String alamatBaru, double ipkBaru) {
		nim = nimBaru;
		nama = namaBaru;
		alamat = alamatBaru;
		ipk = ipkBaru;
	}

	// method
	String predikat(double ipk) {
		if (ipk >= 2.0 && ipk <= 2.75) {
			return ("Memuaskan");
		} else if (ipk >= 2.76 && ipk <= 3.5) {
			return ("Sangat Memuaskan");
		} else if (ipk >= 3.51 && ipk <= 4.0) {
			return ("Dengan pujian");
		} else {
			return ("-");
		}
	}

	void cetak() {
		System.out.println("Nama     = " + nama);
		System.out.println("alamat   = " + alamat);
		System.out.println("NIM      = " + nim);
		System.out.println("IPK      = " + ipk);
		System.out.println("Predikat = " + predikat(ipk));
	}

}
