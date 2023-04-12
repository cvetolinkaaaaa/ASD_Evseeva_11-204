import java.io.FileWriter;
import java.io.IOException;

public class TestCombSort{
    public static void main(String[]args){
        generateTestFiles();
    }
    public static void generateTestFiles() {
        Integer[] a;
        int count;
        int start = 100;
        int end = 10001;

        try {
            FileWriter fileWriter = new FileWriter("test1.txt");

            for (int i = start; i < end; i += 100){
                a = new Integer[i];
                for (int j = 0; j < i; j++){
                    a[j] = (int) (Math.random() * i);
                }
                long t = System.nanoTime();
                count = sort(a);

                fileWriter.write(i + " " + count + " " + (System.nanoTime() - t) + "\n");
            }
            fileWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }


    public static <E extends Comparable<? super E>> int sort(E[] input) {
        int gap = input.length;
        int counter = 0;
        boolean swapped = true;
        int i = 0;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            i = 0;
            swapped = false;
            while (i + gap < input.length) {
                if (input[i].compareTo(input[i + gap]) > 0) {
                    E t = input[i];
                    input[i] = input[i + gap];
                    input[i + gap] = t;
                    swapped = true;
                    counter++;
                }
                i++;
            }
        }
        return counter;

    }

}