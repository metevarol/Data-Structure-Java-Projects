import java.util.*;

/** Class to implement the depth-first search algorithm.
*   @author Koffman and Wolfgang
* */

public class DepthFirstSearch {

  /** A reference to the graph being searched. */
  private Graph graph;

  /** Array of parents in the depth-first search tree. */
  private int[] parent;

  /** Flag to indicate whether this vertex has been visited. */
  private boolean[] visited;

  /** The array that contains each vertex in discovery order. */
  private int[] discoveryOrder;

  /** The array that contains each vertex in finish order. */
  private int[] finishOrder;

  /** The index that indicates the discovery order. */
  private int discoverIndex = 0;

  /** The index that indicates the finish order. */
  private int finishIndex = 0;

  /** The counter that count the number of connected components. */
  private int numberOfConnectedComponents = 0;

  /** Construct the depth-first search of a Graph
      starting at vertex 0 and visiting the start vertices in
      ascending order.
      @param graph The graph
   */
  public DepthFirstSearch(Graph graph) {
    this.graph = graph;
    int n = graph.getNumV();
    parent = new int[n];
    visited = new boolean[n];
    discoveryOrder = new int[n];
    finishOrder = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]){
        depthFirstSearch(i);
        numberOfConnectedComponents++;
      }  
    }
  }

  /** Recursively depth-first search the graph
      starting at vertex current.
      @param current The start vertex
   */
  public void depthFirstSearch(int current) {
    visited[current] = true;
    discoveryOrder[discoverIndex++] = current;

    Iterator < Edge > itr = graph.edgeIterator(current);
    while (itr.hasNext()) {
      int neighbor = itr.next().getDest();
     
      if (!visited[neighbor]) {
        parent[neighbor] = current;
        depthFirstSearch(neighbor);
      }
    }
    finishOrder[finishIndex++] = current;
  }

  /** Get the finish order
      @return finish order
   */
  public int[] getFinishOrder() {
    return finishOrder;
  }

  /** Get the number of connected components
     @return number of connected components
  */
  public int getConnected(){
    return numberOfConnectedComponents;
  }

}
