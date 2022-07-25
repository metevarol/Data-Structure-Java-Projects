@SuppressWarnings("unchecked")
	 interface Collection<E> 
		{

		Iterator iterator();
		void add(E e);
		
		void addAll(Collection c);
		void clear();
		boolean contains(E e); 
		boolean containsAll(Collection c);
		boolean isEmpty();
		void remove(E e);
		void removeAll(Collection c);
		void retainAll(Collection c);
		
		int size();
		E get(int i);

	}