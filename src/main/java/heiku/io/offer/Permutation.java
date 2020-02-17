package heiku.io.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * （全排列问题）
 * https://uploadfiles.nowcoder.com/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @Author: Heiku
 * @Date: 2020/2/17
 */
public class Permutation {
    public ArrayList<String> permutation(String str) {
        List<String> list = new ArrayList<>();
        if (str != null && str.length() > 0){
            permutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return (ArrayList<String>) list;
    }

    public void permutationHelper(char[] cs, int i, List<String> list){
        if (i == cs.length - 1){
            String val = String.valueOf(cs);
            if (!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j = i; j < cs.length; j++){
                swap(cs, i, j);
                permutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
