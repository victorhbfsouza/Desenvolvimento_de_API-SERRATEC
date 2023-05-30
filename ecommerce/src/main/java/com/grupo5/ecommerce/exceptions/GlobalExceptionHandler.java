package com.grupo5.ecommerce.exceptions;

import java.net.URI;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	ProblemDetail handleNoSuchElementException(NoSuchElementException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

		problemDetail.setTitle("Recurso não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Categoria
	@ExceptionHandler(CategoriaNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(CategoriaNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Categoria não encontrada");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Cliente
	@ExceptionHandler(ClienteNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(ClienteNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Cliente não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Endereco
	@ExceptionHandler(EnderecoNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(EnderecoNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Endereco não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Item Pedido
	@ExceptionHandler(ItemPedidoNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(ItemPedidoNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Item Pedido não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Pedido
	@ExceptionHandler(PedidoNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(PedidoNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Pedido não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	// Produto
	@ExceptionHandler(ProdutoNotFoundException.class)
	ProblemDetail handleBookmarkNotFoundException(ProdutoNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Produto não encontrado");
		problemDetail.setType(URI.create("https://api.trabalhofinal-grupo5.com/errors/not-found"));
		return problemDetail;
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {
		ResponseEntity<Object> response = super.handleExceptionInternal(ex, body, headers, statusCode, request);

		if (response.getBody() instanceof ProblemDetail problemDetailBody) {
			problemDetailBody.setProperty("message", ex.getMessage());
			if (ex instanceof MethodArgumentNotValidException subEx) {
				BindingResult result = subEx.getBindingResult();
				problemDetailBody.setTitle("Erro na requisição");
				problemDetailBody.setDetail("Ocorreu um erro ao processar a Requisição");
				problemDetailBody.setProperty("message", "Validation failed for object='" + result.getObjectName()
						+ "'. " + "Error count: " + result.getErrorCount());

				problemDetailBody.setProperty("errors", result.getAllErrors());
			}
		}
		return response;
	}
}
