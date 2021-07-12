import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import structures.DependencyTree;
import structures.Node;
import traversals.PostOrderTraversal;
import traversals.TreeTraversal;

import java.util.*;

public class FindOutTreePostOrderTrasversalExample2Test {


    /** Data use case
     Module A: B, C, D
     Module C: E, F, G, E
     Module G: H, I
     Module I: D
     **/
    DependencyTree dependencyTree = new DependencyTree(initExample2Data());
    TreeTraversal postOrderTraversal = new PostOrderTraversal();

    @Test
    public void showsGDependenciesTest() throws Exception {

        //given un Id
        String gDependency = "G";
        //Armo arbol
        Node root = new Node(gDependency);
        List<String> dependenciesOfG = dependencyTree.getDependenciesModulesOf(gDependency);


        Node tree = dependencyTree.generate(root, dependenciesOfG);


        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(GoutputExpected(), output);

    }

    private HashMap<String, List<String>> initExample2Data() {
        HashMap<String, List<String>> example2Modules = new HashMap<>();
        example2Modules.put("A", Arrays.asList("B", "C", "D"));
        example2Modules.put("C", Arrays.asList("E", "F", "G", "E"));
        example2Modules.put("G", Arrays.asList("H", "I"));
        example2Modules.put("I", Arrays.asList("D"));

        return example2Modules;
    }

    //OUTPUT
    @Test
    public void showsADependenciesTest() throws Exception {
    //given un Id
    String ADependency = "A";
    //Armo arbol
    Node root = new Node(ADependency);
    List<String> dependenciesOfA = dependencyTree.getDependenciesModulesOf(ADependency);


    Node tree = dependencyTree.generate(root, dependenciesOfA);

    //when
    List<String> output = postOrderTraversal.traverse(tree);

    //then
    Assertions.assertEquals(AoutputExpected(), output);

    }

    @Test
    public void showsCDependenciesTest() throws Exception {
        //given un Id
        String CDependency = "C";
        //Armo arbol
        Node root = new Node(CDependency);
        List<String> dependenciesOfA = dependencyTree.getDependenciesModulesOf(CDependency);


        Node tree = dependencyTree.generate(root, dependenciesOfA);

        //when
        List<String> output = postOrderTraversal.traverse(tree);

        //then
        Assertions.assertEquals(CoutputExpected(), output);

    }


    private List<String> GoutputExpected() {
        List<String> outputExpected = new ArrayList<>();
        outputExpected.add("H");
        outputExpected.add("D");
        outputExpected.add("I");
        return outputExpected;
    }

    private List<String> AoutputExpected() {
        List<String> outputExpected = new ArrayList<>();
        outputExpected.add("B");
        outputExpected.add("E");
        outputExpected.add("F");
        outputExpected.add("H");
        outputExpected.add("D");
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
        outputExpected.add("D");
        outputExpected.add("I");
        outputExpected.add("G");
        return outputExpected;
    }



}
