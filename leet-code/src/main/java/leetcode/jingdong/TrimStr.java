package leetcode.jingdong;

public class TrimStr {
    public static void main(String[] args) {
        String st = " i am a   little boy.  ";
        System.out.println(trimStr(st));
        char[] str = st.toCharArray();
        int i = 0, j = 0;
        while (str[i] == ' ') {
            i++;
        }
        while (i <= str.length - 1) // 对于每个字符
        {
            if (str[i] == ' ' && (i == str.length - 1 || str[i + 1] == ' ')) // 结尾或者下一个字符仍然是空格
            { // 如果中间空格的之后还存在空格的话，或者是结尾的话。
                i++;
                continue;
            }
            str[j++] = str[i++]; // 向前移动

        }
        for (int o = 0; o < j; o++) {
            System.out.print(str[o]);
        }
    }

    public static String trimStr(String str) {

        char[] source = str.toCharArray();
        int i = 0, j = 0;
        // i 结果串的最后一个位置
        // j 当前串需要移动的位置
        while (source[j] == ' ') {
            j++;
        }
        while (j < source.length) {
            // 可以保证有一个空格,并且不复制尾巴空格，判断条件||不能弄反
            if (source[j] == ' ' && (j == source.length - 1 || source[j + 1] == ' ')) {
                j++;
                continue;
            }
            source[i++] = source[j++];
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < i; k++) {
            builder.append(source[k]);
        }
        return builder.toString();
    }
}
