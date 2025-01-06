package model;

import java.util.ArrayList;
import java.util.List;

public class SerializadorCSVProdutos {

    public String toCSV(List<Produto> produtos) {
        String csv = "Nome;CódigoInterno;CódigoBarras;Preço;Quantidade";
        for(Produto produto : produtos){
            csv += "\n";
            csv += produto.getNome() + ";"
                    + produto.getCodigoInterno() + ";"
                    + produto.getCodigoBarra() + ";"
                    + produto.getPreco() + ";"
                    + produto.getQuantidade();
        }
        return csv;
    }

    public List<Produto> fromCSV(String data) {
    List<Produto> produtos = new ArrayList<>();
    String[] linhas = data.split("\n"); // Ignora cabeçalho
    for (int i = 1; i < linhas.length; i++) {
        String[] partes = linhas[i].split(";");
        if (partes.length >= 5) {
            Produto produto = new Produto();
            produto.setNome(partes[0]);
            produto.setCodigoInterno(partes[1]);
            produto.setCodigoBarra(partes[2]);

            // Substitui a vírgula por ponto antes de converter para Double
            try {
                String precoStr = partes[3].replace(',', '.'); // Substitui vírgula por ponto
                produto.setPreco(Double.parseDouble(precoStr));
            } catch (NumberFormatException e) {
                produto.setPreco(0.0); // Valor padrão caso a conversão falhe
            }
            // Conversão para Integer para a quantidade
            try {
                produto.setQuantidade(Integer.parseInt(partes[4]));
            } catch (NumberFormatException e) {
                produto.setQuantidade(0); // Valor padrão caso a conversão falhe
            }

            produtos.add(produto);
        }
    }
    return produtos;
}
}
