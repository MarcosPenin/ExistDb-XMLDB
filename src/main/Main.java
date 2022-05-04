package main;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;

public class Main {

	public static void main(String[] args) throws XMLDBException {

		// EJERCICIOS XMLDB

		Collection col = conexion.ConexionXmldb.conectar();
		conexion.ConexionXmldb.verColeciones();
		conexion.ConexionXmldb.verRecursos();

		// operaciones.Operaciones.consultarEmp10(col);

		// operaciones.Operaciones.crearColeccionSubirArchivo(col);
		// operaciones.Operaciones.borrarColeccion(col);
		// operaciones.Operaciones.borrarArchivo(col);

		// operaciones.Operaciones.anadirDocumento(col);
		// operaciones.Operaciones.borrarArchivoSiExiste(col);

		// operaciones.Operaciones.updateStock(col);

		operaciones.Operaciones.consultarPrecio50(col);
	}

}
