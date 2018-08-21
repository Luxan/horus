import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    return Stream.concat(
      Stream.of(this),
      nodes.stream()
        .map(obj -> (ICompositeNode) obj)
        .flatMap(node-> node.getNodes().stream())
    ).collect(Collectors.toList());
  }

}