/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces.Cliente;

import Chamados.Chamado;
import Cliente.Cliente;
import Dao.DaoCategoria;
import Dao.DaoChamado;
import Dao.DaoCliente;
import Dao.DaoPessoa;
import Interfaces.Login.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author 201612030327
 */
public class NovoChamado extends javax.swing.JInternalFrame {

    /**
     * Creates new form NovoChamado
     */
    public NovoChamado() {
        initComponents();
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
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        cbCategoria = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastrar chamado!");

        jLabel1.setText("Título:");

        jLabel2.setText("Descricão:");

        jLabel3.setText("Categoria:");

        jScrollPane1.setViewportView(txtDescricao);

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha uma categoria", "Celulares e telefonia", "TVs", "Projetores", "Antenas, receptores e conversores", "Fotografia e filmadoras", "Computadores", "Notebook e netbook", "Ipad e tablet", "Impressoras e suplementos", "Videogames" }));

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtTitulo)
                            .addComponent(cbCategoria, 0, 350, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String titulo =txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String categoria = cbCategoria.getSelectedItem().toString();
        DaoCategoria dc = new DaoCategoria();
        if(!titulo.equals("") && !descricao.equals("")){
            if(dc.estaConectado()){
            //JOptionPane.showMessageDialog(null,"Categoria: "+categoria+" id: "+dc.getId(categoria),"CATEGORIA",3);
            DaoChamado dcha = new DaoChamado();
            DaoCliente dcli = new DaoCliente();
            DaoPessoa dp = new DaoPessoa();
            if(dcha.estaConectado() && dcli.estaConectado() && dp.estaConectado()){
                Chamado chamado = new Chamado();
                chamado.setCategoria(dc.getId(categoria));
                chamado.setCliente(dcli.getIdCliente(dp.getId(Login.getCliente().getPessoa().getCPF())));
                chamado.setDescricao(descricao);
                chamado.setTitulo(titulo);
                if(chamado.getCategoria() != 0){
                    DaoCliente dcliente = new DaoCliente();
                    if(dcliente.estaConectado() && dp.estaConectado()){
                        Cliente cliente = Login.getCliente();
                        if(cliente.getChamados_num() < 5){
                            if(dcha.newChamado(chamado)){
                                cliente.setChamados_num(cliente.getChamados_num()+1);
                                dcliente.setNumChamados(cliente);
                                JOptionPane.showMessageDialog(null,"Seu chamado foi enviado! Em breve um analista irá responder.","NOVO CHAMADO", 3);
                            }
                        else{
                            JOptionPane.showMessageDialog(null,"Não cadastrado","NOVO CHAMADO", 3);
                             }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Você possui muitos chamados abertos! Aguarde antes de realizar um novo.","AVISO",3);
                            this.dispose();
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro: categoria invalida","FALHA EM CADASTRAR",3);
                }
            }
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!","ALERTA", 3);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
