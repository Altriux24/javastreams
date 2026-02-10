package org.stream.csv.ciclismo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppCiclismo {
	private static final Consumer<Object>Escribidor=System.out::println;
	private List<Vuelta>vueltas;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppCiclismo app=new AppCiclismo();
		app.cargarDatos();
		app.consultas();
		app.guardarDatos();
	}

	private void consultas() {
		// TODO Auto-generated method stub
		//1
		vueltas.stream().filter(v->v.getNumEtapas()>10).sorted((v1,v2)->v1.getAnio()-v2.getAnio()).forEach(v->System.out.println(v.getNombre()+v.getAnio()+v.getDirector()));
		//2
		vueltas.stream().filter(v->v.getPremio()>30000).flatMap(v->v.getEquipos().stream()).flatMap(e->e.getCorredores().stream()).map(c->c.getNombre()).distinct().forEach(Escribidor);
		//3
		Predicate<Corredor>filtroMenorProfesional=c->c.isProfesional()&&c.getFechaNacimiento().isAfter(LocalDate.now().minusYears(18));
		vueltas.stream().flatMap(v->v.getEquipos().stream()).filter(e->e.getCorredores().stream().anyMatch(filtroMenorProfesional)).forEach(Escribidor);
		//4
		vueltas.stream().filter(v->v.getEquipos().stream().anyMatch(e->e.getNacionalidad().equalsIgnoreCase("española"))&&(v.getAnio()<=2020||v.getAnio()==2010));
		//5
		Predicate<Corredor>filtroMayorEdad=c->c.getFechaNacimiento().isBefore(LocalDate.now().minusYears(18));
		vueltas.stream().
		collect(Collectors.
				groupingBy(Vuelta::getNombre,Collectors.
						flatMapping(v->v.getEquipos().stream().flatMap(e->e.getCorredores().stream().filter(filtroMayorEdad).map(c->c.getIdCorredor()+" "+c.getNombre())), Collectors.toList()))).entrySet().forEach(Escribidor);
	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		try {
			vueltas=new CsvToBeanBuilder(new FileReader("ciclismo.csv"))
			 .withType(Vuelta.class).withSeparator(Constantes.SEPARADORCICLISMO).
			 build()
			 .parse();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// stream()
	}
	private void guardarDatos() {
		// TODO Auto-generated method stub
		
		 Writer writer;
			try {
				writer = new FileWriter("ciclismo2.csv");
			     StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
			    		 withSeparator(Constantes.SEPARADORCICLISMO).
			    		 withApplyQuotesToAll(false).
			    		 build();
			     beanToCsv.write(vueltas);
			     writer.close();
			     System.out.println("Operación exitosa Datos Guardados...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}
}
