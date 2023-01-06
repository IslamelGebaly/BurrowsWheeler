import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;

public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    private CircularSuffixArray csa;
    private static final int R = 256;

    public static void transform() {
        StringBuilder sv = new StringBuilder();
        char c;
        do {
            c = BinaryStdIn.readChar();
            sv.append(c);
        } while (!BinaryStdIn.isEmpty());

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
        int start = BinaryStdIn.readInt();
        StringBuilder sb = new StringBuilder();
        char c;
        do {
            c = BinaryStdIn.readChar();
            sb.append(c);
        } while (!BinaryStdIn.isEmpty());

        char[] t = sb.toString().toCharArray();
        char[] a = keyIndexedSorting(t);
        int[] next = new int[t.length];
        Queue[] chars = new Queue[R];
        for (int i = 0; i < t.length; i++) {
            if (chars[t[i]] == null)
                chars[t[i]] = new Queue<Integer>();
            chars[t[i]].enqueue(i);
        }

        for (int i = 0; i < a.length; i++) {
            next[i] = (int) chars[a[i]].dequeue();
        }

        int n = start;
        do {
            BinaryStdOut.write(a[n]);
            n = next[n];
        } while (n != start);
        BinaryStdOut.close();
    }

    private static char[] keyIndexedSorting(char[] t) {

        int[] count = new int[R + 1];
        char[] aux = new char[t.length];

        for (int i = 0; i < t.length; i++) {
            count[t[i] + 1]++;
        }

        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        for (int i = 0; i < t.length; i++) {
            aux[count[t[i]]++] = t[i];
        }

        return aux;
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-"))
            transform();
        else if (args[0].equals("+"))
            inverseTransform();
    }

}

