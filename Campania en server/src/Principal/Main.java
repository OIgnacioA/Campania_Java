package Principal;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
//import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Locale;


//FECHA ACTUAL
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
 
PARAMETROS DE ENTRADA : 

VER CUÁLES SON LOS DATOS A INGRESAR (por ahora 3): 

ANUAL SERÁ SIEMPRE 0 A MENOS QUE S EINDIQUE LO CONTRARIO EN EL SEGUNDO APRAMETRO DEL COMANDO. CON UN 1 (SI SE DESEA HACER EL AGREGADO DE ANUAL.)  

TIPO DE IMPUESTO: AU-EM-ED-BA-RU-IC,  

CANTIDAD DE CORTE.Fija en 150000

LAS URL QUE SE USABAN ORIGINALMENTE, QUE ESTAN EN LA FUNCION "ImpuestoTipo() " YA CASI NO TIENEN  USO, SE IMPLENTÓ EL PDF. 

CORREGI LA REVISION PARA QUE FILTRO POR TIPO DE IMPUESTO.YA QUE LOS OBJETOS VARIAN DE UNO A OTRO. 

SE AGREGO UN MODULO (verificarArchivos) QUE VA A TOMAR EL CALCULO DESDE LA CLASE  CHECKEOCANTIDAD, DE CUANTOS CSV DEBERÍAN FORMARSE. PARA COTEJAR QUE EL RESULTASDO FINAL SEA EN NUMERO Y CONTENIDO, ACEPTABLE. CASO CONTRARIO
SE DAN ERRORES DE TIPO  System.exit(0);

POR OTRO LADO ESTE TIPO DE ERRORES SE AGREGARON EN TODOS LOS FILTROS HECHO HASTA AHORA, Y REVISIONES PREVIAS.


 System.exit(1);  SE AGREGÓ EN LOS LUGARES DONDE SE VUELVAN PARAMETROS PARA SERCIORARSE DE QUE LOS MISMOS SEAN CORRECTOS. 


 */

public class Main {

	public static void main(String[] Args) {

		String Impuesto = "AU"; //Args[0]; // "IC"; 
		String TipoDePago = "DT";
		int cantidadCorte = 150000;

		String Anual = "0"; 
		
		 if (Args.length > 1 && Args[1].equals("1")) {
		        Anual = "1";
		    }else {
	            System.out.println("El valor de Anual debe ser '1'");
	            System.exit(1);
	        }

		int turns = 1;

		
		
		
		
		// ################################ DIRECCIONES DE PREBA EN LOCAL Y EN SERVIDOR.########################################
	

		
		  //modificar el dato de pathDestinoCSV tambien.!!
		  
		String Destino = "/operemi/CAMPANIA/Destino/";
		String Origen = "/operemi/CAMPANIA/Origen/";
		 
		 //-------------------------
		
		
		

		/* modificar el dato de pathDestinoCSV tambien.!!

		String Destino = "C:/Users/oscar.avendano/Desktop/Impuestos/Destino/";
		
		String Origen = "C:/Users/oscar.avendano/Desktop/Impuestos/Origen/";
		
		*/
		//##### FILTRO DE IMPUESTO ERRADO:
		
		if (Impuesto.equals("AU") || Impuesto.equals("EM") || Impuesto.equals("RU") || Impuesto.equals("BA") || Impuesto.equals("ED") || Impuesto.equals("IC")  ) { //XD 
			
		} else {
			System.out.println("el impuesto ingresado no es correcto.");
			System.exit(1);
		}
			
			


		String pathOrigen = Origen + Impuesto;
		String pathDestinoCSV = Destino + Impuesto + "/" + TipoDePago;
		String DestinoImpuesto = Destino + Impuesto;
		String pathOrigen2 = "";

		
		// ##################################################################################################################

		
		
		
		
		
		
		
		while (turns < 3) {

			//################################################# VERIFICAR QUE LA CARPETA DESTINO NO ESTE YA OCUPADA.

			if (!verificarCarpetaDestino(pathDestinoCSV)) {
				System.out.println("La carpeta destino ya contiene archivos.Proceso detenido.");
				System.exit(0); // Esta línea detendrá el programa
			}

			// DEFINIR NOMBRE PARTICULAR DEL ARCHIVO A TRABAJAR.

			Busqueda buscar = new Busqueda();

			String ArchivoNombre = buscar.procesarArchivos(pathOrigen, TipoDePago);

			pathOrigen2 = pathOrigen + "/" + ArchivoNombre;

			
			
			//########################################################## FILTRO:
			
			// FIRLTRAR ARCHIVOS QUE PUDIERAN TENER UN PROBLEMA DE DECLARACION DE COBRO. DT:
			// (1,2,D) - CO: (0)

			ModuloFiltro(pathOrigen2, Impuesto, TipoDePago);


			
			//######################################## EJECUTAR LA CAMPAÑA PRINCIPAL.

			
			System.out.println("TRABAJANDO EN ---> " + pathOrigen2);
			
			
			
			
			//####################################################################  CHECKEO DE CANTIDAD A PRODUCIR DE .CSV PARA COMPARACION POSTERIOR.
			
			CheckeoCantidad  check = new CheckeoCantidad(pathOrigen2, Impuesto, cantidadCorte);
			        
			
			        check.EjecucionContar();
					int DatoCantidad = check.getCantidadArchivos();
					
					verificarArchivos(pathDestinoCSV,  DatoCantidad);   //COMPROBACION
				
		
			//####################################################################

			pathsTriger Ejecucion = new pathsTriger(Impuesto, TipoDePago);

			try {
				Ejecucion.Proceso(pathOrigen2, pathDestinoCSV, ArchivoNombre, Impuesto, TipoDePago, cantidadCorte,
						Anual);
			} catch (IOException e) {

				e.printStackTrace();
			}

			turns++;
			TipoDePago = "CO";

		//	pathDestinoCSV = "C:/Users/oscar.avendano/Desktop/Impuestos/Destino/" + Impuesto + "/" + TipoDePago;

			 pathDestinoCSV = "/operemi/CAMPANIA/Destino/" + Impuesto +"/"+ TipoDePago;
		}

		
		
		
		
		
		
		
		//#####################################  FILTROS Y REVISIONES: #########################################
		
		
		
		// REVISION DEL PRODUCTO FINAL EN LA CARPETA CORRESPONDIENTE.

		if (Impuesto.equals("IC")) {

			RevisionComplementario revi1 = new RevisionComplementario(DestinoImpuesto);

			revi1.UltimaRevision();

		} else {

			Revision revi1 = new Revision(DestinoImpuesto, Impuesto);

			revi1.UltimaRevision();
		}
	}

	public static void ModuloFiltro(String path, String Impuesto, String TipoDePago) {

		String name = path;
		Filtro Fil = new Filtro(name, Impuesto, TipoDePago); // FILTRO PREVIO.

		Fil.CoDt();

		if (Fil.getCoDT() == false) {
			System.out.println(
					"El programa se ha interrumpido debido a una inconsitencia detectada en uno de sus archivos origen.");

			System.exit(0); // Terminar el programa con un estado de salida no exitoso
		}

	}

	private static boolean verificarCarpetaDestino(String carpetaDestino) {
 
		
	    File carpeta = new File(carpetaDestino); //

	    File[] archivos = carpeta.listFiles();

	    if (archivos != null && archivos.length > 0) {
	        return false; // La carpeta destino ya contiene archivos
	    }

	    return true; // La carpeta destino está vacía, se puede proceder
	}

	
	
	
	
	 public static void verificarArchivos(String pathDestinoCSV, int DatoCantidad) {// VERIFICACION DE CANTIDAD Y CONTENIDO DE ARCHIVOS
	        File directorio = new File(pathDestinoCSV);
	        File[] archivos = directorio.listFiles();

	        if (archivos == null || archivos.length != DatoCantidad) {
	            System.exit(0);
	        }

	        for (File archivo : archivos) {
	            if (archivo.length() == 0) {
	                System.exit(0);
	            }
	        }
	    }
	

	
}






class pathsTriger {

	String line = "";
	String TXTInforme = "";
	String ultimoMail = "";
	String nombreArchivoGeneradoPATH = "";
	String mailLinea = "";
	String periodo = "";
	String nombreArchivoGenerado = "";
	int contador = 0;
	int escritos = 0;
	int cantidadArchivosGenerados = 1;
	int contadore = 0;
	int cantidadMailIgual = 0;
	int whileCount = 0;

	int unidades = 0;

	Writer SW = null;
	Writer swResultados = null;
	BufferedWriter br = null;

	public pathsTriger(String Impuesto, String TipoDePago) {

		this.Impuesto = Impuesto;
		this.TipoDePago = TipoDePago;

	}

	public void Proceso(String Origen, String pathDestinoCSV, String txtDestino, String Impuesto, String TipoDePago,
			int cantidadCorte, String Anual) throws IOException {
		// CSV:
		BufferedReader file = null; // Declarar aquí para ampliar el ámbito
		// informe
		BufferedWriter br = null;


		try {
			file = Files.newBufferedReader(Paths.get(Origen), StandardCharsets.ISO_8859_1);

			// PATHS:
			// CSV:
			nombreArchivoGenerado = String.format("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados); // .csv
			nombreArchivoGeneradoPATH += pathDestinoCSV + "/" + nombreArchivoGenerado; // .csv

			SW = new BufferedWriter(new FileWriter(nombreArchivoGeneradoPATH, true));

			// informe
			TXTInforme = pathDestinoCSV + "/Informe.txt";

			br = new BufferedWriter(new FileWriter(TXTInforme, true));
			br.write("Se generearon los siguientes archivos:");
			br.newLine();
			br.newLine();
			br.flush();
		} catch (Exception e) {
			System.out.println("Excepcion cacht    1: " + e);
		}

		EscribirCabecera(SW);
		ImpuestoTipo(Impuesto);

		while ((line = file.readLine()) != null) {

			Kont_barra++;

			// System.out.println("-->"+ Kont_barra);

			LeerLinea(line, Impuesto);

			if (mailAux == "") {
				mailAux = mail;
				razonsocialAux = razonsocial;
				cuitAux = cuit;
			}

			ArmarDatosMail();

			if ((!mail.equals(mailAux)) || (!razonsocial.equals(razonsocialAux))) {

				mailLinea = mailAux;
				fechaOpcion = obtenerFechaActual();
				ImpuestoV = nombreImpuesto;
				mailLinea += String.format("|%s|Cuit: %s|%s|%s|%s|%s|%s|%s|%s", razonsocialAux, formatearCuit(cuitAux),
						fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);

				if (escritos == cantidadCorte) {
					try {
						br.write(String.format("Archivo ** %s **", nombreArchivoGenerado));
						br.newLine();
						br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
						br.newLine();
						br.newLine();
						// br.flush();

						escritos = 0;
						contador = 0;
						cantidadArchivosGenerados++;

						nombreArchivoGenerado = String.format("%s-Parte-%s.csv", txtDestino, cantidadArchivosGenerados);
						nombreArchivoGeneradoPATH = pathDestinoCSV + "/" + nombreArchivoGenerado;
						SW = new BufferedWriter(new FileWriter(nombreArchivoGeneradoPATH, true));

						EscribirCabecera(SW);

					} catch (IOException ex) {
						ex.printStackTrace();
					}

				} // IF B

				try {

					SW.write(mailLinea + "\r\n");
					SW.flush();
					mailLinea = "";
					// SW.close();
				} catch (IOException e) {
				}

				mailAux = mail;
				razonsocialAux = razonsocial;
				cuitAux = cuit;
				datosTodosObjetos = datosObjeto;
				datosObjeto = "";

				escritos++;
			} else {

				datosTodosObjetos += datosObjeto;

			} // if A

			contador++;

			// PORCENTUAL BARRA
			whileCount++;

		

		} // While

		Kont_barra = 0;

		mailLinea = mailAux;
		fechaOpcion = obtenerFechaActual();
		ImpuestoV = nombreImpuesto;
		mailLinea += String.format("|%s|Cuit: %s|%s|%s|%s|%s|%s|%s|%s", razonsocialAux, formatearCuit(cuitAux),
				fechaVencimiento, fechaOpcion, anio, cuota, ImpuestoV, datosTodosObjetos, porcentaje);

		try {

			SW.append(mailLinea + "\r\n");// cambio de cierre a windows (CRLF)
			// SW.append('\n');

		} catch (Exception e) {
			System.out.print("PROBLEM2");
		}

		mailAux = mail;
		razonsocialAux = razonsocial;
		cuitAux = cuit;

		distintos++;

		escritos++;

		try {
			br.write(String.format("Archivo ** %s **", nombreArchivoGenerado));
			br.newLine();
			br.write(String.format("Con %d suscripciones y %d mails para enviar", contador, escritos));
			br.newLine();
			br.newLine();
			br.flush();
			br.close();
		} catch (Exception e) {
		}

		try {
			file.close();
		} catch (Exception e) {
		}

		try {
			SW.flush();
			SW.close();
		} catch (Exception e) {
		}

		System.out.println("contador: " + contadore);

	}

	private void ArmarDatosMail() {

		medioPago = funcionHash();
		QRString = generarStringQr();

		if (Impuesto == "IC") {// COMPLEMENTARIO

			datosObjeto = "<tr class='datos'>";
			datosObjeto += String.format("<td class='gris'>%s - %s</td>", objetoFormateado, plantaDescri); // Objeto Ej
																											// =
																											// 20-0553665-9
			// datosObjeto += String.format("<td class='amarillo'>Cuota %s </td>",
			// cuotaNumero);
			datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);
			datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);

			if (debitoCredito.equals("1") || debitoCredito.equals("D")) {
				datosObjeto += String.format("<td class='gris'>Débito en Cuenta</td>");// DT
			} else if (debitoCredito.equals("2")) {
				datosObjeto += String.format("<td class='gris'>Tarjeta de Crédito</td>");// DT-Cred
			}

			WithQRcod(TipoDePago, Impuesto); // Determina si va con QR o no.

			// datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);
			// datosObjeto += String.format("<td class=''>%s</td>", Variable);
			// WithQRcod(TipoDePago, Impuesto);

			datosObjeto += "</tr>";
		} else {

			if (Anual == "1") {
				// objeto = formatearCuit(objeto); -- OBJETO PARECE NO ESTARSE USANDO...
				datosObjeto = "<tr class='datos'>";
				datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", objetoFormateado);
				datosObjeto += String.format(
						"<td class='amarillo' align=\"center\" valign=\"middle\" height=\"70\">Cuota %s</td>",
						cuotaNumero);
				datosObjeto += String.format(
						"<td class='amarillo' align=\"center\" valign=\"middle\" height=\"70\">%s</td>", montoCuota);
				datosObjeto += String.format("<td rowspan='2' class='gris'>%s</td>", medioPago);
				WithQRcod(TipoDePago, Impuesto);

				datosObjeto += "</tr>";
				datosObjeto += "<td class='blanco' align=\"center\" valign=\"middle\" height=\"70\">Anual</td>";
				datosObjeto += String.format(
						"<td class='blanco' align=\"center\" valign=\"middle\" height=\"70\">%s</td>", montoAnual);
				// datosObjeto += String.Format("<td class=''>%s</td>", Variable);

				datosObjeto += "</tr>";

			} else { // OTROS IMPUESTOS

				contadore++;

				// objeto = formatearCuit(objeto); -- OBJETO PARECE NO ESTARSE USANDO...
				datosObjeto = "<tr class='datos'>";
				datosObjeto += String.format("<td class='gris'>%s</td>", objetoFormateado); // 0190117251
				// datosObjeto += String.format("<td class='amarillo'>Cuota %S</td>",
				// cuotaNumero);// Palabra: 'Cuota'. (?)
				datosObjeto += String.format("<td class='amarillo'>%s</td>", montoCuota);// 7.780.90
				datosObjeto += String.format("<td class='gris'>%s</td>", medioPago);// www.ARBA.gov.ar

				if (debitoCredito.equals("1") || debitoCredito.equals("D")) {

					datosObjeto += String.format("<td class='gris'>Débito en Cuenta</td>");// DT
				} else if (debitoCredito.equals("2")) {

					datosObjeto += String.format("<td class='gris'>Tarjeta de Crédito</td>");// DT-Cred
				}

				WithQRcod(TipoDePago, Impuesto);

				datosObjeto += "</tr>";

			}
		}
	}

	private void ImpuestoTipo(String Impuesto) {

		switch (Impuesto) {

		case "AU": {

			impuestoLiquidar = "1";
			nombreImpuesto = "Automotor";
			Url = "https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=1&opc=LIC&oi=";
			Ente = "002";
			Rubro = "05";

			ImpuestoCorto = "AUT";
			seleccionerronea = true;
			break;
		}
		case "EM": {

			nombreImpuesto = "Embarcaciones";
			impuestoLiquidar = "3";
			Ente = "030";
			Rubro = ""; // consultar.
			ImpuestoCorto = "EMB";
			seleccionerronea = true;
			break;

		}
		case "ED": {

			nombreImpuesto = "Edificado";
			impuestoLiquidar = "0";
			Url = "https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=";
			Ente = "001";
			Rubro = "07";
			ImpuestoCorto = "EDI";
			seleccionerronea = true;
			break;
		}
		case "BA": {

			nombreImpuesto = "Baldio";
			impuestoLiquidar = "0";
			Url = "https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=";
			Ente = "001";
			Rubro = "07";
			ImpuestoCorto = "BAL";
			seleccionerronea = true;
			break;
		}
		case "RU": {

			impuestoLiquidar = "0";
			nombreImpuesto = "Rural";
			Url = "https://www.arba.gov.ar/Aplicaciones/Liquidacion.asp?imp=0&opc=LIC&oi=";
			Ente = "001";
			Rubro = "07";
			ImpuestoCorto = "RUR";
			seleccionerronea = true;
			break;
		}
		case "IC": {

			nombreImpuesto = "Complementario";
			impuestoLiquidar = "10";
			// Url
			// ="https://app.arba.gov.ar/LiqPredet/sso/InicioLiquidacionIIC.do?Frame=NO&origen=WEB&imp=10&cuit=";
			Ente = "004";
			Rubro = "07";
			ImpuestoCorto = "IIC";
			seleccionerronea = true;
			break;
		}

		default: {

			break;
		}

		}

	}

	public void LeerLinea(String line, String Impuesto) {

		switch (Impuesto) {

		case "AU":
		case "EM": {

			mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ", ""));
			objeto = (line.substring(255, 266).replaceAll(" ", ""));
			objetoFormateado = objeto.toUpperCase();
			// razonsocial = trimEnd(line.substring(266,326));
			razonsocial = trimEnd(line.substring(345, 405));
			porcentaje = "";

			try {
				// fechaVencimientoNumero = (line.substring(334, 344).replaceAll(" ",""));
				fechaVencimientoNumero = (line.substring(274, 284).replaceAll(" ", ""));
				fechaVencimiento = StringaDate(fechaVencimientoNumero);
			} catch (Exception e) {

				contadorerrorFecha++;

				System.out.println("error de lectura de fecha en automotor embarcaciones");
			}

			montoCuota = line.substring(284, 301).replaceAll(" ", "");
			montoAnual = line.substring(301, 318);
			codigoElectronico = line.substring(318, 332).replaceAll(" ", "");

			periodo = line.substring(268, 274).replaceAll(" ", ""); // HASH NUEVO
			debitoCredito = line.substring(332, 333).replaceAll(" ", "");
			buenContribuyente = line.substring(333, 334).replaceAll(" ", "");

			try {

				cuit = line.substring(334, 345).replaceAll(" ", "");

			} catch (Exception e) {

				cuit = "";
				conterror++;
			}

			Variable = "Prueba  Automotor";

			porcentaje = "20";// ?????????????????????
			anio = (line.substring(280, 284));
			cuota = (line.substring(273, 274));

			// anio = "2022"; -----> asi lo tenia Juan
			// cuota = "4";

			break;
		}
		case "ED":
		case "BA":
		case "RU": {

			mail = ((line.substring(0, 255).toLowerCase()).replaceAll(" ", ""));
			objeto = (line.substring(255, 266).replaceAll(" ", ""));

			try {

				objetoFormateado = formatearObjetoInmobiliario(objeto);
				fechaVencimiento = StringaDate(fechaVencimientoNumero);
			} catch (Exception e) {
			}

			razonsocial = trimEnd(line.substring(345, 405));
			porcentaje = "";

			try {

				fechaVencimientoNumero = (line.substring(274, 284).replaceAll(" ", ""));

			} catch (Exception e) {
				contadorerrorFecha++;
				System.out.println("error de lectura de fecha en Edificado/Baldio/Rural");
			}

			montoCuota = line.substring(284, 301).replaceAll(" ", "");
			montoAnual = line.substring(301, 318);
			codigoElectronico = line.substring(318, 332).replaceAll(" ", "");
			debitoCredito = line.substring(332, 333).replaceAll(" ", "");
			buenContribuyente = line.substring(333, 334).replaceAll(" ", "");
			periodo = line.substring(268, 274).replaceAll(" ", ""); // HASH NUEVO

			try {

				cuit = line.substring(334, 345).replaceAll(" ", "");

			} catch (Exception e) {
				cuit = "";
				System.out.println("error en línea: " + counter + ", de tipo : ( " + e.getMessage());
				conterror++;
			}

			Variable = "Prueba Edificacion -baldio -rural ";

			break;
		}
		case "IC": {
			LeerLineaNuevo(line);
			break;
		}
		default:
			break;
		}

	}

	private void LeerLineaNuevo(String line) { // "Impuesto Complementario"

		mail = ((line.substring(0, 120).toLowerCase()).replaceAll(" ", ""));
		objeto = (line.substring(120, 131).replaceAll(" ", ""));

		try {

			objetoFormateado = formatearObjetoComplementario(objeto); // Ej: 20-0553665-9

		} catch (Exception e) {
		}

		planta = (line.substring(131, 132).replaceAll(" ", ""));
		razonsocial = trimEnd(line.substring(196, 256));
		porcentaje = (line.substring(132, 134).replaceAll(" ", ""));
		anio = (line.substring(134, 138).replaceAll(" ", ""));
		periodo = line.substring(134, 140).replaceAll(" ", ""); // HASH NUEVO -PDF-
		cuota = (line.substring(138, 140).replaceAll(" ", ""));

		try {

			fechaVencimientoNumero = (line.substring(140, 150).replaceAll(" ", ""));

		} catch (Exception e) {

			contadorerrorFecha++;

			System.out.println("error de lectura de fecha en Complementario");

		}

		montoCuota = line.substring(150, 167).replaceAll(" ", "");
		montoAnual = line.substring(167, 184);
		debitoCredito = line.substring(184, 185).replaceAll(" ", "");

		try {

			cuit = line.substring(185, 196).replaceAll(" ", "");

		} catch (Exception e) {

			cuit = "";
			System.out.println("error en línea: " + counter + ", de tipo : ( " + e.getMessage());
			conterror++;
		}

		Variable = "Prueba  Complementario ";

		if (Anual != "") {
			cuota = cuota + " y Saldo Anual";
		}

		switch (planta) {
		case "B": {
			plantaDescri = "Baldio";
			break;
		}
		case "E": {
			plantaDescri = "Edificado";
			break;
		}
		case "R": {
			plantaDescri = "Rural";
			break;
		}
		default:
			break;
		}

	}
	
//#########################################################################################################################################################	NUEVO HASH
	
	public String funcionHash() {
		
		try {
			
			//System.out.println("impuesto: " + impuestoLiquidar +" Objeto: "+ objeto +  " planta:" + planta  + "Periodo: " + periodo);
			

			String hash = obtenerHashPorObjetoParaPDF(impuestoLiquidar, objeto, planta, periodo); // NUEVO será "objetoFormateado"?
		                                          
			

		 	//String link = "https://app.arba.gov.ar/pdfDeuda/emisiones/ARBADeuda/" + hash;
			 String link = "https://app.test.arba.gov.ar/pdfDeuda/emisiones/ARBADeuda/" + hash;
		
			
			switch (debitoCredito) {
			
			case "1":
			case "D":
			case "2": {
				

				
				medioPago = "<a href=\"" + link + "\">AQUÍ</a>";

				break;
			}
			case "0":
			case "C": {

				medioPago = "<a href=\"" + link + "\">Ingresar</a>";
				
				break;
			}
			default: {

				break;
			}
			}

			return medioPago;

		} catch (Exception e) {
		}
		
		
		

		medioPago = "<a href=\"" + Url + objeto + "\">Ingresar</a>";

		return medioPago;

	}
	
	
	
	//******************************************************************************************************************
	
	
	
public String obtenerHashPorObjetoParaPDF(String impuesto,String objeto,String planta, String periodo ) throws Exception, NoSuchAlgorithmException, UnsupportedEncodingException{


		
	
		if (Impuesto.equals("IC")) { // LA PLANTA DEBERIA IR SOLO EN COMPLEMENTARIO... 
			planta = "";
		}
	
	
		String clave = CLAVEHASH; 
		String hash = "";

		if(!planta.equals("")) {
			planta = planta.toUpperCase();
		}
		
		String impRevisado = impuestoRevisado(impuesto);
		
		/*boolean pltRevisada = plantaRevisada(impRevisado, planta);
			
		if(pltRevisada == false) {
			
		   throw new IllegalArgumentException("PLANTA INCORRECTA"); //Ver como tratan el error que corresponda
		   
			
		}*/
			
			
			
		if((impRevisado.equals("00")||impRevisado.equals("01")||impRevisado.equals("03")||impRevisado.equals("10"))&&periodo.length()==6) {	
				
		hash= getHashEmailNuevo(impRevisado, objeto, planta, periodo, clave);	
		}
		
		
		return hash;
	}
	
	


////////////////////////////////////////////////////// UTILS //////////////////////////////////////////


     /*
	 * Se acomoda-sobreescribe impuesto para que quede con unicidad de entrada y funcione en Queries
	 * @param impuesto a revisar
	 * @return impuesto formateado
	  */



     public String impuestoRevisado(String impuesto) {
			String imp = impuesto;
			try {
			
			switch(imp) {
			case "0":
				imp = "00";
				break;
			case "1":
				imp = "01";
				break;
			case "3":
				imp = "03";
				break;
			}
			}catch(Exception e) {
				System.out.println("El impuesto --> "+impuesto+" no pudo ser revisado");
			}
			
			return imp;
		}
		
	
   public  Boolean plantaRevisada(String impuesto, String planta) {
			boolean plantaCorrecta = false;
			
			if((impuesto.equals("00")|| impuesto.equals("10"))&&(planta.equals("E")||planta.equals("R")||planta.equals("B"))) plantaCorrecta=true;
			if(impuesto.equals("00")&&(planta.equals("E")||planta.equals("R")||planta.equals("B"))) plantaCorrecta=true;
			if(!impuesto.equals("00")&&(planta.equals("")||planta.equals("N"))) plantaCorrecta=true;
				
			return plantaCorrecta;
		} 




 /*
 * Hash de seguridad Para PDF por Email 
 * @param impuesto - valores posibles: 00,01,03,10
 * @param objeto sin espacios ni guiones
 * @param planta - valores posibles: E,R,B y vacia o N 
 * @param periodo - formato AAAAMM
 * @param valorH - valor de la clave para generar el hash
 * 
 * @return String con el hash a pasar por url
 * */

   


public String getHashEmailNuevo(String impuesto,String objeto,String planta,String periodo, String valorH) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	

	String hashFinal = "";
	
	if(!valorH.equals("")) {
				
	// Se acomoda objeto y planta
	objeto = objeto.equals("")?"": objeto.toUpperCase();			
	planta = planta.equals("")?"N":planta.toUpperCase();
	
	String text = valorH+impuesto+objeto+planta+periodo;
	
	MessageDigest sha256=MessageDigest.getInstance("SHA-256");
	sha256.update(text.getBytes("UTF-8"));
	byte[] digest = sha256.digest();
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<digest.length;i++){
		 sb.append(String.format("%02x", digest[i]));
	}
	String hash=sb.toString();		
	hashFinal = periodo+"_"+impuesto+hash.substring(0,hash.length()/2)+planta+hash.substring(hash.length()/2)+objeto;
	}
	
	return hashFinal;
}





//#########################################################################################################################################################	









	//////////////////////////////////// armado del string de QR:

	////////////////////////// ---QR ///////////////////

	public String generarStringQr() {

		QRContenido = "https://app.arba.gov.ar/PagoQR/imagencdni?url="
				+ "https%3A%2F%2fcdni.redlink.com.ar%2flinkarba.html%3Fprod%3Dcdniarba%26ente%3D" + Ente + "%26rubro%3D"
				+ Rubro + "%26cpe%3D" + codigoElectronico; // + "%26crc%3DXXXX"

		QRString = "<td class='gris'align=\"center\" valign=\"middle\" ><img src=" + "'" + QRContenido + "'"
				+ " height='100' width='100'></td> "; // style=\"padding: 1rem; border: solid 1px black;\"

		return QRString;

	}

	public void WithQRcod(String TipoDePago, String Impuesto) {

		switch (TipoDePago) {
		case "CO":
			switch (Impuesto) {
			case "AU":
			case "BA":
			case "ED":
			case "RU":
				ConQrCB = true;
				break;
			case "IC":
			case "EM":
				ConQrCB = false;
				break;
			default:

				break;
			}
			break;
		case "DT":
			switch (Impuesto) {
			case "AU":
			case "BA":
			case "ED":
			case "EM":
			case "RU":
			case "IC":
				ConQrCB = false;
				break;
			default:

				break;
			}
			break;
		default:

			break;
		}

		if (ConQrCB == true) {

			datosObjeto += QRString;
		}

	}

	private String formatearObjetoInmobiliario(String pObjeto) {

		String partido = pObjeto.substring(0, 3).replaceAll(" ", "");
		String partida = pObjeto.substring(3, 9).replaceAll(" ", "");
		String digito = pObjeto.substring(9, 10).replaceAll(" ", "");

		return (partido + "-" + partida + "-" + digito);
	}

	private String formatearObjetoComplementario(String pObjeto) {
		String partido = pObjeto.substring(0, 2).replaceAll(" ", "");
		String partida = pObjeto.substring(2, 9).replaceAll(" ", "");
		String digito = pObjeto.substring(9, 10).replaceAll(" ", "");

		return (partido + "-" + partida + "-" + digito);
	}

	private String formatearCuit(String pCuit) {

		String cuitFormateado = "";

		if (pCuit.length() == 11) {
			String primeraParte = pCuit.substring(0, 2);
			String dni = pCuit.substring(2, 10);
			String digito = pCuit.substring(10, 11);
			cuitFormateado = String.format("%s-%s-%s", primeraParte, dni, digito);
		}

		return cuitFormateado;

	}

	public static String obtenerFechaActual() {
		// Obtener la fecha actual
		LocalDate fechaActual = LocalDate.now();

		// Formatear la fecha en el formato especificado
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fechaActual.format(formatter);

		return fechaFormateada;
	}

	public static String trimEnd(String value) {
		return value.replaceFirst("\\s+$", "");
	}

	private void EscribirCabecera(Writer pSw) { /*-----------------------UTF8*/
		try {
			pSw.write("email|nombre|cuit|fechav|fechao|anio|cuota|impuesto|datos|descuento" + "\r\n"); // cambio de
																										// cierre a
																										// windows
																										// (CRLF)
			// pSw.append('\n');
		} catch (Exception e) {
		}

	}

	public static String StringaDate(String fechaCadena) {

		int anio, mes, dia;

		String Fechas;

		dia = Integer.valueOf(fechaCadena.substring(0, 2));
		mes = Integer.valueOf(fechaCadena.substring(3, 5));
		anio = Integer.valueOf(fechaCadena.substring(6, 10));

		ZoneId zoneId = ZoneId.of("Europe/Madrid");
		ZonedDateTime zdt = ZonedDateTime.of(anio, mes, dia, 0, 0, 0, 0, zoneId);
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		Locale locale = new Locale("es", "ES");
		formatter = formatter.withLocale(locale);

		String output = zdt.format(formatter);

		// ("zdt: " + zdt + " with locale: " + locale + " | output: " + output);

		Fechas = output;

		return Fechas;

	}

	public int Kont_barra;

	private String impuestoLiquidar = "";
	private String cuotaNumero = "";
	private String codigoElectronico = "";
	private String ImpuestoV = "";
	private String objeto = "";
	private String medioPago = "";
	private String debitoCredito = ""; // ejemplo con contenid previo
	private String mailAux = "";
	private String mail = "";
	private String razonsocialAux = "";
	private String cuitAux = "";
	private String cuit = "";
	private String razonsocial = "";
	private String porcentaje = "";
	private String anio = "";
	private String cuota = "";
	private String fechaVencimiento = "";
	private String fechaVencimientoNumero = "";
	private String montoCuota = "";
	private String montoAnual = "";
	private String planta = "";
	private String plantaDescri = "";
	private String fechaOpcion = "";
	private String datosObjeto = "";
	private String objetoFormateado = "";
	private int counter = 0;
	private String QRString = "";
	private String QRContenido = "";
	private String Ente = "";
	private String Rubro = "";
	private String ImpuestoCorto = "";
	public String nombreDeUltimo = "";
	public String formatted = "";
	public String Original = "";
	public int contadorerrorFecha = 0;
	public boolean click = true;
	public boolean seleccionerronea = true;
	public boolean inermail = true;
	public String Url;
	public String Impuesto;
	public String TipoDePago;
	public Boolean ConQrCB;
	public String Anual = "";
	String datosTodosObjetos = "";

	private String buenContribuyente = "";
	private String Variable = "";
	private String nombreImpuesto = "";
	private int distintos = 0;
	private int conterror = 0;
	
	public String CLAVEHASH ="akljf@?ha873254sgdkj%/&%'ndslfaf-lkhifewr3247";
	                      
	




}