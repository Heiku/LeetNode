package heiku.io.offer;

/**
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *
 * same with leftRotateString, one is character, the other is string
 * @see LeftRotateString
 *
 * @Author: Heiku
 * @Date: 2020/2/20
 */
public class ReverseSentence {


    public String reverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] strArr = str.split(" ");
        int lo = 0, hi = strArr.length - 1;
        while (lo <= hi){
            String tmp = strArr[lo];
            strArr[lo] = strArr[hi];
            strArr[hi] = tmp;
            lo++;
            hi--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i] + " ");
        }
        return sb.toString().trim();
    }

}
