package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 * <p>
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

    private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
    private int lineCounter = 1;
    private int currentChar;
    private String tabulation = "\t";


    public FileNumberingFilterWriter(Writer out) {
        super(out);

    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");
        write(str.toCharArray(), off, len);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");
        for (int i = off; i < len + off; i++) {
            this.write(cbuf[i]);
        }
    }

    @Override
    public void write(int c) throws IOException {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");

        // insert line number if we are on the first line
        // or if currentChar is '\r' and not '\n'
        if (lineCounter == 1|| (currentChar == '\r' && c != '\n')  ) {
            out.write(lineCounter++ + tabulation);
        }

        out.write(c);

        if (c == '\n') {
            out.write(lineCounter++ + tabulation);
        }

        // point on the last character
        currentChar = c;
    }

}
