package org.stream.xml.videojuego;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Jugador {
	private Perfil perfil;
	@XmlElement(name="inventarios")
	private Inventarios inventario;
	private Estadistica estadisticas;
	@SerializedName("ultimaConexion")
	@XmlElement(name = "UltimaConexion")
	@XmlJavaTypeAdapter(LocalDateTimeXMLAdapter.class)
	private LocalDateTime ultimaConexion;
}
