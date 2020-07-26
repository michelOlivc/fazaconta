package com.fazaconta.api.error;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -846089848567194659L;

	public ProductNotFoundException(Long id) {
		super("O produto " + id + " não foi encontrado");
	}
}
