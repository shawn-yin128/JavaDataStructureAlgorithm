package Algorithm.GraphSearch.BreadthFirstSearch.TopologicalSort;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However,
 * the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 */
public class AlienWord {
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();
    public String alienOrder(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (char letter: words[i].toCharArray()) {
                if (graph.get(letter) == null) {
                    graph.put(letter, new ArrayList<>());
                    indegree.put(letter, 0);
                }
            }
        }
        for (int i = 1; i < words.length; i++) {
            scan(words, i);
        }
        Deque<Character> q = new ArrayDeque<>();
        for (Character key: indegree.keySet()) {
            if (indegree.get(key)==0) {
                q.offer(key);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            res.append(cur);
            for (Character next: graph.get(cur)) {
                indegree.put(next, indegree.get(next)-1);
                if (indegree.get(next)==0) {
                    q.offer(next);
                }
            }
        }
        return res.length() == indegree.size() ? res.toString() : "";
    }

    private void scan(String[] words, int i) {
        int j = 0;
        while (j<Math.min(words[i].length(), words[i-1].length())) {
            char last = words[i-1].charAt(j);
            char cur = words[i].charAt(j);
            if (cur != last) {
                graph.get(last).add(cur);
                indegree.put(cur, indegree.get(cur)+1);
                break;
            }
            j++;
        }
    }
}
