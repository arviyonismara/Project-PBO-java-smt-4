public class Hello{
	public static void main(String[] args){
		System.out.println("hello world!");

		byte a = 100;
		short b = 10000;
		int c = 100000; int c2 = 123456; int c3;
		c3 = c+c2;
		float f = 234.5f;
		double d = 123.4;
		char letterA = 'A';
		String pbo = "pbo";
		float IPK = 3.8f;

		System.out.println("int c ="+c+"\ndouble d = "+d);
		System.out.println(letterA+"-"+pbo);
		System.out.println(c+"+"+c2+" = "+c3);

		if(IPK>=3.5 && IPK<=4)
			System.out.println("Cumlaude");
		else if(IPK>=3 && IPK<3.5){
			String kategori = "Sugoi";
			System.out.println(kategori);
		}else if(IPK>=0 && IPK<3) 
			System.out.println("belajar lagi ya!");
		else
			System.out.println("salah itu berat!");

		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}