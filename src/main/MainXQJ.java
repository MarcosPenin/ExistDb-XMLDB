package main;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;

import org.xmldb.api.base.XMLDBException;



public class MainXQJ {

	//not functional
	
	public static void main(String[] args) throws XMLDBException {
		
		
	        XQConnection con = conexion.ConexionXqj.conectar();

	            
	            	

			
			
	        if (con != null) {
	            try {
					con.close();
				} catch (XQException e) {
					e.printStackTrace();
				}
	        }
			
			
		
        }
	
}
