import java.util.Arrays;

public class CircularSuffixArray {

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int pointer;
        String s;

        CircularSuffix(String s, int pointer) {
            this.s = s;
            this.pointer = pointer;
        }

        public int compareTo(CircularSuffix that) {
            int i = this.pointer, j = that.pointer;
            for (int n = 0; n < s.length(); n++) {
                i = i + 1 % s.length();
                j = j + 1 % s.length();
                if (this.s.charAt(i) > that.s.charAt(j))
                    return 1;
                if (this.s.charAt(i) < that.s.charAt(j))
                    return -1;
            }
            return 0;
        }
    }

    private CircularSuffix[] circularSuffixArray;
    private final int length;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null)
            throw new IllegalArgumentException();
        length = s.length();
        circularSuffixArray = new CircularSuffix[s.length()];

        for (int i = 0; i < s.length(); i++) {
            circularSuffixArray[i] = new CircularSuffix(s, i);
        }

        Arrays.sort(circularSuffixArray);
    }

    // length of s
    public int length() {
        return this.length;
    }


    // returns index of ith sorted suffix
    public int index(int i) {
        return circularSuffixArray[i].pointer;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}
