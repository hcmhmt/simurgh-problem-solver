package huawei;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String a1 = "aabbccdsadasdz";

        HashMap<String, Integer> stringMap = new HashMap<>();

        Set<String> stringSetList = a1.chars()
                .mapToObj(c -> (char) c)
                .map(Objects::toString)
                .collect(Collectors.toSet());

        stringSetList.forEach(stringValue -> {
            stringMap.put(stringValue, 0);
        });

        for (char c : a1.toCharArray()) {
            stringMap.put(String.valueOf(c), stringMap.get(String.valueOf(c)) + 1);
        }

        stringMap.forEach((s, numberOfString) -> {
            System.out.println(s + " -> " + numberOfString);
        });

    }

}
