/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Login;

import Cliente.Cliente;
import Dao.DaoCliente;
import Dao.DaoPessoa;
import Pessoa.Pessoa;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Cadastro extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
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

        txtSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        btCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastre-se no sistema!");

        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });

        jLabel4.setText("Data de Nascimento:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });

        jLabel3.setText("Senha:");

        cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um nível:", "iniciante", "Pouca experiência", "Conhecimentos básicos", "Exepriente em problemas básicos", "Conhecimento intermediário", "Exeperiente em geral", "Tecnologo em tecnologia", "Graduado em área tecnologica", "Conhecimento avançados", "Profissional" }));

        jLabel6.setText("Descreva seu conhecimento em problemas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txtCpf))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost
        //String senha = new String(txtSenha.getPassword());
        //JOptionPane.showMessageDialog(null, senha, "Senha", 3);
    }//GEN-LAST:event_txtSenhaFocusLost

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        try{
            Cliente cliente = new Cliente();
            String senha = new String(txtSenha.getPassword());
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigestSenhaAdmin[] = algorithm.digest(senha.getBytes("UTF-8"));
            StringBuilder hexStringSenhaAdmin = new StringBuilder();
            for (byte b : messageDigestSenhaAdmin) {
                hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
            }
            senha = hexStringSenhaAdmin.toString();
            //JOptionPane.showMessageDialog(null,senha,"CADASTRO", 3);
            String CPF = txtCpf.getText();
            CPF = CPF.replace(".", "");
            CPF = CPF.replace("-", "");
            String sexo = cbSexo.getSelectedItem().toString();
            int genero = 0;
            if(sexo.equals("Feminino")){
                genero = 1;
            }
            else if(sexo.equals("Masculino")){
                genero = 2;
            }
            Pessoa pCliente = new Pessoa(txtNome.getText(),CPF);
            pCliente.setDt_nasc(txtData.getText());
            pCliente.setSenha(senha);
            pCliente.setSexo(genero);
            pCliente.setTipo_papel(3);
            cliente.setPessoa(pCliente);
            cliente.setNvl_exp(cbNivel.getSelectedIndex());

            DaoCliente daoC = new DaoCliente();
            if(daoC.estaConectado()){
                if(cliente.getNvl_exp()==0){
                    JOptionPane.showMessageDialog(null,"Selecione seu nivel de conhecimento","CAMPO INCOMPLETO", 3);
                }else{
                    if(daoC.adicionar(cliente)){
                        JOptionPane.showMessageDialog(null,"Adicionado com sucesso!","CADASTRO", 3);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Erro ao tentar cadastrar! Analisaremos o ocorrido","CADASTRO", 3);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Não foi possivel conectar ao banco!","CADASTRO", 3);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"CADASTRO", 3);
        }

    }//GEN-LAST:event_btCadastrarActionPerformed

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        try{
            DaoPessoa dao = new DaoPessoa();
            if(dao.estaConectado()){
                String CPF = txtCpf.getText();
                CPF = CPF.replace(".","");
                CPF = CPF.replace("-", "");
                if(dao.cpfCadastrado(CPF)){
                    JOptionPane.showMessageDialog(null,"Esse CPF ja foi cadastrado!","ALERTA!", 3);
                }
                else{
                    //JOptionPane.showMessageDialog(null,"CPF sem cadastro! "+CPF,"OK",3);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel verificar o CPF!"+"\nErro: "+e.getMessage(), "ERRO", 3);
        }
    }//GEN-LAST:event_txtCpfFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JComboBox<String> cbNivel;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
