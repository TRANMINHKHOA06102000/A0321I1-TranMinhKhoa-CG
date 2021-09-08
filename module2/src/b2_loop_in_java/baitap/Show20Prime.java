package b2_loop_in_java.baitap;

public class Show20Prime {
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();*/
        int number=20;
        int count = 0;
        int n = 2;
        System.out.println("20 số nguyên tố đầu tiên:");
        while (count < number) {
            if (isPrimeNumber(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
}
