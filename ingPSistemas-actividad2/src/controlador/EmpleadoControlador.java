/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Empleado;
/**
 *
 * @author sasu
 */
public class EmpleadoControlador {
    public boolean Registrar(Empleado empleado){
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        String sqlM = "INSERT INTO empleado"
                + "( `nombre`,dni ,`apellidoPaterno`, `apellidoMaterno`, `genero`, `fechaNacimiento`, `fechaIngresoEmpresa`, `salario`)"
                + " VALUES(?,?,?,?,?,?,?)"; 
        try {
                                               
            ps = conn.prepareStatement(sqlM);
            
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDNI());
            ps.setString(3, empleado.getApellidoPaterno());
            ps.setString(4, empleado.getApellidoMaterno());
            ps.setInt(5, empleado.getGenero());
            ps.setDate(6, empleado.getFechaNacimiento());
            ps.setDate(7, empleado.getFechaIngresoEmpresa());
          
            
            ps.execute();
            
            return true;

        } catch (SQLException ex) {
           // Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
            return false;
        }
    //    return false;
        
    }
    
    public boolean Modificar(){
        
        
        return false;
    }
    
}
