

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BStarTree bStarTree = new BStarTree();
        int[] array = generateRandomArray(10000);

        ArrayList<OperationResult> insertResults = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            long startTime = System.nanoTime();
            bStarTree.insert(key);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            int operationCount = bStarTree.getOperationCount();
            insertResults.add(new OperationResult(key, duration, operationCount));
        }
        ArrayList<OperationResult> searchResults = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(array.length);
            int key = array[index];
            long startTime = System.nanoTime();
            boolean found = bStarTree.search(key);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            int operationCount = bStarTree.getOperationCount();
            searchResults.add(new OperationResult(key, duration, operationCount, found));
        }
        ArrayList<OperationResult> deleteResults = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int index = random.nextInt(array.length);
            int key = array[index];
            long startTime = System.nanoTime();
            bStarTree.delete(key);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            int operationCount = bStarTree.getOperationCount();
            deleteResults.add(new OperationResult(key, duration, operationCount));
        }
        double averageInsertTime = calculateAverageTime(insertResults);
        double averageDeleteTime = calculateAverageTime(deleteResults);
        double averageSearchTime = calculateAverageTime(searchResults);

        double averageInsertOperations = calculateAverageOperations(insertResults);
        double averageDeleteOperations = calculateAverageOperations(deleteResults);
        double averageSearchOperations = calculateAverageOperations(searchResults);

        System.out.println("Среднее время вставки: " + averageInsertTime + " nanoseconds");
        System.out.println("Среднее время удаления: " + averageDeleteTime + " nanoseconds");
        System.out.println("Среднее время поиска: " + averageSearchTime + " nanoseconds");
        System.out.println("Среднее количество операций вставки:  " + averageInsertOperations);
        System.out.println("Среднее количество операций удаления: " + averageDeleteOperations);
        System.out.println("Среднее количество поисковых операций: " + averageSearchOperations);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static double calculateAverageTime(ArrayList<OperationResult> results) {
        long totalDuration = 0;
        for (OperationResult result : results) {
            totalDuration += result.getDuration();
        }
        return (double) totalDuration / results.size();
    }

    private static double calculateAverageOperations(ArrayList<OperationResult> results) {
        int totalOperations = 0;
        for (OperationResult result : results) {
            totalOperations += result.getOperationCount();
        }
        return (double) totalOperations / results.size();
    }
}
