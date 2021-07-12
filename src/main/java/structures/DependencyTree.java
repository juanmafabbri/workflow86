package structures;

import java.util.HashMap;
import java.util.List;

public class DependencyTree implements Structure {

    private HashMap<String, List<String>> modules;

    public DependencyTree(HashMap<String, List<String>> modules) {
        if(modules == null || modules.isEmpty()) {
            this.modules = new HashMap<String, List<String>>();
        }
        this.modules = modules;
    }

    public Node generate(Node root, List<String> dependenciesOfCurrentModule) {
        if(root == null || dependenciesOfCurrentModule == null || dependenciesOfCurrentModule.isEmpty()) {
            return new Node("");
        }

        for (int i = 0; dependenciesOfCurrentModule.size() > i; i++){
            String currentModule = dependenciesOfCurrentModule.get(i);
            boolean repeatedChild = root.getChildren().stream().anyMatch(
                                        element -> element.getValue() == currentModule);
            //Check if there is a repeated child
            if (!repeatedChild) {
                root.getChildren().add(new Node(currentModule));
            }
            //Add children if there are
            List<String> subModules = getDependenciesModulesOf(currentModule);
            if(subModules != null && !subModules.isEmpty()) {
                Node lastNodeAdded = root.getChildren().get(root.getChildren().size() - 1);
                generate(lastNodeAdded, subModules);
            }
        }
        return root;
    }

    public List<String> getDependenciesModulesOf(String moduleNameToAnalyze) {
        return this.modules.get(moduleNameToAnalyze);
    }

}
