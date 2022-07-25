import java.util.*;

/** Class to implement the breadth-first search algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BreadthFirstSearch {

  /** Number of connexted components. */
  private int numberOfConnectedComponents = 1;
  /** Parent arr to BFS. */
  private int [] parent;
  /** Parent arr2 to BFS. */
  private int [] parent2;
  /** identified boolean arr to BFS. */
  private boolean [] identified;

  /** Main set to count connected components. */
  public Set<Set<Integer>> bigset = new HashSet<Set<Integer>>();

  /** Constructor that counts number of component. */
  public BreadthFirstSearch(Graph graph, int start){

   Set<Integer> set = new HashSet<Integer>();

    breadthFirstSearch(graph,start); 
    parent2 = parent.clone();


    for(int i = 0;i<graph.getNumV();i++){
      if(parent[i]!=-1)
       set.add(i);
    }
      bigset.add(set);
      set.clear();
      

    for(int i = 1;i<graph.getNumV();i++){ 

            if(parent2[i]==-1){

                 breadthFirstSearch(graph,i);  

                  for(int j = 0;j<graph.getNumV();j++){
                        if(parent[j]!=-1)
                            set.add(j);
                      }
                  bigset.add(set);
                  set.clear();
                   
        }
    }

    numberOfConnectedComponents = bigset.size();
  }
  
  /** Getter for connected
   * @return number of connexted components
   * */ 
  public int getConnected(){

    return numberOfConnectedComponents;
  }
  /** Perform a breadth-first search of a graph.
      post: The array parent will contain the predecessor
            of each vertex in the breadth-first
            search tree.
      @param graph The graph to be searched
      @param start The start vertex
   */
  public void breadthFirstSearch(Graph graph, int start) {
    Queue < Integer > theQueue = new LinkedList < Integer > ();
    // Declare array parent and initialize its elements to -1.
    parent = new int[graph.getNumV()];
    for (int i = 0; i < graph.getNumV(); i++) {
      parent[i] = -1;
    }
    // Declare array identified and
    // initialize its elements to false.
    identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
    identified[start] = true;
    theQueue.offer(start);
    /* While the queue is not empty */
    while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
      int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
      Iterator < Edge > itr = graph.edgeIterator(current);
      
      while (itr.hasNext()) {
        Edge edge = itr.next();
        int neighbor = edge.getDest();
        // If neighbor has not been identified
        if (!identified[neighbor]) {
          // Mark it identified.
          identified[neighbor] = true;
          // Place it into the queue.
          theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
          parent[neighbor] = current;
         
        }
        

      }


      // Finished visiting current.
      
    }
  }
}
