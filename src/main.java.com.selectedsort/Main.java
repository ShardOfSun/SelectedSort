package main.java.com.selectedsort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final String FILE_PATH = "SelectedSort/src/resources/input.txt";

    public static void main(String[] args) {
        List<String[]> fileData = readFile(FILE_PATH);

        for (String[] parts : fileData) {
            int n = parts.length - 2;
            Integer[] data = new Integer[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(parts[i]);
            }
            int from = Integer.parseInt(parts[n]);
            int to = Integer.parseInt(parts[n + 1]);

            printResults(parts, data, from, to);
        }
    }

    public static List<String[]> readFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void printResults(String[] parts, Integer[] data, int from, int to) {
        System.out.println("Original array: " + Arrays.toString(data));
        System.out.println("Range: from " + from + " to " + to);

        SelectedSort.sort(data, from, to);

        System.out.println("Sorted array: " + Arrays.toString(data));
        System.out.println();
    }
}
