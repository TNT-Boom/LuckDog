package leetcode.zuochengyun.stringtopic;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseSentence("TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB", 47));
    }

    public static String reverseSentence(String A, int n) {
        if (A == null) {
            return A;
        }

        String[] strings = A.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reverseString(strings[i]);
            builder.append(strings[i]).append(" ");
        }

        return reverseString(builder.toString().trim());
    }

    private static String reverseString(String source) {
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
