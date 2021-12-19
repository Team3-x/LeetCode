/**
 * @author Team3
 * @date 2021/12/19 20:41
 *
 * 997. 找到小镇的法官
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 *
 *
 *
 * 令 mm 为 trust 数组长度，对于每个 trust[i] = (a, b)trust[i]=(a,b) 而言，看作是从 aa 指向 bb 的有向边。
 *
 * 遍历 trust，统计每个节点的「入度」和「出度」：若存在 a -> ba−>b，则 aa 节点「出度」加一，bb 节点「入度」加一。
 *
 * 最后遍历所有点，若存在「入度」数量为 n - 1n−1，且「出度」数量为 0 的节点即是法官。
 *
 *
 */
public class LeetCode997 {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] in = new int[n + 1];
            int[] out = new int[n + 1];

            for (int[] t : trust) {
                out[t[0]]++;
                in[t[1]]++;
            }

            for (int i = 1; i <= n; i++) {
                if (in[i] == n-1 && out[i] == 0) {
                    return i;
                }
            }
            return -1;
        }
    }
}
