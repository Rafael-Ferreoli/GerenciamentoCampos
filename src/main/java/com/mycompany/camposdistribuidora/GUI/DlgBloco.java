/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.camposdistribuidora.GUI;

import com.mycompany.camposdistribuidora.Etiqueta;
import com.mycompany.camposdistribuidora.GerenciadorEtiquetas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class DlgBloco extends javax.swing.JDialog {

    private GerenciadorEtiquetas gerente;
    private String produtoSelecionado;
    private String numeroEtiqueta;
    private int numeroEtiquetaInt;
    private int numeroBlocoAtual;
    private LocalDate dataFormatada = null;
    String[] etiquetasText;

    /**
     * Creates new form DlgBloco
     */
    public DlgBloco(String nomeBloco, int numeroBloco, boolean modal) throws FileNotFoundException {
        this.produtoSelecionado = "";
        this.gerente = new GerenciadorEtiquetas();
        initComponents();
        jLabel_NomeBloco.setText(nomeBloco);
        setNumEtq(numeroBloco);
        numeroBlocoAtual = numeroBloco;
        gerente.carregarDoArquivo("ListagemEtiquetas.csv");
        desabilitarCampos(false);
        etiquetasText = gerente.toStringArray();
        atualizarTextAreas(etiquetasText);
    }

    public void atualizarTextAreas(String[] textos) {
        int inicio = numeroBlocoAtual * 6;
        int fim = inicio + 6;

        // Verifica se o índice final é maior que o tamanho do array textos
        if (fim > textos.length) {
            // Define fim como o tamanho máximo do array textos
            fim = textos.length;
        }
        System.out.println(inicio + 3);
        jTextArea_EtiquetaPrimeiroBloco.setText(obterTextoFormatado(textos, inicio));
        jTextArea_EtiquetaSegundoBloco.setText(obterTextoFormatado(textos, inicio + 1));
        jTextArea_EtiquetaTerceiroBloco.setText(obterTextoFormatado(textos, inicio + 2));
        jTextArea_EtiquetaQuartoBloco.setText(obterTextoFormatado(textos, inicio + 3));
        jTextArea_EtiquetaQuintoBloco.setText(obterTextoFormatado(textos, inicio + 4));
        jTextArea_EtiquetaSextoBloco.setText(obterTextoFormatado(textos, inicio + 5));
    }

    private String obterTextoFormatado(String[] textos, int indice) {
        if (indice >= 0) {
            return textos[indice];
        } else {
            return ""; // Retorna uma string vazia se o índice estiver fora dos limites
        }
    }

    public void desabilitarCampos(boolean flag) {
        jTextArea_EtiquetaPrimeiroBloco.setEditable(flag);
        jTextArea_EtiquetaSegundoBloco.setEditable(flag);
        jTextArea_EtiquetaTerceiroBloco.setEditable(flag);
        jTextArea_EtiquetaQuartoBloco.setEditable(flag);
        jTextArea_EtiquetaQuintoBloco.setEditable(flag);
        jTextArea_EtiquetaSextoBloco.setEditable(flag);
    }
        
    public void setNumEtq(int numeroBloco) {
 
        jLabel_PrimeiraEtqBloco.setText(String.valueOf(numeroBloco + 1));
        jLabel_SegundaEtqBloco.setText(String.valueOf(numeroBloco + 2));
        jLabel_TerceiraEtqBloco.setText(String.valueOf(numeroBloco + 3));
        jLabel_QuartaEtqBloco.setText(String.valueOf(numeroBloco + 4));
        jLabel_QuintaEtqBloco.setText(String.valueOf(numeroBloco + 5));
        jLabel_SextaEtqBloco.setText(String.valueOf(numeroBloco + 6));
    }

    private boolean codigoInternoExiste(String codigoInterno) {
        try (BufferedReader reader = new BufferedReader(new FileReader("ListagemProdutos.csv"))) {
            String line;
            // Ignora o cabeçalho
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2 && parts[1].equals(codigoInterno)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_NomeBloco = new javax.swing.JLabel();
        jLabel_QuintaEtqBloco = new javax.swing.JLabel();
        jLabel_QuartaEtqBloco = new javax.swing.JLabel();
        jLabel_SegundaEtqBloco = new javax.swing.JLabel();
        jLabel_PrimeiraEtqBloco = new javax.swing.JLabel();
        jLabel_TerceiraEtqBloco = new javax.swing.JLabel();
        jLabel_SextaEtqBloco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaSegundoBloco = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaPrimeiroBloco = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaQuartoBloco = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaQuintoBloco = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaSextoBloco = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea_EtiquetaTerceiroBloco = new javax.swing.JTextArea();
        jButton_AdicionarProdutoEqt = new javax.swing.JButton();
        jButton_RemoverProdutoEqt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 473));
        setMinimumSize(new java.awt.Dimension(350, 473));
        setModal(true);

        jLabel_NomeBloco.setText("nome");

        jLabel_QuintaEtqBloco.setText("etq5");
        jLabel_QuintaEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_QuintaEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_QuintaEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jLabel_QuartaEtqBloco.setText("etq4");
        jLabel_QuartaEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_QuartaEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_QuartaEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jLabel_SegundaEtqBloco.setText("etq2");
        jLabel_SegundaEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_SegundaEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_SegundaEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jLabel_PrimeiraEtqBloco.setText("etq1");
        jLabel_PrimeiraEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_PrimeiraEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_PrimeiraEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jLabel_TerceiraEtqBloco.setText("etq3");
        jLabel_TerceiraEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_TerceiraEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_TerceiraEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jLabel_SextaEtqBloco.setText("etq6");
        jLabel_SextaEtqBloco.setMaximumSize(new java.awt.Dimension(35, 25));
        jLabel_SextaEtqBloco.setMinimumSize(new java.awt.Dimension(35, 25));
        jLabel_SextaEtqBloco.setPreferredSize(new java.awt.Dimension(35, 25));

        jTextArea_EtiquetaSegundoBloco.setColumns(20);
        jTextArea_EtiquetaSegundoBloco.setRows(5);
        jTextArea_EtiquetaSegundoBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaSegundoBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(jTextArea_EtiquetaSegundoBloco);

        jTextArea_EtiquetaPrimeiroBloco.setColumns(20);
        jTextArea_EtiquetaPrimeiroBloco.setRows(5);
        jTextArea_EtiquetaPrimeiroBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaPrimeiroBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane2.setViewportView(jTextArea_EtiquetaPrimeiroBloco);

        jTextArea_EtiquetaQuartoBloco.setColumns(20);
        jTextArea_EtiquetaQuartoBloco.setRows(5);
        jTextArea_EtiquetaQuartoBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaQuartoBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane3.setViewportView(jTextArea_EtiquetaQuartoBloco);

        jTextArea_EtiquetaQuintoBloco.setColumns(20);
        jTextArea_EtiquetaQuintoBloco.setRows(5);
        jTextArea_EtiquetaQuintoBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaQuintoBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane4.setViewportView(jTextArea_EtiquetaQuintoBloco);

        jTextArea_EtiquetaSextoBloco.setColumns(20);
        jTextArea_EtiquetaSextoBloco.setRows(5);
        jTextArea_EtiquetaSextoBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaSextoBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane5.setViewportView(jTextArea_EtiquetaSextoBloco);

        jTextArea_EtiquetaTerceiroBloco.setColumns(20);
        jTextArea_EtiquetaTerceiroBloco.setRows(5);
        jTextArea_EtiquetaTerceiroBloco.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea_EtiquetaTerceiroBloco.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane6.setViewportView(jTextArea_EtiquetaTerceiroBloco);

        jButton_AdicionarProdutoEqt.setText("add");
        jButton_AdicionarProdutoEqt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AdicionarProdutoEqtActionPerformed(evt);
            }
        });

        jButton_RemoverProdutoEqt.setText("remo");
        jButton_RemoverProdutoEqt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoverProdutoEqtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_NomeBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AdicionarProdutoEqt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_RemoverProdutoEqt)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_QuartaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_TerceiraEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_PrimeiraEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_SegundaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_QuintaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_SextaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_NomeBloco)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_AdicionarProdutoEqt)
                            .addComponent(jButton_RemoverProdutoEqt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_QuintaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_SextaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_QuartaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_TerceiraEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_SegundaEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_PrimeiraEtqBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AdicionarProdutoEqtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AdicionarProdutoEqtActionPerformed
        boolean inputValido = false;

        while (!inputValido) {
            try {
                // Verifica se o código interno existe na lista de produtos
                this.produtoSelecionado = JOptionPane.showInputDialog("Informe o código interno do produto a ser adicionado a etiqueta:", "");
                if (!codigoInternoExiste(this.produtoSelecionado)) {
                    // Produto não encontrado, exibe mensagem de erro e sai do loop
                    JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    // Produto encontrado, continua com o processo
                    System.out.println("Produto encontrado: " + this.produtoSelecionado);
                }
                // Solicita o número da etiqueta
                this.numeroEtiqueta = JOptionPane.showInputDialog("Informe o número da etiqueta do bloco a ser adicionado o produto:", "");
                if (this.numeroEtiqueta == null) {
                    // Usuário cancelou a entrada, saindo do loop
                    break;
                }
                // Converte a string numeroEtiqueta para inteiro
                numeroEtiquetaInt = Integer.parseInt(this.numeroEtiqueta);
                // Verifica se a etiqueta está no intervalo correto
                if (numeroEtiquetaInt >= numeroBlocoAtual + 1 && numeroEtiquetaInt <= numeroBlocoAtual + 6) {
                    // Solicita a data
                    String data = JOptionPane.showInputDialog("Informe a data (no formato dd/mm/aaaa):", "");
                    if (data == null) {
                        // Usuário cancelou a entrada, saindo do loop
                        break;
                    }

                    try {
                        // Converte a String de data para um objeto LocalDate
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        dataFormatada = LocalDate.parse(data, formatter);

                        // Data está no formato correto
                        JOptionPane.showMessageDialog(this, "Data informada: " + dataFormatada, "Data Informada", JOptionPane.INFORMATION_MESSAGE);

                        // Aqui você pode adicionar o código para processar a data
                        inputValido = true;  // Dados válidos, saindo do loop
                    } catch (DateTimeParseException e) {
                        // Tratamento de erro se a entrada do usuário não estiver no formato esperado
                        JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/mm/aaaa.", "Data Inválida", JOptionPane.ERROR_MESSAGE);
                    }

                    // Aqui você pode adicionar o código para processar a data e o produto
                    // Cria uma nova etiqueta com os dados inseridos
                    Etiqueta novaEtiqueta = new Etiqueta(this.produtoSelecionado, dataFormatada, numeroEtiquetaInt);

                    // Adiciona a nova etiqueta à lista de etiquetas
                    this.gerente.adicionarEtiqueta(novaEtiqueta);
                    etiquetasText = gerente.toStringArray();
                    atualizarTextAreas(etiquetasText);
                    // Salva as etiquetas no arquivo após adicionar a nova etiqueta
                    this.gerente.salvarNoArquivo("ListagemEtiquetas.csv");

                    // Informa ao usuário que a etiqueta foi adicionada com sucesso
                    JOptionPane.showMessageDialog(this, "Etiqueta adicionada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    inputValido = true;  // Dados válidos, saindo do loop
                } else {
                    // Etiqueta fora do intervalo, reiniciando o processo
                    JOptionPane.showMessageDialog(this, "A etiqueta informada não foi encontrada nesse bloco.", "Etiqueta Inválida", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Tratamento de erro caso a conversão para inteiro falhe, reiniciando o processo
                JOptionPane.showMessageDialog(this, "Número de etiqueta inválido. Insira um número inteiro.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(DlgBloco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_AdicionarProdutoEqtActionPerformed

    private void jButton_RemoverProdutoEqtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoverProdutoEqtActionPerformed
        boolean inputValido = false;

        while (!inputValido) {
            try {
                // Solicita o número da etiqueta a ser removida
                String numeroEtiqueta = JOptionPane.showInputDialog("Informe o número da etiqueta do bloco a ser removida:", "");
                if (numeroEtiqueta == null) {
                    // Usuário cancelou a entrada, saindo do loop
                    break;
                }
                // Converte a string numeroEtiqueta para inteiro
                int numeroEtiquetaInt = Integer.parseInt(numeroEtiqueta);

                // Verifica se a etiqueta está no intervalo correto
                if (numeroEtiquetaInt >= numeroBlocoAtual + 1 && numeroEtiquetaInt <= numeroBlocoAtual + 6) {
                    // Tenta remover a etiqueta
                    if (this.gerente.removerEtiqueta(numeroEtiquetaInt)) {
                        // Etiqueta removida com sucesso
                        JOptionPane.showMessageDialog(this, "Etiqueta removida com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                        // Atualiza as áreas de texto
                        String[] etiquetasText = gerente.toStringArray();
                        atualizarTextAreas(etiquetasText);

                        // Salva as alterações no arquivo
                        this.gerente.salvarNoArquivo("ListagemEtiquetas.csv");

                        inputValido = true;  // Dados válidos, saindo do loop
                    } else {
                        // Etiqueta não encontrada
                        JOptionPane.showMessageDialog(this, "Etiqueta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Etiqueta fora do intervalo, reiniciando o processo
                    JOptionPane.showMessageDialog(this, "A etiqueta informada não foi encontrada nesse bloco.", "Etiqueta Inválida", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Tratamento de erro caso a conversão para inteiro falhe, reiniciando o processo
                JOptionPane.showMessageDialog(this, "Número de etiqueta inválido. Insira um número inteiro.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(DlgBloco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_RemoverProdutoEqtActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AdicionarProdutoEqt;
    private javax.swing.JButton jButton_RemoverProdutoEqt;
    private javax.swing.JLabel jLabel_NomeBloco;
    private javax.swing.JLabel jLabel_PrimeiraEtqBloco;
    private javax.swing.JLabel jLabel_QuartaEtqBloco;
    private javax.swing.JLabel jLabel_QuintaEtqBloco;
    private javax.swing.JLabel jLabel_SegundaEtqBloco;
    private javax.swing.JLabel jLabel_SextaEtqBloco;
    private javax.swing.JLabel jLabel_TerceiraEtqBloco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea_EtiquetaPrimeiroBloco;
    private javax.swing.JTextArea jTextArea_EtiquetaQuartoBloco;
    private javax.swing.JTextArea jTextArea_EtiquetaQuintoBloco;
    private javax.swing.JTextArea jTextArea_EtiquetaSegundoBloco;
    private javax.swing.JTextArea jTextArea_EtiquetaSextoBloco;
    private javax.swing.JTextArea jTextArea_EtiquetaTerceiroBloco;
    // End of variables declaration//GEN-END:variables
}
