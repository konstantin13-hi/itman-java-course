package tasks;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        printFilesName();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] parts = result.split("\n");
        System.out.println(Arrays.toString(parts));
        List<Integer> list = new ArrayList<>();
        list.add(1);


    }

    private static void printFilesName() {
        System.out.println("output.txt");
        System.out.println("outputSecond.txt");
        System.out.println("outputThird.txt");
    }
}