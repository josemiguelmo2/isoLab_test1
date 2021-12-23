package com.uclm.test1isabel;

class Persona extends Application{ 
	
	static boolean sana;
	static boolean sintomas;
	static boolean contacto;
	static boolean pasaporteCovid;
	static boolean pasadoCovid;

	
	public Persona(boolean sana, boolean sintomas, boolean contacto, boolean pasadoCovid, boolean pasaporteCovid) {
		
		sana = this.sana;
		sintomas = this.sintomas;
		contacto = this.contacto;
		pasadoCovid = this.pasadoCovid;
		pasaporteCovid = this.pasaporteCovid;

	
	}
	

	public boolean saludPersona(){ 
 
		boolean permiso = false; 
 
		if (sana==true && sintomas==false && contacto==false && pasadoCovid==true && pasaporteCovid==true){ 
 
			permiso = true; 
		} 
 
		return permiso; 
		
	}//fin saludPersona 


	public static boolean isSana() {
		return sana;
	}


	public static void setSana(boolean sana) {
		Persona.sana = sana;
	}


	public static boolean isSintomas() {
		return sintomas;
	}


	public static void setSintomas(boolean sintomas) {
		Persona.sintomas = sintomas;
	}


	public static boolean isContacto() {
		return contacto;
	}


	public static void setContacto(boolean contacto) {
		Persona.contacto = contacto;
	}


	public static boolean isPasaporteCovid() {
		return pasaporteCovid;
	}


	public static void setPasaporteCovid(boolean pasaporteCovid) {
		Persona.pasaporteCovid = pasaporteCovid;
	}


	public static boolean isPasadoCovid() {
		return pasadoCovid;
	}


	public static void setPasadoCovid(boolean pasadoCovid) {
		Persona.pasadoCovid = pasadoCovid;
	}
	
	
}// fin clase Persona 
