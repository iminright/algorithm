/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _863_DistanceK.java, v 0.1 2021Äê03ÔÂ16ÈÕ 8:26 PM wanhaofan
 */
public class _863_DistanceK {

    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        traverse(target, K);
        List<TreeNode> path = pathToTarget(root, target, new ArrayList<>());
        List<TreeNodePath> nodePathList = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            TreeNodePath nodePath;
            if(i == path.size() - 1){
                nodePath = new TreeNodePath(path.get(i), path.get(i).left == target ? 0 : 1);
            }else{
                nodePath = new TreeNodePath(path.get(i), path.get(i).left == path.get(i + 1) ? 0 : 1);
            }
            nodePathList.add(nodePath);
        }
        int distance = 0;
        for (int i = nodePathList.size() - 1; i >= 0; i--) {
            distance++;
            if(K - distance == 0){
                result.add(nodePathList.get(i).node.val);
            }else if(K - distance - 1 >= 0){
                traverse(nodePathList.get(i).direction == 1 ? nodePathList.get(i).node.left : nodePathList.get(i).node.right, K - distance - 1);
            }
        }
        return result;
    }

    private List<TreeNode> pathToTarget(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return null;
        }
        if (root == target) {
            return path;
        }
        path.add(root);
        List<TreeNode> path1 = pathToTarget(root.left, target, new ArrayList<>(path));
        if (path1 != null) {
            return path1;
        } else {
            return pathToTarget(root.right, target, new ArrayList<>(path));
        }
    }

    private void traverse(TreeNode root, int K) {
        if (root == null) {
            return;
        }
        if (K == 0) {
            result.add(root.val);
            return;
        }
        traverse(root.left, K - 1);
        traverse(root.right, K - 1);
    }

    class TreeNodePath{
        TreeNode node;
        int direction;

        public TreeNodePath(TreeNode node, int direction){
            this.node = node;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        //[0,2,1,null,null,3] 3 3
        TreeNode _0 = new TreeNode(0);
        TreeNode _2 = new TreeNode(2);
        TreeNode _1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);

        _0.left = _2;
        _0.right = _1;
        _1.left = _3;
        _863_DistanceK main = new _863_DistanceK();
        main.distanceK(_0, _3, 3);
    }

}