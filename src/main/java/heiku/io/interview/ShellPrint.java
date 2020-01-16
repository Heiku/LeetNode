package heiku.io.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Java 实现 shell 命令 cat 1.log | grep a | sort | uniq -c | sort -rn
 *
 * cat (file read)
 * grep (filter)
 * sort
 * uniq -c (count same element)
 * sort -rn (reverse)
 *
 * @Author: Heiku
 * @Date: 2020/1/16
 */
public class ShellPrint {
    public static void main(String[] args) throws Exception {
        File file = new File("/file.*.log");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String> strList = new ArrayList<>();
        String str = null;
        while ((str = reader.readLine()) != null){
            strList.add(str);
        }

        // grep
        strList = strList.stream().filter(s -> s.contains("a")).collect(Collectors.toList());

        // sort
        strList = strList.stream().sorted().collect(Collectors.toList());

        // uniq -c
        Map<String, Long> countMap = strList.stream().sorted().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        // sort -rn
        List<Long> res = countMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        res.forEach(System.out::println);
    }
}
