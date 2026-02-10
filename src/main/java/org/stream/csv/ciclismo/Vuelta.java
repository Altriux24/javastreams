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
public class Vuelta {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindByPosition(position = 1)
	private float premio;
	@CsvBindByPosition(position = 2)
	private String director;
	@CsvBindByPosition(position = 3)
	private int numEtapas;
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 4)
	private int anio;
	@CsvBindAndSplitByPosition(position = 5,elementType = Equipo.class,splitOn = ",",converter = EquipoAdapterCSV.class,writeDelimiter = ",")
	private List<Equipo>equipos;
}
