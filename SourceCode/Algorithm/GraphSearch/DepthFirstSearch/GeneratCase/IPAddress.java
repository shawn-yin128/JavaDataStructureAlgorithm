package Algorithm.GraphSearch.DepthFirstSearch.GeneratCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
 */
public class IPAddress {
    public List<String> restore(String ip) {
        List<String> result = new ArrayList<>();
        if (ip == null || ip.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(ip.toCharArray(), 0, 0, sb, result);
        return result;
    }

    private void helper(char[] ip, int dotNumber, int index, StringBuilder sb, List<String> result) {
        if (dotNumber == 4) {
            if (sb.length() == ip.length + 4) {
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        if (index < ip.length) {
            sb.append(ip[index]).append('.');
            helper(ip, dotNumber + 1, index + 1, sb, result);
            sb.delete(sb.length() - 2, sb.length());
        }
        if (index + 1 < ip.length) {
            char a = ip[index];
            char b = ip[index + 1];
            if (a != '0') {
                sb.append(a).append(b).append('.');
                helper(ip, dotNumber + 1, index + 2, sb, result);
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        if (index + 2 < ip.length) {
            char a = ip[index];
            char b = ip[index + 1];
            char c = ip[index + 2];
            if (a == '1' || (a == '2' && b >= '0' && b <= '4') || (a == '2' && b == '5' && c >= '0' && c <= '5')) {
                sb.append(a).append(b).append(c).append('.');
                helper(ip, dotNumber + 1, index + 3, sb, result);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }
}
