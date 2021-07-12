import helpers.Printer;
import structures.DependencyTree;
import structures.Node;
import structures.Structure;
import traversals.PostOrderTraversal;
import traversals.TreeTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Workflow86 {

    public static void main(String[] arg) {
        HashMap<String, List<String>> example1Modules = new HashMap<>();
        example1Modules.put("A", Arrays.asList("B", "C", "D"));
        example1Modules.put("C", Arrays.asList("E", "F", "G"));
        example1Modules.put("G", Arrays.asList("H", "I"));

        HashMap<String, List<String>> example2Modules = new HashMap<>();
        example2Modules.put("A", Arrays.asList("B", "C", "D"));
        example2Modules.put("C", Arrays.asList("E", "F", "G", "E"));
        example2Modules.put("G", Arrays.asList("H", "I"));
        example2Modules.put("I", Arrays.asList("D"));

        //Use case #1
        String useCase1title = "Example 1";
        List<String> modulesExample1 = Arrays.asList("G", "C", "A");
        Printer.printInitialData(useCase1title, example1Modules);
        process(example1Modules, modulesExample1);

        //Use case #2
        String useCase2title = "Example 2";
        List<String> modulesExample2 = Arrays.asList("G", "C", "A");
        Printer.printInitialData(useCase2title, example2Modules);
        process(example2Modules, modulesExample2);
    }

    private static void process(HashMap<String, List<String>> example1Modules, List<String> modulesExample1) {
        for(String module : modulesExample1) {
            Structure example1DependencyTree = new DependencyTree(example1Modules);
            String moduleName = module;

            List<String> dependencies = example1DependencyTree.getDependenciesModulesOf(moduleName);

            //Create dependency tree
            Node root = new Node(moduleName);
            Node tree = example1DependencyTree.generate(root, dependencies);

            TreeTraversal postOrderTraversal = new PostOrderTraversal();
            List<String> output = postOrderTraversal.traverse(tree);

            Printer.printResult(moduleName, output);
        }
    }
}
