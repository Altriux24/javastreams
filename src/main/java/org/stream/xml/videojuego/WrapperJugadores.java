package org.stream.xml.videojuego;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@XmlRootElement(name = "jugadores")
@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperJugadores {
	@Singular
	@XmlElement(name="jugador")
	private List<Jugador> jugadores;
}
