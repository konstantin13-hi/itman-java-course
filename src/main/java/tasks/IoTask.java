package tasks;

import collections.ArrayList;
import collections.IntArrayList;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.stream.Stream;

public class IoTask {
    public static void main(String[] args) throws IOException {
        DecimalFormat dF = new DecimalFormat("#.00");
        for (String arg : args) {
            int loop = 0;
            String c = null;
            try (BufferedReader inputStream = new BufferedReader(new FileReader(arg))) {

                double max = Integer.MIN_VALUE;
                double min = Integer.MAX_VALUE;
                while ((c = inputStream.readLine()) != null) {
                    loop++;
                    double d = Double.parseDouble(c);
                    if (max < d) {
                        max = d;
                    }
                    if (min > d) {
                        min = d;
                    }
                }
                System.out.print(arg + " - " + dF.format(((min + max) / 2)));
            } catch (FileNotFoundException e) {
                System.out.print(arg + " - " + "Incorrect input path");
            } catch (NumberFormatException e) {
                String result = ".Incorrect number " + c;
                if (Objects.equals(c, "")) {
                    result = ".Empty line,not found number";
                }
                System.out.print(arg + " - Error on line " + loop + result);
            }
            if (!Objects.equals(arg, args[args.length - 1])) {
                System.out.println();
            }

        }

    }
}
