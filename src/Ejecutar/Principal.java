/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejecutar;

import controlador.ClsUsuario;
import modelo.IdUsuario;
import vista.seguridad.FormUsuario;

/**
 *
 * @author JOEL
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ClsUsuario us = new ClsUsuario();
        //us.createUsuario(1, "jhopes", "123");
        /*FormUsuario f = new FormUsuario();
        f.setVisible(true);
        f.setSize(200, 200);*/
        IdUsuario idus = new IdUsuario();
        ClsUsuario clsus = new ClsUsuario();
        idus.setCondicion(" WHERE login LIKE '%jho%' order by 1 ");
        clsus.SeleccionarUsuario(idus);      
    }
    
}
