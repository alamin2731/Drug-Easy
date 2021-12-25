package com.example.drugeasy;

public class ExpandModel {
    private String name;
    private String pic;
    private boolean expanded;

    public ExpandModel(String name, String pic) {
        this.name = name;
        this.pic = pic;
        this.expanded=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "FormulaModel{" +
                "name='" + name + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
