package org.altsora.operations;

import org.altsora.Result;
import org.altsora.enums.OperationType;
import org.altsora.enums.Place;
import org.altsora.enums.TimeUnit;
import org.altsora.enums.Winner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddOperation extends AbstractOperation {

    public AddOperation(int capacity, TimeUnit timeUnit) {
        super(capacity, timeUnit);
    }

    @Override
    protected Result calc(int capacity, TimeUnit timeUnit) {
        System.out.println("=== ADD ===");
        System.out.println("Capacity: " + prettyCapacity);
        long arrayTime  = checkTime(ARRAY_LIST,  timeUnit, () -> add(new ArrayList<>(),  capacity));
        long linkedTime = checkTime(LINKED_LIST, timeUnit, () -> add(new LinkedList<>(), capacity));
        Winner winner = getWinner(arrayTime, linkedTime);
        System.out.println("-".repeat(repeatSeparate));
        return Result.builder()
                .operationType(OperationType.ADD)
                .capacity(prettyCapacity)
                .place(Place.NAN)
                .arrayTime(prettyNumber(arrayTime))
                .linkedTime(prettyNumber(linkedTime))
                .unit(timeUnit)
                .winner(winner)
                .build();
    }

    private void add(List<Integer> list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }
}
