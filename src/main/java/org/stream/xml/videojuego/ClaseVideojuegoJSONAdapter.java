package org.stream.xml.videojuego;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;



public class ClaseVideojuegoJSONAdapter  extends TypeAdapter<ClaseVideojuego>{

	@Override
	public void write(JsonWriter out, ClaseVideojuego value) throws IOException {
		// TODO Auto-generated method stub
		out.value(value.toString());
	}

	@Override
	public ClaseVideojuego read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return ClaseVideojuego.crearClaseVideojuego(in.nextString());
	}

}
