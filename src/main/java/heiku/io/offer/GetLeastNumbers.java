package heiku.io.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * max heap
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @Author: Heiku
 * @Date: 2020/2/17
 */
public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (k > len || k == 0){
            return list;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (Comparator.reverseOrder()));

        // use a max heap, when we peek the element, the element is the biggest num in heap
        // so we can compare the other num with the heap top, if other num smaller than heap top, replace it.
        // in final, we can get the smallest n
        for (int i = 0; i < len; i++){
            if (maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }else if (maxHeap.peek() > input[i]){
                Integer tmp = maxHeap.poll();
                maxHeap.offer(input[i]);
                tmp = null;
            }
        }
        while (maxHeap.size() != 0){
            list.add(maxHeap.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        new GetLeastNumbers().getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
    }
}
