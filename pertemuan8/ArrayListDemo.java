import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String args[]) {
		ArrayList al = new ArrayList();
		System.out.println("Ukuran awal al: " + al.size());
		al.add(3.14);
		al.add('D');
		al.add(4);
		al.add(1, "A2");
		System.out.println("Ukuran al setelah penambahan: " + al.size());
		System.out.println("Isi dari al: " + al);
		al.remove("D");
		al.remove(2);
		System.out.println("Ukuran al setelah pengurangan: " + al.size());
		System.out.println("Isi dari al: " + al);
	}
}