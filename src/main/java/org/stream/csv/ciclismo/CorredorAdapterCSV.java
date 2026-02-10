package org.stream.csv.ciclismo;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class CorredorAdapterCSV extends AbstractCsvConverter{
	
	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		StringReader stringReader=new StringReader(value);
		CSVParser icsvParser = new CSVParserBuilder().withSeparator(Constantes.SEPARADORCORREDOR).build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();

		
		return new CsvToBeanBuilder<Corredor>(csvReader)
				 .withType(Corredor.class)
				 .build().stream().findFirst().orElseGet(Corredor::new);

	}
	
	@Override
	public String convertToWrite(Object value) throws CsvDataTypeMismatchException
	{
		Writer writer = new StringWriter();
		try {
		     StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
		    		 withSeparator(Constantes.SEPARADORCORREDOR). // separador de campos
		    		 withApplyQuotesToAll(false).// no poner comillas
		    		 withLineEnd("").//separador de elementos
		    		 build();
		     beanToCsv.write(List.of(value));
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return writer.toString();
	}
}
