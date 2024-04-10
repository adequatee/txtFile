package txt.file;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader inputBR = null;
        BufferedReader tempBR = null;

        try {

            File inputFile = new File("inputFile.txt");
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            PrintWriter inputPW = new PrintWriter(inputFile);
            inputPW.println("Java is a programming language and computing platform first released by Sun Microsystems in 1995.\n" +
                    "It has evolved from humble beginnings to power a large share of today’s digital world,\n" +
                    "by providing the reliable platform upon which many services and applications are built.\n" +
                    "New, innovative products and digital services designed for the future continue to rely on Java, as well.");
            inputPW.close();


            File tempFile = new File("toUpperCaseFile.txt");
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            PrintWriter tempPW = new PrintWriter(tempFile);


            String line;

            inputBR = new BufferedReader(new FileReader("toUpperCase.txt"));
            System.out.println("\nbefore working with txt file:");
            while ((line = inputBR.readLine()) != null) {
                System.out.println(line);
                tempPW.println(line.toUpperCase());
            }
            tempPW.close();


            tempBR = new BufferedReader(new FileReader("tempFile.txt"));
            System.out.println("\nafter working with txt file:");
            while ((line = tempBR.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            System.out.println("The file cannot be created! Error: " + e);
        } finally {
            try {
                if (inputBR != null) inputBR.close();
                if (tempBR != null) tempBR.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}