package model.validation;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import model.Cadastro;
import model.exception.CadastroException;

public class CadastroValidacao {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw CadastroException.nomeVazio();
        }

        // se tiver num
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(nome);
        if (matcher.matches()) {
            throw new CadastroException("O nome não pode conter números.");
        }
    }

    public static void validarCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw CadastroException.cpfInvalido();
        }

        // Remove qualquer caractere que não seja dígito
        String cpfNumeros = cpf.replaceAll("\\D", "");
        if (cpfNumeros.length() != 11) {
            throw CadastroException.cpfInvalido();
        }

        // Evita CPFs com todos os dígitos iguais (ex.: 00000000000, 11111111111, etc.)
        if (cpfNumeros.chars().distinct().count() == 1) {
            throw CadastroException.cpfInvalido();
        }

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (10 - i);
            }
            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : 11 - resto;
            if (digito1 != Character.getNumericValue(cpfNumeros.charAt(9))) {
                throw CadastroException.cpfInvalido();
            }

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (11 - i);
            }
            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : 11 - resto;
            if (digito2 != Character.getNumericValue(cpfNumeros.charAt(10))) {
                throw CadastroException.cpfInvalido();
            }
        } catch (NumberFormatException e) {
            throw CadastroException.cpfInvalido();
        }
    }

    public static void validarSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw CadastroException.senhaInvalida();
        }

        // regex do maiusculo minusculo e numero
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(senha);
        if (!matcher.matches()) {
            throw CadastroException.senhaInvalida();
        }
    }

    public static void validarMatriz(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new CadastroException("Matrícula não pode ser vazia.");
        }
    }

    public static void validarUnicidade(String cpf, String matricula, List<Cadastro> cadastros) {
        for (Cadastro cadastro : cadastros) {
            if (cadastro.getCpf().equals(cpf)) {
                throw CadastroException.cpfJaExistente();
            }
            if (cadastro.getMatricula().equals(matricula)) {
                throw CadastroException.matriculaJaExistente();
            }
        }
    }

    public static void validarCamposObrigatorios(Cadastro cadastro) {
        validarNome(cadastro.getNome());
        validarCPF(cadastro.getCpf());
        validarMatriz(cadastro.getMatricula());
        validarSenha(cadastro.getSenha());
    }
}
