
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.DatabaseManager;

public class ConexionXmldb {

    private static Collection obtenColeccion(String nomCol) throws Exception {
        Database dbDriver;
        Collection col;
        dbDriver = (Database) Class.forName("org.exist.xmldb.DatabaseImpl").newInstance();
        DatabaseManager.registerDatabase(dbDriver);
        col = DatabaseManager.getCollection(
                "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionesXML" + nomCol,
                "admin", "1234");
        return col;
    }

    public static void main(String[] args) {
        Collection col = null;
        try {
            col = obtenColeccion("/ColeccionGimnasio");
            System.out.println("Colecci�n actual: " + col.getName());

            int numHijas = col.getChildCollectionCount();
            System.out.println(numHijas + " colecciones hijas.");
            if (numHijas > 0) {
                String nomHijas[] = col.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    System.out.println("\t" + nomHijas[i]);
                }
            }
            int numDocs = col.getResourceCount();
            System.out.println(numDocs + " doocumentos.");
            if (numDocs > 0) {
                String nomDocs[] = col.listResources();
                for (int i = 0; i < numDocs; i++) {
                    System.out.println("\t" + nomDocs[i]);
                }
            }

            Service servicios[] = col.getServices();
            System.out.println("Servicios proporcionados por colecci�n " + col.getName() + ":");
            for (int i = 0; i < servicios.length; i++) {
                System.out.println("\t" + servicios[i].getName() + " - Versi�n: " + servicios[i].getVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (col != null) {
                    col.close();
                }
            } catch (XMLDBException e) {
                e.printStackTrace();
            }
        }
    }
}