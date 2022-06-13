/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author sasu
 */
public class AreaControlador {
    public void listarComboArea(JComboBox cmb){
      
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        ResultSet rs = null;
      
        String cSQL = "SELECT * FROM Area";
        
        try {
            ps = conn.prepareStatement(cSQL);
            rs = ps.executeQuery();
                        
            while(rs.next()){
                cmb.addItem(rs.getString(3));                                                  
              
                
            }
                                  
           
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e + " error al listar combobox listarComboEstacionInicio");
            
        }
         
    } 
}
