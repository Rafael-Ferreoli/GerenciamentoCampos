package model.DAO.CSV;

import model.validation.CadastroValidacao;
import model.Cadastro;
import java.util.ArrayList;
import java.util.List;
import model.exception.CadastroException;

public class SerializadorCSVCadastro {

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

    public List<Cadastro> fromCSV(String data) {
        List<Cadastro> cadastros = new ArrayList<>();
        String[] linhas = data.split("\n");

        // Ignora o cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");

            if (partes.length >= 4) {
                try {
                    Cadastro cadastroTemp = new Cadastro(partes[0], partes[1], partes[2], partes[3]);
                    CadastroValidacao.validarCamposObrigatorios(cadastroTemp);
                    CadastroValidacao.validarUnicidade(partes[1], partes[2], cadastros);
                    cadastros.add(cadastroTemp);
                } catch (CadastroException e) {
                    System.err.println("Erro ao processar cadastro: " + e.getMessage());
                }
            }
        }
        return cadastros;
    }

}
