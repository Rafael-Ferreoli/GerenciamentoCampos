package model.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.DAO.CSV.FilePersistence;
import model.DAO.CSV.SerializadorCSVCadastro;

public class CadastroCSVDAO implements IDAO<Funcionario> {
    
    private final String pathFile = "ListagemCadastro.csv";
    private final SerializadorCSVCadastro serializador;
    private final FilePersistence filePersistence;

    public CadastroCSVDAO() {
        this.serializador = new SerializadorCSVCadastro();
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void save(Funcionario funcionario) {
        List<Funcionario> funcionarios = findAll();
        funcionarios.add(funcionario);
        salvarLista(funcionarios);
    }

    @Override
    public void update(String matricula, Funcionario funcionarioNovo) {
        List<Funcionario> funcionarios = findAll();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula().equals(matricula)) {
                funcionarios.set(i, funcionarioNovo);
                salvarLista(funcionarios);
                return;
            }
        }
    }

    @Override
    public void delete(String matricula) {
        List<Funcionario> funcionarios = findAll();
        funcionarios.removeIf(funcionario -> funcionario.getMatricula().equals(matricula));
        salvarLista(funcionarios);
    }

    @Override
    public Funcionario findById(String matricula) {
        return findAll().stream()
                .filter(funcionario -> funcionario.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Funcionario> findAll() {
        try {
            String csvData = filePersistence.loadFromFile(pathFile);
            return serializador.fromCSV(csvData);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        try {
            String csvData = filePersistence.loadFromFile(pathFile);
            List<Funcionario> funcionarios = serializador.fromCSV(csvData);
        } catch (IOException e) {
            throw new FileNotFoundException("Erro ao carregar arquivo: " + pathFile);
        }
    }

    public void salvarLista(List<Funcionario> funcionarios) {
        try {
            String csvData = serializador.toCSV(funcionarios);
            filePersistence.saveToFile(csvData, pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo CSV: " + e.getMessage(), e);
        }
    }
}
