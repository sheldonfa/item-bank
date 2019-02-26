package com.mypro.ssm.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Long nodeId;
    private Long parentId;
    private String text;
    private List<TreeNode> nodes;
    private Boolean selectable = false;
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public TreeNode() {
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "nodeId=" + nodeId +
                ", parentId=" + parentId +
                ", text='" + text + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
