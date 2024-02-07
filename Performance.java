import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Performance {

    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {new QuickSort(), new MergeSort(), new ShellSort(),
                                                new InsertionSort(), new SelectionSort(), new BubbleSort()};
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        try {
            File file = new File("KSortedResults.txt");
            file.createNewFile();
            System.out.println("file created");
        }
        catch (IOException e) {
            System.out.println("error creating file");
        }

        try (FileWriter writer = new FileWriter("KSortedResults.txt", false)) {
            for(SortingAlgorithm sa : algorithms) {
                writer.write("Algorithm: " + sa.getName());
                Tester t = new Tester(sa);
                for(int s : sizes) {
                    //writer.write("\n" + t.test(20, s));
                    writer.write("\n" + t.kSortedTest(20, s));
                }
                writer.write("\n\n");
                System.out.println(sa.getName() + " done");
            }
        }
        catch(IOException e) {
            System.out.println("error writing to file");
        }
    }
}
