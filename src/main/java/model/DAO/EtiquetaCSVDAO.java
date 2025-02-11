package model.DAO;

import model.DAO.IDAO;
import model.Etiqueta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.DAO.CSV.FilePersistence;
import model.DAO.CSV.SerializadorCSVEtiquetas;

public class EtiquetaCSVDAO implements IDAO<Etiqueta> {

    private List<Etiqueta> etiquetas;
    private String filePath;

    public EtiquetaCSVDAO() {
        this("ListagemEtiquetas.csv");
    }
    
    public EtiquetaCSVDAO(String filePath) {
        this.filePath = filePath;
        this.etiquetas = new ArrayList<>();
        // Tenta carregar os dados do arquivo (se existir)
        try {
            loadFromFile();
        } catch (FileNotFoundException e) {
            // Arquivo não existe ainda – inicia com lista vazia
        }
    }

    @Override
    public void save(Etiqueta entity) {
        etiquetas.add(entity);
        saveToFile();
    }

    @Override
    public void update(String id, Etiqueta entity) {
        int num = Integer.parseInt(id);
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).getNumEtiqueta() == num) {
                etiquetas.set(i, entity);
                saveToFile();
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        int num = Integer.parseInt(id);
        Iterator<Etiqueta> it = etiquetas.iterator();
        while (it.hasNext()) {
            Etiqueta e = it.next();
            if (e.getNumEtiqueta() == num) {
                it.remove();
                saveToFile();
                return;
            }
        }
    }

    @Override
    public Etiqueta findById(String id) {
        int num = Integer.parseInt(id);
        for (Etiqueta e : etiquetas) {
            if (e.getNumEtiqueta() == num) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Etiqueta> findAll() {
        return new ArrayList<>(etiquetas);
    }
    
    // Método para carregar os dados do arquivo CSV
    public void loadFromFile() throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(filePath);
        SerializadorCSVEtiquetas serializador = new SerializadorCSVEtiquetas();
        this.etiquetas = serializador.fromCSV(csvData);
        System.out.println("Etiquetas carregadas do CSV");
    }
    
    // Método para salvar os dados no arquivo CSV
    public void saveToFile() {
        try {
            SerializadorCSVEtiquetas serializador = new SerializadorCSVEtiquetas();
            String csvData = serializador.toCSV(etiquetas);
            FilePersistence filePersistence = new FilePersistence();
            filePersistence.saveToFile(csvData, filePath);
            System.out.println("Etiquetas salvas no CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
