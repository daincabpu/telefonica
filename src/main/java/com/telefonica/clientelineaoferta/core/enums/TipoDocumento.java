package com.telefonica.clientelineaoferta.core.enums;

public enum TipoDocumento {
	DNI(1),
	PASAPORTE(2),
	CARNETEXTRANJERIA(3),
	RUC(4);
	
	private final int value;
	
    private TipoDocumento(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
