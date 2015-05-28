/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.principal;


import Utilitarios.clsUtilidades;
import controlador.ClsUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.IdUsuario;
import utils.ModelClass;

/**
 *
 * @author JOEL
 */
public class FormUsuario extends javax.swing.JInternalFrame {

    IdUsuario idus = new IdUsuario();
    ClsUsuario clsus = new ClsUsuario();
    ModelClass modelo;
    ArrayList<IdUsuario> tableUsuario = new ArrayList<IdUsuario>() ;
    public FormUsuario() {
        initComponents();
        cargarCabecera();
        Cargar("", "");
    }
 private void cargarCabecera(){
   
            modelo = new ModelClass();
            modelo.addColumn("id_usuario");
            modelo.addColumn("login");
            modelo.addColumn("pw");
            tblGrid.setModel(modelo);
            tblGrid.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            tblGrid.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblGrid.getColumnModel().getColumn(1).setPreferredWidth(225);
            tblGrid.getColumnModel().getColumn(1).setPreferredWidth(225);    
// clsUtilidades.setOcultarColumnasJTable(tblGrid,new int[]{3,4,5,6,7,8});
           
    }
private void Cargar(String Filtro, String Condicion){
        

        if (Condicion.length() > 0){
            idus.setCondicion(" WHERE UPPER("+Filtro +") LIKE UPPER('%" + Condicion + "%') order by 1 ");
            
          tableUsuario = clsus.SeleccionarUsuario(idus);
        } else {
             idus.setCondicion(" order by 1 ");
          tableUsuario = clsus.SeleccionarUsuario(idus);
        }

        clsUtilidades.limpiarDatos(tblGrid,modelo);
        for(IdUsuario us: tableUsuario)
            {
                modelo.addRow(new Object[]{us.getId_usuario(),
                                         us.getLogin(),
                                         us.getPw()
                });
            }
    }
    private void addUsuario() {
        //idus.setId_usuario("2");
        idus.setLogin(this.TxtUsuario.getText());
        idus.setPw(this.TxtPw.getText());
        idus.setConfirmPw(this.TxtConfirmPw.getText());
        String result = clsus.createUsuario(idus);
        if(result.equals("1")){
            JOptionPane.showMessageDialog(null, "Proceso Efectuado con éxito",
                "INFORMACION DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        }else if(result.equals("2")){
            JOptionPane.showMessageDialog(null, "Proceso Efectuado sin éxito",
                "INFORMACION DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        }else if(result.equals("3")){
            JOptionPane.showMessageDialog(null, "Claves no coinciden",
                "INFORMACION DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        }
        Cargar("", "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtPw = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtConfirmPw = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGrid = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        BtnEditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtBuscar = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario:");
        jLabel1.setAutoscrolls(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 130, 25);
        jPanel1.add(TxtUsuario);
        TxtUsuario.setBounds(160, 30, 150, 25);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Contraseña");
        jLabel2.setAutoscrolls(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 60, 130, 25);
        jPanel1.add(TxtPw);
        TxtPw.setBounds(160, 70, 150, 25);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Confirmar Contraseña");
        jLabel3.setAutoscrolls(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 130, 25);
        jPanel1.add(TxtConfirmPw);
        TxtConfirmPw.setBounds(160, 110, 150, 25);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        BtnNuevo.setText("Nuevo");
        jPanel2.add(BtnNuevo);
        BtnNuevo.setBounds(11, 10, 63, 23);

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGuardar);
        BtnGuardar.setBounds(80, 10, 71, 23);

        BtnCancel.setText("Cancelar");
        jPanel2.add(BtnCancel);
        BtnCancel.setBounds(160, 10, 75, 23);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        tblGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblGrid);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(0, 2, 360, 140);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        BtnEditar.setText("Editar");
        jPanel4.add(BtnEditar);
        BtnEditar.setBounds(5, 8, 61, 25);

        jButton2.setText("Eliminar");
        jPanel4.add(jButton2);
        jButton2.setBounds(65, 8, 70, 25);

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyPressed(evt);
            }
        });
        jPanel4.add(TxtBuscar);
        TxtBuscar.setBounds(135, 8, 150, 25);

        BtnBuscar.setText("Buscar");
        BtnBuscar.setToolTipText("");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(BtnBuscar);
        BtnBuscar.setBounds(285, 8, 70, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        addUsuario();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
       Cargar("login",this.TxtBuscar.getText());
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        Cargar("login",this.TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtConfirmPw;
    private javax.swing.JTextField TxtPw;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblGrid;
    // End of variables declaration//GEN-END:variables

    
}
