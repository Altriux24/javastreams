package org.stream.csv.ciclismo;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class BooleanAdapterCSV extends AbstractBeanField<String, Boolean>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		return (Boolean) value.equalsIgnoreCase("si");
	}

	@Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{
		Boolean profesional = (Boolean) value;
		
		return profesional?"si":"no";
	}
}
