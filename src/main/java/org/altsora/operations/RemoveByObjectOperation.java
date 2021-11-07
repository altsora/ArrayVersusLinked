package org.altsora.operations;

import org.altsora.Result;
import org.altsora.enums.OperationType;
import org.altsora.enums.Place;
import org.altsora.enums.TimeUnit;
import org.altsora.enums.Winner;

import java.util.List;

public class RemoveByObjectOperation extends IndexList {
    public RemoveByObjectOperation(int capacity, TimeUnit timeUnit) {
        super(capacity, timeUnit);
    }

    @Override
    protected Result calc(int capacity, TimeUnit timeUnit, Place place, int index) {
        System.out.println("=== REMOVE BY OBJECT ===");
        System.out.println("Capacity: " + prettyCapacity);
        System.out.println("Place: " + place.getDesc());
        createArrayList(capacity);
        createLinkedList(capacity);
        long arrayTime  = checkTime(ARRAY_LIST,  timeUnit, () -> remove(arrayList, index));
        long linkedTime = checkTime(LINKED_LIST, timeUnit, () -> remove(linkedList, index));
        Winner winner = getWinner(arrayTime, linkedTime);
        System.out.println("-".repeat(repeatSeparate));
        return Result.builder()
                .operationType(OperationType.REMOVE_BY_OBJECT)
                .capacity(prettyCapacity)
                .place(place)
                .arrayTime(prettyNumber(arrayTime))
                .linkedTime(prettyNumber(linkedTime))
                .unit(timeUnit)
                .winner(winner)
                .build();
    }

    private void remove(List<Integer> list, int value) {
        list.remove(Integer.valueOf(value));
    }
}
