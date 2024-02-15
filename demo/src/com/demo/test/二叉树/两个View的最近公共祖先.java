package com.demo.test.二叉树;

public class 两个View的最近公共祖先 {

    /**
     * 在Android中，View树是一个典型的层级结构，每个View可以有零个或多个子View。要找到两个任意子View的最近公共父节点（最近共同祖先），可以通过从这两个View开始，分别向上遍历它们各自的父View，直到找到相同的父View为止。
     * 以下是一个简单的递归算法思路：
     * <p>
     * 从给定的两个子View开始:
     * 对于每个View，获取其getParent()方法返回的父View。
     * 比较两个View当前获得的父View是否相同。
     * 如果相同，则该父View即为最近公共父节点，结束查找。
     * 如果不同，则分别继续对各自的父View进行上述步骤，直到找到相同的父View。
     * 如果用编程的方式来实现，可以采用迭代或递归的方法：
     */
    public View findCommonParent(View view1, View view2) {
        if (view1 == null || view2 == null) return null;

        // 获取当前视图的父视图
        View currentView = view1.getParent();

        while (currentView != null) {
            // 检查当前视图是否同时是两个目标视图的直接或间接父视图
            if (isAncestorOf(currentView, view1) && isAncestorOf(currentView, view2)) {
                // 当前视图就是最近公共父视图
                return currentView;
            }

            // 继续向上传递到更高层级的父视图
            currentView = currentView.getParent();
        }

        return null; // 没有找到公共父视图
    }

    // 辅助方法，判断一个视图是否为另一个视图的祖先
    private boolean isAncestorOf(View ancestor, View descendant) {
        View temp = descendant.getParent();
        while (temp != null) {
            if (temp == ancestor) {
                return true;
            }
            temp = temp.getParent();
        }
        return false;
    }

    public class View {
        View[] children;
        View parent;

        public View getParent() {
            return parent;
        }
    }
}
