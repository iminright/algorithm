### 遍历
前序/中序/后序中的前中后分别表示根节点遍历的位置
* 前序表示根节点第一个访问(root->left->right)
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

