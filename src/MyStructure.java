import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStructure extends NodeCollection implements IMyStructure {

  @Override
  public INode findByCode(String code) {
    return getNodeByPredicate(node -> node.getCode().equals(code));
  }

  @Override
  public INode findByRenderer(String renderer) {
    return getNodeByPredicate(node -> node.getRenderer().equals(renderer));
  }

  private INode getNodeByPredicate(Predicate<INode> iNodePredicate) {
    Optional<INode> any = getAllChildrenNodes()
      .filter(iNodePredicate)
      .findAny();
    return any.orElse(null);
  }

  @Override
  public int count() {
    return getAllChildrenNodes()
      .collect(Collectors.toList())
      .size();
  }

  private Stream<INode> getAllChildrenNodes() {
    return nodes.stream()
      .map(obj -> (ICompositeNode) obj)
      .flatMap(node -> node.getNodes().stream());
  }

}