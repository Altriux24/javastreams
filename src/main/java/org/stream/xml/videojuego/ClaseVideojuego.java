package org.stream.xml.videojuego;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import com.google.gson.annotations.SerializedName;


@XmlEnum (String.class)
public enum ClaseVideojuego {
	@SerializedName("Guerrero")
	@XmlEnumValue ("Guerrero")
	GUERRERO {public String toString(){return "Guerrero";}}, 
	@SerializedName("Paladin")
	@XmlEnumValue ("Paladin")
	PALADIN {public String toString(){return "Paladin";}}, 
	@SerializedName("Mago")
	@XmlEnumValue ("Mago")
	MAGO {public String toString(){return "Mago";}}, 
	@SerializedName("Arquero")
	@XmlEnumValue ("Arquero")
	ARQUERO {public String toString(){return "Arquero";}};
	
	public static ClaseVideojuego crearClaseVideojuego (String valor)
	{
		
		return Arrays.stream(ClaseVideojuego.values()).
				filter(a -> a.toString().equals(valor)).
				findFirst().
				orElse(ClaseVideojuego.MAGO);
	}

}
