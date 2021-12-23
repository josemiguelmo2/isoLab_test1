package com.uclm.test1isabel;
import java.util.Scanner;
public class Application{
	
	final static Scanner teclado = new Scanner (System.in);
	
	static boolean covid; 
	static String actividad;
	static int temperatura = 0;
	static int humedad = 0;
	static boolean precipitaciones = true;
	static boolean nublado = true;
	static boolean confinamiento = true;
	static int aforo = 0;
	static Persona persona;
	
	//static boolean sana = false, sintomas = false, contacto = false, pasaporteCovid = false, pasadoCovid = false;

	public static void main(String[] args) {
		
		menu();

	}	
	
	public static boolean menu() {
		
		boolean a = true;
	
	try{
		
		System.out.println("Por favor, introduzca si está sana (true/false): ");
		boolean sana = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si tiene síntomas de covid (true/false): ");
		boolean sintomas = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si ha tenido contacto con un positivo (true/false): ");
		boolean contacto = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si tiene pasaporte Covid (true/false): ");
		boolean pasaporteCovid = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si ha pasado el Covid (true/false): ");
		boolean pasadoCovid = teclado.nextBoolean();
		System.out.println(pasadoCovid);
		persona = new Persona(sana, sintomas, contacto, pasadoCovid, pasaporteCovid);
		covid = persona.saludPersona();
		
		
		System.out.println("Introduzca los siguientes datos:\n");
		System.out.println("Temperatura:\n" );
		obtenerPositivo();
		System.out.println("Humedad:\n" );
		obtenerHumedad();
		System.out.println("Por favor, introduzca si habrá precipitaciones (true/false): ");
		precipitaciones = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si estará nublado (true/false): ");
		nublado = teclado.nextBoolean();
		System.out.println("Por favor, introduzca si hay confinamiento (true/false): ");
		confinamiento = teclado.nextBoolean();
		System.out.println("aforo:\n");
		obtenerPositivo();
		
		actividad = actividadRealizar();
		System.out.println("Puedes realizar: " + actividad);
		
		//a = true;

	}catch(NoHayAforoException e) {
		a = false;
		System.out.println("No hay aforo");

	}catch(DatosException n) {
		a=false;
		System.out.println("Error en el formato de los datos");

	}catch(HumedadException h) {
		a=false;
		System.out.println("Humedad inválida");
		}
	
	return a;

	}
	
	
public static String actividadRealizar() throws NoHayAforoException, DatosException, HumedadException {
	String mensaje = "";

	if(covid == false){
		mensaje = "No puede realizar ninguna actividad";

	}else if(temperatura<0 && humedad<15 && precipitaciones==true){
		mensaje ="Mejor quedate en casa";

	}else if(temperatura<0 && humedad<15  && precipitaciones==false && aforo<300){
		mensaje = "Puedes ir a esquiar";

	}else if(temperatura>0 && temperatura<=15 && humedad<=15  && precipitaciones==false && aforo<200){
		mensaje = "Puedes hacer senderismo";

	}else if(temperatura>15 && temperatura<=25 && humedad<=60  && precipitaciones==false && nublado==false && confinamiento==false){
		mensaje = "Puedes hacer turismo al aire libre";

	}else if(temperatura>=25 && temperatura<=35 && precipitaciones==false && aforo<90){
		mensaje = "Puedes irte de cañas";

	}else if (temperatura>=30 && precipitaciones==false && aforo<150){
		mensaje = "Puedes ir a la piscina o a la playa";

	}else if (temperatura>=30 && precipitaciones==false){
		mensaje = "Puedes ir a la playa";
	}
	if(aforo <= 0){
		throw new NoHayAforoException("Lo sentimos, no hay plazas suficientes.");
	}
	
	return mensaje;
	}//fin actividadRealizar 


public static int obtenerHumedad() throws HumedadException{
	int hum = 0;
	hum = 10;
	if(hum <= 0 || hum > 100){
		throw new HumedadException("Error, ha introducido una humedad inválida.");
	}

	return hum;
}

public static int obtenerPositivo() throws DatosException{
	int numero = 0;
	numero = teclado.nextInt();
	if(numero < 0){
		throw new DatosException("Dato incorrecto, por favor, introduzca números positivos.");
	}

	return numero;
}



}
