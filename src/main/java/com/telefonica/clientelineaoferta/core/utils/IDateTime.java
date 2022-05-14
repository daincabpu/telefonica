package com.telefonica.clientelineaoferta.core.utils;

import java.util.Date;

public interface IDateTime {
	Date getCurrentDate();
	boolean isValid(String text);
	String format(Date date, String format);
}
