package com.manom.interview.questions;

public interface CustomMap<K, E> {
    void add(E element);
    boolean remove(K key);
}
