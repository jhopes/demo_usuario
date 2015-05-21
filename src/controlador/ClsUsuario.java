/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.conexion.ConexionBD;
import static controlador.conexion.ConexionBD.con;
import static controlador.conexion.ConexionBD.st;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.IdUsuario;

/**
 *
 * @author JOEL
 */
public class ClsUsuario {
    IdUsuario idus;
    ConexionBD cx;
    private String sql;
    public ClsUsuario() {
        cx = new ConexionBD();
        try {
            cx.AbrirConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClsUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean validaUsuario(IdUsuario idus){
        
        sql = "SELECT login, pw FROM usuario ";        
        boolean result=false;
        try {
            ResultSet rs = st.executeQuery(sql);
        
            if(rs!=null)
            {
                while(rs.next()){
                    System.out.println("holaaa");
                    if(rs.getString("login").equals(idus.getLogin()) && rs.getString("pw").equals(idus.getPw())){
                        result=true;
                    }
                }
            }
            
            //st.close();
            //rs.close();
            //con.close();
        } catch (Exception ex) {
            
        }
        return result;
        
    }
    public void createUsuario(int id, String login, String pw) 
    {
        
            sql="INSERT INTO usuario (id_usuario, login, pw) "
                    + "VALUES("+id+", '"+login+"', '"+pw+"')";
        try {    
            int result = st.executeUpdate(sql);
            System.out.println("result "+ result);
            if(result!=0){
                con.commit();
                System.out.println("Inserto correctamente "+ sql);
            }else{
                con.rollback();
                System.out.println("No insertó ");
            }
            //cx.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ClsUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
