/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.Cliente;

import Chamados.Chamado;
import Cliente.Cliente;
import Dao.DaoChamado;
import Dao.DaoCliente;
import Dao.DaoPessoa;
import Interfaces.Login.Login;
import interfaces.GerenteDeJanelas;
import interfaces.VisualizarChamado;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class MeusChamados extends javax.swing.JInternalFrame {

    /**
     * Creates new form MeusChamados
     */
    GerenteDeJanelas gerenteDeJanelas;
    public MeusChamados(GerenteDeJanelas gdj) {
        initComponents();
        this.gerenteDeJanelas = gdj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btBuscarChamados = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();

        setClosable(true);
        setResizable(true);
        setTitle("Meus chamados");

        btBuscarChamados.setText("Buscar");
        btBuscarChamados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarChamadosActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo:");

        rb1.setSelected(true);
        rb1.setText("Todos");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        rb2.setText("Apenas abertos");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        rb3.setText("Apenas fechados");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb1)
                                .addGap(18, 18, 18)
                                .addComponent(rb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btBuscarChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1)
                    .addComponent(rb2)
                    .addComponent(rb3))
                .addGap(32, 32, 32)
                .addComponent(btBuscarChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarChamadosActionPerformed
        DaoChamado dc = new DaoChamado();
        DaoCliente dcliente = new DaoCliente();
        DaoPessoa dp = new DaoPessoa();
        if(dc.estaConectado() && dcliente.estaConectado() && dp.estaConectado()){
            try{
                int abertos = 0;
                if(rb1.isSelected()){
                    abertos = 0;
                }
                else if(rb2.isSelected()){
                    abertos = 1;
                }
                else if(rb3.isSelected()){
                    abertos = 2;
                }
                Cliente cliente = Login.getCliente();
                ArrayList<Chamado> chamados = dc.meusChamados(dcliente.getIdCliente(dp.getId(cliente.getPessoa().getCPF())),abertos,txtTitulo.getText());
                if(chamados.size()>0){
                    VisualizarChamado vs = new VisualizarChamado(chamados,2,this.gerenteDeJanelas,cliente,txtTitulo.getText());
                    this.gerenteDeJanelas.abrirJanelas(vs);
                }else{
                    JOptionPane.showMessageDialog(null,"Nenhum chamado localizado","AVISO",3);
                }
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"FALHA AO ABRIR VISUALIZAÇÃO",3);
            }
        }else{
                JOptionPane.showMessageDialog(null,"Não localizou nenhum chamado","BUSCAR",3);
        }
    }//GEN-LAST:event_btBuscarChamadosActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        rb1.setSelected(true);
        rb2.setSelected(false);
        rb3.setSelected(false);
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        rb1.setSelected(false);
        rb2.setSelected(true);
        rb3.setSelected(false);
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(true);
    }//GEN-LAST:event_rb3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarChamados;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}