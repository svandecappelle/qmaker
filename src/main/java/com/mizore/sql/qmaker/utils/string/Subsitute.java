package com.mizore.sql.qmaker.utils.string;

import java.io.Serializable;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Substitute interface. Need to substituate a value with another.
 */
public interface Subsitute extends Serializable {

    /**
     * The value data to replace.
     * 
     * @return the replacement String.
     */
    String getValue();

    /**
     * The replacement pattern need to be replaced.
     * 
     * @return the key to replace.
     */
    String getReplacementPattern();
}
