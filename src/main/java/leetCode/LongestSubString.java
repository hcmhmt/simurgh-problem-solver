package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubString {

    public static void main(String[] args) {

        System.out.println("abcabcbb -> " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb -> " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew -> " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("dvdf -> " + lengthOfLongestSubstring("dvdf"));
        System.out.println("asjrgapa -> " + lengthOfLongestSubstring("asjrgapa"));

        System.out.println("------------------------------");
        System.out.println("abcabcbb -> " + lengthOfLongestSubstring2("abcabcbb"));
        System.out.println("bbbbb -> " + lengthOfLongestSubstring2("bbbbb"));
        System.out.println("pwwkew -> " + lengthOfLongestSubstring2("pwwkew"));
        System.out.println("dvdf -> " + lengthOfLongestSubstring2("dvdf"));
        System.out.println("asjrgapa -> " + lengthOfLongestSubstring2("asjrgapa"));
    }

    private static int lengthOfLongestSubstring(String s) {

        List<Character> charList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        HashMap<Integer, List<Character>> characterHashMap = new HashMap<>();
        Integer flag = 0;
        characterHashMap.put(flag, new ArrayList<>());

        for (int i = 0; i < charList.size(); i++) {
            for (int j = i; j <charList.size(); j++) {
                if (characterHashMap.get(flag).isEmpty()) {
                    ArrayList<Character> objects = new ArrayList<>();
                    objects.add(charList.get(j));
                    characterHashMap.put(flag, objects);
                } else if (!characterHashMap.get(flag).contains(charList.get(j))) {
                    characterHashMap.get(flag).add(charList.get(j));
                }
            }
            flag++;
            characterHashMap.put(flag, new ArrayList<>());
        }

        int max = 0;
        for (Map.Entry<Integer, List<Character>> entry : characterHashMap.entrySet()) {
            max = Math.max(max, entry.getValue().size());
        }

        return max;
    }

    private static int lengthOfLongestSubstring2(String s) {

        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);

            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }

        }
        return maxLength;
    }

}
