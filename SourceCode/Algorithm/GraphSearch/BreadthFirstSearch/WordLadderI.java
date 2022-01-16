package Algorithm.GraphSearch.BreadthFirstSearch;

import java.util.*;

/**
 * Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word,
 * and return the length of the transformation sequence. Return 0 if there is no such transformations.
 * In each transformation, you can only change one letter,
 * and the word should still in the dictionary after each transformation.
 */
public class WordLadderI {
    public int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> step = new HashMap<>();
        step.put(beginWord, 1);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> neis = findNeighbor(cur, wordList);
            int curStep = step.get(cur);
            for (String nei : neis) {
                if (!step.containsKey(nei)) {
                    step.put(nei, curStep + 1);
                    queue.offer(nei);
                }
            }
        }
        return step.getOrDefault(endWord, 0);
    }

    private List<String> findNeighbor(String cur, List<String> wordList) {
        List<String> result = new ArrayList<>();
        for (String str : wordList) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (cur.charAt(i) != str.charAt(i)) {
                    diff++;
                }
            }
            if (diff == 1) {
                result.add(str);
            }
        }
        return result;
    }
}
