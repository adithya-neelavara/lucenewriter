package com.acc.lucene.lucenewriter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSequenceGenerator {

    private AtomicInteger value = new AtomicInteger(1);

    public int getNext() {
        return value.getAndIncrement();
    }
}