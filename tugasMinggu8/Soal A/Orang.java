public class Orang {
	private String nama;
	private String alamat;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Orang() {

	}

	public Orang(String nama, String alamat) {
		setNama(nama);
		setAlamat(alamat);
	}

	public void cetak() {
		System.out.println("nama = " + nama);
		System.out.println("alamat = " + alamat);
	}
}