
package conexioniefi;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    //Atributos de la clase para conexion a BD
    private  String usuario;
    private  String clave;
    private  String url;
        
    //Metodo constructor
    
    public Conexion(String url,String usr, String clave) {
        
        this.url = url;
        this.usuario = usr;
        this.clave = clave;
                
    }    
    
    //Metodo para conectar a la BD
    
    private Connection conectar() throws SQLException{
        
        Connection conex = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver cargado");
            } catch (Exception e) {
                System.out.println("Error en carga de driver" + e.getMessage());  
            }
        
        try {
            conex = DriverManager.getConnection(url,usuario,clave);
            //System.out.println("Conexion exitosa");
        } catch(Exception e){
            System.out.println("No se pudo conectar" + e.getMessage());  
        }
            return conex;
            
    }
    
    public void listar() throws SQLException{
        
        try {
        Connection listar  = conectar();
        Statement listado = listar.createStatement();
        ResultSet result = listado.executeQuery("SELECT * FROM iefi.Alumnos");
        while (result.next()) {                
                System.out.println(result.getInt("id_alumno")+" " +result.getString("nombre")+ " " +result.getString("apellido")+ " "+result.getInt("dni"));
            }
        listar.close();
        } catch (Exception e) {
            System.out.println("No se pudo listar" + e.getMessage());
        }
        
        
    }
    
    public void insertar(String nombre, String apellido, int dni){
        
        String sql = "INSERT INTO Alumnos(nombre,apellido,dni) VALUES (" + "'" + nombre + "'" + "," + "'" + apellido + "'" +  "," + "'" + dni + "'"+")";
        System.out.println(sql);
        
        try {
            Connection listar  = conectar();
            Statement insertar = listar.createStatement();
            insertar.executeUpdate(sql);
            listar.close();
        } catch (Exception e) {
            System.out.println("No se pudo insertar" + e.getMessage());
        }
    }
    
    
    
    public void actualizar(int id, String nombre, String apellido, int dni){
        
        String sql = "UPDATE iefi.Alumnos SET nombre="+"'"+nombre+"'" + ","+ " apellido=" + "'" + ","+ apellido + "'" + "," + " dni="+ "'"+dni+"'" + " WHERE id_alumno=" + id;
        
        try {
            Connection listar  = conectar();
            Statement actualizar = listar.createStatement();
            actualizar.executeUpdate(sql);
            listar.close();
            
        } catch (Exception e) {
            System.out.println("No se pudo insertar" + e.getMessage());
        }
    }
        
        
    public void borrar(int id){
        
        String sql = "DELETE FROM iefi.Alumnos WHERE id_alumno="+"'"+id+"'";
        
        try {
            Connection listar  = conectar();
            Statement borrar = listar.createStatement();
            borrar.executeUpdate(sql);
            System.out.println(sql);
            listar.close();
            
        } catch (Exception e) {
            System.out.println("No se pudo insertar" + e.getMessage());
        }
    }
            
}
    

