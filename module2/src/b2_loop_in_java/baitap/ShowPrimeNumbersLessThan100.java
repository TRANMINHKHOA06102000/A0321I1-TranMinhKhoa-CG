package b2_loop_in_java.baitap;

public class ShowPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        for (int numbers = 1; numbers < 100; ++numbers)
        {
            int count = 0;
            for (int i = 2; i <= Math.sqrt(numbers); i++)
            {
                if (numbers % i == 0)
                {
                    count++;
                }
            }
            if (count == 0 && numbers > 1)
                System.out.print("\t" +  numbers);
        }
    }
}
