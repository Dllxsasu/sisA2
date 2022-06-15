/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Modelo.Usuario;
import Modelo.Conexion;

/**
 *
 * @author ALEX
 */
public class UsuarioController {
     public boolean Login(Usuario user) {
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        ResultSet rs = null;
        String sql = "SELECT username, password FROM usuario  WHERE username = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (user.getPassword().equals(rs.getString(2))) {
                    

                   // c.setDni(rs.getString(1));
                   // c.setNombres(rs.getString(2));
                    
                    return true;
                } else {
                    return false;
                }

            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     /*
     public boolean Registrar(CCliente c) {
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        
        String sqlM = "INSERT INTO cliente (idCliente,nombreClien,apellidoClien,telefonoClien,operador,correo,password) VALUES(?,?,?,?,?,?,?)"; 
        try {
                                               
            ps = conn.prepareStatement(sqlM);
            
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getApellidos());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getOperador());
            ps.setString(6, c.getCorreo());
            ps.setString(7, c.getPassword());
          
            
            ps.execute();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int ExisteUsuario(String usuario) {
        PreparedStatement ps = null;
        Connection conn = Conexion.getConnection();
        ResultSet rs = null;
        String sql = "SELECT count(idCliente) FROM cliente WHERE idCliente = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    
     public boolean esEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(correo);

        return matcher.find();

    }
*/
}
