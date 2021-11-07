package org.altsora;

import org.altsora.enums.TimeUnit;
import org.altsora.operations.*;

import java.util.ArrayList;
import java.util.List;

import static org.altsora.enums.TimeUnit.MILLISECONDS;
import static org.altsora.enums.TimeUnit.NANOSECONDS;

public class Application {
    private static final Writer writer = Writer.getWriter();

    public static void main(String[] args) {
        add();
        get();
        set();
        insert();
        removeByIndex();
        removeByObject();

        writer.createFile();
    }

    private static void add() {
        List<Result> results = new ArrayList<>();
        results.add(new AddOperation(100, NANOSECONDS).runNoIndex());
        results.add(new AddOperation(100_000, NANOSECONDS).runNoIndex());
        results.add(new AddOperation(1_000_000, MILLISECONDS).runNoIndex());
        results.add(new AddOperation(10_000_000, MILLISECONDS).runNoIndex());
        results.add(new AddOperation(30_000_000, MILLISECONDS).runNoIndex());
        writer.write(results);
        writer.emptyLine();
    }

    private static void get() {
        get(100, NANOSECONDS);
        get(100_000, NANOSECONDS);
        get(1_000_000, NANOSECONDS);
        get(10_000_000, NANOSECONDS);
        get(30_000_000, NANOSECONDS);
    }

    private static void set() {
        set(100, NANOSECONDS);
        set(100_000, NANOSECONDS);
        set(1_000_000, NANOSECONDS);
        set(10_000_000, NANOSECONDS);
        set(30_000_000, NANOSECONDS);
    }

    private static void insert() {
        insert(100, NANOSECONDS);
        insert(100_000, NANOSECONDS);
        insert(1_000_000, NANOSECONDS);
        insert(10_000_000, NANOSECONDS);
        insert(30_000_000, NANOSECONDS);
    }

    private static void removeByIndex() {
        removeByIndex(100, NANOSECONDS);
        removeByIndex(100_000, NANOSECONDS);
        removeByIndex(1_000_000, NANOSECONDS);
        removeByIndex(10_000_000, NANOSECONDS);
        removeByIndex(30_000_000, NANOSECONDS);
    }

    private static void removeByObject() {
        removeByObject(100, NANOSECONDS);
        removeByObject(100_000, NANOSECONDS);
        removeByObject(1_000_000, NANOSECONDS);
        removeByObject(10_000_000, NANOSECONDS);
        removeByObject(30_000_000, NANOSECONDS);
    }

    private static void get(int capacity, TimeUnit unit) {
        List<Result> results = new GetOperation(capacity, unit).runIndex();
        writer.write(results);
        writer.emptyLine();
    }

    private static void set(int capacity, TimeUnit unit) {
        List<Result> results = new SetOperation(capacity, unit).runIndex();
        writer.write(results);
        writer.emptyLine();
    }

    private static void insert(int capacity, TimeUnit unit) {
        List<Result> results = new InsertOperation(capacity, unit).runIndex();
        writer.write(results);
        writer.emptyLine();
    }

    private static void removeByObject(int capacity, TimeUnit unit) {
        List<Result> results = new RemoveByObjectOperation(capacity, unit).runIndex();
        writer.write(results);
        writer.emptyLine();
    }

    private static void removeByIndex(int capacity, TimeUnit unit) {
        List<Result> results = new RemoveByIndexOperation(capacity, unit).runIndex();
        writer.write(results);
        writer.emptyLine();
    }
}
