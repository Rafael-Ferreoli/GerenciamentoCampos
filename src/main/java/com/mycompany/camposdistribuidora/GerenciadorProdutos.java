/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora;

import com.mycompany.camposdistribuidora.File.FilePersistence;
import com.mycompany.camposdistribuidora.File.SerializadorCSVProdutos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class GerenciadorProdutos {

    private List<Produto> produtos;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProdutos(Produto produtos) {
        this.produtos.add(produtos);
        System.out.println("produto adicionado");
    }

    public boolean removerCadastro(String codInternoSelecionado) {
        for (Produto produto : produtos) {
            if (produto.getCodigoInterno().equals(codInternoSelecionado)) {
                produtos.remove(produto);
                System.out.println("produto removido");
                return true;
            }
        }
        System.out.println("produto nao encontrado");
        return false;

    }

    public Produto buscarProduto(String codInternoSelecionado) {
        for (Produto produto : produtos) {
            if (produto.getCodigoInterno().equals(codInternoSelecionado)) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarProduto(String codInternoSelecionado, Produto produtoNovo) {
        Produto produtoExistente = buscarProduto(codInternoSelecionado);
        if (produtoExistente != null) {
            int indice = produtos.indexOf(produtoExistente);
            produtos.set(indice, produtoNovo);
            System.out.println("produto atualizado");
        } else {
            System.out.println("produto " + codInternoSelecionado + " nao encontado");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Produto produto : produtos) {
            saida.append(produto.toString()).append("\n");
        }
        return saida.toString();
    }

    public void salvarNoArquivo(String pathFile) throws IOException{
        SerializadorCSVProdutos serializadorCSV = new SerializadorCSVProdutos();
        String csvData = serializadorCSV.toCSV(this.produtos);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, pathFile);
        System.out.println("produto salvo");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException{
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(pathFile);
        SerializadorCSVProdutos serializadorCSV = new SerializadorCSVProdutos();
        this.produtos = serializadorCSV.fromCSV(csvData);
        System.out.println("produtos carregados");
    }
    
    
    
    
    
    
    
    
    
    
    /*
    public void lerCSV(JTextArea textArea) throws FileNotFoundException {
        FileReader arq = new FileReader("C:\\Users\\rafae\\OneDrive\\Documentos\\NetBeansProjects\\MiniSAP\\src\\main\\java\\com\\mycompany\\minisap\\cadastrosUsuarios.csv");
        Scanner arquivoLido = new Scanner(arq);
        arquivoLido.useDelimiter("\n");
        // Ignorar a primeira linha (cabeçalho)
        while (arquivoLido.hasNext()) {
            String linhaLida = arquivoLido.next();
            String vetor[] = linhaLida.split(";");
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(vetor[0]);
            cadastro.setCargo(vetor[1]);
            cadastro.setCpf(vetor[2]);
            cadastro.setEmail(vetor[3]);
            cadastro.setMatricula(vetor[4]);
            cadastro.setSenha(vetor[5]);
            textArea.append(cadastro.toString() + "\n");
        }
        cadastros.clear();
        arquivoLido.close();
    }

    public void escreverCSV() throws IOException {
        FileWriter arq = new FileWriter("C:\\Users\\rafae\\OneDrive\\Documentos\\NetBeansProjects\\MiniSAP\\src\\main\\java\\com\\mycompany\\minisap\\cadastrosUsuarios.csv", true); // Abrir o arquivo no modo de adição
        PrintWriter gravarArq = new PrintWriter(arq);

        // Adicionar o novo cadastro no final do arquivo
        for (Cadastro cadastro : cadastros) {
            gravarArq.println();
            gravarArq.printf("%s;%s;%s;%s;%s;%s",
                    cadastro.getNome(),
                    cadastro.getEmail(),
                    cadastro.getCpf(),
                    cadastro.getCargo(),
                    cadastro.getMatricula(),
                    cadastro.getSenha());
        }

        System.out.println("Novo cadastro adicionado ao CSV com sucesso.");
        arq.close();
    }
*/
}
