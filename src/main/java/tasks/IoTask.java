package tasks;

import collections.ArrayList;
import collections.IntArrayList;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.stream.Stream;


public class IoTask {


    private static class EmptyFile extends Exception {
        public EmptyFile() {
        }

        public EmptyFile(String message) {
            super(message);
        }
    }


    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("#.00");

        for (String arg : args) {
            int loop = 0;
            String c = null;
            try (BufferedReader inputStream = new BufferedReader(new FileReader(arg));) {
                if (new File(arg).length() == 0) {
                    throw new EmptyFile("Empty file");
                }
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
            } catch (EmptyFile e) {
                System.out.print(arg + " - " + e.getMessage());
            } catch (IOException e) {
                System.out.println(arg + " - " + e.getMessage());
            }
            if (!Objects.equals(arg, args[args.length - 1])) {
                System.out.println();
            }

        }

    }
}
