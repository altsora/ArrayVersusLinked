package org.altsora.operations;

import org.altsora.Result;
import org.altsora.enums.TimeUnit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class IndexList extends AbstractOperation{
    protected List<Integer> arrayList;
    protected List<Integer> linkedList;

    protected IndexList(int capacity, TimeUnit timeUnit) {
        super(capacity, timeUnit);
    }

    protected void createArrayList(int capacity) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
    }

    protected void createLinkedList(int capacity) {
        linkedList = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(i);
        }
    }

    @Override
    protected Result calc(int capacity, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Работа без индекса не допускается");
    }
}
