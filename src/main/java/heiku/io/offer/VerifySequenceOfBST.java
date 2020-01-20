package heiku.io.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @Author: Heiku
 * @Date: 2020/1/20
 */
public class VerifySequenceOfBST {
    public boolean verifySequenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;

        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] sequence, int start, int end){
        if (start >= end)
            return true;

        // find the left index
        int i = start;
        while (sequence[i] < sequence[end])
            ++i;

        // right side all larger than root node value
        for (int j = i; j < end; j++){
            if (sequence[j] < sequence[end]){
                return false;
            }
        }
        return judge(sequence, start, i - 1) && judge(sequence, i, end - 1);
    }
}
