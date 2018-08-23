/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import javax.persistence.Persistence;

/**
 *
 * @author luis.silva
 */
public class criartabelaNoOracle {

    public static void main(String[] args) {

        Persistence.createEntityManagerFactory("bancoOracle");

    }

}
