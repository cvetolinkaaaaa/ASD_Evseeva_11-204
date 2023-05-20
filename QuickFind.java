import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QuickFind {
    public static void main(String[] args) {
        int n;
        try (Scanner file = new Scanner(new File("test.txt"))){
            n = Integer.parseInt(file.nextLine());
            int[] graph = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = i;
            }
            while (file.hasNextLine()) {
                String[] data = file.nextLine().split(",");
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                if (a >= n || b >= n) {
                    throw new IllegalArgumentException();
                }
                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                System.out.println("(" + a + ", " + b + ")");
                int graphElem = graph[b];
                for (int i = 0; i < n; i++) {
                    if (graph[i] == graphElem) {
                        graph[i] = graph[a];
                    }
                }
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
