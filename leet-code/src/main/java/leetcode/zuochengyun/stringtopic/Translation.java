package leetcode.zuochengyun.stringtopic;

public class Translation {
    public String stringTranslation(String A, int n, int len) {
        if (A == null) {
            return A;
        }
        if (len > A.length() - 1) {
            return A;
        }
        String pre = reverseString(A.substring(0, len));
        String last = reverseString(A.substring(len));

        return reverseString(pre + last);
    }

    private String reverseString(String source) {
        if (source == null) {
            return source;
        }
        char[] dest = new char[source.length()];
        for (int i = source.length() - 1; i >= 0; i--) {
            dest[source.length() - 1 - i] = source.charAt(i);
        }
        return new String(dest);
    }
}
