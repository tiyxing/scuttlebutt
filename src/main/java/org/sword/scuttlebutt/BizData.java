package org.sword.scuttlebutt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tiyxing
 * @date 2019-11-10
 * @since 1.0.0
 */
@AllArgsConstructor
@Setter
@Getter
public class BizData<T> {
    private String key;

    private T value;
}
