import java.util.List;

public interface ICompositeNode extends INode {

  List<INode> getNodes();

  void addChildNode(INode node);

}
