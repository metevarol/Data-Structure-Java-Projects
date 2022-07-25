import java.util.*;

public class Main{


	@SuppressWarnings("unchecked")
	public static void main(String[] arg){

		//------------------------------------------------------------MAPITERATOR TEST------------------------------------------------
		
		System.out.println();
		System.out.println("**************** MAPITERATOR TEST **************");
		System.out.println();

		MapIterator<String,Integer> map = new MapIterator<String,Integer>();

		map.put("Alex",10);
		map.put("Ronaldo",7);
		map.put("Neuer",1);
		map.put("Zidane",5);
		map.put("Messi",10);
		map.put("Benzema",9);
		map.put("Pirlo",21);

		System.out.println();
		System.out.println(map);

		System.out.println("-MapIterator created..");
		System.out.println();
		
		System.out.println();
		System.out.println("-next method performed 10 time");
		System.out.println();
		
		for(int i=0;i<10;i++){

		System.out.println(map.next());	

		}
	
		System.out.println();
		System.out.println("-prev method performed 15 time");
		System.out.println();

		for(int i=0;i<10;i++){

		System.out.println(map.prev());	

		}
		

		MapIterator<String,Integer> map2 = new MapIterator<String,Integer>("Zidane");

		map2.put("Alex",10);
		map2.put("Ronaldo",7);
		map2.put("Neuer",1);
		map2.put("Zidane",5);
		map2.put("Messi",10);
		map2.put("Benzema",9);
		map2.put("Pirlo",21);

		System.out.println("\n-Iterator set to 'Alex' with one parameter constructor...\n");


		System.out.println("Alex is the first element. hasNext method performed after 'Alex'");
		System.out.println(map2.hasNext());

		MapIterator<String,Integer> map3 = new MapIterator<String,Integer>("Messi");

		map3.put("Alex",10);
		map3.put("Ronaldo",7);
		map3.put("Neuer",1);
		map3.put("Zidane",5);
		map3.put("Messi",10);
		map3.put("Benzema",9);
		map3.put("Pirlo",21);

		System.out.println("\n-Iterator set to 'Messi' with one parameter constructor...\n");


		System.out.println("Messi is the last element. hasNext method performed after 'Messi'");
		map3.next();
		System.out.println(map3.hasNext());


		MapIterator<String,Integer> map4 = new MapIterator<String,Integer>("Zidane");

		map4.put("Alex",10);
		map4.put("Ronaldo",7);
		map4.put("Neuer",1);
		map4.put("Zidane",5);
		map4.put("Messi",10);
		map4.put("Benzema",9);
		map4.put("Pirlo",21);

		System.out.println("\n-Iterator set to 'Zidane' with one parameter constructor...\n");

		System.out.println("-next method performed 5 time");
		System.out.println();

		for(int i=0;i<5;i++){

		System.out.println(map4.next());	

		}

		
		System.out.println();
		System.out.println("**************** HashtableChainLinkedList Test **************");
		System.out.println();

		long startTime1 = System.nanoTime();

		HashtableChainLinkedList<Integer,String> map5 = new HashtableChainLinkedList<Integer,String>();

		map5.put(3,"Alex");
		map5.put(12,"Ronaldo");
		map5.put(13,"Neuer");
		map5.put(53,"Messi");
		map5.put(23,"Zidane");
		map5.put(73,"Maradona");
		map5.put(42,"Hazard");


		System.out.println();
		System.out.println("Elements added to Hashtable with put method");
		System.out.println();


		System.out.println();
		System.out.println("Get method called for each element");
		System.out.println();

		System.out.println(map5.get(3));
		System.out.println(map5.get(12));
		System.out.println(map5.get(13));
		System.out.println(map5.get(53));
		System.out.println(map5.get(23));
		System.out.println(map5.get(73));
		System.out.println(map5.get(42));

		System.out.println();
		System.out.println("3 element removed");
		System.out.println();

		map5.remove(3);
		map5.remove(13);
		map5.remove(53);

		System.out.println();
		System.out.println("Get method called for each element again");
		System.out.println();

		System.out.println(map5.get(3));
		System.out.println(map5.get(12));
		System.out.println(map5.get(13));
		System.out.println(map5.get(53));
		System.out.println(map5.get(23));
		System.out.println(map5.get(73));
		System.out.println(map5.get(42));

		long stopTime1 = System.nanoTime();

		System.out.println();
		System.out.println("**************** HashtableChainTreeSet Test **************");
		System.out.println();

		long startTime2 = System.nanoTime();

		HashtableChainTreeSet<Integer,String> map6 = new HashtableChainTreeSet<Integer,String>();

		map6.put(3,"Kaka");
		map6.put(12,"Ronaldo");
		map6.put(13,"Dida");
		map6.put(53,"Shevchenko");
		map6.put(23,"Gattuso");
		map6.put(73,"Inzaghi");
		map6.put(42,"Seedorf");


		System.out.println();
		System.out.println("Elements added to Hashtable with put method");
		System.out.println();


		System.out.println();
		System.out.println("Get method called for each element");
		System.out.println();

		System.out.println(map6.get(3));
		System.out.println(map6.get(12));
		System.out.println(map6.get(13));
		System.out.println(map6.get(53));
		System.out.println(map6.get(23));
		System.out.println(map6.get(73));
		System.out.println(map6.get(42));

		System.out.println();
		System.out.println("3 element removed");
		System.out.println();

		map6.remove(3);
		map6.remove(42);
		map6.remove(12);

		System.out.println();
		System.out.println("Get method called for each element again");
		System.out.println();

		System.out.println(map6.get(3));
		System.out.println(map6.get(12));
		System.out.println(map6.get(13));
		System.out.println(map6.get(53));
		System.out.println(map6.get(23));
		System.out.println(map6.get(73));
		System.out.println(map6.get(42));

		long stopTime2 = System.nanoTime();

		System.out.println();
		System.out.println("**************** HashtableCoalesced Test (SIZE 10) **************");
		System.out.println();

		long startTime3 = System.nanoTime();

		HashtableCoalesced<Integer,String> map7 = new HashtableCoalesced<Integer,String>(10);

		map7.put(3,"Kaka");
		map7.put(12,"Ronaldo");
		map7.put(13,"Seedorf");
		map7.put(25,"Dida");
		map7.put(23,"Shevchenko");
		map7.put(51,"Gattuso");
		map7.put(42,"Inzaghi");


		System.out.println();
		System.out.println("Elements added to Hashtable with put method");
		System.out.println();

		System.out.println();
		System.out.println("Get method called for each element");
		System.out.println();

		System.out.println(map7.get(3));
		System.out.println(map7.get(12));
		System.out.println(map7.get(13));
		System.out.println(map7.get(25));
		System.out.println(map7.get(23));
		System.out.println(map7.get(51));
		System.out.println(map7.get(42));

		System.out.println();
		System.out.println("Hashtable View:");
		System.out.println();

		map7.printTable();

		System.out.println();
		System.out.println("3 element removed(3,42,12)");
		System.out.println();

		map7.remove(3);
		map7.remove(42);
		map7.remove(12);

		System.out.println();
		System.out.println("Hashtable View:");
		System.out.println();

		map7.printTable();

		System.out.println();
		System.out.println("Get method called for each element again");
		System.out.println();

		System.out.println(map7.get(3));
		System.out.println(map7.get(12));
		System.out.println(map7.get(13));
		System.out.println(map7.get(25));
		System.out.println(map7.get(23));
		System.out.println(map7.get(51));
		System.out.println(map7.get(42));


		long stopTime3 = System.nanoTime();

		System.out.println();
		System.out.println("**************** HashtableCoalesced Test (SIZE 100) **************");
		System.out.println();

		HashtableCoalesced<Integer,String> map8 = new HashtableCoalesced<Integer,String>(100);

		map8.put(3,"Kaka");
		map8.put(12,"Ronaldo");
		map7.put(13,"Seedorf");
		map8.put(25,"Dida");
		map8.put(23,"Shevchenko");
		map8.put(51,"Gattuso");
		map8.put(42,"Inzaghi");


		System.out.println();
		System.out.println("Elements added to Hashtable with put method");
		System.out.println();

		System.out.println();
		System.out.println("Get method called for each element");
		System.out.println();

		System.out.println(map8.get(3));
		System.out.println(map8.get(12));
		System.out.println(map8.get(13));
		System.out.println(map8.get(25));
		System.out.println(map8.get(23));
		System.out.println(map8.get(51));
		System.out.println(map8.get(42));

		System.out.println();
		System.out.println("3 element removed(51,42,25)");
		System.out.println();

		map8.remove(51);
		map8.remove(42);
		map8.remove(25);

		System.out.println();
		System.out.println("Get method called for each element again");
		System.out.println();

		System.out.println(map8.get(3));
		System.out.println(map8.get(12));
		System.out.println(map8.get(13));
		System.out.println(map8.get(25));
		System.out.println(map8.get(23));
		System.out.println(map8.get(51));
		System.out.println(map8.get(42));

				System.out.println();
		System.out.println("**************** HashtableCoalesced Test (SIZE 1000) **************");
		System.out.println();

		HashtableCoalesced<Integer,String> map9 = new HashtableCoalesced<Integer,String>(1000);

		map9.put(3,"Kaka");
		map9.put(12,"Ronaldo");
		map9.put(13,"Seedorf");
		map9.put(25,"Dida");
		map9.put(23,"Shevchenko");
		map9.put(51,"Gattuso");
		map9.put(42,"Inzaghi");


		System.out.println();
		System.out.println("Elements added to Hashtable with put method");
		System.out.println();

		System.out.println();
		System.out.println("Get method called for each element");
		System.out.println();

		System.out.println(map9.get(3));
		System.out.println(map9.get(12));
		System.out.println(map9.get(13));
		System.out.println(map9.get(25));
		System.out.println(map9.get(23));
		System.out.println(map9.get(51));
		System.out.println(map9.get(42));

		System.out.println();
		System.out.println("3 element removed(3,25,23)");
		System.out.println();

		map9.remove(3);
		map9.remove(25);
		map9.remove(23);

		System.out.println();
		System.out.println("Get method called for each element again");
		System.out.println();

		System.out.println(map9.get(3));
		System.out.println(map9.get(12));
		System.out.println(map9.get(13));
		System.out.println(map9.get(25));
		System.out.println(map9.get(23));
		System.out.println(map9.get(51));
		System.out.println(map9.get(42));


		System.out.println();
		System.out.println("**************** Performance Results of 3 Different Tables for Same Tasks **************");
		System.out.println();


		System.out.println("HashtableChainLinkedList time in nanoseconds : "+(stopTime1 - startTime1));
		System.out.println();
		System.out.println("HashtableChainTreeSet time in nanoseconds : "+(stopTime2 - startTime2));
		System.out.println();
		System.out.println("HashtableCoalesced time in nanoseconds : "+(stopTime3 - startTime3));
		System.out.println();
		
	}
}