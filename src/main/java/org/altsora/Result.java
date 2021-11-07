package org.altsora;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.altsora.enums.Winner;
import org.altsora.enums.OperationType;
import org.altsora.enums.Place;
import org.altsora.enums.TimeUnit;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private OperationType operationType;
    private String capacity;
    private Place place;
    private String arrayTime;
    private String linkedTime;
    private TimeUnit unit;
    private Winner winner;
}
