import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    private CircularSuffixArray csa;

    public static void transform() {
        StringBuilder sv = new StringBuilder();
        char c;
        do {
            c = BinaryStdIn.readChar();
            sv.append(c);
        } while (c != '!');
        BinaryStdIn.close();

        CircularSuffixArray csa = new CircularSuffixArray(sv.toString());
        int index;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < csa.length(); i++) {
            if (csa.index(i) == 0) {
                BinaryStdOut.write(i);
            }

            index = csa.index(i) == 0 ? csa.length() - 1 : csa.index(i) - 1;
            sb.append(sv.charAt(index));
        }

        BinaryStdOut.write(sb.toString());
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {

    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

        if (args[0].equals("-"))
            transform();
        else if (args[0] == "+")
            inverseTransform();
    }

}

