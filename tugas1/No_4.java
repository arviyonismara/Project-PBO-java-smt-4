import java.util.Scanner;

public class No_4{
	public static void main(String[] args){
		System.out.println("=====Triangle Loop=====");
		
		int tinggi;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("tinggi segitiga: ");
        	tinggi = keyboard.nextInt();
		
		for(int i=1; i<=tinggi; i++){
			for(int j=1; j<=i; j++){
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}