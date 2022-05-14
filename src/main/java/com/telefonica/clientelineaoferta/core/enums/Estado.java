package com.telefonica.clientelineaoferta.core.enums;

public enum Estado {
	ACTIVO("A"),
	CANCELADO("C"),
	ELIMINADO("E");
	
	private final String value;
	
    private Estado(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
