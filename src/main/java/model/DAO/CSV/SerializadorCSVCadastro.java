package model.DAO.CSV;

import model.validation.ValidacaoProduto;
import java.util.ArrayList;
import java.util.List;
import model.Cadastro;

public class SerializadorCSVCadastro {

    // Serializa a lista de cadastros para CSV
    public String toCSV(List<Cadastro> cadastros) {
        StringBuilder csv = new StringBuilder("Nome;CPF;Matricula;Senha");
        for (Cadastro cadastro : cadastros) {
            csv.append("\n")
               .append(cadastro.getNome()).append(";")
               .append(cadastro.getCpf()).append(";")
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
                    ValidacaoProduto.validarStringNaoVazia(partes[0], "Nome não pode ser vazio");
                    ValidacaoProduto.validarStringNaoVazia(partes[1], "CPF não pode ser vazio");
                    ValidacaoProduto.validarCPF(partes[1]);
                    ValidacaoProduto.validarEmail(partes[2]);
                    ValidacaoProduto.validarStringNaoVazia(partes[3], "Matrícula não pode ser vazia");

                    Cadastro cadastro = new Cadastro(partes[0], partes[1], partes[2], partes[3]);
                    cadastros.add(cadastro);
                } catch (IllegalArgumentException e) {
                    System.err.println("Erro ao processar cadastro: " + e.getMessage());
                }
            }
        }
        return cadastros;
    }
}
