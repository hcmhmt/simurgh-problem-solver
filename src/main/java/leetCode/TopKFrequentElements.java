package leetCode;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] ints1 = {1, 1, 1,1, 2,2, 2,3, 3};
        int[] ints2 = {1, 2, 2, 2, 4, 3};

        System.out.println(Arrays.toString(topKFrequent(ints1, 1)));
        System.out.println(Arrays.toString(topKFrequent(ints1, 2)));
        System.out.println(Arrays.toString(topKFrequent(ints2, 1)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else {
                frequencyMap.put(nums[i], 1);
            }
        }

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public int[] topKFrequentBestMemory2(int[] nums, int k) {
        Map<Integer, Long> countMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return countMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
