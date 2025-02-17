package model.validation;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import model.Funcionario;
import model.exception.CadastroException;

public class CadastroValidation {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw CadastroException.nomeVazio();
        }

        // Verifica se contém números
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

        // Senha precisa ter pelo menos uma letra minúscula, uma maiúscula e um número
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(senha);
        if (!matcher.matches()) {
            throw CadastroException.senhaInvalida();
        }
    }

    public static void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new CadastroException("Email não pode ser vazio.");
        }

        // Regex básica para validar email
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new CadastroException("Email inválido.");
        }
    }

    public static void validarMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new CadastroException("Matrícula não pode ser vazia.");
        }
    }

    public static void validarUnicidade(String cpf, String matricula, List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                throw CadastroException.cpfJaExistente();
            }
            if (funcionario.getMatricula().equals(matricula)) {
                throw CadastroException.matriculaJaExistente();
            }
        }
    }

    public static void validarCamposObrigatorios(Funcionario funcionario) {
        validarNome(funcionario.getNome());
        validarCPF(funcionario.getCpf());
        validarMatricula(funcionario.getMatricula());
        validarSenha(funcionario.getSenha());
        validarEmail(funcionario.getEmail());
    }
}
