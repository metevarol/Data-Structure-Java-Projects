	import java.util.*;

	public class Main{

	@SuppressWarnings("unchecked")
	public static void main(String[] arg)
	{
		System.out.println("---------------------------MaxHeap Test-----------------------------");
		System.out.println();
		System.out.println();

		System.out.println("The Max Heap is ");

		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(500);
		MaxHeap<Integer> maxHeap2 = new MaxHeap<Integer>(500);
		Iterator iter = maxHeap.iterator();
	
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);

		maxHeap2.insert(90);
		maxHeap2.insert(23);
		maxHeap2.insert(66);
		maxHeap2.insert(7);
		maxHeap2.insert(2);

		System.out.println();
		System.out.println("maxHeap1 and maxHeap2 created successfully..");
		System.out.println();

		System.out.println("maxHeap1:\n");
		maxHeap.print();
		System.out.println();

		System.out.println("maxHeap2:\n");
		maxHeap2.print();
		System.out.println();

		System.out.println("Search operation occured for element 22. Position of 22 : "+maxHeap.findElement(22,1));
		System.out.println("Search operation occured for element 9. Position of 9 : "+maxHeap.findElement(9,1));
		System.out.println("Search operation occured for element 90. Position of 90 : "+maxHeap2.findElement(90,1));
		System.out.println("Search operation occured for element 7. Position of 7 : "+maxHeap2.findElement(7,1));

		System.out.println();
		System.out.println();

		System.out.println("Merge operation occured for maxHeap1(maxHeap2).");

		maxHeap.mergeHeaps(maxHeap2);

		System.out.println();
		System.out.println();
		

		System.out.println("New maxHeap1:\n");
		maxHeap.print();

		System.out.println();
		System.out.println();

		System.out.println("Removing ith largest element operation occured.");
		System.out.println();
		System.out.println();


		System.out.println("Removed 3th largest element from maxHeap1. 3th largest element = "+ maxHeap.removeTh(3));
		System.out.println();
		System.out.println();

		System.out.println("New maxHeap1:\n");
		maxHeap.print();


		System.out.println();
		System.out.println();

		System.out.println("Iterator created for maxHeap1..");
		System.out.println();

		System.out.println("Five time move with Iterator:");	

		for(int i=0;i<5;i++){

			System.out.println("-"+iter.next());
		}

		

		System.out.println();
		System.out.println();

		System.out.println("Set last element to 15 when loop count = 3...");
		//iter.setLast(15);
		
		System.out.println("Five time move with Iterator:");	
		iter = maxHeap.iterator();
		for(int i=0;i<5;i++){

			System.out.println("-"+iter.next());

			if(i==2)
				iter.setLast(15);
		}

		System.out.println();
		System.out.println();


		System.out.println("--------------------------BSTHeapTree Test---------------------------");

		System.out.println();
		System.out.println();
		
		BSTHeapTree<Integer> myTree = new BSTHeapTree<Integer>();

		HashSet<Integer> modset = new HashSet<Integer>();
		HashSet<Integer> modset2 = new HashSet<Integer>();

		int []array = new int[3000];
		
		for (int i = 0; i < 3000; i++){
			int r = (int)(Math.random() * 5000) + 1;
			array[i] = r;
			myTree.add(r);
		}


		Arrays.sort(array);

		int res;

		for(int j=0;j<100;j++){
			res=0;
		for (int i=0; i<3000; i++)
            if (array[j] == array[i])
              res++;

        System.out.println(array[j]+" = "+res);	
		}
        
        int testarr[] = {7033,5001,6001,7777,8676,9685,6744,7455,6555,8455};

        System.out.println();
        System.out.println();

		for(int j=0;j<10;j++){
			res=0;
		for (int i=0; i<3000; i++)
            if (testarr[j] == array[i])
              res++;

        System.out.println(testarr[j]+" = "+res);	
		}

		 int maxValue = 0, maxCount = 0, i, j;

      	for (i = 0; i < 3000; i++) {
         int count = 0;
         for (j = 0; j < 3000; ++j) {
            if (array[j] == array[i])
            ++count;
         }

         	if (count > maxCount) {
            maxCount = count;
            maxValue = array[i];
         	}
      	}

     

      	for (i = 0; i < 3000; i++) {
         int count = 0;
         for (j = 0; j < 3000; j++) {
            if (array[j] == array[i]){
             ++count;
            }
         }
         	if (count == maxCount) {
            modset.add(array[i]);
         	}
      	}

		System.out.println();
      	System.out.println("Number of occurrences test completed.(100 numbers in the array and 10 numbers not in the array)");   
      	System.out.println();

		System.out.println("Manuel mode calculation with array:(all modes)\n");
		System.out.println(modset);

		System.out.println();

		System.out.println("find_mode method:(all modes)");
		System.out.println();
		myTree.find_mode();


		for(j=0;j<80;j++){
		
			myTree.remove(array[j]);
		}

		maxValue = 0; 
		maxCount = 0;

      	for (i = 100; i < 3000; i++) {
         int count = 0;
         for (j = 100; j < 3000; ++j) {
            if (array[j] == array[i])
            ++count;
         }

         	if (count > maxCount) {
            maxCount = count;
            maxValue = array[i];
         	}
      	}

     

      	for (i = 100; i < 3000; i++) {
         int count = 0;
         for (j = 100; j < 3000; j++) {
            if (array[j] == array[i]){
             ++count;
            }
         }
         	if (count == maxCount) {
            modset2.add(array[i]);
         	}
      	}



		System.out.println();
		System.out.println();
		System.out.println("****************   Removal operation completed   ******************");
		System.out.println();
		System.out.println("After remove:\n");

		System.out.println("Manuel mode calculation with array:(all modes)\n");
		System.out.println(modset2);

		System.out.println();

		System.out.println("find_mode method:(all modes)");
		System.out.println();
		myTree.find_mode();
		System.out.println();



	}
}