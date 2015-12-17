class Entry <K, V> {
	K key;
	V value;
	Entry <K, V> next;

	public Entry(K key, V value, Entry<K, V> next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

class HashMap <K, V> {

	Entry<K, V>[] table;
	int capacity = 10;

	public HashMap(){
		table = new Entry[capacity];
	}

	public int hash(K key){
		return Math.abs(key.hashCode()) % capacity;
	}

	public void put(K newKey, V data){
		if (newKey == null){
			return;
		}

		int hash = hash(newKey);
		Entry<K, V> newEntry = new Entry<K, V> (newKey, data, null);

		if (table[hash] == null){
			table[hash] = newEntry;
		}
		else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];

			while(current != null){
				if(current.key.equals(newKey)){
					if(previous == null){
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}
					else{
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}

	}

	public V get (K newKey){
		int hash = hash(newKey);

		if (table[hash] == null){
			return null;
		}
		else{
			Entry<K, V> tempEntry = table[hash];
			while(tempEntry != null){
				if(tempEntry.key.equals(newKey))
					return tempEntry.value;
				else
					tempEntry = tempEntry.next;
			}
			return null;
		}

	}
	
	public boolean remove(K deleteKey){

		int hash = hash(deleteKey);

		if (table[hash] == null){
			return false;
		}
		else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];

			while(current != null){
				if(current.key.equals(deleteKey)){
					if(previous == null){
						table[hash] = current.next;
						return true;
					}
					else{
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}

	//Expensive process. O(n)
	public void display(){
		for(int i=0;i<capacity;i++){
           if(table[i]!=null){
                  Entry<K, V> entry=table[i];
                  while(entry!=null){
                        System.out.println("{"+entry.key+"="+entry.value+"}" +" ");
                        entry=entry.next;
                  }
           }
       }

	}

	public static void main(String[] args){
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		hMap.put(21, 12);
		hMap.put(22, 121);
		hMap.put(23, 122);
		hMap.put(24, 125);
		hMap.put(26, 128);

		System.out.println(hMap.get(21));
		hMap.display();

		hMap.remove(24);
		hMap.display();

	}

}