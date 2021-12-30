package DataStructure.Array.KArray;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInKSortedArray {
    public List<Integer> common(List<List<Integer>> arrays) {
        List<Integer> result = arrays.get(0);
        for (int i = 1; i < arrays.size(); i++) {
            result = helper(result, arrays.get(i));
        }
        return result;
    }

    private List<Integer> helper(List<Integer> l1, List<Integer> l2) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).equals(l2.get(j))) {
                result.add(l1.get(i));
                i++;
                j++;
            } else if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}