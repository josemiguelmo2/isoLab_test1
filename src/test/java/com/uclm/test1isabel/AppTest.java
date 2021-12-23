package com.uclm.test1isabel;

import static org.junit.Assert.*; 



import com.uclm.test1isabel.*;

import org.junit.*;

public class AppTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before-> How many times do I appear?");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After-> How many times do I appear?");
	}
	
	
//	@Test
//	public void testMenu()  {
//	
//	Application.covid = true;
//	Application.temperatura = -10;
//	Application.humedad = 10;
//	Application.precipitaciones = true;
//	Application.aforo = 100;
//	Application.nublado = true;
//	Application.confinamiento = true;
//	Persona.sana = true;
//	Persona.sintomas = false;
//	Persona.contacto = false;
//	Persona.pasaporteCovid = true;
//	Persona.pasadoCovid = true;
//	assertEquals(true, Application.menu());
//	}
	
	
	
//	public void testMain9() throws NoHayAforoException, DatosException, HumedadException {
//		
//		Application.covid = false;
//		//assertTrue(Application.actividadRealizar().equalsIgnoreCase("No puede realizar ninguna actividad"));
//		assertEquals("No puede realizar ninguna actividad", Application.actividadRealizar());
//	}
	
	@Test
	public void testMain() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = -10;
		Application.humedad = 10;
		Application.precipitaciones = true;
		Application.aforo = 100;
		Application.nublado = true;
		Application.confinamiento = true;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Mejor quedate en casa"));
	}
	
	@Test
	public void testMain2() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = -10;
		Application.humedad = 10;
		Application.precipitaciones = false;
		Application.aforo = 100;
		Application.nublado = true;
		Application.confinamiento = true;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes ir a esquiar"));
	}
	
	@Test
	public void testMain3() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = 10;
		Application.humedad = 10;
		Application.precipitaciones = false;
		Application.aforo = 100;
		Application.nublado = true;
		Application.confinamiento = true;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes hacer senderismo"));
	}
	
	@Test
	public void testMain4() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = 17;
		Application.humedad = 55;
		Application.precipitaciones = false;
		Application.aforo = 100;
		Application.nublado = false;
		Application.confinamiento = false;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes hacer turismo al aire libre"));
	}
	
	@Test
	public void testMain5() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = 26;
		Application.humedad = 10;
		Application.precipitaciones = false;
		Application.aforo = 80;
		Application.nublado = false;
		Application.confinamiento = false;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes irte de cañas"));
	}
	
	@Test
	public void testMain6() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = 37;
		Application.humedad = 10;
		Application.precipitaciones = false;
		Application.aforo = 80;
		Application.nublado = false;
		Application.confinamiento = false;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes ir a la piscina o a la playa"));
	}
	
	
	@Test
	public void testMain7() throws NoHayAforoException, DatosException, HumedadException {
		Application.covid = true;
		Application.temperatura = 31;
		Application.humedad = 10;
		Application.precipitaciones = false;
		Application.aforo = 200;
		Application.nublado = false;
		Application.confinamiento = false;
		assertTrue(Application.actividadRealizar().equalsIgnoreCase("Puedes ir a la playa"));
	}
	
	
//	public void testMain8() throws NoHayAforoException, DatosException, HumedadException {
//	
//		Application.aforo = -9;
//		assertEquals("Lo sentimos, no hay plazas suficientes.", Application.actividadRealizar());
//		//assertTrue(Application.actividadRealizar().equalsIgnoreCase("Lo sentimos, no hay plazas suficientes."));	
//	}
	
	

	@Test
	public void test_obtenerHumedad() throws HumedadException{
		Application a = new Application();
		assertTrue(Application.obtenerHumedad()<100);
	}
	



	
	
	@Test
	public void testSaludPersona()throws Exception {
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);
		assertEquals(true, p.saludPersona());
	}

	@Test
	public void testIsSana() throws Exception{
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);

		assertEquals(true, p.isSana());
	}

	@Test
	public void testSetSana() throws Exception{
		Persona p = new Persona(false, false, false, false, false);
	    p.setSana(true);
	    assertTrue(p.isSana());
	}

	@Test
	public void testIsSintomas() throws Exception{
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);

		assertEquals(false, p.isSintomas());
	}

	@Test
	public void testSetSintomas() throws Exception{
		Persona p = new Persona(false, false, false, false, false);
	    p.setSintomas(true);
	    assertTrue(p.isSintomas());
	}

	@Test
	public void testIsContacto() throws Exception{
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);

		assertEquals(false, p.isContacto());
	}

	@Test
	public void testSetContacto() throws Exception{
		Persona p = new Persona(false, false, false, false, false);
	    p.setContacto(true);
	    assertTrue(p.isContacto());
	}

	@Test
	public void testIsPasaporteCovid() throws Exception{
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);

		assertEquals(true, p.isPasaporteCovid());
	}

	@Test
	public void testSetPasaporteCovid() throws Exception{
		Persona p = new Persona(false, false, false, false, false);
	    p.setPasaporteCovid(true);
	    assertTrue(p.isPasaporteCovid());	
	}

	@Test
	public void testIsPasadoCovid() throws Exception{
		Persona.sana = true;
		Persona.sintomas = false;
		Persona.contacto = false;
		Persona.pasaporteCovid = true;
		Persona.pasadoCovid = true;
		Persona p = new Persona(Persona.sana ,Persona.sintomas, Persona.contacto, Persona.pasaporteCovid, Persona.pasadoCovid);
		assertEquals(true, p.isPasadoCovid());
	}

	@Test
	public void testSetPasadoCovid() throws Exception{
	    Persona p = new Persona(false, false, false, false, false);
	    p.setPasadoCovid(true);
	    assertTrue(p.isPasadoCovid());	
	    
	}}	
