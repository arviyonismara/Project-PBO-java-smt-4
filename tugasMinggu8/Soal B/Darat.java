public class Darat extends Kendaraan {
	private int roda;

	public int getRoda() {
		return roda;
	}

	public void setRoda(int roda) {
		this.roda = roda;
	}

	public Darat() {

	}

	public Darat(String nama, int tahunProduksi, int roda) {
		super(nama, tahunProduksi);
		setRoda(roda);
	}

	public void cetak() {
		super.cetak();
		System.out.println("Roda " + getRoda());
	}
}
