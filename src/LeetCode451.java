import java.util.PriorityQueue;


/**
 * @author Team3
 * @date 2020/11/17 22:05
 *
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class LeetCode451 {
    public int CHARACTER_SIZE = 94;
    public char HEAD_CHARACTER = ' ';
    public String frequencySort(String s) {
        if (s.length() < 1) {
            return s;
        }
        int[] record = new int[CHARACTER_SIZE];
        for (char ch : s.toCharArray()) {
            record[ch - HEAD_CHARACTER]++;
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((x, y) -> y.value - x.value);
        for (int i = 0; i < CHARACTER_SIZE; i++) {
            if (record[i] > 0) {
                pq.add(new Item(record[i], (char) (i + HEAD_CHARACTER)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() != 0) {
            Item item = pq.poll();
            for (int i = 0; i < item.value; i++) {
                sb.append(item.pattern);
            }
        }
        return sb.toString();
    }
    class Item {
        int value;
        char pattern;
        public Item(int v, char p) {
            this.value = v;
            this.pattern = p;
        }
    }
}
