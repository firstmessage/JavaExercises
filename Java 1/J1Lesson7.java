/**
 * Java. Level 1. Lesson 7
 *
 * @author Sergey Iryupin
 * @version dated Oct 17, 2017
 */
import java.io.*; 

class J1Lesson7 {

    public static void main(String[] args) {
        testString(120000);
        testStringBuilder(120000);
        //testFileReader("file.name");
        //testBufferedReader("file.name");
    }

    /**
     * Testing class String (immutable)
     */
    static void testString(int cycles) {
        System.out.print("Testing String...");
        long t1 = System.currentTimeMillis();
        long m1 = Runtime.getRuntime().freeMemory();

        String a = "";
        for (int i = 0; i < cycles; i++)
            a += "w";

        long t2 = System.currentTimeMillis();
        long m2 = Runtime.getRuntime().freeMemory();
        System.out.print("It took " + (t2 - t1) + " mc ");
        System.out.println("and " + (m1 - m2)/1024 + " Kb");
    }

    /**
     * Testing class StringBuilder (mutable)
     */
    static void testStringBuilder(int cycles) {
        System.out.print("Testing StringBuilder...");
        long t1 = System.currentTimeMillis();
        long m1 = Runtime.getRuntime().freeMemory();

        StringBuilder a = new StringBuilder("");
            for (int i = 0; i < cycles; i++)
                a.append("w");

        long t2 = System.currentTimeMillis();
        long m2 = Runtime.getRuntime().freeMemory();
        System.out.print("It took " + (t2 - t1) + " mc ");
        System.out.println("and " + (m1 - m2)/1024 + " Kb");
    }

    /**
     * Testing class FileReader
     */
    static void testFileReader(String fileName) {
        System.out.print("Testing FileReader...");
        long t1 = System.currentTimeMillis();

        try {
            int x = -1;
            FileReader file = new FileReader(fileName);
            do
                x = file.read();
            while (x != -1);
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }

    /**
     * Testing class BufferedReader
     */
    static void testBufferedReader(String fileName) {
        System.out.print("Testing BufferedReader...");
        long t1 = System.currentTimeMillis();

        try {
            int x = -1;
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            do
                x = file.read();
            while (x != -1);
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " mc");
    }
}