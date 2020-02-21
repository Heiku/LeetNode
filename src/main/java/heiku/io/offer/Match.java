package heiku.io.offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class Match {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){return true;}
        return matchRec(str, pattern, 0, 0);
    }
    private boolean  matchRec(char[] str, char[] pattern, int strIdx, int patIdx){
        if(strIdx == str.length && patIdx == pattern.length){return true;}
        if(strIdx != str.length && patIdx == pattern.length){return false;}

        if(patIdx + 1 < pattern.length && pattern[patIdx + 1] == '*'){//下一个是*
            if( (strIdx != str.length && (str[strIdx] == pattern[patIdx] || pattern[patIdx] == '.'))){ //下一个是*,而且此处字符相匹配
                return matchRec(str, pattern, strIdx, patIdx+2)   //出现0次
                        || matchRec(str, pattern, strIdx+1, patIdx+2)  //出现1次
                        || matchRec(str, pattern, strIdx+1, patIdx);  //出现多次
            }else{
                return matchRec(str, pattern, strIdx, patIdx+2);  //此处字符不匹配，当它出现0次
            }
        }else{//下一个字符不是*
            if( (strIdx != str.length && (str[strIdx] == pattern[patIdx] || pattern[patIdx] == '.'))){  //若匹配
                return matchRec(str, pattern, strIdx+1, patIdx+1);
            }
        }
        return false;
    }

}
