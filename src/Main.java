import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;


public class Main {

  private static Node rootNode = new Node("rootCode", "rootRender");
  private static Node ANode = new Node("ACode", "ARender");
  private static Node AANode = new Node("AACode", "AARender");
  private static Node ABNode = new Node("ABCode", "ABRender");
  private static Node BNode = new Node("BCode", "BRender");
  private static Node BANode = new Node("BACode", "BARender");
  private static Node BBNode = new Node("BBCode", "BBRender");
  private static Node CNode = new Node("CCode", "CRender");

  private static List<INode> nodeList = Arrays.asList(rootNode, ANode, AANode, ABNode, BNode, BANode, BBNode, CNode);

  static {
    rootNode.addChildNode(ANode);
    rootNode.addChildNode(BNode);
    ANode.addChildNode(AANode);
    ANode.addChildNode(ABNode);
    BNode.addChildNode(BANode);
    BNode.addChildNode(BBNode);
  }

  public static void main(String[] args) {
    testMyStructure();
    testMyIterable();
  }

  private static void testMyStructure() {
    MyStructure myStructure = new MyStructure();
    myStructure.addNode(rootNode);
    myStructure.addNode(CNode);

    nodeList.forEach(node -> assertEquals(myStructure.findByCode(node.getCode()), node));
    nodeList.forEach(node -> assertEquals(myStructure.findByRenderer(node.getRenderer()), node));

    assertNull(myStructure.findByRenderer("null"));
    assertNull(myStructure.findByCode("null"));

    assertEquals(myStructure.count(), nodeList.size());
  }

  private static void testMyIterable() {
    MyIterator myIterator = new MyIterator(Arrays.asList(rootNode, CNode));
    List<INode> resultNodeList = new ArrayList<>();
    while (myIterator.hasNext())
      resultNodeList.add(myIterator.next());
    assertEquals(resultNodeList.size(), nodeList.size());
    assertTrue(resultNodeList.containsAll(nodeList));
  }

}



