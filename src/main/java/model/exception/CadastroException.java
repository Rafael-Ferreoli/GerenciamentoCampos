package model.exception;

/**
 * Exceção personalizada para erros relacionados a Cadastro.
 */
public class CadastroException extends RuntimeException {

    public CadastroException(String message) {
        super(message);
    }
    
    // Métodos fábrica para criar exceções com mensagens padronizadas

    public static CadastroException nomeVazio() {
        return new CadastroException("Nome não pode ser vazio.");
    }
    
    public static CadastroException cpfInvalido() {
        return new CadastroException("CPF inválido.");
    }
    
    public static CadastroException senhaInvalida() {
        return new CadastroException("A senha deve conter pelo menos uma letra maiúscula, uma minúscula e um dígito.");
    }
    
    public static CadastroException cpfJaExistente() {
        return new CadastroException("CPF já existe.");
    }
    
    public static CadastroException matriculaJaExistente() {
        return new CadastroException("Matrícula já existe.");
    }
}
