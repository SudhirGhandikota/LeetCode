package LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Implements LeetCode LRU Cache question.
 * uses a modified implementation of LinkedHashMap DS.
 * LinkedHashMap is a linked list implementation of the Map Interface(https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html)
 * It maintains a doubly-linked list running through all the entries to maintain the insertion order
 * removeEldestEntry() method overridden and set a return value of true to automatically remove the oldest item in the map
 */
public class LRUCache_Mod extends LinkedHashMap<Integer,Integer>{
	private int cacheSize;
	
	public LRUCache_Mod(int size)
	{
		super(size,0.75f,true);
		this.cacheSize = size;
	}
	
	/*
	 * Returns 'true' if Map should remove oldest entry. So returning true value will enable the map to remove the oldest used value automatically
	 * We need not remove the value manually
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
	{
		//removes the oldest element when size limit is reached
		return size()>cacheSize;
	}
	/*
	 * returns the key value if it exists. If not returns -1
	 */
	public Integer get(int key)
	{
		if(this.containsKey(key))
			return super.get(key);
		else
			return -1;
	}
	/*
	 * If the key exists, it removes the key and re-adds it again to make it the least recently used(latest) one
	 * else it directly adds the new key,value pair
	 */
	public void set(int key, int value)
	{
		if(this.containsKey(key))
			this.remove(key);
		this.put(key, value);
		
	}
	
	public static void main(String args[])
	{
		LRUCache_Mod cache = new LRUCache_Mod(3);
		cache.set(1, 44);
		System.out.println(cache.get(1));
	}

}
