package cn.chenhenry.java.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solutaion1 {

    public String run(int[] nums) {
        List<String> strs = new ArrayList<String>() {{
            for (int num : nums) {
                add(String.valueOf(num));
            }
        }};

        // 时间来不及我偷懒了, 算不算分随意, 主要是这个比较算法
        // 有个特别的case要注意, 就是32和321的时候, 到底是32132还是32321有点讲究
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Length = s1.length(), s2Length = s2.length();
                int i = 0;
                while (i < s1.length() && i < s2.length()) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if (c1 == c2) {
                        i++;
                        continue;
                    }

                    if (c1 > c2) {
                        return 1;
                    }
                    return -1;
                }

                if (s1Length == s2Length) {
                    return 0;
                }

                return compare(s1+s2, s2+s1);
            }
        });
        System.out.println(strs);

        StringBuffer sb = new StringBuffer("");
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solutaion1().run(new int[]{3, 32, 321}));
    }
}
