public class No_3{
	public static void main(String[] args){
		System.out.println("=====Menghitung Volume Tabung=====");
		
		double phi = 3.14;double R = 14.0;double tinggi = 10.0;
		double volume = phi*R*R*tinggi;
		
		System.out.println("phi       = "+phi);
		System.out.println("R         = "+R);
		System.out.println("tinggi    = "+tinggi);
		System.out.println("Volume    = "+volume);

		if(volume>=1000)
			System.out.println("Besar");
		else
			System.out.println("Kecil");
	}
}