import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class Main {

  private static Node rootNode = new Node("rootCode", "rootRender");
  private static Node ANode = new Node("ACode", "ARender");
  private static Node AANode = new Node("AACode", "AARender");
  private static Node ABNode = new Node("ABCode", "ABRender");
  private static Node BNode = new Node("BCode", "BRender");
  private static Node BANode = new Node("BACode", "BARender");
  private static Node BBNode = new Node("BBCode", "BBRender");

  private static List<Node> nodeList = Arrays.asList(rootNode, ANode, AANode, ABNode, BNode, BANode, BBNode);

  public static void main(String[] args) {
    MyStructure myStructure = new MyStructure();
    myStructure.addNode(rootNode);

    rootNode.addChildNode(ANode);
    rootNode.addChildNode(BNode);
    ANode.addChildNode(AANode);
    ANode.addChildNode(ABNode);
    BNode.addChildNode(BANode);
    BNode.addChildNode(BBNode);

    nodeList.forEach(node -> assertEquals(myStructure.findByCode(node.getCode()), node));
    nodeList.forEach(node -> assertEquals(myStructure.findByRenderer(node.getRenderer()), node));

    assertNull(myStructure.findByRenderer("null"));
    assertNull(myStructure.findByCode("null"));

    assertEquals(myStructure.count(), nodeList.size());
  }

}



