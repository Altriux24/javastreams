package org.stream.xml.videojuego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



public class AppVideojuego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Type  listaDeJugadores;
		List<Jugador> jugadores = null;
		
		GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
						
		
		// mostrar nulls al escribir json
		creadorGson.serializeNulls();
		
		// poner adaptador de ClaseVideojuego
		creadorGson.registerTypeAdapter(ClaseVideojuego.class, new ClaseVideojuegoJSONAdapter());
		
		// poner adaptador de LocalDateTime
		creadorGson.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJSONAdapter());
		//poner adaptador de Invetario
		creadorGson.registerTypeAdapter(Inventarios.class, new InventariosAdapter());
		
		Gson gson = creadorGson.create();
		
		try(Reader reader = new FileReader (new File ("videojuego.json"))) {
			listaDeJugadores = TypeToken.getParameterized(List.class, Jugador.class).getType();
			jugadores=gson.fromJson(reader,listaDeJugadores);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		jugadores.forEach(System.out::println);

		System.out.println(gson.toJson(jugadores));
		
		
		//Escribir XML
			LeerYEscribirXML <WrapperJugadores> manejador = new LeerYEscribirXML<WrapperJugadores>();
			try {
				manejador.escribirXML(new WrapperJugadores(jugadores), new FileWriter("videojuego2.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//Leer XML
			WrapperJugadores cs = manejador.leerXML(WrapperJugadores.class, new File("videojuego2.xml"));
				System.out.println(cs);
				
				
	}
	
}
