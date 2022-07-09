import javax.xml.transform.SourceLocator;

class Dog extends Mamalia {
	String color = "black";

	Dog() {
		super("Land");
		// jika ridak memunculkan super, maka memanggil konstruktor parent yang tidak
		// ada inputan
		System.out.println("Dog is created");
	}

	void printColor() {
		System.out.println("My parent color is " + super.color);
		// memanggil variabel color dari parent
		System.out.println("And now my color is " + color);
	}

	String eat() {
		return super.eat() + "Dog eat bone";
		// String berisi "Mamalia eat..." Dog eat bone
		// super.eat() memanggil method eat milik parent
		// return "Dog eat bone"
		// String berisi "Dog eat bone"
	}
	// jika di testSuper ibuk memanggil
	// System.out.println(d.eat());
	// maka yang keluar ? Mamalia eat ... Dog eat bone
}
