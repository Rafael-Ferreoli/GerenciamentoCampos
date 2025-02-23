/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.GerenciadorProdutos;
import model.Produto;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.exception.ProdutoException;

/**
 *
 * @author rafae
 */
public class DlgCadastroProdutosJTable extends javax.swing.JDialog {

    private String produtoSelecionado;
    private boolean editando;
    private GerenciadorProdutos gerente;

    public DlgCadastroProdutosJTable(boolean modal) {
        this.editando = false;
        this.produtoSelecionado = "";
        // Em vez de "csv", coletamos o tipo de persistência da classe Persistencia
        this.gerente = new GerenciadorProdutos();
        initComponents();
        this.adicionarMascaraNosCampos();
        setTitle("Produtos");
        this.habilitarCampos(false);
        this.limparCampos();

        grdProdutos.setModel(gerente);

        gerente.carregarProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_CadastroProduto_Novo = new javax.swing.JButton();
        jButton_CadastroProduto_Editar = new javax.swing.JButton();
        jButton_CadastroProduto_Cancelar = new javax.swing.JButton();
        jButton_CadastroProduto_Excluir = new javax.swing.JButton();
        jButton_CadastroProduto_Salvar = new javax.swing.JButton();
        jLabel_CadastroProduto_Título = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_CadastroProduto_Nome = new javax.swing.JLabel();
        jLabel_CadastroProduto_Preco = new javax.swing.JLabel();
        jTextField_CadastroProduto_Nome = new javax.swing.JTextField();
        jTextField_CadastroProduto_Preço = new javax.swing.JTextField();
        jLabel_CadastroProduto_CodInterno = new javax.swing.JLabel();
        jLabel_CadastroProduto_CodBarras = new javax.swing.JLabel();
        jTextField_CadastroProduto_CodInterno = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_CadastroProduto_Quantidade = new javax.swing.JLabel();
        jTextField_CadastroProduto_Quantidade = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdProdutos = new javax.swing.JTable();
        jTextField_CadastroProduto_CodBarras = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jButton_CadastroProduto_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-novo.png"))); // NOI18N
        jButton_CadastroProduto_Novo.setText("Novo");
        jButton_CadastroProduto_Novo.setMaximumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Novo.setMinimumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Novo.setPreferredSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroProduto_NovoActionPerformed(evt);
            }
        });

        jButton_CadastroProduto_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-20.png"))); // NOI18N
        jButton_CadastroProduto_Editar.setText("Editar");
        jButton_CadastroProduto_Editar.setMaximumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Editar.setMinimumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Editar.setPreferredSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroProduto_EditarActionPerformed(evt);
            }
        });

        jButton_CadastroProduto_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-cancelar-20 (1).png"))); // NOI18N
        jButton_CadastroProduto_Cancelar.setText("Cancelar");
        jButton_CadastroProduto_Cancelar.setMaximumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Cancelar.setMinimumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Cancelar.setPreferredSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroProduto_CancelarActionPerformed(evt);
            }
        });

        jButton_CadastroProduto_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir.png"))); // NOI18N
        jButton_CadastroProduto_Excluir.setText("Excluir");
        jButton_CadastroProduto_Excluir.setMaximumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Excluir.setMinimumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Excluir.setPreferredSize(new java.awt.Dimension(100, 27));
        jButton_CadastroProduto_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroProduto_ExcluirActionPerformed(evt);
            }
        });

        jButton_CadastroProduto_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-salvar.png"))); // NOI18N
        jButton_CadastroProduto_Salvar.setText("Salvar");
        jButton_CadastroProduto_Salvar.setMaximumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Salvar.setMinimumSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Salvar.setPreferredSize(new java.awt.Dimension(110, 27));
        jButton_CadastroProduto_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroProduto_SalvarActionPerformed(evt);
            }
        });

        jLabel_CadastroProduto_Título.setFont(new java.awt.Font("Segoe UI", 1, 56)); // NOI18N
        jLabel_CadastroProduto_Título.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_CadastroProduto_Título.setText("Cadastro de Produtos");

        jLabel_CadastroProduto_Nome.setText("Nome:");

        jLabel_CadastroProduto_Preco.setText("Preço:");

        jTextField_CadastroProduto_Nome.setMaximumSize(new java.awt.Dimension(210, 22));
        jTextField_CadastroProduto_Nome.setMinimumSize(new java.awt.Dimension(210, 22));
        jTextField_CadastroProduto_Nome.setPreferredSize(new java.awt.Dimension(210, 22));

        jTextField_CadastroProduto_Preço.setMaximumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_Preço.setMinimumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_Preço.setPreferredSize(new java.awt.Dimension(190, 22));

        jLabel_CadastroProduto_CodInterno.setText("Código Interno:");

        jLabel_CadastroProduto_CodBarras.setText("Código de Barras:");

        jTextField_CadastroProduto_CodInterno.setMaximumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_CodInterno.setMinimumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_CodInterno.setPreferredSize(new java.awt.Dimension(190, 22));

        jLabel_CadastroProduto_Quantidade.setText("Quantidade:");

        jTextField_CadastroProduto_Quantidade.setMaximumSize(new java.awt.Dimension(83, 22));
        jTextField_CadastroProduto_Quantidade.setMinimumSize(new java.awt.Dimension(83, 22));
        jTextField_CadastroProduto_Quantidade.setPreferredSize(new java.awt.Dimension(83, 22));

        grdProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        grdProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grdProdutos);

        jTextField_CadastroProduto_CodBarras.setMaximumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_CodBarras.setMinimumSize(new java.awt.Dimension(190, 22));
        jTextField_CadastroProduto_CodBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_CadastroProduto_CodBarrasFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_CadastroProduto_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_CadastroProduto_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_CadastroProduto_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_CadastroProduto_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_CadastroProduto_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel_CadastroProduto_Título, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_CadastroProduto_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_CadastroProduto_Preco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_CadastroProduto_Preço, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_CadastroProduto_Quantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_CadastroProduto_Quantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField_CadastroProduto_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_CadastroProduto_CodBarras)
                            .addComponent(jLabel_CadastroProduto_CodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_CadastroProduto_CodInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_CadastroProduto_CodBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_CadastroProduto_Título, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CadastroProduto_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CadastroProduto_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CadastroProduto_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CadastroProduto_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CadastroProduto_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_CadastroProduto_Nome)
                            .addComponent(jTextField_CadastroProduto_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_CadastroProduto_Preco)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField_CadastroProduto_Preço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_CadastroProduto_Quantidade)
                                .addComponent(jTextField_CadastroProduto_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_CadastroProduto_CodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_CadastroProduto_CodInterno))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_CadastroProduto_CodBarras)
                            .addComponent(jTextField_CadastroProduto_CodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarMascaraNosCampos() {
        try {
            MaskFormatter maskCodBarra = new MaskFormatter("#############"); // 13 caracteres
            maskCodBarra.setValidCharacters("0123456789"); // Aceita apenas números
            maskCodBarra.setPlaceholder(""); // Remove o preenchimento automático
            maskCodBarra.install(jTextField_CadastroProduto_CodBarras);

        } catch (ParseException ex) {
            Logger.getLogger(DlgCadastroProdutosJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampos() {
        this.jTextField_CadastroProduto_Nome.setText("");
        this.jTextField_CadastroProduto_Preço.setText("");
        this.jTextField_CadastroProduto_CodBarras.setText("");
        this.jTextField_CadastroProduto_CodInterno.setText("");
        this.jTextField_CadastroProduto_Quantidade.setText("");
    }

    public void habilitarCampos(boolean flag) {
        this.jTextField_CadastroProduto_Nome.setEnabled(flag);
        this.jTextField_CadastroProduto_Preço.setEnabled(flag);
        this.jTextField_CadastroProduto_CodBarras.setEnabled(flag);
        this.jTextField_CadastroProduto_CodInterno.setEnabled(flag);
        this.jTextField_CadastroProduto_Quantidade.setEnabled(flag);
    }

    public Produto camposParaObjeto() {
        Produto produto = new Produto();
        try {
        produto.setNome(jTextField_CadastroProduto_Nome.getText());
        produto.setCodigoInterno(jTextField_CadastroProduto_CodInterno.getText());
        produto.setCodigoBarra(jTextField_CadastroProduto_CodBarras.getText());
        produto.setPreco(Double.parseDouble(jTextField_CadastroProduto_Preço.getText().trim()));
        produto.setQuantidade(Integer.parseInt(jTextField_CadastroProduto_Quantidade.getText().trim()));
    } catch (NumberFormatException e) {
        throw ProdutoException.camposInvalidos("Preço e Quantidade devem ser números válidos.");
    }
        return produto;
    }

    public void objetoParaCampos(Produto produto) {
        jTextField_CadastroProduto_Nome.setText(produto.getNome());
        jTextField_CadastroProduto_CodInterno.setText(produto.getCodigoInterno());
        jTextField_CadastroProduto_Preço.setText(String.valueOf(produto.getPreco()));
        jTextField_CadastroProduto_CodBarras.setText(produto.getCodigoBarra());
        jTextField_CadastroProduto_Quantidade.setText(String.valueOf(produto.getQuantidade()));
    }


    private void jButton_CadastroProduto_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroProduto_NovoActionPerformed
        this.limparCampos();
        this.habilitarCampos(true);
        this.editando = false;
    }//GEN-LAST:event_jButton_CadastroProduto_NovoActionPerformed

    private void jButton_CadastroProduto_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroProduto_EditarActionPerformed
        this.produtoSelecionado = JOptionPane.showInputDialog("Informe o código interno do produto selecionado:", "");
        Produto produtoEditando = this.gerente.buscarProduto(produtoSelecionado);
        if (produtoEditando != null) {
            this.editando = true;
            this.limparCampos();
            this.habilitarCampos(true);
            objetoParaCampos(produtoEditando);

        } else {
            System.out.println("produto inexistente");
            JOptionPane.showMessageDialog(this, "O código informado não foi encontrada no sistema.", "Cadastro Inexistente", HEIGHT);
        }
    }//GEN-LAST:event_jButton_CadastroProduto_EditarActionPerformed

    private void jButton_CadastroProduto_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroProduto_CancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;
    }//GEN-LAST:event_jButton_CadastroProduto_CancelarActionPerformed

    private void jButton_CadastroProduto_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroProduto_ExcluirActionPerformed
        this.produtoSelecionado = JOptionPane.showInputDialog("Informe o código interno do produto a ser excluído:", "");
        if (gerente.removerProduto(produtoSelecionado)) {
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.", "Produto Excluído", HEIGHT);
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", HEIGHT);
        }

    }//GEN-LAST:event_jButton_CadastroProduto_ExcluirActionPerformed

    private void jButton_CadastroProduto_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroProduto_SalvarActionPerformed
        try {
            Produto novoProduto = this.camposParaObjeto();

            if (this.editando) {
                this.gerente.atualizarProduto(this.produtoSelecionado, novoProduto);
            } else {
                this.gerente.adicionarProduto(novoProduto);
            }

            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.limparCampos();
            this.habilitarCampos(false);
            this.editando = false;

        } catch (ProdutoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DlgCadastroProdutosJTable.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_CadastroProduto_SalvarActionPerformed

    private void grdProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdProdutosMouseClicked
        // Verifica se o evento foi um duplo clique
        if (evt.getClickCount() == 2) {
            int row = grdProdutos.getSelectedRow(); // Obtém a linha selecionada
            if (row != -1) { // Verifica se há uma linha válida selecionada
                Produto produto = gerente.getProdutoAt(row); // Obtém o produto correspondente
                if (produto != null) {
                    this.produtoSelecionado = produto.getCodigoInterno(); // Salva o código interno do produto
                    this.editando = true;
                    this.habilitarCampos(true);
                    this.objetoParaCampos(produto); // Preenche os campos com os dados do produto
                } else {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_grdProdutosMouseClicked

    private void jTextField_CadastroProduto_CodBarrasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_CadastroProduto_CodBarrasFocusGained
        jTextField_CadastroProduto_CodBarras.setText(""); // Limpa o campo ao ganhar o foco
    }//GEN-LAST:event_jTextField_CadastroProduto_CodBarrasFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdProdutos;
    private javax.swing.JButton jButton_CadastroProduto_Cancelar;
    private javax.swing.JButton jButton_CadastroProduto_Editar;
    private javax.swing.JButton jButton_CadastroProduto_Excluir;
    private javax.swing.JButton jButton_CadastroProduto_Novo;
    private javax.swing.JButton jButton_CadastroProduto_Salvar;
    private javax.swing.JLabel jLabel_CadastroProduto_CodBarras;
    private javax.swing.JLabel jLabel_CadastroProduto_CodInterno;
    private javax.swing.JLabel jLabel_CadastroProduto_Nome;
    private javax.swing.JLabel jLabel_CadastroProduto_Preco;
    private javax.swing.JLabel jLabel_CadastroProduto_Quantidade;
    private javax.swing.JLabel jLabel_CadastroProduto_Título;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JFormattedTextField jTextField_CadastroProduto_CodBarras;
    private javax.swing.JTextField jTextField_CadastroProduto_CodInterno;
    private javax.swing.JTextField jTextField_CadastroProduto_Nome;
    private javax.swing.JTextField jTextField_CadastroProduto_Preço;
    private javax.swing.JTextField jTextField_CadastroProduto_Quantidade;
    // End of variables declaration//GEN-END:variables
}
