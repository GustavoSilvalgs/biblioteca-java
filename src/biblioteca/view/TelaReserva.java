package biblioteca.view;

import biblioteca.controller.LivroController;
import biblioteca.controller.ReservaController;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class TelaReserva extends javax.swing.JFrame {

    private final LivroController livroController;
    private final ReservaController reservaController;

    public TelaReserva() {
        initComponents();
        this.livroController = new LivroController();
        this.reservaController = new ReservaController();
        loadTableLivros();
    }

    public void loadTableLivros() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Código", "Título", "Status"}, 0);
        List<Livro> livros = livroController.listarLivros();
        for (Livro livro : livros) {
            Object[] row = new Object[3];
            row[0] = livro.getId();
            row[1] = livro.getTitulo();
            row[2] = livro.getStatus();
            model.addRow(row);
        }
        tbLivros.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLivros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoReserva = new javax.swing.JTextField();
        btnReservarLivro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoDevolver = new javax.swing.JTextField();
        btnDevolverLivro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("RESERVA E DEVOLUÇÃO DE LIVROS");

        tbLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Título", "Status", "Id Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLivros);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("RESERVAR");

        jLabel3.setText("Informe o Código");

        txtCodigoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoReservaActionPerformed(evt);
            }
        });

        btnReservarLivro.setText("Reservar");
        btnReservarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarLivroActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("DEVOLVER");

        jLabel5.setText("Informe o Código");

        txtCodigoDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoDevolverActionPerformed(evt);
            }
        });

        btnDevolverLivro.setText("Devolver");
        btnDevolverLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverLivroActionPerformed(evt);
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReservarLivro)))))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnDevolverLivro)
                                        .addComponent(txtCodigoDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDevolverLivro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReservarLivro)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivrosMouseClicked

    }//GEN-LAST:event_tbLivrosMouseClicked

    private void txtCodigoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoReservaActionPerformed
        btnReservarLivroActionPerformed(evt);
    }//GEN-LAST:event_txtCodigoReservaActionPerformed

    private void txtCodigoDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoDevolverActionPerformed
        int livroId = Integer.parseInt(txtCodigoDevolver.getText());

        LivroController livroController = new LivroController();
        ReservaController reservaController = new ReservaController();

        boolean reservado = reservaController.verificarLivroReservado(livroId);

        if (reservado) {
            reservaController.devolverLivro(livroId);
            livroController.atualizarStatusLivro(livroId, "disponível");
            txtCodigoDevolver.setText("");

            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("O livro não pode ser devolvido, pois não está reservado.");
        }
    }//GEN-LAST:event_txtCodigoDevolverActionPerformed

    private void btnDevolverLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverLivroActionPerformed
        int livroId;
        try {
            livroId = Integer.parseInt(txtCodigoDevolver.getText());
        } catch (NumberFormatException ex) {
            System.out.println("Por favor, insira um ID de livro válido.");
            return;
        }

        if (!reservaController.verificarLivroReservado(livroId)) {
            System.out.println("O livro não pode ser devolvido, pois não está reservado.");
            return;
        }

        reservaController.devolverLivro(livroId);
        livroController.atualizarStatusLivro(livroId, "disponível");
        System.out.println("Livro devolvido com sucesso. Status atualizado para disponível.");
        txtCodigoDevolver.setText("");
        loadTableLivros();
    }//GEN-LAST:event_btnDevolverLivroActionPerformed

    private void btnReservarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarLivroActionPerformed
        String codigoLivroStr = txtCodigoReserva.getText().trim();
        if (codigoLivroStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o código do livro.", "Campo vazio", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int livroId;
        try {
            livroId = Integer.parseInt(codigoLivroStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O código do livro deve ser um número.", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (livroController.verificarDisponibilidadeLivro(livroId)) {
            reservaController.fazerReserva(livroId);
            livroController.atualizarStatusLivro(livroId, "reservado");
            loadTableLivros();
            System.out.println("Livro reservado com sucesso.");
            txtCodigoReserva.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "O livro selecionado já está reservado.", "Livro indisponível", JOptionPane.WARNING_MESSAGE);
        }
        loadTableLivros();
    }//GEN-LAST:event_btnReservarLivroActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolverLivro;
    private javax.swing.JButton btnReservarLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbLivros;
    private javax.swing.JTextField txtCodigoDevolver;
    private javax.swing.JTextField txtCodigoReserva;
    // End of variables declaration//GEN-END:variables
}
