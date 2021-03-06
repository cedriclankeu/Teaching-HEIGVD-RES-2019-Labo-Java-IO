package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

import static com.sun.javafx.util.Utils.split;

/**
 * @author Olivier Liechti
 */
public class Utils {

    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    /**
     * This method looks for the next new line separators (\r, \n, \r\n) to extract
     * the next line in the string passed in arguments.
     *
     * @param lines a string that may contain 0, 1 or more lines
     * @return an array with 2 elements; the first element is the next line with
     * the line separator, the second element is the remaining text. If the argument does not
     * contain any line separator, then the first element is an empty string.
     */
    public static String[] getNextLine(String lines) {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");

        String[] nextLine;
        if (lines.contains("\r\n")) {
            // contain "\r\n" as line separator
            nextLine = lines.split("\r\n", 2);
            nextLine[0] += "\r\n";
        } else if (lines.contains("\r")) {
            // contain "\r" as line separator
            nextLine = lines.split("\r", 2);
            nextLine[0] += "\r";
        } else if (lines.contains("\n")) {
            // contain "\n" as line separator
            nextLine = lines.split("\n", 2);
            nextLine[0] += "\n";

        } else
            // do not contain any line separator,  then the first element is an empty string
            nextLine = new String[]{"", lines};

        return nextLine;

    }

}
