/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import br.com.projeto.dao.UsuarioDAOOracle;
import java.text.ParseException;

/**
 *
 * @author luis.silva
 */
public class OperacoesNoOracle {

    public static void main(String[] args) throws ParseException {
//
        //Persistence.createEntityManagerFactory("bancoMysql");
        UsuarioDAOOracle dao = new UsuarioDAOOracle();
        //dao.buscarTodos();
        //dao.inserirUsuario("Zuleide", "654321", "zuleide@gmail.com", "01/01/1981");
        //dao.selectUsuario("Azevedo", "654321");
        //dao.excluirUsuario("Otávio", "12345");
        dao.AtualizarDadosUsuario(4, "Kawan", "Kawan@gmail.com", "Oxosse", "21/09/2001");

    }

}
