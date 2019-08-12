/**
 * 
 */
package com.xpto.cadastro.facade.rest.exception;

public class CadastroApplicationException extends Exception {

	private static final long serialVersionUID = -5991854317032417225L;
	
	public CadastroApplicationException() {}

    public CadastroApplicationException(String message) {
        super(message);
    }

    public CadastroApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CadastroApplicationException(Throwable cause) {
        super(cause);
    }
}
