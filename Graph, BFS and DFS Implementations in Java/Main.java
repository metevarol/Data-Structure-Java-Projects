import java.util.*;
@SuppressWarnings("deprecation")
public class Main{

	public static void dijkstrasAlgorithm(Graph graph,int start,int[] pred,double[] dist,char operation,int grtype) {

	    int numV = graph.getNumV();
	
	    PriorityQueue < Integer > vMinusS = new PriorityQueue < Integer > (numV);
	    // Initialize V-S.
	    for (int i = 0; i < numV; i++) {
	      if (i != start) {
	        vMinusS.add(i);
	      }
	    }
	    // Initialize pred and dist.
	    for (int v : vMinusS) {
	      pred[v] = start;

	      if(graph.getEdge(start, v).edgetype == 0)
      		dist[v] = graph.getEdge(start, v).getWeight();

      	  if(graph.getEdge(start, v).edgetype == 1)
      		dist[v] = graph.getEdge(start, v).getTime();

      	  if(graph.getEdge(start, v).edgetype == 2)
      		dist[v] = graph.getEdge(start, v).getQuality();

	    }

	    // Main loop

	    while (vMinusS.size() != 0) {
	      // Find the value u in V-S with the smallest dist[u].
	      double minDist = Double.POSITIVE_INFINITY;
	      int u = -1;
	      for (int v : vMinusS) {
	        if (dist[v] < minDist) {
	          minDist = dist[v];
	          u = v;
	        }
	      }
	      // Remove u from vMinusS.
	      vMinusS.remove(u);
	      // Update the distances.
	      if(grtype==0){

		      for (int v : vMinusS) {
		        if (graph.isEdge(u, v)) {

		        	if(graph.getEdge(u, v).edgetype == 0){
		        		double weight = graph.getEdge(u, v).getWeight();
		        			if(operation=='+'){
			        			if (dist[u] + weight < dist[v]) {
				            		dist[v] = dist[u] + weight;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * weight < dist[v]) {
				            		dist[v] = dist[u] * weight;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + weight - dist[u]* weight )< dist[v]) {
				            		dist[v] = (dist[u] + weight - dist[u]* weight);
				            		pred[v] = u;
				          		}	
		        			}

			          		
		        	}


		        	if(graph.getEdge(u, v).edgetype == 1){
		        		int time = graph.getEdge(u, v).getTime();
		        			if(operation=='+'){
			        			if (dist[u] + time < dist[v]) {
				            		dist[v] = dist[u] + time;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * time < dist[v]) {
				            		dist[v] = dist[u] * time;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + time - dist[u]* time) < dist[v]) {
				            		dist[v] = (dist[u] + time - dist[u]* time);
				            		pred[v] = u;
				          		}	
		        			}
		        	}


		        	if(graph.getEdge(u, v).edgetype == 2){
		        		float quality = graph.getEdge(u, v).getQuality();
		        			if(operation=='+'){
			        			if (dist[u] + quality < dist[v]) {
				            		dist[v] = dist[u] + quality;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * quality < dist[v]) {
				            		dist[v] = dist[u] * quality;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + quality - dist[u]* quality )< dist[v]) {
				            		dist[v] =(dist[u] + quality - dist[u]* quality);
				            		pred[v] = u;
				          		}	
		        			}
		        	}		          
		        }
		      }

		  } else{

		  		Iterator<Edge> edgeIter = graph.edgeIterator(u);
		  		while (edgeIter.hasNext()) {
		  			Edge edge = edgeIter.next();
					int v = edge.getDest();
					if (vMinusS.contains(new Integer(v))){
						if(edge.edgetype==0){

						double weight = edge.getWeight(); 
		        			if(operation=='+'){
			        			if (dist[u] + weight < dist[v]) {
				            		dist[v] = dist[u] + weight;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * weight < dist[v]) {
				            		dist[v] = dist[u] * weight;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + weight - dist[u]* weight )< dist[v]) {
				            		dist[v] = (dist[u] + weight - dist[u]* weight);
				            		pred[v] = u;
				          		}	
		        			}

						}
						if(edge.edgetype==1){
						int time = edge.getTime();
						   if(operation=='+'){
			        			if (dist[u] + time < dist[v]) {
				            		dist[v] = dist[u] + time;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * time < dist[v]) {
				            		dist[v] = dist[u] * time;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + time - dist[u]* time) < dist[v]) {
				            		dist[v] = (dist[u] + time - dist[u]* time);
				            		pred[v] = u;
				          		}	
		        			}

						}
						if(edge.edgetype==2){

						float quality = edge.getQuality();
							if(operation=='+'){
			        			if (dist[u] + quality < dist[v]) {
				            		dist[v] = dist[u] + quality;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='x'){
			        			if (dist[u] * quality < dist[v]) {
				            		dist[v] = dist[u] * quality;
				            		pred[v] = u;
				          		}	
		        			}
		        			if(operation=='*'){
			        			if ((dist[u] + quality - dist[u]* quality )< dist[v]) {
				            		dist[v] =(dist[u] + quality - dist[u]* quality);
				            		pred[v] = u;
				          		}	
		        			}


						}

					}
		  		}

		  }



	    }
	
  	}

	public static void main(String[] args) {

		try{

		System.out.println("---- HOMEWORK 8 TEST CASES ----\n");

		//------------------ PART 1 ----------------------------
		
		System.out.println("---- PART 1 ----\n");

		System.out.println("-- Q1 --\n");

		Graph grList = new ListGraph(5,true);
		Graph grMatrix = new MatrixGraph(5,true);

		Edge e1 = new Edge(0,1,10.0);
		Edge e2 = new Edge(0,4,100.0);
		Edge e3 = new Edge(0,3,30.0);
		Edge e4 = new Edge(1,2,50.0);
		Edge e5 = new Edge(2,4,10.0);
		Edge e6 = new Edge(3,2,20.0);
		Edge e7 = new Edge(3,4,60.0);

		grMatrix.insert(e1);
		grMatrix.insert(e2);
		grMatrix.insert(e3);
		grMatrix.insert(e4);
		grMatrix.insert(e5);
		grMatrix.insert(e6);
		grMatrix.insert(e7);

		grList.insert(e1);
		grList.insert(e2);
		grList.insert(e3);
		grList.insert(e4);
		grList.insert(e5);
		grList.insert(e6);
		grList.insert(e7);

		Iterator < Edge > grListiter1 = grList.edgeIterator(0);
		Iterator < Edge > grListiter2 = grList.edgeIterator(1);
		Iterator < Edge > grListiter3 = grList.edgeIterator(2);
		Iterator < Edge > grListiter4 = grList.edgeIterator(3);
		Iterator < Edge > grListiter5 = grList.edgeIterator(4);

		Iterator < Edge > grMatrixiter1 = grMatrix.edgeIterator(0);
		Iterator < Edge > grMatrixiter2 = grMatrix.edgeIterator(1);
		Iterator < Edge > grMatrixiter3 = grMatrix.edgeIterator(2);
		Iterator < Edge > grMatrixiter4 = grMatrix.edgeIterator(3);
		Iterator < Edge > grMatrixiter5 = grMatrix.edgeIterator(4);

		System.out.println("Directed ListGraph created : \n");
		System.out.println("  S  D   Weight Time Quality");

		while(grListiter1.hasNext()) System.out.println(grListiter1.next());
		while(grListiter2.hasNext()) System.out.println(grListiter2.next());
		while(grListiter3.hasNext()) System.out.println(grListiter3.next());
		while(grListiter4.hasNext()) System.out.println(grListiter4.next());
		while(grListiter5.hasNext()) System.out.println(grListiter5.next());

		System.out.println("\nDirected MatrixGraph created : \n");
		System.out.println("  S  D   Weight Time Quality");

		while(grMatrixiter1.hasNext()) System.out.println(grMatrixiter1.next());
		while(grMatrixiter2.hasNext()) System.out.println(grMatrixiter2.next());
		while(grMatrixiter3.hasNext()) System.out.println(grMatrixiter3.next());
		while(grMatrixiter4.hasNext()) System.out.println(grMatrixiter4.next());
		while(grMatrixiter5.hasNext()) System.out.println(grMatrixiter5.next());

		int [] predList = new int[5];
		double [] distList = new double[5];
		int [] predMatrix = new int[5];
		double [] distMatrix = new double[5];


		long startList = System.nanoTime();
		dijkstrasAlgorithm(grList,0,predList,distList,'+',1);
		long stopList = System.nanoTime();

		System.out.println("\nDijkstra's algorithm called for ListGraph : \n");

		for(int i=1;i<5;i++) System.out.println(distList[i]);

		long startMatrix = System.nanoTime();
		dijkstrasAlgorithm(grMatrix,0,predMatrix,distMatrix,'+',0);
		long stopMatrix = System.nanoTime();

		System.out.println("\nDijkstra's algorithm called for MatrixGraph : \n");

		for(int i=1;i<5;i++) System.out.println(distMatrix[i]);
		

		System.out.println("\nRunning times for two different type of graph with the same edges : ");
		System.out.println("\nListGraph =  "+(stopList-startList));
		System.out.println("\nMatrixGraph =  "+(stopMatrix-startMatrix));

		System.out.println("\n-- Q2 --\n");

		Graph grList2 = new ListGraph(4,true);
		Graph grList3 = new ListGraph(4,true);
		Graph grList4 = new ListGraph(4,true);

		Edge t1 = new Edge(0,1,1);
		Edge t2 = new Edge(1,2,3);
		Edge t3 = new Edge(1,3,5);

		Edge q1 = new Edge(0,1,20.0f);
		Edge q2 = new Edge(1,2,30.0f);
		Edge q3 = new Edge(1,3,15.0f);

		Edge w1 = new Edge(0,1,25.8);
		Edge w2 = new Edge(1,2,34.3);
		Edge w3 = new Edge(1,3,43.1);

		grList2.insert(t1);grList2.insert(t2);grList2.insert(t3);
		grList3.insert(q1);grList3.insert(q2);grList3.insert(q3);
		grList4.insert(w1);grList4.insert(w2);grList4.insert(w3);


		System.out.println("Directed ListGraph created (Time) : \n");
		System.out.println("  S  D   Weight Time Quality");

		Iterator < Edge > grListiter6 = grList2.edgeIterator(0);
		Iterator < Edge > grListiter7 = grList2.edgeIterator(1);
		Iterator < Edge > grListiter8 = grList2.edgeIterator(2);
		Iterator < Edge > grListiter9 = grList2.edgeIterator(3);

		while(grListiter6.hasNext()) System.out.println(grListiter6.next());
		while(grListiter7.hasNext()) System.out.println(grListiter7.next());
		while(grListiter8.hasNext()) System.out.println(grListiter8.next());
		while(grListiter9.hasNext()) System.out.println(grListiter9.next());

		System.out.println("Directed ListGraph created (Quality) : \n");
		System.out.println("  S  D   Weight Time Quality");

		Iterator < Edge > grListiter10 = grList3.edgeIterator(0);
		Iterator < Edge > grListiter11 = grList3.edgeIterator(1);
		Iterator < Edge > grListiter12 = grList3.edgeIterator(2);
		Iterator < Edge > grListiter13 = grList3.edgeIterator(3);

		while(grListiter10.hasNext()) System.out.println(grListiter10.next());
		while(grListiter11.hasNext()) System.out.println(grListiter11.next());
		while(grListiter12.hasNext()) System.out.println(grListiter12.next());
		while(grListiter13.hasNext()) System.out.println(grListiter13.next());

		int [] predTime = new int[4];
		double [] distTime = new double[4];
		int [] predQuality = new int[4];
		double [] distQuality = new double[4];

		dijkstrasAlgorithm(grList2,0,predTime,distTime,'+',1);

		System.out.println("\nDijkstra's algorithm for Time : \n");

		for(int i=1;i<4;i++) System.out.println(distTime[i]);

		dijkstrasAlgorithm(grList3,0,predQuality,distQuality,'+',1);

		System.out.println("\nDijkstra's algorithm for Quality : \n");

		for(int i=1;i<4;i++) System.out.println(distQuality[i]);

		System.out.println("\n-- Q3 --\n");

		System.out.println("Directed ListGraph created : \n");
		System.out.println("  S  D   Weight Time Quality");

		grListiter1 = grList.edgeIterator(0);
		grListiter2 = grList.edgeIterator(1);
		grListiter3 = grList.edgeIterator(2);
		grListiter4 = grList.edgeIterator(3);
		grListiter5 = grList.edgeIterator(4);

		while(grListiter1.hasNext()) System.out.println(grListiter1.next());
		while(grListiter2.hasNext()) System.out.println(grListiter2.next());
		while(grListiter3.hasNext()) System.out.println(grListiter3.next());
		while(grListiter4.hasNext()) System.out.println(grListiter4.next());
		while(grListiter5.hasNext()) System.out.println(grListiter5.next());

		int [] predAdd = new int[5];
		double [] distAdd = new double[5];
		int [] predMult = new int[5];
		double [] distMult = new double[5];
		int [] predStar = new int[5];
		double [] distStar = new double[5];

		dijkstrasAlgorithm(grList,0,predAdd,distAdd,'+',1);


		System.out.println("\nDijkstra's algorithm for '+' operator : \n");

		for(int i=1;i<5;i++) System.out.println(distAdd[i]);

		dijkstrasAlgorithm(grList,0,predMult,distMult,'x',1);

		System.out.println("\nDijkstra's algorithm for 'x' operator : \n");

		for(int i=1;i<5;i++) System.out.println(distMult[i]);

		dijkstrasAlgorithm(grList,0,predStar,distStar,'*',1);

		System.out.println("\nDijkstra's algorithm for '*' operator : \n");

		for(int i=1;i<5;i++) System.out.println(distStar[i]);


		
		//------------------ PART 2 ----------------------------
		
		System.out.println("---- PART 2 ----\n");
		Graph gr1 = new ListGraph(500,false);
		Graph gr2 = new ListGraph(1000,false);
		Graph gr3 = new ListGraph(2000,false);
		Graph gr4 = new ListGraph(5000,false);
		Graph gr5 = new ListGraph(10000,false);

		Graph gr6 = new MatrixGraph(500,false);
		Graph gr7 = new MatrixGraph(1000,false);
		Graph gr8 = new MatrixGraph(2000,false);
		Graph gr9 = new MatrixGraph(5000,false);
		Graph gr10 = new MatrixGraph(10000,false);

		int d;
		Random rand = new Random();

		for(int i=0;i<500;i++){ d = rand.nextInt((499 - 0) + 1) + 0;  Edge e = new Edge(i,d);  gr1.insert(e); }
		for(int i=0;i<1000;i++){ d = rand.nextInt((999 - 0) + 1) + 0;  Edge e = new Edge(i,d);  gr2.insert(e); }
		for(int i=0;i<2000;i++){ d = rand.nextInt((1999 - 0) + 1) + 0;  Edge e = new Edge(i,d);  gr3.insert(e); }
		for(int i=0;i<5000;i++){ d = rand.nextInt((4999 - 0) + 1) + 0;  Edge e = new Edge(i,d);  gr4.insert(e); }
		for(int i=0;i<10000;i++){ d = rand.nextInt((9999 - 0) + 1) + 0;  Edge e = new Edge(i,d);  gr5.insert(e); }
	
		long dfs1_f = System.nanoTime();	
		DepthFirstSearch dfscount1 = new DepthFirstSearch(gr1);
		long dfs1_l = System.nanoTime();

		long bfs1_f = System.nanoTime();	
		BreadthFirstSearch bfscount1 = new BreadthFirstSearch(gr1,0);
		long bfs1_l = System.nanoTime();

		System.out.println("Check count functions : \n");

		System.out.println("DFS = "+dfscount1.getConnected());
		System.out.println("BFS = "+dfscount1.getConnected());

		System.out.println();
		//------------------------- 2  -------------------------
		long dfs2_f = System.nanoTime();
		DepthFirstSearch dfscount2 = new DepthFirstSearch(gr2);
		long dfs2_l = System.nanoTime();
		
		long bfs2_f = System.nanoTime();
		BreadthFirstSearch bfscount2 = new BreadthFirstSearch(gr2,0);
		long bfs2_l = System.nanoTime();
		//------------------------- 3 -------------------------
		
		long dfs3_f = System.nanoTime();
		DepthFirstSearch dfscount3 = new DepthFirstSearch(gr3);
		long dfs3_l = System.nanoTime();
		
		long bfs3_f = System.nanoTime();
		BreadthFirstSearch bfscount3 = new BreadthFirstSearch(gr3,0);
		long bfs3_l = System.nanoTime();
		//------------------------- 4  -------------------------
		long dfs4_f = System.nanoTime();
		DepthFirstSearch dfscount4 = new DepthFirstSearch(gr4);
		long dfs4_l = System.nanoTime();
		
		long bfs4_f = System.nanoTime();
		BreadthFirstSearch bfscount4 = new BreadthFirstSearch(gr4,0);
		long bfs4_l = System.nanoTime();
		//------------------------- 5  -------------------------
		long dfs5_f = System.nanoTime();
		DepthFirstSearch dfscount5 = new DepthFirstSearch(gr5);
		long dfs5_l = System.nanoTime();
		
		long bfs5_f = System.nanoTime();
		BreadthFirstSearch bfscount5 = new BreadthFirstSearch(gr5,0);
		long bfs5_l = System.nanoTime();
		
	
		System.out.println("Results : \n");
		System.out.println("500 : BFS = "+(bfs1_l-bfs1_f)+" DFS = "+(dfs1_l-dfs1_f));
		System.out.println("1000 : BFS = "+(bfs2_l-bfs2_f)+" DFS = "+(dfs2_l-dfs2_f));
		System.out.println("2000 : BFS = "+(bfs3_l-bfs3_f)+" DFS = "+(dfs3_l-dfs3_f));
		System.out.println("5000 : BFS = "+(bfs4_l-bfs4_f)+" DFS = "+(dfs4_l-dfs4_f));
		System.out.println("10000 : BFS = "+(bfs5_l-bfs5_f)+" DFS = "+(dfs5_l-dfs5_f));
		
	 } catch (Exception e){
      	System.out.println("Error");
    	}
		//------------------ PART 3 ----------------------------



	}
}