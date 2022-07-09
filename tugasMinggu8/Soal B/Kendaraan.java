public class Kendaraan {
	private String nama;
	private int tahunProduksi;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getTahunProduksi() {
		return tahunProduksi;
	}

	public void setTahunProduksi(int tahunProduksi) {
		this.tahunProduksi = tahunProduksi;
	}

	public Kendaraan() {

	}

	public Kendaraan(String nama, int tahunProduksi) {
		setNama(nama);
		setTahunProduksi(tahunProduksi);
	}

	public void cetak() {
		System.out.println("Nama " + getNama());
		System.out.println("Tahun Produksi " + getTahunProduksi());
	}
}