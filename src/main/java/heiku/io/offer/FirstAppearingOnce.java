package heiku.io.offer;

/**
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class FirstAppearingOnce {
    int[] table = new int[256];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        table[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chars = sb.toString().toCharArray();
        for (char c : chars){
            if (table[c] == 1)
                return c;
        }

        return '#';
    }
}
