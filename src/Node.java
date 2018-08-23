import java.util.ArrayList;
import java.util.List;

public class Node implements ICompositeNode {

  private String code;
  private String renderer;
  private List<INode> children = new ArrayList<>();

  Node(String code, String renderer) {
    this.code = code;
    this.renderer = renderer;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getRenderer() {
    return renderer;
  }

  @Override
  public List<INode> getNodes() {
    return children;
  }

  @Override
  public void addChildNode(INode node) {
    children.add(node);
  }

}