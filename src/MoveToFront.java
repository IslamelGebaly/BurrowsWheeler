import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to standard output
    private static final int R = 256;

    private static char[] initSequence() {
        char[] seq = new char[R];
        for (char c = 0; c < R; c++) {
            seq[c] = c;
        }
        return seq;
    }

    public static void encode() {
        char[] seq = initSequence();
        char c;
        do {
            c = BinaryStdIn.readChar();
            for (char i = 0; i < R; i++) {
                if (c == seq[i]) {
                    BinaryStdOut.write(i);
                    moveToFront(seq, i);
                    break;
                }
            }
        } while (c != '!');
        BinaryStdIn.close();
        BinaryStdOut.close();

    }

    private static void moveToFront(char[] arr, int a) {
        char temp = arr[a];
        for (int i = a; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] seq = initSequence();
        int c;
        while (!BinaryStdIn.isEmpty()) {
            c = BinaryStdIn.readByte();

            BinaryStdOut.write(seq[c]);
            moveToFront(seq, c);
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-"))
            encode();
        else
            decode();
    }

}
