/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm;

import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.model.Tipo;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import br.com.eugeniosolucoes.cfm.service.impl.ControleFinanceiroImpl;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author eugenio
 */
public class LancamentoView extends javax.swing.JFrame {

    IControleFinanceiro icf;

    List<Frequencia> frequencias;

    List<Categoria> categorias;

    Map<Tipo, List<Categoria>> categoriasPorTipo;

    /**
     * Creates new form LancamentoView
     */
    public LancamentoView() {
        initComponents();
        icf = new ControleFinanceiroImpl();
        icf.autenticar( "eugenio", "" );
        loadFrequencia();
        loadCategorias();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        txtInclusao.setText( sdf.format( new Date() ) );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        txtLancamento = new javax.swing.JTextField();
        txtLink = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        cmbFrequencia = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JFormattedTextField();
        txtInclusao = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listCategorias);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQuantidade.setText("1");
        txtQuantidade.setToolTipText("");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValor.setText("0");

        txtInclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtInclusao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLancamento)
                    .addComponent(txtLink)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(btnSalvar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFrequencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if ( cmbTipo.getActionCommand().equals( "comboBoxChanged" ) ) {
            if ( cmbTipo.getSelectedIndex() == 0 ) {
                loadCategoriasPorTipoLista( Tipo.DEBITO );
            } else {
                loadCategoriasPorTipoLista( Tipo.CREDITO );
            }
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String inclusao = tratarData( txtInclusao.getText() );
            String quantidade = tratarNumero( txtQuantidade.getText() );
            String valor = tratarNumero( txtValor.getText() );
            Lancamento lancamento = new Lancamento( Tipo.fromOrdinal( cmbTipo.getSelectedIndex() ),
                    txtLancamento.getText(), inclusao, quantidade, valor, 1 );
            icf.salvarLancamento( lancamento );
            JOptionPane.showMessageDialog( this, "Lançamento salvo com sucesso!" );
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog( this, e.getMessage() );
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private String tratarData( String text ) {
        String[] data = text.split( "/" );
        String inclusao = String.format( "%s-%s-%s", data[2], data[1], data[0] );
        return inclusao;
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ClassNotFoundException ex ) {
            java.util.logging.Logger.getLogger( LancamentoView.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger( LancamentoView.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger( LancamentoView.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger( LancamentoView.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                new LancamentoView().setVisible( true );
            }
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbFrequencia;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JFormattedTextField txtInclusao;
    private javax.swing.JTextField txtLancamento;
    private javax.swing.JTextField txtLink;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void loadFrequencia() {
        frequencias = icf.getFrequencias();
        frequencias.forEach( ( frequencia ) -> {
            cmbFrequencia.addItem( frequencia.getDescricao() );
        } );
    }

    private void loadCategorias() {
        categorias = icf.getCategorias();
        loadCategoriasPorTipo();
        loadCategoriasPorTipoLista( Tipo.DEBITO );
    }

    private void loadCategoriasPorTipoLista( Tipo tipo ) {
        List<Categoria> lista = categoriasPorTipo.get( tipo );
        Collections.sort( lista );
        DefaultListModel<String> model = new DefaultListModel<>();
        lista.forEach( ( categoria ) -> {
            model.addElement( categoria.getDescricao() );
        } );
        listCategorias.setModel( model );
    }

    private void loadCategoriasPorTipo() {
        categoriasPorTipo = new HashMap<>();
        categoriasPorTipo.put( Tipo.CREDITO, new ArrayList<>() );
        categoriasPorTipo.put( Tipo.DEBITO, new ArrayList<>() );
        for ( Categoria categoria : categorias ) {
            switch ( categoria.getTipo() ) {
                case CREDITO:
                    categoriasPorTipo.get( Tipo.CREDITO ).add( categoria );
                    break;
                case DEBITO:
                    categoriasPorTipo.get( Tipo.DEBITO ).add( categoria );
                    break;
            }
        }
    }

    private String tratarNumero( String text ) {
        return text.replace( ",", "." );
    }
}
