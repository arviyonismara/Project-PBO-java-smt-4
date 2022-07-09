import javax.swing.text.AbstractDocument.LeafElement;

public class PersegiPanjang {
	// properti atau atribut atau variabel
	public int panjang;
	public int lebar;
	public static int jumlahObjek = 0; // variable static

	// method
	PersegiPanjang() {
		jumlahObjek++;
	}

	PersegiPanjang(int panjangBaru, int lebarBaru) {
		panjang = panjangBaru;
		lebar = lebarBaru;
		jumlahObjek++;
	}
	// persegi panjang ini disebut konstruktor, overloading method dimana nama
	// method sama namun berbeda parameter inputannya

	int getLuas() {
		return panjang * lebar;
	}

	int getKeliling() {
		return 2 * (panjang * lebar);
	}

	// method static
	public static int getJumlajObjek() {
		return jumlahObjek;
	}
}