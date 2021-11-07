package org.altsora;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.altsora.enums.TimeUnit;

@Data
@AllArgsConstructor
public class CapacityUnit {
    private int capacity;
    private TimeUnit timeUnit;
}
