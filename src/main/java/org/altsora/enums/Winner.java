package org.altsora.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Winner {
    ARRAY_LIST("ArrayList"),
    LINKED_LIST("LinkedList"),
    EQUAL("Равны");
    private final String desc;
}
