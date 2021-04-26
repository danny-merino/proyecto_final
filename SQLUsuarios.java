
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLUsuarios extends Conexion {
    
    public boolean registrar(usuarios usr){
    
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            
            String sql = "INSERT INTO usuarios (Usuario,Contraseña,Nombre,Correo,id_tipo) Values(?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getContraseña());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
