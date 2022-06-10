/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examfinal_alvizurijose.script;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ggpo0
 */
public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/dbplato?serverTimezone=UTC"; 
    private static final String USUARIO="root"; 
    private static final String PASSWORD="casa"; 
    
    private static Connection cnn;
    
    public static synchronized Connection conectar(){
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             cnn=DriverManager.getConnection(URL,USUARIO,PASSWORD);
             System.out.println(" ------- conexion satisfactoria -------- ");
        } catch (Exception e) {
            System.out.println(" error en conexion ... "+e.getMessage());
        }
       return cnn;
    }
    
    public static void close(){
        try {
            if(cnn!=null){
                cnn.close();
            }
            System.out.println(" ----------------- conexion cerrada -------------- ");
        } catch (Exception e) {
            System.out.println(" error al cerrar conexion "+e.getMessage());
        }
    }
    
}
