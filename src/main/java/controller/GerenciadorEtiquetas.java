package controller;

import factory.Persistencia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Etiqueta;
import model.DAO.IDAO;
import model.DAO.ProdutoSQLiteDAO;
import model.Produto;

public class GerenciadorEtiquetas {

    private IDAO<Etiqueta> etiquetaDAO;

    public GerenciadorEtiquetas() {
        this.etiquetaDAO = factory.Persistencia.getEtiquetaDAO();

    }

    public void adicionarEtiqueta(Etiqueta etiqueta) {
        etiquetaDAO.save(etiqueta);
        System.out.println("Etiqueta adicionada");
    }

    public boolean removerEtiqueta(int numero) {
        Etiqueta etiqueta = buscarEtiqueta(numero);
        if (etiqueta != null) {
            etiquetaDAO.delete(String.valueOf(numero));
            System.out.println("Etiqueta removida");
            return true;
        }
        System.out.println("Etiqueta não encontrada");
        return false;
    }

    public Etiqueta buscarEtiqueta(int numero) {
        // Se o DAO tiver o método findById implementado de forma eficiente, use-o
        Etiqueta etiqueta = etiquetaDAO.findById(String.valueOf(numero));
        if (etiqueta != null) {
            return etiqueta;
        }
        // Alternativamente, pode filtrar a lista completa:
        for (Etiqueta e : etiquetaDAO.findAll()) {
            if (e.getNumEtiqueta() == numero) {
                return e;
            }
        }
        return null;
    }

    public List<Etiqueta> buscarProduto(String codInterno) {
        List<Etiqueta> etiquetasEncontradas = new ArrayList<>();
        for (Etiqueta etiqueta : etiquetaDAO.findAll()) {
            if (etiqueta.getCodigoInterno().equals(codInterno)) {
                etiquetasEncontradas.add(etiqueta);
            }
        }
        return etiquetasEncontradas;
    }

    public void atualizarEtiqueta(int numero, Etiqueta etiquetaNova) {
        if (buscarEtiqueta(numero) != null) {
            etiquetaDAO.update(String.valueOf(numero), etiquetaNova);
            System.out.println("Etiqueta atualizada");
        } else {
            System.out.println("Etiqueta " + numero + " não encontrada");
        }
    }

    // Mantemos o método codigoInternoExiste caso ele verifique o arquivo de produtos
    public boolean codigoInternoExiste(String codigoInterno) {
        if (Persistencia.getTipoPersistencia().equalsIgnoreCase("sqlite")) {
            // Usa o DAO de produto SQLite para verificar a existência
            IDAO<Produto> produtoDAO = new ProdutoSQLiteDAO();
            Produto produto = produtoDAO.findById(codigoInterno);
            return produto != null;
        } else { // assume CSV
            try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("ListagemProdutos.csv"))) {
                String line;
                reader.readLine(); // Ignora o cabeçalho
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 2 && parts[1].equals(codigoInterno)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public String[] toStringArray(int numeroBlocoAtual) {
        StringBuilder[] textAreas = new StringBuilder[6];
        for (int i = 0; i < 6; i++) {
            textAreas[i] = new StringBuilder();
        }
        for (Etiqueta etiqueta : etiquetaDAO.findAll()) {
            int index = etiqueta.getNumEtiqueta() - 1;
            if (index >= numeroBlocoAtual && index < numeroBlocoAtual + 6) {
                textAreas[index - numeroBlocoAtual].append(etiqueta.toString()).append("\n");
            }
        }
        String[] result = new String[6];
        for (int i = 0; i < 6; i++) {
            result[i] = textAreas[i].toString();
        }
        return result;
    }

    public String toStringEtiqueta(int etiquetaSelecionada) {
        Etiqueta etiqueta = buscarEtiqueta(etiquetaSelecionada);
        return etiqueta != null ? etiqueta.toString() + "\n" : "";
    }

    public String toStringProduto(String codInterno) {
        StringBuilder saida = new StringBuilder();
        for (Etiqueta etiqueta : buscarProduto(codInterno)) {
            saida.append(etiqueta.toString()).append("\n");
        }
        return saida.toString();
    }

    public String toStringValidades() {
        List<Etiqueta> todas = etiquetaDAO.findAll();
        Collections.sort(todas, new Comparator<Etiqueta>() {
            @Override
            public int compare(Etiqueta e1, Etiqueta e2) {
                return e1.getData().compareTo(e2.getData());
            }
        });
        StringBuilder saida = new StringBuilder();
        for (Etiqueta etiqueta : todas) {
            saida.append(etiqueta.toString()).append("\n");
        }
        return saida.toString();
    }
    
    
}
