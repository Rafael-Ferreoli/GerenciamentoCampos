package model.DAO;

import model.Etiqueta;
import model.DAO.CSV.SerializadorCSVEtiquetas;
import model.DAO.CSV.FilePersistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaCSVDAO implements IDAO<Etiqueta> {

    private final String filePath = "ListagemEtiquetas.csv";
    private final SerializadorCSVEtiquetas serializador;
    private final FilePersistence filePersistence;
    
    public EtiquetaCSVDAO() {
        this.serializador = new SerializadorCSVEtiquetas();
        this.filePersistence = new FilePersistence();
    }
    
    @Override
    public void save(Etiqueta etiqueta) {
        List<Etiqueta> etiquetas = findAll();
        etiquetas.add(etiqueta);
        salvarLista(etiquetas);
    }
    
    @Override
    public void update(String id, Etiqueta etiquetaAtualizada) {
        int num = Integer.parseInt(id);
        List<Etiqueta> etiquetas = findAll();
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).getNumEtiqueta() == num) {
                etiquetas.set(i, etiquetaAtualizada);
                salvarLista(etiquetas);
                return;
            }
        }
    }
    
    @Override
    public void delete(String id) {
        int num = Integer.parseInt(id);
        List<Etiqueta> etiquetas = findAll();
        etiquetas.removeIf(e -> e.getNumEtiqueta() == num);
        salvarLista(etiquetas);
    }
    
    @Override
    public Etiqueta findById(String id) {
        int num = Integer.parseInt(id);
        for (Etiqueta e : findAll()) {
            if (e.getNumEtiqueta() == num) {
                return e;
            }
        }
        return null;
    }
    
    @Override
    public List<Etiqueta> findAll() {
        try {
            String csvData = filePersistence.loadFromFile(filePath);
            return serializador.fromCSV(csvData);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    private void salvarLista(List<Etiqueta> etiquetas) {
        try {
            String csvData = serializador.toCSV(etiquetas);
            filePersistence.saveToFile(csvData, filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo CSV: " + e.getMessage(), e);
        }
    }
    
    
}
