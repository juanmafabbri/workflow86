package structures;

import java.util.List;

public interface Structure {

    List<String> getDependenciesModulesOf(String moduleNameToAnalyze);

    Node generate(Node root, List<String> dependenciesOfCurrentModule);

}
