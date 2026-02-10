package org.stream.xml.videojuego;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Perfil {
	@EqualsAndHashCode.Include
	@SerializedName("id")
	@XmlAttribute(name = "id")
	private long id;
	@SerializedName("nickname")
	@XmlAttribute(name = "Nickname")
	private String nickname;
	@SerializedName("nivel")
	@XmlAttribute(name = "Nivel")
	private int nivel;
	@SerializedName("experiencia")
	@XmlElement(name = "Experiencia")
	private int experiencia;
	@SerializedName("online")
	@XmlElement(name = "Online")
	private boolean online;
	@SerializedName("vida")
	@XmlElement(name = "Vida")
	private int vida;
	@SerializedName("clase")
	@XmlAttribute(name = "Clase")
	private ClaseVideojuego clase;
}
