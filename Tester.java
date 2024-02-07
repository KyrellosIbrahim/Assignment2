import java.util.Random;
public class Tester {
    SortingAlgorithm sa;
    public Tester(SortingAlgorithm sa) {
        this.sa = sa;
    }

    public double singleTest(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        long startTime = System.nanoTime();
        sa.sorty(arr);
        long endTime = System.nanoTime();
        return ((endTime - startTime)/1000000);
    }

    public double kSortedSingleTest(int size) {
        int[] arr = generateKSorted(size);
        long startTime = System.nanoTime();
        sa.sorty(arr);
        long endTime = System.nanoTime();
        return ((endTime - startTime)/1000000);
    }

    public String test(int iterations, int size) {
        double total = 0;
        for(int i = 0; i < iterations; i++) {
            total += singleTest(size);
        }
        double average = total/iterations;

        return ("Sorted " + size + " elements in " + average + "ms (avg)");
    }

    public String kSortedTest(int iterations, int size) {
        double total = 0;
        for(int i = 0; i < iterations; i++) {
            total += kSortedSingleTest(size);
        }
        double average = total/iterations;

        return ("Sorted " + size + " elements in " + average + "ms (avg)");
    }

    public static int[] generateKSorted(int size) {
        int k = 10;
        int[] arr = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(i-k, i+k+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateKSorted(50);
        for(int i : arr) {
            System.out.println(i);
        }
    }

}
