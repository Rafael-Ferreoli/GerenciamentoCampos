/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class FilePersistence {

    public String loadFromFile(String filePath) throws FileNotFoundException {
        String conteudoLido = "";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        while (scanner.hasNext()) {
            conteudoLido += scanner.next();
        }
        return conteudoLido;
    }

    public void saveToFile(String texto, String filePath) throws IOException {
        FileWriter arq = new FileWriter(filePath);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.print(texto);
        arq.close();
    }
}
