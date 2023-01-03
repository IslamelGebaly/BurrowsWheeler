import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to standard output
    private static final int R = 256;

    public static void encode() {
        int[] seq = new int[R];
        for (char c = 0; c < R; c++) {
            seq[c] = c;
        }
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {

    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        for (char c = 0; c < R; c++) {
            StdOut.println(c);
        }
    }

}
