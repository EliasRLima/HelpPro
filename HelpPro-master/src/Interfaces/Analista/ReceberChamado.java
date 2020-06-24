/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.Analista;

import Analista.Analista;
import Chamados.Chamado;
import Dao.DaoAnalista;
import Dao.DaoChamado;
import Dao.DaoPessoa;
import Interfaces.Login.Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class ReceberChamado extends javax.swing.JInternalFrame {

    private ArrayList<Chamado> chamados = new ArrayList<Chamado>();
    private int index_atual = 0;
    DaoChamado dc = new DaoChamado();
    
    public ReceberChamado() {
        initComponents();
        btReceber.setVisible(false);
        btAnterior.setVisible(false);
        btProximo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btReceber = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        btProximo = new javax.swing.JButton();
        btAnterior = new javax.swing.JButton();

        setClosable(true);
        setTitle("Novos chamados!");

        jLabel1.setText("Título:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btReceber.setText("Receber");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });

        txtTitulo.setFocusable(false);

        jLabel2.setText("Descrição:");

        txtDescricao.setFocusable(false);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel3.setText("Cliente:");

        txtCliente.setFocusable(false);

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha uma categoria", "Celulares e telefonia", "TVs", "Projetores", "Antenas, receptores e conversores", "Fotografia e filmadoras", "Computadores", "Notebook e netbook", "Ipad e tablet", "Impressoras e suplementos", "Videogames" }));

        btProximo.setText("Próximo");
        btProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximoActionPerformed(evt);
            }
        });

        btAnterior.setText("Anterior");
        btAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btProximo)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProximo)
                    .addComponent(btAnterior))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        this.chamados = new ArrayList<Chamado>();
        this.index_atual = 0;
        setChamados();
        if(this.chamados.size() > 0){
            visualizar();
        }else{
            //JOptionPane.showMessageDialog(null,"Não possui novos chamados nessa categoria!","AVISO",3);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        if(this.index_atual > 0){
            this.index_atual--;
            visualizar();
        }else{
            JOptionPane.showMessageDialog(null,"Esse é o primeiro na localizado!","ALERTA",3);
        }
    }//GEN-LAST:event_btAnteriorActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
       if(dc.estaConectado()){
           DaoAnalista dA = new DaoAnalista();
           DaoPessoa dP = new DaoPessoa();
           dA.estaConectado();dP.estaConectado();
           Analista analista = Login.getAnalista();
           if(dc.receberChamado(this.chamados.get(this.index_atual), analista)){
               JOptionPane.showMessageDialog(null,"Chamado recebido! Verifique seus chamados ativos!","SUCESSO",3);
               this.chamados = new ArrayList<Chamado>();
               setChamados();
               this.index_atual = 0;
               this.visualizar();
               this.dispose();
           }
       }
    }//GEN-LAST:event_btReceberActionPerformed

    private void btProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximoActionPerformed
        if(this.index_atual < this.chamados.size()-1){
            this.index_atual++;
            visualizar();
        }else{
            JOptionPane.showMessageDialog(null,"Esse é o ultimo na localizado!","ALERTA",3);
        }
    }//GEN-LAST:event_btProximoActionPerformed
    
    private void setChamados(){
        if(this.dc.estaConectado()){
            ArrayList<Chamado> newchamados = dc.buscarNovosChamados(cbCategoria.getSelectedIndex());
            if(newchamados != null && newchamados.size()>0){
                this.chamados = newchamados;
            }else{
                JOptionPane.showMessageDialog(null,"Não possui novos chamados nessa categoria!","AVISO",3);
                Limpar();
            }
            
        }
    }
    
    private void Limpar(){
        txtCliente.setText("");
        txtDescricao.setText("");
        txtTitulo.setText("");
        cbCategoria.setSelectedIndex(0);
    }
    
    private void visualizar(){
        if(this.dc.estaConectado()){
            if(this.index_atual==0 && this.index_atual!=this.chamados.size()-1){
                btAnterior.setVisible(false);
                btProximo.setVisible(true);
            }
            else if(this.index_atual==(this.chamados.size()-1) && this.index_atual!=this.chamados.size()-1){
                btProximo.setVisible(false);
                btAnterior.setVisible(true);
            }else if(this.index_atual>0 && this.index_atual<this.chamados.size()-1){
               btProximo.setVisible(true);
               btAnterior.setVisible(true); 
            }else if(this.index_atual==0 && this.index_atual==this.chamados.size()-1){
                btAnterior.setVisible(false);
                btProximo.setVisible(false);
            }
            
            if(cbCategoria.getSelectedItem().toString().equals("Escolha uma categoria")){
                btReceber.setVisible(false);
            }else if(!cbCategoria.getSelectedItem().toString().equals("Escolha uma categoria")){
                btReceber.setVisible(true);
            }
            Chamado atual = this.chamados.get(this.index_atual);
            txtTitulo.setText(atual.getTitulo());
            txtDescricao.setText(atual.getDescricao());
            txtCliente.setText(dc.getNomeCliente(atual));
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btProximo;
    private javax.swing.JButton btReceber;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
