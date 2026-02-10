package org.stream.xml.videojuego;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class InventariosAdapter  extends TypeAdapter<Inventarios>{

	@Override
	public void write(JsonWriter out, Inventarios value) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson ();

		
		// escribrir inicio objeto
		out.beginObject();
		
		// escribir clave inventario
		out.name("inventario");
		
		
		if (value.getInventario().size() > 1) // escribir array
		{
			out.beginArray();
			for (Inventario i : value.getInventario())
				out.jsonValue(gson.toJson(i));
			out.endArray();
		}
		else // escribir un sólo elemento
			out.jsonValue(gson.toJson(value.getInventario().get(0)));
		
		
		
		// escribir fin del objeto
		out.endObject();
		
	}

	@Override
	public Inventarios read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		Inventarios inventarios = new Inventarios ();
		Gson gson = new Gson ();

		
		if (in.peek() == JsonToken.BEGIN_ARRAY)
		{
			
			
			Type  listaDeInventarios = TypeToken.getParameterized(ArrayList.class, Inventario.class).getType();
			inventarios.setInventario(gson.fromJson(in, listaDeInventarios));
			
		}

		else 
			inventarios.getInventario().add(gson.fromJson(in, Inventario.class));
		
		
		return inventarios;
	}

}
