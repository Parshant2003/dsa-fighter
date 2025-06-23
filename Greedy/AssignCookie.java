import java.util.*;

public class AssignCookie {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // child is content
            }
            j++; // move to next cookie
        }

        return i; // number of content children
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3}; // greed factors
        int[] s = {1, 1};    // cookie sizes

        int result = findContentChildren(g, s);
        System.out.println("Maximum content children: " + result);
    }
}
