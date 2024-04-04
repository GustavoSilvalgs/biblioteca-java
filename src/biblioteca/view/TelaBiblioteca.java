package biblioteca.view;

import biblioteca.controller.AutorController;
import biblioteca.controller.LivroController;
import biblioteca.model.Autor;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class TelaBiblioteca extends javax.swing.JFrame {

    ArrayList<Autor> listaAutor;
    ArrayList<Livro> listaLivro;

    public void loadTableAutores() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Código", "Nome", "Sobrenome"}, 0);
        AutorController ac = new AutorController();
        List<Autor> autores = ac.listAutores();
        for (Autor autor : autores) {
            Object[] row = new Object[3];
            row[0] = autor.getId();
            row[1] = autor.getNome();
            row[2] = autor.getSobrenome();
            model.addRow(row);
            listaAutor.add(autor); // Populando a lista de autores
        }
        tbAutores.setModel(model);
    }

    public void loadTableLivros() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Código", "Título", "Data Publicação", "Id do Autor"}, 0);
        LivroController lc = new LivroController();
        List<Livro> livros = lc.listarLivros();
        for (Livro livro : livros) {
            Object[] row = new Object[4];
            row[0] = livro.getId();
            row[1] = livro.getTitulo();
            row[2] = livro.getDataPublicacao();
            row[3] = livro.getAutorId();
            model.addRow(row);
            listaLivro.add(livro); 
        }
        tbLivros.setModel(model);
    }

    public TelaBiblioteca() {
        initComponents();
        setLocationRelativeTo(null);
        listaAutor = new ArrayList();
        listaLivro = new ArrayList();
        handleInterface("Navigate");
        loadTableAutores();
        loadTableLivros();
    }

    private void handleInterface(String mode) {
        switch (mode) {
            case "Navigate":
                btnNewAutor.setEnabled(true);
                btnEditAutor.setEnabled(false);
                btnDeleteAutor.setEnabled(false);
                btnNewLivro.setEnabled(true);
                btnEditLivro.setEnabled(false);
                btnDeleteLivro.setEnabled(false);
                break;
            case "New":
                btnNewAutor.setEnabled(false);
                btnEditAutor.setEnabled(false);
                btnDeleteAutor.setEnabled(false);
                txtId.setEnabled(false);
                btnNewLivro.setEnabled(false);
                btnEditLivro.setEnabled(false);
                btnDeleteLivro.setEnabled(false);
                txtIdLivro.setEnabled(false);
                break;
            case "Edit":
                btnNewAutor.setEnabled(false);
                btnEditAutor.setEnabled(true);
                btnDeleteAutor.setEnabled(false);
                btnNewLivro.setEnabled(false);
                btnEditLivro.setEnabled(true);
                btnDeleteLivro.setEnabled(false);
                break;
            case "Delete":
                btnNewAutor.setEnabled(false);
                btnEditAutor.setEnabled(false);
                btnDeleteAutor.setEnabled(false);
                btnNewLivro.setEnabled(false);
                btnEditLivro.setEnabled(false);
                btnDeleteLivro.setEnabled(false);
                break;
            case "Select":
                btnNewAutor.setEnabled(false);
                btnEditAutor.setEnabled(true);
                btnDeleteAutor.setEnabled(true);
                btnNewLivro.setEnabled(false);
                btnEditLivro.setEnabled(true);
                btnDeleteLivro.setEnabled(true);
                break;
            default:
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        tbdPainelAutores = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAutores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnNewAutor = new javax.swing.JButton();
        btnEditAutor = new javax.swing.JButton();
        btnDeleteAutor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLivros = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdLivro = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        btnCancel1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtIdAutor = new javax.swing.JTextField();
        btnNewLivro = new javax.swing.JButton();
        btnEditLivro = new javax.swing.JButton();
        btnDeleteLivro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu3.setText("jMenu3");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Sobrenome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAutores.setColumnSelectionAllowed(true);
        tbAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAutores);
        tbAutores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbAutores.getColumnModel().getColumnCount() > 0) {
            tbAutores.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbAutores.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbAutores.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalhes do Autor"));

        jLabel1.setText("Código: ");

        jLabel2.setText("Nome: ");

        jLabel3.setText("Sobrenome: ");

        txtId.setEditable(false);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/ok.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/ok.png"))); // NOI18N
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSobrenome)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnNewAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/plus.png"))); // NOI18N
        btnNewAutor.setText("Novo");
        btnNewAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAutorActionPerformed(evt);
            }
        });

        btnEditAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/edit.png"))); // NOI18N
        btnEditAutor.setText("Editar");
        btnEditAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAutorActionPerformed(evt);
            }
        });

        btnDeleteAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/delete.png"))); // NOI18N
        btnDeleteAutor.setText("Excluir");
        btnDeleteAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnNewAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tbdPainelAutores.addTab("Autores", jPanel4);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("LOGIN");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Senha");

        jLabel6.setText("Usuário");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnLogin)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addComponent(btnLogin)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        tbdPainelAutores.addTab("Login", jPanel3);

        tbLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Data Publicação", "Id do Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalhes do Autor"));

        jLabel8.setText("Código: ");

        jLabel9.setText("Título: ");

        jLabel10.setText("Data Publicação");

        txtIdLivro.setEditable(false);

        btnCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/ok.png"))); // NOI18N
        btnCancel1.setText("Cancelar");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/ok.png"))); // NOI18N
        btnSave1.setText("Salvar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Id do Autor");

        txtIdAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnCancel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave1))
                .addContainerGap())
        );

        btnNewLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/plus.png"))); // NOI18N
        btnNewLivro.setText("Novo");
        btnNewLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLivroActionPerformed(evt);
            }
        });

        btnEditLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/edit.png"))); // NOI18N
        btnEditLivro.setText("Editar");
        btnEditLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditLivroActionPerformed(evt);
            }
        });

        btnDeleteLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/src/images/delete.png"))); // NOI18N
        btnDeleteLivro.setText("Excluir");
        btnDeleteLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditLivro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnNewLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnDeleteLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel5.getAccessibleContext().setAccessibleName("Detalhes do Livro");

        tbdPainelAutores.addTab("Livros", jPanel1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tbdPainelAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdPainelAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        handleInterface("Navigate");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         String nome = txtNome.getText();
    String sobrenome = txtSobrenome.getText();

    if (txtId.getText().isEmpty()) {
        Autor novoAutor = new Autor(nome, sobrenome);
        AutorController ac = new AutorController();
        ac.addAutor(novoAutor); 
        listaAutor.add(novoAutor); 
    } else {
        int id = Integer.parseInt(txtId.getText());
        Autor autorExistente = null;

        for (Autor autor : listaAutor) {
            if (autor.getId() == id) {
                autorExistente = autor;
                break;
            }
        }

        if (autorExistente != null) {
            autorExistente.setNome(nome);
            autorExistente.setSobrenome(sobrenome);
            AutorController ac = new AutorController();
            ac.updateAutor(autorExistente); 
        }
    }

    loadTableAutores();

    handleInterface("Navigate");
    txtId.setText("");
    txtNome.setText("");
    txtSobrenome.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAutorActionPerformed
        int index = tbAutores.getSelectedRow();

        if (index >= 0 && index < listaAutor.size()) {
            Autor autorSelecionado = listaAutor.get(index);

            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este autor?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                AutorController ac = new AutorController();
                ac.deleteAutor(autorSelecionado.getId());
                listaAutor.remove(index);
                loadTableAutores();
                handleInterface("Navigate");
                JOptionPane.showMessageDialog(null, "Autor excluído com sucesso!");
                txtId.setText("");
                txtNome.setText("");
                txtSobrenome.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um autor para excluir.");
        }

        loadTableAutores();
        handleInterface("Navigate");
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
    }//GEN-LAST:event_btnDeleteAutorActionPerformed

    private void btnEditAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAutorActionPerformed
        int index = tbAutores.getSelectedRow();

        if (index >= 0 && index < listaAutor.size()) {
            Autor autorSelecionado = listaAutor.get(index);

            int id = autorSelecionado.getId();

            txtId.setText(String.valueOf(id));
            txtNome.setText(autorSelecionado.getNome());
            txtSobrenome.setText(autorSelecionado.getSobrenome());

            txtId.setEditable(false);

            handleInterface("Edit");
        }

        loadTableAutores();
        handleInterface("Navigate");
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
    }//GEN-LAST:event_btnEditAutorActionPerformed

    private void btnNewAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAutorActionPerformed
        txtId.setEditable(true);
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        handleInterface("New");
    }//GEN-LAST:event_btnNewAutorActionPerformed

    private void tbAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAutoresMouseClicked
        int index = tbAutores.getSelectedRow();

        if (index >= 0 && index < listaAutor.size()) {
            Autor a = listaAutor.get(index);
            txtId.setText(String.valueOf(a.getId()));
            txtNome.setText(a.getNome());
            txtSobrenome.setText(a.getSobrenome());
            handleInterface("Select");

            txtId.setEditable(false);
        }
    }//GEN-LAST:event_tbAutoresMouseClicked

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        txtIdLivro.setText("");
        txtTitulo.setText("");
        txtData.setText("");
        txtIdAutor.setText("");
        handleInterface("Navigate");
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        String titulo = txtTitulo.getText();
        String dataPublicacaoString = txtData.getText();
        String autorIdString = txtIdAutor.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataPublicacaoUtil = dateFormat.parse(dataPublicacaoString);

            java.sql.Date dataPublicacao = new java.sql.Date(dataPublicacaoUtil.getTime());

            int autorId = Integer.parseInt(autorIdString);

            if (txtIdLivro.getText().isEmpty()) {
                Livro novoLivro = new Livro(titulo, dataPublicacao, autorId);
                listaLivro.add(novoLivro);
                LivroController lc = new LivroController();
                lc.cadastrarLivro(novoLivro);
            } else {
                int idLivro = Integer.parseInt(txtIdLivro.getText());
                Livro livroExistente = null;

                for (Livro livro : listaLivro) {
                    if (livro.getId() == idLivro) {
                        livroExistente = livro;
                        break;
                    }
                }

                if (livroExistente != null) {
                    livroExistente.setTitulo(titulo);
                    livroExistente.setDataPublicacao(dataPublicacao);
                    livroExistente.setAutorId(autorId);
                    LivroController lc = new LivroController();
                    lc.atualizarLivro(livroExistente);
                }
            }

            loadTableLivros();
            handleInterface("Navigate");
            txtIdLivro.setText("");
            txtTitulo.setText("");
            txtData.setText("");
            txtIdAutor.setText("");
        } catch (ParseException ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Erro ao converter ID do autor para inteiro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnNewLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLivroActionPerformed
        txtIdLivro.setEditable(true);
        txtIdLivro.setText("");
        txtTitulo.setText("");
        txtData.setText("");
        txtIdAutor.setText("");
        handleInterface("New");
    }//GEN-LAST:event_btnNewLivroActionPerformed

    private void btnEditLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLivroActionPerformed
        int index = tbLivros.getSelectedRow();

        if (index >= 0 && index < listaLivro.size()) {
            Livro livroSelecionado = listaLivro.get(index);

            int id = livroSelecionado.getId();

            txtIdLivro.setText(String.valueOf(id));
            txtTitulo.setText(livroSelecionado.getTitulo());
            txtData.setText(livroSelecionado.getDataPublicacao().toString()); //
            txtIdAutor.setText(String.valueOf(livroSelecionado.getAutorId())); 

            txtId.setEditable(false);

            handleInterface("Edit");
        }

        loadTableLivros();
        handleInterface("Navigate");
        txtIdLivro.setText("");
        txtTitulo.setText("");
        txtData.setText("");
        txtIdAutor.setText("");
    }//GEN-LAST:event_btnEditLivroActionPerformed

    private void btnDeleteLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLivroActionPerformed
        int index = tbLivros.getSelectedRow();

        if (index >= 0 && index < listaLivro.size()) {
            Livro livroSelecionado = listaLivro.get(index);

            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este livro?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                LivroController lc = new LivroController();
                lc.excluirLivro(livroSelecionado.getId());
                listaLivro.remove(index);
                loadTableLivros();
                handleInterface("Navigate");
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
                txtIdLivro.setText("");
                txtTitulo.setText("");
                txtData.setText("");
                txtIdAutor.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um livro para excluir.");
        }

        loadTableLivros();
        handleInterface("Navigate");
        txtIdLivro.setText("");
        txtTitulo.setText("");
        txtData.setText("");
        txtIdAutor.setText("");
    }//GEN-LAST:event_btnDeleteLivroActionPerformed

    private void txtIdAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAutorActionPerformed

    private void tbLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivrosMouseClicked
        int index = tbLivros.getSelectedRow();

        if (index >= 0 && index < listaLivro.size()) {
            Livro l = listaLivro.get(index);
            txtIdLivro.setText(String.valueOf(l.getId()));
            txtTitulo.setText(l.getTitulo());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataPublicacaoFormatada = dateFormat.format(l.getDataPublicacao());
            txtData.setText(dataPublicacaoFormatada);

            txtIdAutor.setText(String.valueOf(l.getAutorId()));
            handleInterface("Select");
            txtIdLivro.setEditable(false);
        }
    }//GEN-LAST:event_tbLivrosMouseClicked

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        login();
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        login();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void login() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "admin", "admin", "admin"));
        usuarios.add(new Usuario(2, "operador", "operador", "operador"));

        for (Usuario u : usuarios) {
            if (u.getNome().equals(usuario) && u.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                TelaReserva telaReserva = new TelaReserva();
                telaReserva.setVisible(true);
                this.dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Credenciais inválidas. Por favor, tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String args[]) throws InstantiationException, IllegalAccessException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnDeleteAutor;
    private javax.swing.JButton btnDeleteLivro;
    private javax.swing.JButton btnEditAutor;
    private javax.swing.JButton btnEditLivro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNewAutor;
    private javax.swing.JButton btnNewLivro;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAutores;
    private javax.swing.JTable tbLivros;
    private javax.swing.JTabbedPane tbdPainelAutores;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdAutor;
    private javax.swing.JTextField txtIdLivro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtSobrenome;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
