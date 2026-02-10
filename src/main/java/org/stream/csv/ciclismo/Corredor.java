package org.stream.csv.ciclismo;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;

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
public class Corredor {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String idCorredor;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvCustomBindByPosition(position = 3,converter = BooleanAdapterCSV.class)
	private boolean profesional;

}
