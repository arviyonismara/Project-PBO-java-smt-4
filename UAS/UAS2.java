public class UAS2 {
	public static void main(String[] args)
    { 
        try{
            int a[]=new int[5];
            for (int i=0;i<5;i++){
                a[i]=i;
                System.out.println(a[i]);
            }
            a[4]=4718/1;
            System.out.println(a[4]);
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOf Bounds Exception occurs");
        }catch(Exception e){
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}
