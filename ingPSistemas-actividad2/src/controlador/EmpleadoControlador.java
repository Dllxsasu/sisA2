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
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
     public DefaultTableModel ListarEmpleados() {
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        ResultSet rs = null;
     
        String[] titulos = {"Codigo", "DNI", "nombres" , "Ape Paterno", "Ape Materno", "Genero", "Area", "F. Nacimiento", "F. ingreso", "Salario"};
        Object[] registro = new Object[10];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String cSQL = "SELECT `codigo`, `DNI`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `genero`, `fechaNacimiento`, `fechaIngresoEmpresa`, `salario` FROM `empleado`";

        try {
            ps = conn.prepareStatement(cSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getString(9);
               

                modelo.addRow(registro);
            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e + " error mostrar listar Estacion");
            return null;
        }
    }
     
    public boolean Modificar(){
        
        
        return false;
    }
    
}
