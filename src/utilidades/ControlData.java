package utilidades;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class ControlData {

	/**
	 * * Comprueba que el cÃ³digo estÃ© formado por tres dÃ­gitos seguidos de una
	 * letra
	 *
	 * @param codigo
	 * @throws CodigoIncorrecto
	 */
	public static boolean comprobarCodigo(String codigo) {
		boolean correcto = false;
		String valido = "\\d{3}[A-Z/a-z]";
		if (Pattern.matches(valido, codigo)) {
			correcto = true;
		} else {
			System.out.println("El cÃ³digo debe estar formado por tres dÃ­gitos seguidos de una letra");
		}
		return correcto;
	}

	/**
	 * Pide una fecha por teclado y la devuelve convertida a Date
	 * 
	 * @return
	 */

	public static Date pedirFecha() {

		Scanner sc = new Scanner(System.in);
		Pattern x = Pattern.compile("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}");
		Date fecha = null;

		do {
			System.out.println("Introduce la fecha, formato yyyy-MM-dd");
			String fechaString = ControlData.lerString(sc);

			Matcher y = x.matcher(fechaString);

			if (y.matches()) {

				int ano = Integer.parseInt(fechaString.substring(0, 4));
				int mes = Integer.parseInt(fechaString.substring(5, 7));
				int dia = Integer.parseInt(fechaString.substring(8, 10));

				fecha = new Date(ano - 1900, mes - 1, dia + 1);
			}
			if (fecha == null) {
				System.out.println("Formato no soportado");
			}

		} while (fecha == null);

		return fecha;

	}

	/**
	 * No entiendo por quÃ© es necesario, pero cuando llamaba al mÃ©todo anterior
	 * desde el mÃ©todo buscar, la fecha obtenida era diferente a la registrada en
	 * un dÃ­a. Fui incapaz de encontrar el origen del error, asÃ­ que tuve que
	 * parchear creando un nuevo mÃ©todo sin el ajuste en el dÃ­a.
	 * 
	 * @return
	 */

	public static Date pedirFecha2() {

		Scanner sc = new Scanner(System.in);
		Pattern x = Pattern.compile("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}");
		Date fecha = null;

		do {
			System.out.println("Introduce la fecha, formato yyyy-MM-dd");
			String fechaString = ControlData.lerString(sc);

			Matcher y = x.matcher(fechaString);

			if (y.matches()) {

				int ano = Integer.parseInt(fechaString.substring(0, 4));
				int mes = Integer.parseInt(fechaString.substring(5, 7));
				int dia = Integer.parseInt(fechaString.substring(8, 10));

				fecha = new Date(ano - 1900, mes - 1, dia);
			}
			if (fecha == null) {
				System.out.println("Formato no soportado");
			}

		} while (fecha == null);

		return fecha;

	}

	/**
	 * Comprueba que un DNI estÃ© compuesto de ocho dÃ­gitos seguidos de una letra
	 * vÃ¡lida
	 *
	 * @param dni
	 * @throws DniInvalido
	 */
	public static boolean comprobarDni(String dni) {
		boolean respuesta = true;
		String dniValido = "\\d{8}[A-HJ-NP-TV-Z]";
		if (!Pattern.matches(dniValido, dni)) {
			System.out.println("Por favor, introduzca un dni válido");
			respuesta = false;
		}
		return respuesta;
	}

	/**
	 * Comproba que un parÃ¡metro estÃ¡ dentro dun rango
	 *
	 * @param l1 Tipo int - lÃ­mite inferior del rango de nÃºmeros
	 * @param l2 Tipo int - lÃ­mite superior del rango de nÃºmeros
	 * @return Tipo boolean - true si estÃ¡ en el rango y false en caso contrario
	 */
	public static boolean rango(int l1, int l2, int op) {
		boolean enrango = true;
		if (op < l1 || op > l2) {
			enrango = false;
			System.out.println("\tERRO: debe introducir un valor dentro do rango de nÃºmeros posibles. "
					+ "\n\t\tVolva a introducir un nÃºmero: \n");
		}
		return enrango;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo byte - valor de tipo byte introducido por teclado
	 */
	public static byte lerByte(Scanner sc) {
		byte valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextByte()) {
				valor = sc.nextByte();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor vÃ¡lido. " + "\n\t\tVolva a introducir un nÃºmero: \n");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return valor Tipo short - valor de tipo short introducido por teclado
	 */
	public static short lerShort(Scanner sc) {
		short valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextShort()) {
				valor = sc.nextShort();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor numÃ©rico. " + "\n\t\tVolva a introducir un nÃºmero: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo int - valor de tipo int introducido por teclado
	 */
	public static int lerInt(Scanner sc) {
		int valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextInt()) {
				valor = sc.nextInt();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor numÃ©rico. " + "\n\t\tVolva a introducir un nÃºmero: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo long - valor de tipo long introducido por teclado
	 */
	public static long lerLong(Scanner sc) {
		long valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextLong()) {
				valor = sc.nextLong();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor numÃ©rico. " + "\n\t\tVolva a introducir un nÃºmero: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo float - valor de tipo float introducido por teclado
	 */
	public static float lerFloat(Scanner sc) {
		float valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextFloat()) {
				valor = sc.nextFloat();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor decimal. " + "\n\t\tVolva a introducir un nÃºmero: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo double - valor de tipo double introducido por teclado
	 */
	public static double lerDouble(Scanner sc) {
		double valor = 0;
		boolean repetir = true;

		do {
			if (sc.hasNextDouble()) {
				valor = sc.nextDouble();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor decimal. " + "\n\t\tVolva a introducir un nÃºmero: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo boolean - valor de tipo boolean introducido por teclado
	 */
	public static boolean lerBoolean(Scanner sc) {
		boolean valor = false;
		boolean repetir = true;

		do {
			if (sc.hasNextBoolean()) {
				valor = sc.nextBoolean();
				repetir = false;
			} else {
				System.out.println(
						"\tERRO: debe introducir un valor booleano. " + "\n\t\tVolva a introducir un booleano: ");
			}
			sc.nextLine();
		} while (repetir);

		return valor;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo String - valor de tipo String introducido por teclado
	 */
	public static String lerString(Scanner sc) {
		String resultado = null;

		do {
			resultado = sc.nextLine();
		} while (resultado.isEmpty());

		return resultado;
	}

/*
	    public static void verproductos(XQConnection connection) {

	        String consultaXQuery = "for $producto in collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc return $producto";
	        try {
	            XQExpression query = connection.createExpression();
	            XQResultSequence result = query.executeQuery(consultaXQuery);

	            System.out.println("----TODOS LOS PRODUCTOS----");
	            while (result.next()) {
	                System.out.println(result.getItemAsString(null));
	            }

	        } catch (XQException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void cuentaproduc(XQConnection connection) {

	        String consultaXQuery = "for $numProductos in count(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc[precio>50]) return $numProductos";
	        try {
	            XQExpression query = connection.createExpression();
	            XQResultSequence result = query.executeQuery(consultaXQuery);

	            System.out.print("NÚMERO DE PRODUCTOS CON PRECIO SUPERIOR A 50: ");
	            while (result.next()) {
	                System.out.println(result.getItemAsString(null));
	            }

	        } catch (XQException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void numporzona(XQConnection connection) {

	        String consultaXQuery = "for $zona in distinct-values(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc/cod_zona)\n"
	                + "let $con := count(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc[cod_zona = $zona])\n"
	                + "return concat('ZONA: ', $zona, '- NÚM. PRODUCTOS: ', $con)";
	        try {
	            XQExpression query = connection.createExpression();
	            XQResultSequence result = query.executeQuery(consultaXQuery);

	            System.out.println("--- NÚMERO DE PRODUCTOS POR ZONA --- ");
	            while (result.next()) {
	                System.out.println(result.getItemAsString(null));
	            }

	        } catch (XQException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void ejecutarconsultadefichero(XQConnection connection) {

	        //miconsulta.xq
	        File fichero = new File("miconsulta.xq");

	        String data = "";
	        try {

	            Scanner myReader = new Scanner(fichero);
	            while (myReader.hasNextLine()) {
	                data = myReader.nextLine();
	                System.out.println(data);
	            }
	            myReader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }

	        String consultaXQuery = data;

	        try {
	            XQExpression query = connection.createExpression();
	            XQResultSequence result = query.executeQuery(consultaXQuery);

	            System.out.println("--- PRODUCTOS CON PRECIO SUPERIOR A 50 Y DE LA ZONA 10 --- ");
	            while (result.next()) {
	                System.out.println(result.getItemAsString(null));
	            }

	        } catch (XQException e) {
	            e.printStackTrace();
	        }

	    }

	    public static void creaemple10(XQConnection connection) throws IOException {

	        String consultaXQuery = "for $empleados10 in collection('/db/ColeccionesXML/ColeccionPruebas')/EMPLEADOS/EMP_ROW[DEPT_NO=10] return $empleados10";
	        try {
	            XQExpression query = connection.createExpression();
	            XQResultSequence result = query.executeQuery(consultaXQuery);

	            BufferedWriter bw = new BufferedWriter(new FileWriter("NUEVO_EMPLE10.xml"));
	            bw.write("<?xml version='1.0' encoding='ISO-8859-1'?>" + "\n"+"<NUEVO_EMPLE10>\n");
	            while (result.next()) {
	                //String cad = result.toString();
	                String cad = result.getItem().getItemAsString(null);
	                //System.out.println(result.getItem().getItemAsString(null));
	                System.out.println(" output " + cad); // visualizamos
	                bw.write(cad + "\n"); // grabamos en el fichero

	            }
	            
	            bw.write("</NUEVO_EMPLE10>");

	            bw.close(); // Cerramos el fichero el fichero

	        } catch (XQException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void muestraDatosProductosXML(XQConnection connection) {

	        String consultaXQuery = "/productos";
	        try {
	            XQPreparedExpression query = connection.prepareExpression(consultaXQuery);
	            XQResultSequence result = query.executeQuery();

	            System.out.println("DATOS DE TODOS LOS DOCUMENTOS productos.xml");
	            while (result.next()) {
	                System.out.println(result.getItemAsString(null));
	            }

	        } catch (XQException e) {
	            e.printStackTrace();
	        }
	    }
	

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo char - valor de tipo char introducido por teclado
	 */
	public static char lerChar(Scanner sc) {
		String resultado = null;

		do {
			resultado = sc.nextLine();
		} while (resultado.isEmpty());

		return resultado.charAt(0);
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo char - valor de la pimera letra que se introduce por teclado
	 */
	public static char lerLetra(Scanner sc) {
		char caracter = '\0';

		do {
			caracter = (sc.nextLine()).charAt(0);
		} while (!Character.isLetter(caracter));

		return caracter;
	}

	/**
	 * Controla a introduciÃ³n correcta dunha variable tipo byte utilizando unha
	 * variable Scanner que se pasa por parÃ¡metro
	 *
	 * @param sc Tipo Scanner
	 * @return Tipo String - valor de tipo String introducido por teclado
	 */
	public static String lerNome(Scanner sc) {
		String nome = null;
		boolean repetir = true;

		do {
			nome = sc.nextLine();
			if (nome.isEmpty() || !nome.toUpperCase().matches("[A-ZÃ�Ã‰Ã�Ã“ÃšÃœÃ‘\\-\\s]*")) {
				System.out.print("\tERRO: debe introducir algÃºn nome vÃ¡lido " + "\n\t\tVolva a introducir: ");
			} else {
				repetir = false;
			}
		} while (repetir);

		return nome;
	}
}
