package structures;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private List<Node> children = new ArrayList<>();

    public List<Node> getChildren() {
        return children;
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
