package org.agentesYTransacciones;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Setter(value = AccessLevel.PRIVATE)
public class Transaccion {
	private final Agente agente;
	private final int anio;
	private final int cantidad;
}
