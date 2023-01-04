import java.util.Arrays;

public class CircularSuffixArray {

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int pointer;
        String s;

        CircularSuffix(String s, int pointer) {
            this.s = s;
            this.pointer = pointer;
        }


        public int compareTo(CircularSuffix o) {
            return 0;
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null)
            throw new IllegalArgumentException();

        circularSuffixArray = new String[s.length()];
        indices = new int[s.length()];

        circularSuffixArray[0] = s;
        for (int i = 1; i < s.length(); i++) {
            this.s = rotateLeft(this.s);
            circularSuffixArray[i] = this.s;
        }


        Arrays.stream(circularSuffixArray).sorted();
    }

    // length of s
    public int length() {
        return s.length();
    }

    private String rotateLeft(String s) {
        String nS = "";
        for (int i = 1; i > s.length(); i--) {
            nS += s.charAt(i);
        }
        nS += s.charAt(0);
        return nS;
    }

    // returns index of ith sorted suffix
    public int index(int i) {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}
