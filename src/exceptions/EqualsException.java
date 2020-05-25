/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author diegoa.torres
 */
public class EqualsException extends Exception {

    /**
     * Creates a new instance of <code>EqualsException</code> without detail
     * message.
     */
    public EqualsException() {
    }

    /**
     * Constructs an instance of <code>EqualsException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public EqualsException(String msg) {
        super(msg);
    }
}
