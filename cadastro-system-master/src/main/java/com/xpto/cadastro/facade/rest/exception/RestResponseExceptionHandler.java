/**
 * 
 */
package com.xpto.cadastro.facade.rest.exception;

import javax.persistence.PersistenceException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe para manipulação global de exceptions da aplicação. Atuando semelhante a um interceptor.
 */
@RestControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	 private HttpHeaders headers;

    // Erro 500

    @ExceptionHandler({CadastroApplicationException.class, PersistenceException.class, NullPointerException.class, RuntimeException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final Exception ex, final WebRequest request) {

    	 headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	     
	     HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	     
       return handleExceptionInternal(ex, new Error(request, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex), headers, status, request);
    }
    
    public class Error {

    	private String mensagemErro;
    	private int status;
    	private String pathDetalhe;
    	private String causa;
    	private String tipoException;
    	private String stackTrace;
    	private String linkDocumentacaoErro;
    	@JsonIgnore
    	private Exception exception;
		
    	
    	public Error(WebRequest request, int status, Exception exception) {

    		this.mensagemErro = exception.getMessage();
    		this.status = status;
    		this.pathDetalhe = request.toString();
			this.exception = exception;
			this.causa = exception.getCause() == null ? "Indefinido" : exception.getCause().toString();
			this.tipoException = exception.getClass().getSimpleName();
			this.stackTrace = ExceptionUtils.getStackTrace(exception);
			this.linkDocumentacaoErro = "www.site.com.br/";
		}

    	public Error(){}

		public String getMensagemErro() {
			return mensagemErro;
		}

		public void setMensagemErro(String mensagemErro) {
			this.mensagemErro = mensagemErro;
		}
		
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getPathDetalhe() {
			return pathDetalhe;
		}

		public void setPathDetalhe(String pathDetalhe) {
			this.pathDetalhe = pathDetalhe;
		}

		public String getCausa() {
			return causa;
		}

		public void setCausa(String causa) {
			this.causa = causa;
		}

		public String getTipoException() {
			return tipoException;
		}

		public void setTipoException(String tipoException) {
			this.tipoException = tipoException;
		}

		public String getStackTrace() {
			return stackTrace;
		}

		public void setStackTrace(String stackTrace) {
			this.stackTrace = stackTrace;
		}

		public String getLinkDocumentacaoErro() {
			return linkDocumentacaoErro;
		}

		public void setLinkDocumentacaoErro(String linkDocumentacaoErro) {
			this.linkDocumentacaoErro = linkDocumentacaoErro;
		}
    }

}
