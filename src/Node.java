import java.util.List;

public class Node extends NodeCollection implements ICompositeNode {

  private String code;
  private String renderer;

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
    return nodes;
  }

}