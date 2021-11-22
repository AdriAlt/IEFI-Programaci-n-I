/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexioniefi;

import java.sql.SQLException;
import java.util.Scanner;


public class ConexionIEFI {



    
    public static void main(String[] args) throws SQLException {
        
        String usuario = "root";
        String clave = "abcd1234";
        String url = "jdbc:mysql://localhost:3306/iefi";
        
        Conexion conect = new Conexion(url,usuario,clave);
        
        
        Scanner entrada =new Scanner(System.in);
        int opcion = 0;
        
        do {
            // Menu de opciones
            System.out.println("1 - Listar datos de la base de datos");
            System.out.println("2 - Ingresar datos en la base de datos");
            System.out.println("3 - Actualizar datos en la base de datos");
            System.out.println("4 - Borrar datos de la base de datos");
            System.out.println("0 - Salir");
            //Se lee la opcion
            System.out.print("Elija una opcion: ");
            opcion=entrada.nextInt();
            
            switch (opcion) {
                
                case 0:
                    
                    System.out.println(" ");
                    System.out.println("Que tenga un buen dia");           
                    break;
                case 1: 
                    System.out.println(" ");
                    System.out.println("La lista de los alumnos es:");
                    //Llama al metodo listar
                    conect.listar();
                    System.out.println(" ");
                    break;
                    
                case 2:
                    
                    System.out.println("Ingrese el nombre del alumno:");
                    String nombre = entrada.next();
                    System.out.println("Ingrese el apellido del alumno:");
                    String apellido = entrada.next();
                    System.out.println("Ingrese el dni del alumno:");
                    int dni  = entrada.nextInt();
                    //Llama al metodo ingresar con los parametros
                    conect.insertar(nombre,apellido,dni);
                    System.out.println("Se ingresaron los datos");
                    System.out.println(" ");
                    break;
                case 3:
                    
                    System.out.println("Ingrese el id de alumno a actualizar:");
                    int idAct  = entrada.nextInt();
                    System.out.println("Ingrese el nombre del alumno:");
                    String nomAct = entrada.next();
                    System.out.println("Ingrese el apellido del alumno:");
                    String apellAct = entrada.next();
                    System.out.println("Ingrese el dni del alumno:");
                    int dniAct  = entrada.nextInt();
                    //Llama al metodo actualizar
                    conect.actualizar(idAct, nomAct, apellAct, dniAct);
                    System.out.println("Se actualizaron los datos");
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Ingrese el id de alumno a borrar:");
                    int idBorr  = entrada.nextInt();
                    //Llama al metodo borrar
                    conect.borrar(idBorr);
                    System.out.println("Se borraron los datos");
                    System.out.println(" ");
                    break;
                default:
                    
                    System.out.println("Elija una opcion del 0 al 4");
                
            }
        

        } while(opcion > 0);
    
}

}
