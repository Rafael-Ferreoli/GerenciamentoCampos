/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cadastro;
import model.DAO.CSV.FilePersistence;
import model.DAO.CSV.SerializadorCSVCadastro;

/**
 *
 * @author rafae
 */
public class CadastroCSVDAO implements IDAO<Cadastro>{
    
    private final String pathFile = "ListagemCadastro.csv";
    private final SerializadorCSVCadastro serializador;
    private final FilePersistence filePersistence;

    public CadastroCSVDAO() {
        this.serializador = new SerializadorCSVCadastro();
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void save(Cadastro cadastro) {
        List<Cadastro> cadastros = findAll();
        cadastros.add(cadastro);
        salvarLista(cadastros);
    }

    @Override
    public void update(String matricula, Cadastro cadastroNovo) {
        List<Cadastro> cadastros = findAll();
        for (int i = 0; i < cadastros.size(); i++) {
            if (cadastros.get(i).getMatricula().equals(matricula)) {
                cadastros.set(i, cadastroNovo);
                salvarLista(cadastros);
                return;
            }
        }
    }

    @Override
    public void delete(String matricula) {
        List<Cadastro> cadastros = findAll();
        cadastros.removeIf(cadastro -> cadastro.getMatricula().equals(matricula));
        salvarLista(cadastros);
    }

    @Override
    public Cadastro findById(String matricula) {
        return findAll().stream()
                .filter(cadastro -> cadastro.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cadastro> findAll() {
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
            List<Cadastro> cadastros = serializador.fromCSV(csvData);
        } catch (IOException e) {
            throw new FileNotFoundException("Erro ao carregar arquivo: " + pathFile);
        }
    }

    public void salvarLista(List<Cadastro> cadastros) {
        try {
            String csvData = serializador.toCSV(cadastros);
            filePersistence.saveToFile(csvData, pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo CSV: " + e.getMessage(), e);
        }
    }
}

   
