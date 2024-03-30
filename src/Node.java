import java.util.ArrayList;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import jersey.repackaged.com.google.common.hash.HashCode;

public class Node<T> {
  private T data;
  private static int globalID;
  private int nodeID;
  private ArrayList<Node<T>> links;

  public Node(T data) {
    this.data = data;
  }

  public Node(T data, ArrayList<Node<T>> links) {
    this.setNodeID();
    this.data = data;
    this.links = links;
  }
  public Node(T data,Node<T> link) {
    this.setNodeID();
    this.data = data;
    links = new ArrayList<>();
    links.add(link);
  }
  public void addTwoWayLink(Node<T> node){
    for (Node<T> link:links){
      if (link.equals(node)){ //If we find the node we're looking to add in our links list
        return; //leave the function
      }
    }
    links.add(node);
    node.addTwoWayLink(this);
  }

//  public Node<T> filter(Predicate<T> p){
//
//  }
//
//  public Node<T> filterHelper(ArrayList<Node<T>> searched,Predicate<T> p){
//    if
//
//
//
//    return
//  }
  public int fold(Function<T,Integer> function,Integer starVal){
    return this.foldHelper(new ArrayList<Node<T>>(),function,starVal);
  }

  private int foldHelper(ArrayList<Node<T>> nodesChecked,Function<T,Integer> function,Integer starVal){
    for (Node<T> node:nodesChecked){ //Check if we've already done this node
      if (node.equals(this)){
        return starVal;
      }
    nodesChecked.add(this); //Mark ourselves checked
    for (Node<T> linkedNode:links){ //Have all our children check their nodes
      starVal +=linkedNode.foldHelper(nodesChecked,function,starVal);
    }
    starVal += function.apply(this.data);
    }
    return starVal;//return the value
  }

  private void setNodeID(){
    nodeID = ++globalID;
  }


  public int getNodeID() {
    return nodeID;
  }

  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (!(o instanceof Node)){
      return false;
    }
    T otherData = (T) o;
    return (this.data.equals(otherData));
  }
  @Override
  public int hashCode(){
    return Objects.hash(this.nodeID);
  }
}
