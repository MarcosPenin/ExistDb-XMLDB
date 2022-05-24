package conexion;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;

import net.xqj.exist.ExistXQDataSource;



public class ConexionXqj {

	//(not functional)
    
    public static XQConnection conectar() {

       XQConnection conexion = null;
       try {
    	   XQDataSource recurso = new ExistXQDataSource();
           recurso.setProperty("serverName", "localhost");
           recurso.setProperty("port", "8080");

           conexion = recurso.getConnection("admin", "1234");
       } catch (XQException e) {
           e.printStackTrace();
       }
       return conexion;
   }}
   
	
	
