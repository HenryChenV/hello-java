package cn.chenhenry.java.bracket;

/**
 * @author henrychen
 * @date created at 2021/1/29 10:52 下午
 */
public class Bracket {
    public static void main(String[] args) {
        System.out.println(Bracket.isValid("()"));
        System.out.println(Bracket.isValid("#)"));
        System.out.println(Bracket.isValid("#(#)#"));
        System.out.println(Bracket.isValid("(("));
        System.out.println(Bracket.isValid("))"));
    }

    private static boolean isValid(String str) {
        return doIsValid(str, 0, 0);
    }

    private static boolean doIsValid(String str, int leftCount, int index) {
        if (leftCount < 0) {
            return false;
        }

        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                leftCount--;
                if (leftCount < 0) {
                    return false;
                }
            } else {
                if (doIsValid(str, leftCount + 1, index + 1) ||
                        doIsValid(str, leftCount - 1, index + 1)) {
                    return true;
                }
            }
        }

        return leftCount == 0;
    }
}
