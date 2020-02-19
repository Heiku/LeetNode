package heiku.io.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @Author: Heiku
 * @Date: 2020/2/19
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap();
        if (str == null || str.isEmpty()){
            return -1;
        }
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i), count+1);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar("google"));
    }
}
