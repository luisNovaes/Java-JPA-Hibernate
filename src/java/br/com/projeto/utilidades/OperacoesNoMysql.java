/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import br.com.projeto.dao.UsuarioDAOMysql;
import java.text.ParseException;

/**
 *
 * @author luis.silva
 */
public class OperacoesNoMysql {

    public static void main(String[] args) throws ParseException {
//
        //Persistence.createEntityManagerFactory("bancoMysql");
        UsuarioDAOMysql dao = new UsuarioDAOMysql();
        //dao.buscarTodos();
        //dao.inserirUsuario("Otávio", "12345", "luis@gmail.com", "30/10/2000");
        //dao.selectUsuario("Jose Benedito", "Jesus");
        //dao.excluirUsuario("Antonio", "111111");
        dao.AtualizarDadosUsuario(50, "Bob Marley", "boby@gmail.com", "regae", "25/05/1975");

    }

}
