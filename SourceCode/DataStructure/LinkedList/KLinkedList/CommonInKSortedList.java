package DataStructure.LinkedList.KLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all common elements in K sorted lists.
 */
public class CommonInKSortedList {
    public List<Integer> common(List<List<Integer>> lists) {
        List<Integer> result = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            result = helper(result, lists.get(i));
        }
        return result;
    }

    private List<Integer> helper(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            int compare = l1.get(i).compareTo(l2.get(j));
            if (compare == 0) {
                result.add(l1.get(i));
                i++;
                j++;
            } else if (compare < 0) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */