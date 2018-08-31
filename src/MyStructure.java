import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

  private List<INode> nodes = new ArrayList<>();

  private MyIterator iterator() {
    return new MyIterator(nodes);
  }

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
    List<INode> list = new ArrayList<>();
    iterator().forEachRemaining(list::add);
    return list;
  }

  void addNode(INode node) {
    nodes.add(node);
  }

}