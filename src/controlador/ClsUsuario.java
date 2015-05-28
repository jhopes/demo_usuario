/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import Lib.DataBase.ScrollableTableModel;
import controlador.conexion.ConexionBD;
import static controlador.conexion.ConexionBD.con;
import static controlador.conexion.ConexionBD.st;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    ResultSet rs;
    ScrollableTableModel Model;
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
    public String createUsuario(IdUsuario idus) 
    {
        String id="";
       if(idus.getPw().equals(idus.getConfirmPw())){
           
           sql = "SELECT max(id_usuario+1) as id FROM usuario ";  
        try {
            ResultSet rs = st.executeQuery(sql);
        
            if(rs!=null)
            {
                while(rs.next()){
                    id = rs.getString("id");
                    
                }
            }
            
            //st.close();
            //rs.close();
            //con.close();
        } catch (Exception ex) {
            
        }
            sql="INSERT INTO usuario (id_usuario, login, pw) "
                    + "VALUES("+id+", '"+idus.getLogin()+"', '"+idus.getPw()+"')";
        try {    
            int result = st.executeUpdate(sql);
            System.out.println("result "+ result);
            if(result!=0){
                con.commit();
                System.out.println("Inserto correctamente "+ sql);
                return "1";
            }else{
                con.rollback();
                System.out.println("No insertó ");
                return "2";
            }
            //cx.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ClsUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return "2";
        }
       }else{
        return "3";
       }
    }

    public ArrayList SeleccionarUsuario(IdUsuario idus)
    {
        ArrayList ls = new ArrayList<String>();
            sql = "SELECT id_usuario , login, pw FROM usuario "+idus.getCondicion();
        try {
            
            rs = st.executeQuery(sql);
            //con.commit();
            while(rs.next()){
                IdUsuario us = new IdUsuario();
                us.setId_usuario(rs.getString("id_usuario"));
                us.setLogin(rs.getString("login"));
                us.setPw(rs.getString("login"));
                ls.add(us);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClsUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
    
    
}
