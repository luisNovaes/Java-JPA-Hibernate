/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import br.com.projeto.dao.UsuarioDAOPostigres;
import java.text.ParseException;

/**
 *
 * @author luis.silva
 */
public class OperacoesNoPostegres {

    public static void main(String[] args) throws ParseException {

        //Persistence.createEntityManagerFactory("bancoMysql");
        UsuarioDAOPostigres dao = new UsuarioDAOPostigres();
        //dao.buscarTodos();
        //dao.inserirUsuario("Adriano", "55555", "luana@gamil.com", "21/10/1999");
        //dao.selectUsuario("Fernado", "999999");
        //dao.excluirUsuario("Antonio", "111111");
        dao.AtualizarDadosUsuario(12, "Ogum", "ogum@gmail.com", "101010", "21/04/1982");

    }

}
