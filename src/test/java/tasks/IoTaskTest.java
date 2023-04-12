package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

class IoTaskTest {
    @Nested
    public class IoTaskMain {
        @Test
        public void shouldReturnResultWhenFileContainsIntegers() throws IOException {
            try {

                String[] strings = new String[1];
                String path = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "test.txt").getAbsolutePath();
                strings[0] = path;
                Assertions.assertEquals(returnsStrings(strings),
                        path + " - 149.33");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }


        @Test
        public void shouldReturnResultWhenFileContainsDoubles() throws IOException {
            try {

                String[] strings = new String[1];
                String path = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testSecond.txt").getAbsolutePath();
                strings[0] = path;
                Assertions.assertEquals(returnsStrings(strings), strings[0] + " - 27.77");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }


        @Test
        public void shouldReturnErrorWhenFileContainsString() throws IOException {
            try {


                String[] strings = new String[1];
                String path = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testFour.txt").getAbsolutePath();
                strings[0] = path;
                Assertions.assertEquals(returnsStrings(strings), strings[0] +
                        " - Error on line 1.Incorrect number ref");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }

        @Test
        public void shouldReturnErrorWhenFileContainsSpace() throws IOException {
            try {
                String[] strings = new String[1];
                String path = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testThird.txt").getAbsolutePath();
                strings[0] = path;
                Assertions.assertEquals(returnsStrings(strings), strings[0] +
                        " - Error on line 2.Empty line,not found number");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        @Test
        public void shouldReturnErrorWhenFileDoesntExist() throws IOException {
            try {

                String[] strings = new String[1];
                strings[0] = "testNotExists.txt";
                Assertions.assertEquals(returnsStrings(strings), strings[0] +
                        " - Incorrect input path");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


        @Test
        public void shouldReturnResultsWhenSeveralFiles() throws IOException {
            try {


                String[] strings = new String[5];
                String path = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "test.txt").getAbsolutePath();
                strings[0] = path;
                String pathSecond = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testSecond.txt").getAbsolutePath();
                strings[1] = pathSecond;
                String pathThird = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testThird.txt").getAbsolutePath();
                strings[2] = pathThird;
                String pathFourth = new File("src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "testFour.txt").getAbsolutePath();
                strings[3] = pathFourth;
                strings[4] = "testNotExists.txt";
                Assertions.assertEquals(returnsStrings(strings),
                        strings[0] + " - 149.33" + "\n" +
                                strings[1] + " - 27.77" + "\n" +
                                strings[2] + " - Error on line 2.Empty line,not found number" + "\n" +
                                strings[3] + " - Error on line 1.Incorrect number ref" + "\n" +
                                strings[4] + " - Incorrect input path");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private String returnsStrings(String[] strings) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        IoTask.main(strings);
        String result = outputStream.toString();
        System.setOut(consoleStream);
        System.out.println(result);
        return result;
    }


}