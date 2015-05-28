/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author JOEL
 */
public class IdUsuario extends IdSistema {
    String id_usuario;
      
    String login, pw, confirmPw;

    public String getConfirmPw() {
        return confirmPw;
    }

    public void setConfirmPw(String confirmPw) {
        this.confirmPw = confirmPw;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
}
