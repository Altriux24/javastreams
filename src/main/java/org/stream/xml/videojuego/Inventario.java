package org.stream.xml.videojuego;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventario {
	@EqualsAndHashCode.Include
	@SerializedName("itemId")
	@XmlElement(name = "ItemId")
	private String itemId;
	@SerializedName("nombre")
	@XmlElement(name = "Nombre")
	private String nombre;
	@Singular(value = "atributos")
	@SerializedName("atributos")
	@XmlElementWrapper (name="Atributos")
	@XmlElement(name="Atributo")
	private List<Integer>atributos;
}
