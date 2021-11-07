package org.altsora.operations;

import org.altsora.Result;
import org.altsora.enums.Place;
import org.altsora.enums.TimeUnit;
import org.altsora.enums.Winner;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOperation {
    protected static final String ARRAY_LIST = "ArrayList";
    protected static final String LINKED_LIST = "LinkedList";
    protected int capacity;
    protected TimeUnit timeUnit;
    protected int repeatSeparate = 30;
    protected String prettyCapacity;

    protected AbstractOperation(int capacity, TimeUnit timeUnit) {
        this.capacity = capacity;
        this.timeUnit = timeUnit;
        this.prettyCapacity = prettyNumber(capacity);
    }

    public final Result runNoIndex() {
        return calc(capacity, timeUnit);
    }

    public final List<Result> runIndex() {
        List<Result> out = new ArrayList<>();
        out.add(calc(capacity, timeUnit, Place.BEGIN, 0));
        out.add(calc(capacity, timeUnit, Place.MIDDLE, capacity / 2));
        out.add(calc(capacity, timeUnit, Place.END, capacity - 1));
        return out;
    }

    protected abstract Result calc(int capacity, TimeUnit timeUnit);

    protected Result calc(int capacity, TimeUnit timeUnit, Place place, int index) {
        throw new UnsupportedOperationException("Операция в абстрактном классе не реализована");
    }

    protected static long checkTime(String list, TimeUnit timeUnit, Runnable task) {
        String format = "%-10s: %10s %s";
        if (timeUnit == TimeUnit.NANOSECONDS) {
            long startNano = System.nanoTime();
            task.run();
            long resNano = System.nanoTime() - startNano;
            System.out.printf(format + "%n", list, resNano, "ns");
            return resNano;
        }
        long start = System.currentTimeMillis();
        task.run();
        long res = System.currentTimeMillis() - start;
        System.out.printf(format + "%n", list, res, "ms");
        return res;
    }

    protected static Winner getWinner(long arrayTime, long linkedTime) {
        if (arrayTime < linkedTime) {
            System.out.println(ARRAY_LIST + " is faster");
            return Winner.ARRAY_LIST;
        } else if (linkedTime < arrayTime) {
            System.out.println(LINKED_LIST + " is faster");
            return Winner.LINKED_LIST;
        } else {
            System.out.println(ARRAY_LIST + " eq " + LINKED_LIST);
            return Winner.EQUAL;
        }
    }

    protected String prettyNumber(long number) {
        return String.format("%,d", number).replaceAll("\\D", "_");
    }
}
