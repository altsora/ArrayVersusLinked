package org.altsora.operations;


import org.altsora.Result;
import org.altsora.enums.OperationType;
import org.altsora.enums.Place;
import org.altsora.enums.TimeUnit;
import org.altsora.enums.Winner;

import java.util.List;

public class SetOperation extends IndexList {
    public SetOperation(int capacity, TimeUnit timeUnit) {
        super(capacity, timeUnit);
    }

    @Override
    protected Result calc(int capacity, TimeUnit timeUnit, Place place, int index) {
        System.out.println("=== SET ===");
        System.out.println("Capacity: " + prettyCapacity);
        System.out.println("Place: " + place.getDesc());
        createArrayList(capacity);
        createLinkedList(capacity);
        long arrayTime = checkTime(ARRAY_LIST, timeUnit, () -> set(arrayList, index));
        long linkedTime = checkTime(LINKED_LIST, timeUnit, () -> set(linkedList, index));
        Winner winner = getWinner(arrayTime, linkedTime);
        System.out.println("-".repeat(repeatSeparate));

        return Result.builder()
                .operationType(OperationType.SET)
                .capacity(prettyCapacity)
                .place(place)
                .arrayTime(prettyNumber(arrayTime))
                .linkedTime(prettyNumber(linkedTime))
                .unit(timeUnit)
                .winner(winner)
                .build();
    }

    private void set(List<Integer> list, int index) {
        list.set(index, -1);
    }
}
