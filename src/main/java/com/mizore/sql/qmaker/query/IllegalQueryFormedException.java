package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 * 
 * @since 0.0.1
 * 
 *        Illegal SQL building state execption.
 */
public class IllegalQueryFormedException extends RuntimeException {

    private static final long serialVersionUID = -2858418558028898650L;

    /**
     * Create an IllegalQueryFormedException whith the given message.
     * 
     * @param message
     *            message output cause.
     */
    public IllegalQueryFormedException(String message) {
        super(message);
    }

}
