public class Murid extends Orang {
	public int noInduk;

	public Murid() {

	}

	public Murid(String nama, String alamat, int noInduk) {
		super(nama, alamat);
		setNoInduk(noInduk);

	}

	public int getNoInduk() {
		return noInduk;
	}

	public void setNoInduk(int noInduk) {
		this.noInduk = noInduk;
	}

	public void cetak() {
		super.cetak();
		System.out.println("nomor Induk " + noInduk);
	}
}
