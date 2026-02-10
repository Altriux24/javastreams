package org.stream.xml.videojuego;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Estadistica {
	@SerializedName("enemigosDerrotados")
	@XmlElement(name = "EnemigosDerrotados")
	private int enemigosDerrotados;
	@SerializedName("muerte")
	@XmlElement(name = "Muerte")
	private int muerte;
	@SerializedName("tiempoJugadoHoras")
	@XmlElement(name = "TiempoJugadoHoras")
	private float tiempoJugadoHoras;
}
