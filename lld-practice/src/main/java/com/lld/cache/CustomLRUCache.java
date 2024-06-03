package com.lld.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomLRUCache<K,V> implements Cache<K, V> {
    private int capacity;
    private Map<K, LinkedListNode<CacheElement<K,V>>> linkedListNodeMap;
    private DoublyLL<CacheElement<K,V>> doublyLL;


    public CustomLRUCache( int capacity){
        this.capacity = capacity;
        this.linkedListNodeMap = new HashMap<>();
        this.doublyLL = new DoublyLL<>();
    }

    @Override
    public boolean put(K key, V value) {
        CacheElement<K,V> item = new CacheElement<K,V>(key, value);
        LinkedListNode<CacheElement<K, V>> newNode = null;
        if( this.linkedListNodeMap.containsKey( key )){
            LinkedListNode<CacheElement<K,V>> node = this.linkedListNodeMap.get( key);
            newNode = doublyLL.updateAndMoveToFront( node, item);

        }else{
            if( this.size() >= capacity){
                this.evictElement();
                newNode = this.doublyLL.add( item);
            }
        }
        if( newNode.isEmpty()){
            return false;
        }
        return true;
    }

    private void evictElement() {
    }

    @Override
    public V get(K key) {
        LinkedListNode<CacheElement<K,V>> linkedListNode = this.linkedListNodeMap.get( key );
        if( linkedListNode != null && !linkedListNode.isEmpty()){
            linkedListNodeMap.put( key , this.doublyLL.moveToFrom( linkedListNode));
            linkedListNode.getElement().getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return this.linkedListNodeMap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedListNodeMap.isEmpty();
    }

    @Override
    public void clear() {
        this.linkedListNodeMap.clear();
        this.doublyLL = null;

    }
}
