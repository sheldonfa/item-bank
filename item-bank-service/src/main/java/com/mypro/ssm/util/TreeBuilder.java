package com.mypro.ssm.util;

import com.mypro.ssm.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.getParentId()==0) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        for (TreeNode it : treeNodes) {
            if (treeNode.getNodeId().equals(it.getParentId())) {
                if (treeNode.getNodes() == null) {
                    treeNode.setNodes(new ArrayList<>());
                }
                treeNode.getNodes().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
