import java.util.List;
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
    Optional<INode> any = getAllNodes().stream()
      .filter(iNodePredicate)
      .findAny();
    return any.orElse(null);
  }

  @Override
  public int count() {
    return getAllNodes().size();
  }

  private List<INode> getAllNodes() {
    return nodes.stream()
      .map(obj -> (ICompositeNode) obj)
      .flatMap(MyStructure::getChildNodes)
      .collect(Collectors.toList());
  }

  private static Stream<INode> getChildNodes(ICompositeNode node) {
    return Stream.concat(
      Stream.of(node),
      node.getNodes().stream()
        .map(obj -> (ICompositeNode) obj)
        .flatMap(MyStructure::getChildNodes)
    );
  }

}