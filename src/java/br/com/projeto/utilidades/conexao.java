/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis.silva
 */
public class conexao {

    /* declaração dos objetos de conexões com os bancos*/
    private static final EntityManagerFactory factoryMysql;
    private static final EntityManagerFactory factoryPostgres;
    private static final EntityManagerFactory factoryOracle;

    /* fáblicas de conexão com o Banco Mysql */
    static {
        factoryMysql = Persistence.createEntityManagerFactory("bancoMysql");
    }

    public static EntityManager getEntityManagerMysql() {
        return factoryMysql.createEntityManager();
    }

    /* fáblicas de conexão com o Banco Postgres */
    static {
        factoryPostgres = Persistence.createEntityManagerFactory("bancopostgres");
    }

    public static EntityManager getEntityManagerPostgres() {
        return factoryPostgres.createEntityManager();
    }

    /* fáblicas de conexão com o Banco Oracle*/
    static {
        factoryOracle = Persistence.createEntityManagerFactory("bancoOracle");
    }

    public static EntityManager getEntityManagerOracle() {
        return factoryOracle.createEntityManager();
    }

    /* fecha conexão com as fáblicas*/
    public static void close() {
        factoryMysql.close();
        factoryPostgres.close();
        factoryOracle.close();
    }

}
