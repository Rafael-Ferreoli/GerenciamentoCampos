package model;

import model.validation.Validacao;
import java.util.ArrayList;
import java.util.List;

public class SerializadorCSVCadastro {

    // Serializa a lista de cadastros para CSV
    public String toCSV(List<Cadastro> cadastros) {
        StringBuilder csv = new StringBuilder("Nome;Cargo;CPF;Email;Matricula;Senha");
        for (Cadastro cadastro : cadastros) {
            csv.append("\n")
               .append(cadastro.getNome()).append(";")
               .append(cadastro.getCargo()).append(";")
               .append(cadastro.getCpf()).append(";")
               .append(cadastro.getEmail()).append(";")
               .append(cadastro.getMatricula()).append(";")
               .append(cadastro.getSenha());
        }
        return csv.toString();
    }

    // Desserializa os dados CSV para a lista de cadastros
    public List<Cadastro> fromCSV(String data) {
        List<Cadastro> cadastros = new ArrayList<>();
        String[] linhas = data.split("\n"); // Ignora cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 6) {
                try {
                    // Usamos a validação ao criar o objeto Cadastro
                    Validacao.validarStringNaoVazia(partes[0], "Nome não pode ser vazio");
                    Validacao.validarStringNaoVazia(partes[1], "Cargo não pode ser vazio");
                    Validacao.validarStringNaoVazia(partes[2], "CPF não pode ser vazio");
                    Validacao.validarCPF(partes[2]);
                    Validacao.validarStringNaoVazia(partes[3], "Email não pode ser vazio");
                    Validacao.validarEmail(partes[3]);
                    Validacao.validarStringNaoVazia(partes[4], "Matrícula não pode ser vazia");

                    Cadastro cadastro = new Cadastro(partes[0], partes[3], partes[2], partes[1], partes[5], partes[4]);
                    cadastros.add(cadastro);
                } catch (IllegalArgumentException e) {
                    System.err.println("Erro ao processar cadastro: " + e.getMessage());
                }
            }
        }
        return cadastros;
    }
}
