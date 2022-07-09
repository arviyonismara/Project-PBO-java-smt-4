public class Mobil extends Darat {
	private int muatan;

	public int getMuatan() {
		return muatan;
	}

	public void setMuatan(int muatan) {
		this.muatan = muatan;
	}

	public Mobil() {

	}

	public Mobil(String nama, int tahunProduksi, int roda, int muatan) {
		super(nama, tahunProduksi, roda);
		setMuatan(muatan);
	}

	public void reset(String nama, int tahunProduksi, int roda, int muatan) {
		setNama(nama);
		setTahunProduksi(tahunProduksi);
		setRoda(roda);
		setMuatan(muatan);
	}

	public String kategori(int muatan) {
		if (muatan <= 6) {
			return "Mini";
		}
		if (muatan <= 15) {
			return "Sedang";
		} else {
			return "Besar";
		}
	}

	public void cetak() {
		super.cetak();
		System.out.println("Muatan " + getMuatan());
		System.out.println("Kategori " + kategori(muatan));
	}
}
