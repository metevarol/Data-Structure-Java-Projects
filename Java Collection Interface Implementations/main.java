import java.util.Scanner;

public class main{

	@SuppressWarnings("unchecked")
	public static void main(String [] args)throws RuntimeException{

		Scanner input = new Scanner(System.in);
		int menu;

		 ArrayList<Integer> arrInt1 = new ArrayList<Integer>();
		 ArrayList<Integer> arrInt2 = new ArrayList<Integer>();
		 ArrayList<String> arrStr1 = new ArrayList<String>();
		 ArrayList<String> arrStr2 = new ArrayList<String>();

		 HashSet<Integer> hashInt1 = new HashSet<Integer>();
		 HashSet<Integer> hashInt2 = new HashSet<Integer>();
		 HashSet<String> hashStr1 = new HashSet<String>();
		  HashSet<String> hashStr2 = new HashSet<String>();

		 LinkedList<Integer> linkInt1 = new LinkedList<Integer>();
		 LinkedList<Integer> linkInt2 = new LinkedList<Integer>();
		 LinkedList<String> linkStr1 = new LinkedList<String>();
		 LinkedList<String> linkStr2 = new LinkedList<String>();

		Iterator arr_it1 = arrInt1.iterator();
		Iterator arr_it2 = arrInt2.iterator();
		Iterator hash_it1 = hashStr1.iterator();
		Iterator hash_it2 = hashStr2.iterator();
		Iterator link_it1 = linkInt1.iterator();
		Iterator link_it2 = linkInt2.iterator();
while(true){
		System.out.println("--------MENU-------");
		System.out.println("Test all method for:");
		System.out.println("\t1.ArrayList(Integer)");
		System.out.println("\t2.HashSet(String)");
		System.out.println("\t3.LinkedList(Integer)");
		System.out.println("\t4.Exit");
		System.out.println("Please choose one:");

		menu = input.nextInt();
		
//--------------------------------------------------------ARRAY LIST DEMO---------------------------------------------------------------------
			if(menu==1){
		 	System.out.println("elements added to first ArrayList(14,43,13,51)");
				arrInt1.add(14);     	  
				arrInt1.add(43);		  
				arrInt1.add(13);		  
				arrInt1.add(51);
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());	

			System.out.println("elements added to second ArrayList(23,67,31)");
				arrInt2.add(23); 
				arrInt2.add(67);
				arrInt2.add(31); 
			for(int i=0;i<arrInt2.size();i++)
			System.out.println("-"+arr_it2.next());
			arr_it2 = arrInt2.iterator();
			System.out.println("size = "+arrInt2.size());	
			System.out.println();
		
			System.out.println("second ArrayList added to first ArrayList (addAll)");
			
			arrInt1.addAll(arrInt2);
	
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());
			System.out.println();	

			System.out.println("contains(67) called for last ArrayList:");
			if(arrInt1.contains(67))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			System.out.println("containsAll(second ArrayList) called for last ArrayList:");
			if(arrInt1.containsAll(arrInt1))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();
			System.out.println("isEmpty called for last ArrayList:");
			if(arrInt1.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			System.out.println("element 14 removed from last ArrayList:");
			arrInt1.remove(14);
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());
			System.out.println();	

			System.out.println("second ArrayList removed from last ArrayList:");
			arrInt1.removeAll(arrInt2);
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());
			System.out.println();	

			System.out.println("add second ArrayList again:");
			arrInt1.addAll(arrInt2);
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());
			System.out.println();	

			System.out.println("retain second ArrayList only:");
			arrInt1.retainAll(arrInt2);
			for(int i=0;i<arrInt1.size();i++)
			System.out.println("-"+arr_it1.next());
			arr_it1 = arrInt1.iterator();
			System.out.println("size = "+arrInt1.size());
			System.out.println();

			System.out.println("lastly clear method called:");
			arrInt1.clear();
			System.out.println("size = "+arrInt1.size());
			System.out.println();

			System.out.println("isEmpty called for last ArrayList:");
			if(arrInt1.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();
		}
//------------------------------------------HASHLIST DEMO---------------------------------------------------------------------
			if(menu==2){
			System.out.println("elements added to first HashList(add method) duplicate elements not added");
				hashStr1.add("Arsenal"); 
				hashStr1.add("Arsenal");     	  	  
				hashStr1.add("Leeds United");
				hashStr1.add("Chelsea");
				hashStr1.add("Tottenham Hotspur");
				hashStr1.add("Burnley");
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();	

			System.out.println("elements added to second HashList(add) duplicate elements not added");
				hashStr2.add("Manchester United"); 
				hashStr2.add("Liverpool");
				hashStr2.add("Everton"); 
			for(int i=0;i<hashStr2.size();i++)
			System.out.println("-"+hash_it2.next());
			hash_it2 = hashStr2.iterator();
			System.out.println("size = "+hashStr2.size());
			System.out.println();	

		
			System.out.println("second HashList added to first HashList (addAll)");
			
				hashStr1.addAll(hashStr2);
	
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();	

			System.out.println("contains(Liverpool) called for last HashList:");
			if(hashStr1.contains("Liverpool"))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			System.out.println("containsAll(second HashList) called for last HashList:");
			if(hashStr1.containsAll(hashStr1))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();
			System.out.println("isEmpty called for last HashList:");
			if(hashStr1.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			System.out.println("element Leeds United removed from last HashList:");
			hashStr1.remove("Leeds United");
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();	

			System.out.println("second HashList removed from last HashList:");
			hashStr1.removeAll(hashStr2);
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();	

			System.out.println("add second HashList again:");
			hashStr1.addAll(hashStr2);
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();	

			System.out.println("retain second HashList only:");
			hashStr1.retainAll(hashStr2);
			for(int i=0;i<hashStr1.size();i++)
			System.out.println("-"+hash_it1.next());
			hash_it1 = hashStr1.iterator();
			System.out.println("size = "+hashStr1.size());
			System.out.println();

			System.out.println("lastly clear method called:");
			hashStr1.clear();
			System.out.println("size = "+hashStr1.size());
			System.out.println();

			System.out.println("isEmpty called for last HashList:");
			if(hashStr1.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();
		}
//--------------------------------------------------------LINKED LIST DEMO---------------------------------------------------------------------
			if(menu==3){
			System.out.println("elements added to first LinkedList(14,43,13,51)");
				linkInt1.add(14);     	  
				linkInt1.add(43);		  
				linkInt1.add(13);		  
				linkInt1.add(51);
			for(int i=0;i<linkInt1.size();i++)
			System.out.println("-"+link_it1.next());
			link_it1 = linkInt1.iterator();
			System.out.println("size = "+linkInt1.size());	

			System.out.println("elements added to second LinkedList(23,67,31)");
				linkInt2.add(23); 
				linkInt2.add(67);
				linkInt2.add(31); 
			for(int i=0;i<linkInt2.size();i++)
			System.out.println("-"+link_it2.next());
			link_it2 = linkInt2.iterator();
			System.out.println("size = "+linkInt2.size());	
			System.out.println();
		
			System.out.println("second LinkedList added to first LinkedList (addAll)");
			
				linkInt1.addAll(linkInt2);
	
			for(int i=0;i<linkInt1.size();i++)
			System.out.println("-"+link_it1.next());
			link_it1 = linkInt1.iterator();
			System.out.println("size = "+linkInt1.size());
			System.out.println();	

			System.out.println("contains(67) called for last LinkedList:");
			if(linkInt1.contains(67))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			System.out.println("containsAll(second LinkedList) called for last LinkedList:");
			if(linkInt1.containsAll(linkInt1))
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();
			System.out.println("isEmpty called for last LinkedList:");
			if(linkInt1.isEmpty())
				System.out.println("true");
			else
				System.out.println("false");
			System.out.println();

			try{
			System.out.println("remove method called for last LinkedList:");
			linkInt1.remove(14);
			}catch(RuntimeException e){
			System.out.println(e);
			}
			System.out.println();	

			try{
			System.out.println("removeAll method called for last LinkedList:");
			linkInt1.removeAll(linkInt2);
			}catch(RuntimeException e){
			System.out.println(e);
			}
			System.out.println();

			try{
			System.out.println("retainAll method called for last LinkedList:");
			linkInt1.retainAll(linkInt2);
			}catch(RuntimeException e){
			System.out.println(e);
			}
			System.out.println();

			try{
			System.out.println("clear method called for last LinkedList:");
			linkInt1.clear();
			}catch(RuntimeException e){
			System.out.println(e);
			}
			System.out.println();

			System.out.println("element method called for last LinkedList:");
			System.out.println("first element of LinkedList:"+linkInt1.element());
			System.out.println();

			System.out.println("offer method called and elements offered to LinkedList(23,67,31):");
				linkInt1.offer(23); 
				linkInt1.offer(67);
				linkInt1.offer(31); 
			for(int i=0;i<linkInt1.size();i++)
			System.out.println("-"+link_it1.next());
			link_it1 = linkInt1.iterator();
			System.out.println("size = "+linkInt1.size());	
			System.out.println();

			System.out.println("poll method called and removed first element of last LinkedList:");
				linkInt1.poll();  
			for(int i=0;i<linkInt1.size();i++)
			System.out.println("-"+link_it1.next());
			link_it1 = linkInt1.iterator();
			System.out.println("size = "+linkInt1.size());	
			System.out.println();
		}
			if(menu==4){
				break;
			}

	}
		
	
	}

}

