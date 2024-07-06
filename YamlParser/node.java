package CodingChallenges.YamlParser;

import java.util.HashSet;

public class node {
    private Object name;
    private HashSet<node> children;

    public node(Object name){
        this.name = name;
        this.children = null;
    }
    public node(Object name, HashSet<node> children){
        this.name = name;
        this.children = children;
    }
    
    public void setChild(node child){
        this.children.add(child);
    }
    public String getName() {
        return (String) this.name;
    }
    public node getChildren() {
        return this.children.iterator().next();
    }
    
}

