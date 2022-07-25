
import java.util.*;

public class Main {


    public static void main(String[] args) {

        try{

        NavigableAVLTree<Integer> n1 = new NavigableAVLTree<Integer>();
        NavigableSkipList <Integer, Integer> n2 = new NavigableSkipList<>();
       
        SortedSet<Integer> headset = new TreeSet<Integer>();
        SortedSet<Integer> tailset = new TreeSet<Integer>();



        n1.insert(5);
        n1.insert(3);
        n1.insert(8);
        n1.insert(10);
        n1.insert(33);

        System.out.println("\n----------- NavigableAVLTree ------------");
        System.out.println("-----------------------------------------");

        System.out.println("- 5,3,8,10,33 are added to NavigableAVLTree.\n");

        System.out.println("- NavigableAVLTree Iterator created.\n");

        System.out.println("- NavigableAVLTree Iterator called 5 time :\n");


        Iterator<Integer> iter = n1.iterator();

        for(int i=0;i<5;i++){

            System.out.print(iter.next()+" ");
           
        }



        headset = n1.headSet(6);

        tailset = n1.tailSet(7);

        System.out.print("\n\n- headSet method performed(toElement = 6):  ");

        System.out.println(headset);

        System.out.print("- tailSet method performed(fromElement = 7):  ");

        System.out.println(tailset);

        System.out.println();

        //-------------------------------------------------------------------------------

        System.out.println("\n----------- NavigableSkipList ------------");
        System.out.println("-----------------------------------------");

        System.out.println("- 5,8,10 are added to NavigableSkipList.\n");

        System.out.println("- NavigableSkipList Iterator created.\n");

        System.out.println("- NavigableSkipList Iterator called 3 time :\n");

        Iterator<Integer> iter1 = n2.descendingIterator();

        n2.insert(1,6);
        n2.insert(2,8);
        n2.insert(3,10);

        iter1.next();
        System.out.println("Level 1 : "+n2.get(iter1.next())); 
        System.out.println("Level 2 : "+n2.get(iter1.next()));
        System.out.println("Level 3 : "+n2.get(iter1.next()));
        System.out.println("\nSize: "+n2.size());

        n2.delete(2);
        n2.delete(3);

        System.out.println("\nLevel 2 and Level 3 deleted :\n");

        Iterator<Integer> iter2 = n2.descendingIterator();

        System.out.println("Level 1 : "+n2.get(iter2.next())); 
        System.out.println("\nSize: "+n2.size());


        System.out.println();

        //-------------------------------------------------------------------------------

        BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();

        bst1.add(15);
        bst1.add(5);
        bst1.add(20);
        bst1.add(23);
        bst1.add(4);
        bst1.add(6);

        bst2.add(1);
        bst2.add(2);
        bst2.add(3);
        bst2.add(4);
        bst2.add(5);
      

        System.out.println("\n----------- BinarySearchTree Check(AVL or Not) ------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("- 15,5,20,23,4,6 are added to bst1(AVL Tree).\n");
        System.out.println("\t- BST's recursive checkAVL method called.");   
        System.out.print("\t- Check = ");   

        if(bst1.checkAVL())
            System.out.println("True");
        else
            System.out.println("False");

        System.out.println("\n- 1,2,3,4,5, are added to bst2(Not AVL Tree).\n");
        System.out.println("\t- BST's recursive checkAVL method called.");
        System.out.print("\t- Check = "); 

        if(bst2.checkAVL())
            System.out.println("True");
        else
            System.out.println("False");


        //----------------------------------------------------------------------------------------------------------------

        BinarySearchTree <Integer> bst10= new BinarySearchTree<Integer>();
        BinarySearchTree <Integer> bst20 = new BinarySearchTree<Integer>();
        BinarySearchTree <Integer> bst40 = new BinarySearchTree<Integer>();
        BinarySearchTree <Integer> bst80 = new BinarySearchTree<Integer>();

        AVLTree <Integer> avl10 = new AVLTree<Integer>();
        AVLTree <Integer> avl20 = new AVLTree<Integer>();
        AVLTree <Integer> avl40 = new AVLTree<Integer>();
        AVLTree <Integer> avl80 = new AVLTree<Integer>();

        RedBlackTree <Integer> rbt10 = new RedBlackTree <Integer>();
        RedBlackTree <Integer> rbt20 = new RedBlackTree <Integer>();
        RedBlackTree <Integer> rbt40 = new RedBlackTree <Integer>();
        RedBlackTree <Integer> rbt80 = new RedBlackTree <Integer>();

        TwoThreeFourTree <Integer> ttf10 = new TwoThreeFourTree <Integer>();
        TwoThreeFourTree <Integer> ttf20 = new TwoThreeFourTree <Integer>();
        TwoThreeFourTree <Integer> ttf40 = new TwoThreeFourTree <Integer>();
        TwoThreeFourTree <Integer> ttf80 = new TwoThreeFourTree <Integer>();


        Random rand = new Random();

        int rand_int;

        long startTime,stopTime;
        long b1,b2,b3,b4;

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){

            rand_int = rand.nextInt(1000);
            bst10.add(rand_int);
        }
        stopTime = System.nanoTime();

        b1 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<20000;i++){

            rand_int = rand.nextInt(1000);
            bst20.add(rand_int);
        }
        stopTime = System.nanoTime();

        b2 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<40000;i++){

            rand_int = rand.nextInt(1000);
            bst40.add(rand_int);
        }
        stopTime = System.nanoTime();

        b3 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<80000;i++){

            rand_int = rand.nextInt(1000);
            bst80.add(rand_int);
        }
        stopTime = System.nanoTime();

        b4 = stopTime - startTime;

        //------------------------------------------------------------------------------------------------------------------------

        long a1,a2,a3,a4;

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){

            rand_int = rand.nextInt(1000);
            avl10.add(rand_int);
        }
        stopTime = System.nanoTime();

        a1 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<20000;i++){

            rand_int = rand.nextInt(1000);
            avl20.add(rand_int);
        }
        stopTime = System.nanoTime();

        a2 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<40000;i++){

            rand_int = rand.nextInt(1000);
            avl40.add(rand_int);
        }
        stopTime = System.nanoTime();

        a3 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<80000;i++){

            rand_int = rand.nextInt(1000);
            avl80.add(rand_int);
        }
        stopTime = System.nanoTime();

        a4 = stopTime - startTime;


        //------------------------------------------------------------------------------------------------------------------------

        long r1,r2,r3,r4;

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){

            rand_int = rand.nextInt(1000);
            rbt10.add(rand_int);
        }
        stopTime = System.nanoTime();

        r1 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<20000;i++){

            rand_int = rand.nextInt(1000);
            rbt20.add(rand_int);
        }
        stopTime = System.nanoTime();

        r2 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<40000;i++){

            rand_int = rand.nextInt(1000);
            rbt40.add(rand_int);
        }
        stopTime = System.nanoTime();

        r3 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<80000;i++){

            rand_int = rand.nextInt(1000);
            rbt80.add(rand_int);
        }
        stopTime = System.nanoTime();

        r4 = stopTime - startTime;


        //------------------------------------------------------------------------------------------------------------------------

        long t1,t2,t3,t4;

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){

            rand_int = rand.nextInt(1000);
            ttf10.add(rand_int);
        }
        stopTime = System.nanoTime();

        t1 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<20000;i++){

            rand_int = rand.nextInt(1000);
            ttf20.add(rand_int);
        }
        stopTime = System.nanoTime();

        t2 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<40000;i++){

            rand_int = rand.nextInt(1000);
            ttf40.add(rand_int);
        }
        stopTime = System.nanoTime();

        t3 = stopTime - startTime;

        startTime = System.nanoTime();
        for(int i=0;i<80000;i++){

            rand_int = rand.nextInt(1000);
            ttf80.add(rand_int);
        }
        stopTime = System.nanoTime();

        t4 = stopTime - startTime;

        //------------------------------------------------------------------------------------------------------------------------        

        System.out.println("\n------------Average Running Times------------");
        System.out.println("---------------------------------------------");

        System.out.println("\n10000 number:\n");

        System.out.println("BinarySearchTree : "+b1);
        System.out.println("AVLTree : "+a1);
        System.out.println("RedBlackTree : "+r1);
        System.out.println("TwoThreeFourTree : "+t1);

        System.out.println("\n20000 number:\n");

        System.out.println("BinarySearchTree : "+b2);
        System.out.println("AVLTree : "+a2);
        System.out.println("RedBlackTree : "+r2);
        System.out.println("TwoThreeFourTree : "+t2);

        System.out.println("\n40000 number:\n");

        System.out.println("BinarySearchTree : "+b3);
        System.out.println("AVLTree : "+a3);
        System.out.println("RedBlackTree : "+r3);
        System.out.println("TwoThreeFourTree : "+t3);

        System.out.println("\n80000 number:\n");

        System.out.println("BinarySearchTree : "+b4);
        System.out.println("AVLTree : "+a4);
        System.out.println("RedBlackTree : "+r4);
        System.out.println("TwoThreeFourTree : "+t4);

    } catch (Exception e){
      System.out.println("Error");
    }

    
}
}