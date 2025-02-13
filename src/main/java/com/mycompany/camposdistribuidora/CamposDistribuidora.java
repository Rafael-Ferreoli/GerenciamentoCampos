/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.camposdistribuidora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import view.FrHome;
/**
 *
 * @author rafae
 */
public class CamposDistribuidora {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CamposDistribuidoraPU");
        EntityManager entityManager = factory.createEntityManager();
        FrHome tela1 = new FrHome();
        tela1.setVisible(true);
        entityManager.close();
        factory.close();
    }
}
