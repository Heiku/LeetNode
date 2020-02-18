package heiku.io.offer;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @Author: Heiku
 * @Date: 2020/2/18
 */
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(numbers).forEach(e -> list.add(e));

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e));
        return sb.toString();
    }
}
