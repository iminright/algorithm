### 遍历
因为树也是图的一部分,所以遍历的方法可以分为两个方向阐述
1. DFS

前序/中序/后序都属于DFS
前序/中序/后序中的前中后分别表示根节点遍历的位置
* 前序表示根节点第一个访问(root->left->right)
  
前序遍历的形式总是[根节点, [左子树的前序遍历结果], [右子树的前序遍历结果]]

```text
public void traverse(TreeNode root){
    /**
     * do sth to root
     * ......
     */
    traverse(root.left);
    traverse(root.right);
}
```
* 中序(left->root->right)
  
中序遍历的形式总是
[[左子树的中序遍历结果], 根节点, [右子树的中序遍历结果]]
```text
public void traverse(TreeNode root){
    traverse(root.left);
    /**
     * do sth to root
     * ......
     */
    traverse(root.right);
}
```
* 后序(left->right->root)

后序遍历的形式总是
[[左子树的后序遍历结果], [右子树的后序遍历结果], 根节点]
```text
public void traverse(TreeNode root){
    traverse(root.left);
    traverse(root.right);
    /**
     * do sth to root
     * ......
     */
}
```

2. BFS

BFS一般的使用场景是求最短路径和层序遍历
```text
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```



