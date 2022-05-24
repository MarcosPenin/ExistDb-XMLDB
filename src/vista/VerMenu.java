package vista;

import java.util.ArrayList;
import java.util.Scanner;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;

import utilidades.Menu;
import utilidades.ControlData;
import operaciones.*;

public class VerMenu {

	static Scanner sc = new Scanner(System.in);
	static Menu menuApp = new Menu(opcionesApp());
	static byte op;

	public static void menuPrincipal(Collection col) throws XMLDBException {

		Menu menuPrincipal = new Menu(opciones());
		byte opMenu;
		System.out.println("*********************************************************************");
		System.out.println("****************************BIENVENIDO*********************** ");

		do {
			System.out.println("*********************************************************************");
			System.out.println("Introduzca la opción que desee realizar:");
			menuPrincipal.printMenu();
			opMenu = ControlData.lerByte(sc);
			switch (opMenu) {
			case 1:
				operaciones.OperacionesXMLDB.consultarEmp10(col);
				break;
			case 2:
				conexion.ConexionXmldb.verColeciones();
				conexion.ConexionXmldb.verRecursos();
				break;
			case 3:
				operaciones.OperacionesXMLDB.crearColeccionSubirArchivo(col);
				break;
			case 4:
				operaciones.OperacionesXMLDB.borrarColeccion(col);
				break;
			case 5:
				operaciones.OperacionesXMLDB.borrarArchivo(col);
				break;
			case 6:
				operaciones.OperacionesXMLDB.anadirDocumento(col);
				break;
			case 7:
				operaciones.OperacionesXMLDB.borrarArchivoSiExiste(col);
				break;
			case 8:
				operaciones.OperacionesXMLDB.updateStock(col);
				break;
			case 9:
				operaciones.OperacionesXMLDB.guardarFichero();
				break;
			case 10:
				operaciones.OperacionesXMLDB.consultarPrecio50(col);
				break;
			case 11:
				menuApp();
				break;
			}

		} while (opMenu != 11);
	}

	public static void menuApp() {
		System.out.println("*********************************************************************");
		System.out.println("Introduzca la opción que desee realizar:");
		menuApp.printMenu();
		op = ControlData.lerByte(sc);
		switch (op) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		}

	}

//	public static void menuBorrar() {
//		System.out.println("*********************************************************************");
//		System.out.println("¿Que desea borrar?");
//		menuTablas.printMenu();
//		op = ControlData.lerByte(sc);
//		switch (op) {
//		case 1:
//			Borrar.borrarAutor(session);
//			break;
//		case 2:
//			Borrar.borrarLibro(session);
//			break;	
//		}
//
//	}
//
//	public static void menuConsultar() {
//		System.out.println("*********************************************************************");
//		System.out.println("¿Que desea consultar?");
//		menuConsultas.printMenu();
//		op = ControlData.lerByte(sc);
////		switch (op) {
//		case 1:
//			Consultar.libro(session);
//			break;
//		case 2:
//			Consultar.librosAutor(session);
//			break;
//		case 3:
//			Consultar.libros(session);
//			break;
//		case 4:
//			Consultar.todo(session);
//			break;
//		}
//	}
//}

	static ArrayList<String> opciones() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Obtener empleados departamento 10");
		opciones.add("Ver colecciones y recursos");
		opciones.add("Crear colección y subir archivo");
		opciones.add("Borrar colección");

		opciones.add("Borrar fichero");
		opciones.add("Añadir fichero concreto a una colección");
		opciones.add("Borrar el fichero anterior");
		opciones.add("Incrementar stock en 10");
		opciones.add("Guardar documento");
		opciones.add("Consultar productos con precio >50 y zona 10");
		opciones.add("Aplicación");
		opciones.add("Salir");
		return opciones;
	}

	static ArrayList<String> opcionesApp() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Listar departamentos");
		opciones.add("Insertar un departamento");
		opciones.add("Consultar un departamento");
		opciones.add("Modificar un departamento");
		opciones.add("Borrar un departamento");
		return opciones;
	}

}
