//package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-11
 */

// ReverseTheString class
public final class ReverseTheString {

    /** Private constructor to prevent instantiation. */
    private ReverseTheString() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        // declare opening list
        final ArrayList<String> stringList = new ArrayList<String>();

        try {
            // preps file access and writing/reading
            final File fileInput = new File("input.txt");
            final File fileOutput = new File("output.txt");
            final Scanner sc = new Scanner(fileInput);
            final FileWriter fW = new FileWriter(fileOutput);
            final PrintWriter write = new PrintWriter(fW);

            // reads each line of file
            while (sc.hasNextLine()) {
                // adds the next file
                stringList.add(sc.nextLine());
            }

            // reverse each string in the list than writes to output
            for (String inputString : stringList) {
                String revString = RecReverse(inputString);
                write.println(revString);
            }

            // program finished
            System.out.println("Done");

            // closes resources
            write.close();
            sc.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
     * Reverses the strings
     *
     * @param stringList
     * @return reversed string list
     */
    public static String RecReverse(String stringList) {
        // if no characters are left end function 
        if (stringList.length() == 0) {
            return stringList;
        }
        // if there is a string left, reverse the strings
        else {
            return RecReverse(stringList.substring(1)) + stringList.charAt(0);
        }
    }
}
