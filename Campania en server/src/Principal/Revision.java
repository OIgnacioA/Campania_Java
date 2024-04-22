package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

/*
 * 
 * 		
 * 
 */

public class Revision {

	public String Name;

	public Revision(String carpetaCSV, String Imp) {
		this.carpetaCSV = carpetaCSV;
		this.vuelta = 1;
		this.Imp = Imp;
	}

	public void UltimaRevision() {
		Tipo = "/DT";
		destinoActual = carpetaCSV + Tipo;
		File carpeta = new File(destinoActual);
		File[] archivos = carpeta.listFiles();

		System.out.println("   ");

		while (vuelta < 3) { // SE REVISAN CADA CARPETA POR SEPARADO: CO Y DT.

			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isFile() && archivo.getName().endsWith(".csv")) {

						try {
							Revisionado rev = new Revisionado(archivo.getAbsolutePath(), Imp); // Tipo,
							System.out.println("   ");
							Name = archivo.getName();
							System.out.println("revisando: " + Name);
							rev.chequeo(Name);
						} catch (IOException e) {
							System.out.println(
									"Error al procesar el archivo " + archivo.getName() + ": " + e.getMessage());
							         System.exit(0);
						}

					}
				}
			}

			Tipo = "/CO";
			destinoActual = carpetaCSV + Tipo; // "C:/Users/oscar.avendano/Desktop/Impuestos/Destino/AU/DT";//COLOCAR
												// DESTINO DESDE PRINCIPAL.
			carpeta = new File(destinoActual);
			archivos = carpeta.listFiles();
			vuelta++;
		}
		System.out.println("Revision terminada.");
	}

	private String carpetaCSV;
	public String destinoActual;
	private int vuelta = 1;
	public String Tipo;
	public String Imp;

}

class Revisionado {

	public Revisionado(String Path, String Imp) {// String Tipo,

		this.pathDestinoCSV = Path;
		// this.Tipo = Tipo;
		this.Imp = Imp;
	}

	public void chequeo(String Name) throws IOException {

		try {
			file = Files.newBufferedReader(Paths.get(pathDestinoCSV), StandardCharsets.ISO_8859_1);
			file.readLine();

		} catch (Exception e) {
			System.out.println("Excepcion cacht    1: " + e);
		}

		Nombre = Name;

		while ((line = file.readLine()) != null) {

			if (Nombre.contains("CO")) {//

				str1 = detectarYProcesar(line);// OBJETO EN <td class='gris'>
				str2 = detectarYProcesar2(line, Imp);// N-ELECTRONICO QR
				str3 = detectarYProcesar3_CO(line);// NUMERO en PDF

				

				Boolean coincidencia = alMenosDosIguales(str1, str2, str3);

				if (!coincidencia) {

					 System.out.println("se ha detectado una falta de coincidencias en el archivo: "+
                     Nombre + ". En la linea: " + counter);
					 System.exit(0);

				}

			} else {

				str1 = detectarYProcesar(line);// OBJETO EN <td class='gris'>
				str2 = detectarYProcesar3(line);// EN PDF

				if (!str2.contains(str1)) {

					System.out.println("se ha detectado una falta de coincidencias en el archivo: " + Nombre
							+ ". En la linea: " + counter);
					System.exit(0);

				}
			}

			counter++;
		}
		counter = 1;
	}

	// OBTENER NUMEROS DEL ORIGINAL

	public String detectarYProcesar(String line) {// OBJETO EN <td class='gris'>

		int index = line.indexOf("class='gris'>");

		int startIndex = index + 13; // Establecer la posición inicial después de "class='gris>'"
		int endIndex = line.indexOf('<', startIndex); // Obtener la posición del siguiente '<'

		if (endIndex != -1) {

			substr = line.substring(startIndex, endIndex).replaceAll("-", ""); // Obtener los caracteres hasta '<'

			TipoPatente = substr.length();

			return substr;

		} else {

			return "no 1";

		}

	}

	public String detectarYProcesar2(String line, String Imp) {// NUMERO DE PAGO ELECTRONICO en QR -CO

		int index2 = line.indexOf("%26cpe%3D"); // Buscar la cadena "%26cpe%3D" en la línea
		int startIndex2 = 0;
		int endIndex2 = 0;

		if (index2 != -1) {

			if (Imp.equals("EM")) { // LOS IMPUESTOS DAN DIFERENTES OBJETOS.

				startIndex2 = index2 + 13; // Establecer la posición inicial después de "%26cpe%3D"
				endIndex2 = Math.min(startIndex2 + 10, line.length());

			} else if (Imp.equals("AU")) {

				if (TipoPatente >= 7) { // HAY DOS TIPOS DE PATENTE

					startIndex2 = index2 + 12;
					endIndex2 = Math.min(startIndex2 + 11, line.length());

				} else {

					startIndex2 = index2 + 14;
					endIndex2 = Math.min(startIndex2 + 9, line.length());

				}

			} else { // OTROS RU BA ED

				startIndex2 = index2 + 13;
				endIndex2 = line.indexOf("'", startIndex2);

			}

			substr2 = line.substring(startIndex2, endIndex2);

			//System.out.println("--->" + substr2);
			return substr2;
		} else {

			return "no 2";
		}

	}

	public String detectarYProcesar3(String line) {// NUMERO en el PDF en DT

		String Npdf;
		int indice = line.indexOf("\">AQU");

		if (indice != -1 && indice >= 7) {
			Npdf = line.substring(indice - 10, indice);
			return Npdf;
		} else {
			System.out.println("No se encontró la cadena \">AQU \" o no hay suficientes caracteres antes.");
			System.exit(0);
			return "";
		}
	}

	public String detectarYProcesar3_CO(String line) {// NUMERO en el PDF en CO

		String Npdf = "";
		int indice = line.indexOf("\">Ingresar");

		if (indice != -1) {

			if (Imp.equals("AU")) { // AUTOMOTOR

				if (TipoPatente >= 7) {

					if (indice != -1 && indice >= 7) {
						Npdf = line.substring(indice - 7, indice);
						return Npdf;
					}

				} else {

					if (indice != -1 && indice >= 7) {
						Npdf = line.substring(indice - 6, indice);
						return Npdf;
					}
				}
				return "";

			} else if (Imp.equals("EM")) {

				Npdf = line.substring(indice - 5, indice);
				return Npdf;

			} else {// RU BA ED

				Npdf = line.substring(indice - 10, indice);
				return Npdf;

			}

		} else {

			System.out.println("No se encontró la cadena \">Ingresar \" o no hay suficientes caracteres antes.");
			System.exit(0);
			return "";
		}

	}

	public String convertNumberToString(String number) {

		String FirstPart = "";
		String FirstPart2 = "";
		String MiddleLetters = "";
		String LastPart = "";
		String LastPart2 = "";

		String FirstLetters = "";
		String FirstLetters2 = "";
		String SecondLetter = "";
		String SecondLetter2 = "";

		if (TipoPatente >= 7) {// DOS TIPOS DE PATENTE

			FirstPart = number.substring(0, 2);
			FirstPart2 = number.substring(2, 4);
			MiddleLetters = number.substring(4, 7);
			LastPart = number.substring(7, 9);
			LastPart2 = number.substring(9, 11);

			FirstLetters = obtenerLetra(FirstPart);
			FirstLetters2 = obtenerLetra(FirstPart2);
			SecondLetter = obtenerLetra(LastPart);
			SecondLetter2 = obtenerLetra(LastPart2);

			return FirstLetters + FirstLetters2 + MiddleLetters + SecondLetter + SecondLetter2;

		} else {// PATENTES CORTAS

			FirstPart = number.substring(0, 2);
			FirstPart2 = number.substring(2, 4);
			LastPart = number.substring(4, 6); // TERCER NUMERO
			LastPart2 = number.substring(6, 9); // NUMERO EN PATENTE

			FirstLetters = obtenerLetra(FirstPart);
			SecondLetter = obtenerLetra(FirstPart2);
			SecondLetter2 = obtenerLetra(LastPart);// TERCER NUMERO

			return FirstLetters + SecondLetter + SecondLetter2 + LastPart2;
		}

	}

	public String obtenerLetra(String num) {

		char letra;

		switch (num) {
		case "30":
			letra = 'A';
			break;
		case "31":
			letra = 'B';
			break;
		case "32":
			letra = 'C';
			break;
		case "33":
			letra = 'D';
			break;
		case "34":
			letra = 'E';
			break;
		case "35":
			letra = 'F';
			break;
		case "36":
			letra = 'G';
			break;
		case "37":
			letra = 'H';
			break;
		case "38":
			letra = 'I';
			break;
		case "39":
			letra = 'J';
			break;
		case "40":
			letra = 'K';
			break;
		case "41":
			letra = 'L';
			break;
		case "42":
			letra = 'M';
			break;
		case "43":
			letra = 'N';
			break;
		case "44":
			letra = 'O';
			break;
		case "45":
			letra = 'P';
			break;
		case "46":
			letra = 'Q';
			break;
		case "47":
			letra = 'R';
			break;
		case "48":
			letra = 'S';
			break;
		case "49":
			letra = 'T';
			break;
		case "50":
			letra = 'U';
			break;
		case "51":
			letra = 'V';
			break;
		case "52":
			letra = 'W';
			break;
		case "53":
			letra = 'X';
			break;
		case "54":
			letra = 'Y';
			break;
		case "55":
			letra = 'Z';
			break;
		default:
			letra = ' ';
			break;
		}
		String letraString = "" + letra;
		return letraString;
	}

	public boolean alMenosDosIguales(String str1, String str2, String str3) {

		if (str1.equals(str2) || str1.equals(str3)) {
			return true;
		}

		if (str2.equals(str3)) {
			return true;
		}

		return false;
	}
	// OBTENER NOMBRE DE ARCHIVO

	public String obtenerNombreArchivo(String ruta) {

		int lastIndex = ruta.lastIndexOf("/");

		if (lastIndex != -1 && lastIndex < ruta.length() - 1) {
			return ruta.substring(lastIndex + 1);
		} else {
			// Devuelve un valor predeterminado o lanza una excepción según tu requerimiento
			return "no-name";
		}
	}

	public int TipoPatente = 0;

	public String aresultado = "";
	public String pathDestinoCSV;
	BufferedReader file = null; // Declarar aquí para ampliar el ámbito
	public String line;
	public String objeto;
	public String Tipo;

	public String str2;
	public String str1;
	public String str3;
	public String substr;
	public String substr2;
	public String NumElec;
	public String Pat;
	public int counter = 1;
	public String Nombre;
	public String Imp;
}
