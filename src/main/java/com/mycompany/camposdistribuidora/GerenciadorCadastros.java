/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora;

import com.mycompany.camposdistribuidora.File.FilePersistence;
import com.mycompany.camposdistribuidora.File.SerializadorCSVCadastro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class GerenciadorCadastros {

    private List<Cadastro> cadastros;

    public GerenciadorCadastros() {
        this.cadastros = new ArrayList<>();
    }

    public void adicionarCadastros(Cadastro cadastro) {
        cadastros.add(cadastro);
        System.out.println("cadastro adicionado");
    }

    public boolean removerCadastro(String matriculaSelecionada) {
        for (Cadastro cadastro : cadastros) {
            if (cadastro.getMatricula().equals(matriculaSelecionada)) {
                cadastros.remove(cadastro);
                System.out.println("cadastro removido");
                return true;
            }
        }
        System.out.println("cadastro nao encontrado");
        return false;

    }

    public Cadastro buscarCadastro(String matricula) {
        for (Cadastro cadastro : cadastros) {
            if (cadastro.getMatricula().equals(matricula)) {
                return cadastro;
            }
        }
        return null;
    }

    public void atualizarCadastro(String matriculaSelecionada, Cadastro cadastroNovo) {
        Cadastro cadastroExistente = buscarCadastro(matriculaSelecionada);
        if (cadastroExistente != null) {
            int indice = cadastros.indexOf(cadastroExistente);
            cadastros.set(indice, cadastroNovo);
            System.out.println("cadastro atualizado");
        } else {
            System.out.println("cadastro " + matriculaSelecionada + " nao encontado");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Cadastro cadastro : cadastros) {
            saida.append(cadastro.toString()).append("\n");
        }
        return saida.toString();
    }

    public void salvarNoArquivo(String pathFile) throws IOException{
        SerializadorCSVCadastro serializadorCSV = new SerializadorCSVCadastro();
        String csvData = serializadorCSV.toCSV(this.cadastros);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, pathFile);
        System.out.println("cadastro salvo");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException{
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(pathFile);
        SerializadorCSVCadastro serializadorCSV = new SerializadorCSVCadastro();
        this.cadastros = serializadorCSV.fromCSV(csvData);
        System.out.println("cadastros carregados");
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
