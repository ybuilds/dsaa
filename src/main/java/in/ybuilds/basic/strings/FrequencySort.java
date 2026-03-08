package in.ybuilds.basic.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {
    public List<Character> frequencySort(String s) {
        var frequency = s
                .chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));

        return frequency
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int compare = Long.compare(e2.getValue(), e1.getValue());
                    if (compare == 0)
                        return Character.compare(e1.getKey(), e2.getKey());
                    return compare;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FrequencySort object = new FrequencySort();
        System.out.println(object.frequencySort(scanner.next()));
    }
}
