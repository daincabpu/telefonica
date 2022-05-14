package com.telefonica.clientelineaoferta.core.enums;

public enum TipoPlan {
	PREPAGO("PRE"),
	POSTPAGO("POS");
	
	private final String value;
	
    private TipoPlan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
