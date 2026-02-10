package org.stream.xml.videojuego;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Inventarios {
	
	private List<Inventario> inventario;
	
	public Inventarios() {
		inventario=new ArrayList<>();
	}
}
