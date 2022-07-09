public class MahasiswaDemo {
	public static void main(String[] args) {
		Mahasiswa mhs = new Mahasiswa();
		mhs.nama = "Arvie Arvearie Y";
		mhs.nim = "A11.2020.12792";
		mhs.alamat = "Pedurungan Kidul";
		mhs.ipk = 3.8;
		mhs.predikat(mhs.ipk);
		mhs.cetak();
	}
}
