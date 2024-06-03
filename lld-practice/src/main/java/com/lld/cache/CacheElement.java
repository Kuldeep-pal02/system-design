package com.lld.cache;

public class CacheElement<K,V> {
    private K key;
    private V value;
    public CacheElement( K k, V v){
        this.key = k;
        this.value = v;
    }

    public V getValue(){
        return this.value;
    }
}
