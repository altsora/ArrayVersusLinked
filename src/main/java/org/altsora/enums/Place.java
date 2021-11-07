package org.altsora.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Place {
    NAN("-"),
    BEGIN("begin"),
    MIDDLE("middle"),
    END("end");
    private final String desc;
}
