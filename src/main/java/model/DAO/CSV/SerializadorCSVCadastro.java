package model.DAO.CSV;

import model.Funcionario;
import model.Administrador;
import model.Operador;
import model.validation.CadastroValidation;
import model.exception.CadastroException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializadorCSVCadastro {

    public String toCSV(List<Funcionario> funcionarios) {
        // Adiciona a nova coluna "Administrador" no cabeçalho
        StringBuilder csv = new StringBuilder("Nome;CPF;Matricula;Senha;Email;Cargo;Administrador");
        for (Funcionario funcionario : funcionarios) {
            csv.append("\n")
                    .append(funcionario.getNome()).append(";")
                    .append(funcionario.getCpf()).append(";")
                    .append(funcionario.getMatricula()).append(";")
                    .append(funcionario.getSenha()).append(";")
                    .append(funcionario.getEmail()).append(";")
                    .append(funcionario.getCargo()).append(";");
            // Se for Operador, grava a matrícula do Administrador associado (ou deixa em branco se for null)
            if (funcionario instanceof Operador) {
                Operador operador = (Operador) funcionario;
                if (operador.getAdministrador() != null) {
                    csv.append(operador.getAdministrador().getMatricula());
                }
            }
        }
        return csv.toString();
    }

    public List<Funcionario> fromCSV(String data) {
        List<Funcionario> funcionarios = new ArrayList<>();
        // Mapa temporário para associar cada Operador à matrícula do Administrador informado no CSV
        Map<Operador, String> operadorAdminMap = new HashMap<>();

        String[] linhas = data.split("\n");
        // Ignora o cabeçalho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 6) {
                try {
                    String nome = partes[0];
                    String cpf = partes[1];
                    String matricula = partes[2];
                    String senha = partes[3];
                    String email = partes[4];
                    String cargo = partes[5];

                    Funcionario funcionarioTemp;
                    if (cargo.equalsIgnoreCase("ADMINISTRADOR")) {
                        funcionarioTemp = new Administrador(nome, cpf, matricula, senha, email);
                    } else if (cargo.equalsIgnoreCase("OPERADOR")) {
                        funcionarioTemp = new Operador(nome, cpf, matricula, senha, email);
                        // Se houver a coluna do Administrador e ela não estiver vazia, guarda o valor
                        if (partes.length == 7 && !partes[6].isBlank()) {
                            operadorAdminMap.put((Operador) funcionarioTemp, partes[6]);
                        }
                    } else {
                        throw new CadastroException("Cargo inválido: " + cargo);
                    }

                    CadastroValidation.validarCamposObrigatorios(funcionarioTemp);
                    CadastroValidation.validarUnicidade(cpf, matricula, funcionarios);
                    funcionarios.add(funcionarioTemp);
                } catch (CadastroException e) {
                    System.err.println("Erro ao processar cadastro: " + e.getMessage());
                }
            }
        }

        // Após carregar todos os cadastros, vincule os Operadores aos seus Administradores
        for (Map.Entry<Operador, String> entry : operadorAdminMap.entrySet()) {
            Operador operador = entry.getKey();
            String adminMatricula = entry.getValue();
            Administrador adminEncontrado = null;
            for (Funcionario f : funcionarios) {
                if (f instanceof Administrador && f.getMatricula().equals(adminMatricula)) {
                    adminEncontrado = (Administrador) f;
                    break;
                }
            }
            operador.setAdministrador(adminEncontrado);
            // Opcional: mantenha a relação bidirecional
            if (adminEncontrado != null) {
                adminEncontrado.getOperadores().add(operador);
            }
        }

        return funcionarios;
    }
}

