package com.telefonica.clientelineaoferta.core.utils.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.telefonica.clientelineaoferta.Generated;
import com.telefonica.clientelineaoferta.core.utils.IDateTime;

@Service
@Generated
class DateTimeImpl implements IDateTime {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public Date getCurrentDate() {
       return new Date();
    }
    
    public boolean isValid(String text) {
        if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(text);
            return true;
        } catch (ParseException ex) {
        	logger.error(ex.getMessage());
            return false;
        }
    }

	@Override
	public String format(Date date, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
            return null;
        }
	}
	
	@Override
	public String changeFormat(String date, String formatOrigen, String formatDestino) {
		try {
			
			SimpleDateFormat df = new SimpleDateFormat(formatOrigen);
			Date fecha = df.parse(date);
			df = new SimpleDateFormat(formatDestino);
			return df.format(date);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
            return null;
        }
	}
	
}