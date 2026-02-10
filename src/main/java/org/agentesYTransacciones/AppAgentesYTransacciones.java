package org.agentesYTransacciones;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AppAgentesYTransacciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Consumer<Object> ESCRIBIDOR = System.out::println;

		Agente sofia = Agente.builder().nombre("Sofia").ciudad("Paris").build();
		Agente rosa = Agente.builder().nombre("Rosa").ciudad("London").build();
		Agente rodrigo = Agente.builder().nombre("Rodrigo").ciudad("Paris").build();
		Agente vicente = Agente.builder().nombre("Vicente").ciudad("Paris").build();

		List<Transaccion> transacciones = Arrays.asList(
				Transaccion.builder().agente(vicente).anio(2015).cantidad(430).build(),
				Transaccion.builder().agente(sofia).anio(2010).cantidad(1100).build(),
				Transaccion.builder().agente(sofia).anio(2015).cantidad(300).build(),
				Transaccion.builder().agente(rosa).anio(2012).cantidad(715).build(),
				Transaccion.builder().agente(rosa).anio(2012).cantidad(700).build(),
				Transaccion.builder().agente(rodrigo).anio(2012).cantidad(975).build());
		
		//Filtrar por anio y Ordenar la cantidad de forma Descendiente
		transacciones.stream().filter(t -> t.getAnio() == 2015).sorted((t1, t2) -> t1.getCantidad() - t2.getCantidad())
				.forEach(ESCRIBIDOR);
		//Transformar para listar las ciudades de los agentes distintos
		transacciones.stream().map(Transaccion::getAgente).map(Agente::getCiudad).distinct().forEach(ESCRIBIDOR);
		
		transacciones.stream().filter(t -> t.getAgente().getCiudad().equalsIgnoreCase("Paris")).distinct()
		.sorted((t1, t2) -> t1.getAgente().getNombre().compareTo(t2.getAgente().getNombre())).forEach(ESCRIBIDOR);
		
		transacciones.stream().map(t -> t.getAgente().getNombre()).sorted(String::compareTo)
				.forEach(ESCRIBIDOR);
		
		System.out.println(transacciones.stream().distinct().anyMatch(t -> t.getAgente().getCiudad().equalsIgnoreCase("London")));
		transacciones.stream().filter(t -> t.getAgente().getCiudad().equalsIgnoreCase("Paris")).map(s -> s.getCantidad())
				.forEach(ESCRIBIDOR);
				
		System.out.println(transacciones.stream().map(t -> t.getCantidad()).max((v1, v2) -> v1 - v2).orElse(0));
		
		System.out.println(transacciones.stream().min(Comparator.comparing(Transaccion::getCantidad)).orElse(null));
		
		//Total de cantidades segun la ciudad
		Function<Entry<String, List<Transaccion>>, Entry<String, Integer>> ciudadYvaloresTotales = t -> Map
				.entry(t.getKey(), t.getValue().stream().map(tr -> tr.getCantidad()).reduce(0, (tr1, tr2) -> tr1 + tr2));
		
		transacciones.stream().collect(Collectors.groupingBy(t -> t.getAgente().getCiudad())).entrySet().stream()
				.map(ciudadYvaloresTotales).sorted((v1, v2) -> v2.getValue() - v1.getValue()).forEach(ESCRIBIDOR);
			
		// t.getValue().stream().map(tr->tr.getValue()).reduce(0,(tr1,tr2)->tr1+tr2)
	}

}
