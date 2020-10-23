/**
 * @author Team3
 * @date 2020/10/23 22:33
 *
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0){
            int l = num / div;
            int r = num % 10;
            if (l != r) {
                return false;
            }
            num = (num - l * div) / 10;
            div /= 100;
        }
        return true;
    }
}
