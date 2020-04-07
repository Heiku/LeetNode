package heiku.io.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address,
 * mail sent there will be forwarded to the same address without dots in the local name.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 * Example 1:
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 *
 * @Author: Heiku
 * @Date: 2019/8/14
 */
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            s.add(filter(emails[i]));
        }
        return s.size();
    }

    public String filter(String str){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(str.charAt(index) != '@'){
            char ch = str.charAt(index);
            if(ch == '.'){
                index++;
                continue;
            }else if(ch == '+'){
                while(str.charAt(index) != '@'){index++;}
            }else{
                sb.append(ch);
                index++;
            }
        }
        sb.append(str.substring(index));
        return sb.toString();
    }


    // 36ms, beat 31%
    public int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            String[] sArr = s.split("@");
            String local = sArr[0].split("[+]")[0].replace(".", "");
            String domain = sArr[1];

            set.add(local + "@" + domain);
        }

        return set.size();
    }
}
