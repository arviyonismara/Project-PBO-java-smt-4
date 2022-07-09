class Mamalia extends Animal {
	public Mamalia() {
		super();// memanggil konstruktornya parent(animal), ada atau tidak ada,
		// otomatis
		// memanggil konstruktor parent
		System.out.println("Mamalia is Created");
	}

	Mamalia(String desc) {
		System.out.println(desc + "Mamalia is created");
	}

	// Mamalia merupakan method dengan nama sama namun inputan berbeda atau disebut
	// overloading
	String eat() {
		String e;
		e = "Mamalia eat ... ";
		return e;
	}
}
