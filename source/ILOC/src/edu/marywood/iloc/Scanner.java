package edu.marywood.iloc;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * <p><b>Scanner</b> will perform our lexical analysis on the incoming source file.</p>
 *
 */
public class Scanner {
    private String filename;
    private FileReader fr;
    private PushbackReader pr;
    // Add some local variables to track line and column positions

    /**
     * <p><b>Scanner</b> constructor will open the source file and initialize the position recorders.</p>
     *
     * @param sourceFilename identifies the file to compile
     * @throws IOException occurs on file exceptions
     */
    public Scanner(String sourceFilename) throws IOException {
        // Build filename location with path.
        filename = "input/" + sourceFilename;

        // Open the file reader
        fr = new FileReader(filename);

        // Create a PushbackReader using the file reader.
        pr = new PushbackReader(fr);
    }

    /**
     * <p><b>nextChar</b> will read the next character from the input file using the PushbackReader,
     * which provides the ability to unread/push the character back into the file.</p>
     *
     * @return A single character from the file.
     * @throws IOException occurs on file exceptions
     */
    public int nextChar() throws IOException {
        int char1 = pr.read();
        // Increment column counter
        // If newline increment line counter
        return char1;
    }

    /**
     * <p><b>pushChar</b> pushes a character back into the file using the PushbackReader.</p>
     * @param argChar will push back into the file reader
     * @throws IOException occurs on file exceptions
     */
    public void pushChar(int argChar) throws IOException {
        pr.unread(argChar);
        // Decrement column counter
        // If pushing newline, decrement line counter
    }

    /**
     * <p><b>peekChar</b> allows you to peek at the next character without impacting the
     * file reader position.</p>
     *
     * @return A single character without moving file reader.
     * @throws IOException occurs on file exceptions
     */
    public int peekChar() throws IOException {
        int peeker = nextChar();
        pushChar(peeker);
        return peeker;
    }

    /**
     * <p><b>closeScanner</b> should always be called when you're done with the file.</p>
     */
    public void closeScanner() {
        try {
            // Close the reader
            pr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

