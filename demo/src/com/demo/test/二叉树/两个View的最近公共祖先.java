package com.demo.test.二叉树;

public class 两个View的最近公共祖先 {

    /**
     * 在Android中，View树是一个典型的层级结构，每个View可以有零个或多个子View。要找到两个任意子View的最近公共父节点（最近共同祖先），可以通过从这两个View开始，分别向上遍历它们各自的父View，直到找到相同的父View为止。
     * <p>
     * 以下是一个简单的递归算法思路：
     * <p>
     * 从给定的两个子View开始。
     * 对于每个View，获取其getParent()方法返回的父View。
     * 比较两个View当前获得的父View是否相同。
     * 如果相同，则该父View即为最近公共父节点，结束查找。
     * 如果不同，则分别继续对各自的父View进行上述步骤，直到找到相同的父View。
     * 如果用编程的方式来实现，可以采用迭代或递归的方法：
     */
    public static View findClosestCommonParent(View view1, View view2) {
        // 初始化父View指针为各自当前的父View
        View parent1 = view1.getParent();
        View parent2 = view2.getParent();

        while (parent1 != null && parent2 != null) {
            // 如果找到了相同的父View，直接返回它
            if (parent1 == parent2) {
                return parent1;
            }

            // 否则，分别向上查找各自的父View
            parent1 = parent1.getParent();
            parent2 = parent2.getParent();
        }

        // 如果其中一个View的父View为空（意味着已经到达根View，而另一个还没有）
        // 或者它们最终在同一级（比如都到了DecorView或者同一层级的FrameLayout等）
        // 这时最后一个非空的父View就是它们的共同祖先
        if (parent1 == null) {
            return parent2;
        } else if (parent2 == null) {
            return parent1;
        }

        // 应该不会出现这种情况，因为循环会在两者相等时结束
        throw new IllegalStateException("Views don't share a common ancestor.");
    }

    public class View {
        View[] children;
        View parent;

        public View getParent() {
            return parent;
        }
    }
}
