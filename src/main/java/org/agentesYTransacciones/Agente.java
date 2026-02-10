package org.agentesYTransacciones;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Builder
@Setter(value = AccessLevel.PRIVATE)
public class Agente {
	@NonNull
	private final String nombre;
	@NonNull
	private final String ciudad;
	
}
