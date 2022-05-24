package main;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;

import vista.VerMenu;

public class Main {

	public static void main(String[] args) throws XMLDBException {

		// EJERCICIOS XMLDB

		Collection col = conexion.ConexionXmldb.conectar();

		
		 
		 
		//VerMenu.menuPrincipal(col);
		//operaciones.OperacionesXMLDB.consultarPrecio50(col);
		
		col.close();
		
		
		
	}

}
