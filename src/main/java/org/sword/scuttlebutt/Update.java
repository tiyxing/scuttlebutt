package org.sword.scuttlebutt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tiyxing
 * @date 2019-11-10
 * @since 1.0.0
 */
@Setter
@Getter
@AllArgsConstructor
public class Update<T> {
    private String sourceId;
    private long timestamp;
    private BizData<T> bizData;
}
