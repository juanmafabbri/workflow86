import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import structures.DependencyTree;
import structures.Node;
import traversals.PostOrderTraversal;
import traversals.TreeTraversal;

import java.util.*;

public class FindOutTreePostOrderTraversalExample1Test {

    /** Data use case
    Module A: B, C, D
    Module C: E, F, G
    Module G: H, I
     **/
    DependencyTree example1DependencyTree = new DependencyTree(initExample1Data());
    TreeTraversal postOrderTraversal = new PostOrderTraversal();

    @Test
    public void showsGDependenciesTest() throws Exception {
        //given
        String gDependency = "G";
        Node root = new Node(gDependency);
        List<String> dependenciesOfG = example1DependencyTree.getDependenciesModulesOf(gDependency);
        Node tree = example1DependencyTree.generate(root, dependenciesOfG);

        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(GoutputExpected(), output);
    }

    @Test
    public void showsADependenciesTest() throws Exception {
        //given
        String ADependency = "A";
        Node root = new Node(ADependency);
        List<String> dependenciesOfA = example1DependencyTree.getDependenciesModulesOf(ADependency);
        Node tree = example1DependencyTree.generate(root, dependenciesOfA);

        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(AoutputExpected(), output);
    }

    @Test
    public void showsCDependenciesTest() throws Exception {
        //given
        String CDependency = "C";
        Node root = new Node(CDependency);
        List<String> dependenciesOfA = example1DependencyTree.getDependenciesModulesOf(CDependency);
        Node tree = example1DependencyTree.generate(root, dependenciesOfA);

        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(CoutputExpected(), output);
    }

    @Test
    public void showsNoDependenciesForAnEmptyModuleGroupTest() throws Exception {
        HashMap<String, List<String>> exampleModuleEmpty = new HashMap<>();
        exampleModuleEmpty.put("E", new ArrayList<>());

        //given
        String emptyDependency = "E";
        Node root = new Node(emptyDependency);
        List<String> dependenciesOf = example1DependencyTree.getDependenciesModulesOf(emptyDependency);
        Node tree = example1DependencyTree.generate(root, dependenciesOf);
        postOrderTraversal = new PostOrderTraversal();

        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(new ArrayList<>(), output);
    }

    private HashMap<String, List<String>> initExample1Data() {
        HashMap<String, List<String>> example1Modules = new HashMap<>();
        example1Modules.put("A", Arrays.asList("B", "C", "D"));
        example1Modules.put("C", Arrays.asList("E", "F", "G"));
        example1Modules.put("G", Arrays.asList("H", "I"));

        return example1Modules;
    }

    private List<String> GoutputExpected() {
        List<String> outputExpected = new ArrayList<>();
        outputExpected.add("H");
        outputExpected.add("I");
        return outputExpected;
    }

    private List<String> AoutputExpected() {
        List<String> outputExpected = new ArrayList<>();
        outputExpected.add("B");
        outputExpected.add("E");
        outputExpected.add("F");
        outputExpected.add("H");
        outputExpected.add("I");
        outputExpected.add("G");
        outputExpected.add("C");
        outputExpected.add("D");
        return outputExpected;
    }

    private List<String> CoutputExpected() {
        List<String> outputExpected = new ArrayList<>();
        outputExpected.add("E");
        outputExpected.add("F");
        outputExpected.add("H");
        outputExpected.add("I");
        outputExpected.add("G");
        return outputExpected;
    }
}
