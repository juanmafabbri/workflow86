package traversals;

import structures.Node;
import traversals.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal implements TreeTraversal {

    private Integer currentRootIndex = 0;
    private Stack<Pair> stack = new Stack<>();
    private ArrayList<String> postorderTraversal = new ArrayList<>();


    //Helper class to add nodes and index into the stack
    static class Pair {
        public Node node;
        public Integer childrenIndex;

        public Pair(Node node, Integer childrenIndex) {
            this.node = node;
            this.childrenIndex = childrenIndex;
        }
    }


    public List<String> traverse(Node root) {
        while (root != null || !stack.isEmpty()) {
            if (root != null) {

                // Push the root and it's index
                // into the stack
                stack.push(new Pair(root, currentRootIndex));
                currentRootIndex = 0;

                // If root don't have any children's that
                // means we are already at the left most
                // node, so we will mark root as null
                if (root. getChildren().size() >= 1) {
                    root = root.getChildren().get(0);
                } else {
                    root = null;
                }
                continue;
            }

            Pair temp = stack.pop();
            postorderTraversal.add(temp.node.getValue());

            // Repeatedly we will the pop all the
            // elements from the stack till popped
            // element is last children of top of
            // the stack
            while (!stack.isEmpty() && temp.childrenIndex ==
                    stack.peek().node.getChildren().size() - 1) {
                temp = stack.pop();

                postorderTraversal.add(temp.node.getValue());
            }

            // If stack is not empty, then simply assign
            // the root to the next children of top
            // of stack's node
            if (!stack.isEmpty()) {
                root = stack.peek().node.getChildren().get(temp.childrenIndex + 1);
                currentRootIndex = temp.childrenIndex + 1;
            }
        }

        removeRootFromResultList();
        return postorderTraversal;
    }


    private void removeRootFromResultList() {
        postorderTraversal.remove(postorderTraversal.size() - 1);
    }
}
