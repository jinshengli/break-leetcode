package stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *  2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 */
public class AsteroidCollision_735 {

    // 优化。  --》  《---
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                isAlive = stack.peek() < -asteroid;
                if (stack.peek() <= -asteroid) { // 更大或者相等 都爆炸
                    stack.pop();
                }
            }
            if (isAlive) {
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public int[] asteroidCollision01(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (true) {
                if (stack.isEmpty()){
                    stack.push(asteroid);
                    break;
                }
                Integer peek = stack.peek();

                // <---
                if (peek < 0) {
                    stack.push(asteroid);
                    break;
                }

                // peek > 0  -->  <---
                if (asteroid + peek == 0) {
                    stack.pop();
                    break;
                }

                // peek > 0
                if (asteroid > 0) {
                    stack.push(asteroid);
                    break;
                }

                // peek > 0
                // asteroid < 0
                if (peek + asteroid < 0) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision_735 asteroidCollision_735 = new AsteroidCollision_735();
        int[] ints = asteroidCollision_735.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(ints);
    }

}
