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
            double result = 0;
            try (BufferedReader inputStream = new BufferedReader(new FileReader(arg))) {
                String c;
                int loop = 0;
                int brk = 0;
                while ((c = inputStream.readLine()) != null) {
                    ++loop;
                    try {
                        if (c.equals("")) {
                            throw new Exception("Empty line,not found number");
                        }
                        try {
                            double d = Double.parseDouble(c);
                            result += d;
                        } catch (Exception e) {
                            throw new Exception("Incorrect number " + c);
                        }
                    } catch (Exception e) {
                        System.out.print(arg + " - Error on line " + loop + "." + e.getMessage());
                        brk++;
                        break;
                    }
                }
                if (brk == 0) {
                    System.out.print(arg + " - " + dF.format((result / loop)));
                }
            } catch (Exception e) {
                System.out.print(arg + " - " + "Incorrect input path");
            }
            if (!Objects.equals(arg, args[args.length - 1])) {
                System.out.println();
            }

        }

    }
}
