package operaciones;

import java.io.File;
import java.util.Scanner;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XPathQueryService;

public class Operaciones {
	static Scanner sc = new Scanner(System.in);

	public static void consultarEmp10(Collection col) throws XMLDBException {

		XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");

		String strAction = "for $emp in /EMPLEADOS/EMP_ROW[DEPT_NO = 10] return $emp";

		ResourceSet result = service.query(strAction);

		ResourceIterator i = result.getIterator();
		while (i.hasMoreResources()) {
			Resource r = (Resource) i.nextResource();
			System.out.println((String) r.getContent());
		}
	}

	public static void crearColeccionSubirArchivo(Collection col) {

		CollectionManagementService mgtService;
		try {
			mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
			System.out.println("Introduce el nombre de la nueva colección: ");
			String coleccion = sc.nextLine();
			mgtService.createCollection(coleccion);

			Collection collectionHija = col.getChildCollection(coleccion);
			File file = new File("biblioteca.xml");
			Resource resource = collectionHija.createResource(file.getName(), "XMLResource");
			resource.setContent(file);
			collectionHija.storeResource(resource);
			System.out.println("Se ha creado la colección " + coleccion + " con el archivo biblioteca.xml");

		} catch (XMLDBException e) {
			e.printStackTrace();

		}
	}

	public static void borrarColeccion(Collection col) {

		CollectionManagementService mgtService;
		try {
			mgtService = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
			System.out.println("Introduce el nombre de la coleccion : ");
			String nombre = sc.nextLine();
			mgtService.removeCollection(nombre);

		} catch (XMLDBException e) {
			e.printStackTrace();

		}
	}

	public static void borrarArchivo(Collection col) {

		Resource recursoParaBorrar;

		System.out.println("Introduce el nombre de la colección:");
		String nombreCol = sc.nextLine();

		System.out.println("Introduce el nombre del archivo a borrar");
		String nombre = sc.nextLine();
		try {
			Collection collectionHija = col.getChildCollection(nombreCol);
			recursoParaBorrar = collectionHija.getResource(nombre + ".xml");
			collectionHija.removeResource(recursoParaBorrar);
		} catch (XMLDBException e) {

			e.printStackTrace();
		}
	}

	public static void anadirDocumento(Collection col) {

		Collection collectionHija;
		try {
			collectionHija = col.getChildCollection("Varios");

			File file = new File("NuevosDepartamentos.xml");
			Resource resource = collectionHija.createResource(file.getName(), "XMLResource");
			resource.setContent(file);
			collectionHija.storeResource(resource);
			System.out.println("Se ha creado el archivo Nuevosdepartamentos en la colección Varios ");
		} catch (XMLDBException e) {

			e.printStackTrace();
		}
	}

	public static void borrarArchivoSiExiste(Collection col) {

		Resource recursoParaBorrar;
		try {
			Collection collectionHija = col.getChildCollection("Varios");
			recursoParaBorrar = collectionHija.getResource("NuevosDepartamentos.xml");

			if (recursoParaBorrar != null) {
				collectionHija.removeResource(recursoParaBorrar);
				System.out.println("Se ha borrado el recurso NuevosDepartamentos.xml");
			} else {
				System.out.println("El recurso no existe");
			}
		} catch (XMLDBException e) {

			e.printStackTrace();
		}
	}

	// UPDATE NO FUNCIONA
	public static void updateStock(Collection col) {

		XPathQueryService service;
		try {
			service = (XPathQueryService) col.getService("XPathQueryService", "1.0");

			String strAction = "for $produc in /PRODUCTOS let $stock_actual "
					+ ":= $produc/stock_actual return update value $produc/stock_actual with data($stockactual)+10";
			ResourceSet result = service.query(strAction);

		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// POR IMPLEMENTAR
	public static void guardarFichero() {
	}

	public static void consultarPrecio50(Collection col) {

		XPathQueryService service;
		try {
			service = (XPathQueryService) col.getService("XPathQueryService", "1.0");

			String strAction = "for $produc in /productos/produc[precio > 50 and cod_zona=10]  return $produc";

			ResourceSet result = service.query(strAction);

			ResourceIterator i = result.getIterator();
			while (i.hasMoreResources()) {
				Resource r = (Resource) i.nextResource();
				System.out.println((String) r.getContent());
			}
		} catch (XMLDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		

	}

}