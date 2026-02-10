package org.stream.csv.ciclismo;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Equipo {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindAndSplitByPosition(position = 1,elementType = Corredor.class,splitOn = "&",converter = CorredorAdapterCSV.class,writeDelimiter = "&")
	private List<Corredor>corredores;
	@CsvBindByPosition(position = 2)
	private String nacionalidad;
	@CsvBindByPosition(position = 3)
	private float donacion;
}
