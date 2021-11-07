package org.altsora.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimeUnit {
    NANOSECONDS("ns"),
    MILLISECONDS("ms");
    private final String desc;
}
