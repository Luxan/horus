import java.util.*;

class MyIterator implements Iterator<INode> {

  private Deque<INode> stack = new LinkedList<>();

  MyIterator(List<INode> nodes) {
    stack.addAll(nodes);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public INode next() {
    if(stack.isEmpty()){
      throw new NoSuchElementException();
    }
    INode node = stack.pop();
    if (node != null) {
      if (node instanceof ICompositeNode) {
        ICompositeNode compositeNode = (ICompositeNode) node;
        stack.addAll(compositeNode.getNodes());
      }
    }
    return node;
  }

}

