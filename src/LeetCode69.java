/**
 * @author Team3
 * @date 2020/11/4 22:04
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int max = (int)Math.sqrt(Integer.MAX_VALUE);
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return end;
        } else {
            return start;
        }
    }
}
