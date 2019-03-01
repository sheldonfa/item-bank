package com.mypro.ssm.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Long code;
    private Long parentCode;
    private String name;
    private List<TreeNode> child = new ArrayList<>();
    private String icon;

    public TreeNode() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long nodeId) {
        this.code = nodeId;
    }

    public Long getParentCode() {
        return parentCode;
    }

    public void setParentCode(Long parentId) {
        this.parentCode = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChild() {
        return child;
    }

    public void setChild(List<TreeNode> nodes) {
        this.child = nodes;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "code=" + code +
                ", parentCode=" + parentCode +
                ", name='" + name + '\'' +
                ", child=" + child +
                '}';
    }
}
