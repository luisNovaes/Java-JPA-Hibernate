/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.Usuario;
import br.com.projeto.utilidades.conexao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author luis.silva
 */
public class UsuarioDAOPostigres {

    /* Instância da classe usuário, criando um objeto
     (usuario)com as propriedades da classe */
    Usuario usuario = new Usuario();

    /* Instância da interface EntityManager, criando os objetos
     com as propriedades dos métodos de conexão com os bancos */
    EntityManager managerPostigres = conexao.getEntityManagerPostgres();
    EntityTransaction conexaoPostgres = managerPostigres.getTransaction();

    /*Busca todos os daos contidos na tabela usuarios, com uso de criteria */
    public String buscarTodos() {

        try {
            CriteriaBuilder builder = managerPostigres.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);

            Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
            criteriaQuery.select(usuario);

            TypedQuery<Usuario> query = managerPostigres.createQuery(criteriaQuery);
            List<Usuario> Usuarios = query.getResultList();

            for (Usuario user : Usuarios) {
                Date data = user.getDataNascimento();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataNacimento = sdf.format(data);
                System.out.println(user.getId() + " - "
                        + user.getNome() + " - "
                        + user.getSenha() + " - "
                        + user.getEmail() + " - "
                        + dataNacimento);
            }

        } catch (Exception e) {
            System.out.println("Erro (" + e.getMessage()
                    + ") ao consultar pessoa no banco!");

        } finally {
            managerPostigres.close();
            conexao.close();
        }

        return "Operação realizada com sucesso!";
    }

    //insere dados no banco
    public String inserirUsuario(String nome, String senha,
            String email, String dataNascimento) throws ParseException {

        DateFormat f = DateFormat.getDateInstance();
        Date data = f.parse(dataNascimento);
        System.out.println(data);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Data formatada: " + sdf.format(data));

        try {
            conexaoPostgres.begin();

            this.usuario.setNome(nome);
            this.usuario.setSenha(senha);
            this.usuario.setEmail(email);
            this.usuario.setDataNascimento(data);
            managerPostigres.persist(this.usuario);

            conexaoPostgres.commit();

        } catch (Exception e) {
            System.out.println(" Erro ao tentar inserir usuário no sistema! "
                    + "Já existe um usuario com este nome no sistema.");

        } finally {
            managerPostigres.close();
            conexao.close();
        }
        return "Operação realizada com sucesso!";
    }

    //faz select de usuario pelo nome e senha (poderia usar como chave primaria composta)
    public Usuario selectUsuario(String nomeUsuario, String senha) {

        try {
            this.usuario = (Usuario) managerPostigres
                    .createQuery(
                            "SELECT u from Usuario u where u.nome = "
                            + ":name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            Date data = usuario.getDataNascimento();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataNacimento = sdf.format(data);

            System.out.println(usuario.getId() + " -- "
                    + usuario.getNome() + " -- "
                    + usuario.getSenha() + " -- "
                    + usuario.getEmail() + " --"
                    + dataNacimento);
            return usuario;

        } catch (NoResultException e) {
            System.out.println(" Erro (" + e.getMessage()
                    + ") ao tentar buscar usuario no sistema ou não existe!");
            return null;

        } finally {
            managerPostigres.close();
            conexao.close();
        }
    }

    public String excluirUsuario(String nomeUsuario, String senha) {

        //long id = codigo;
        try {
            conexaoPostgres.begin();
            //usuario = managerMysql.find(Usuario.class, id);

            usuario = (Usuario) managerPostigres.createQuery(
                    "SELECT u from Usuario u where u.nome = :name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            managerPostigres.remove(usuario);
            conexaoPostgres.commit();
            System.out.println(" Pessoa excluida com sucesso!");

        } catch (Exception e) {

            System.out.println("Esta pessoa não pode ser excluida, "
                    + "pode está vinculada a algum cadastro ou não existe no sistema!");

        } finally {
            managerPostigres.close();
            conexao.close();
        }

        return "Operação realizada com sucesso!";
    }

    public String AtualizarDadosUsuario(int codigo, String nome, String email,
            String senha, String dadaNascimento) throws ParseException {

        long id = codigo;

        DateFormat f = DateFormat.getDateInstance();
        Date data = f.parse(dadaNascimento);
        System.out.println(data);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Data formatada: " + sdf.format(data));

        try {
            conexaoPostgres.begin();
            usuario = managerPostigres.find(Usuario.class, id);

            System.out.println("Nome atual: " + usuario.getNome());
            usuario.setNome(nome);
            System.out.println("Novo nome: " + usuario.getNome());

            System.out.println("Email atual: " + usuario.getEmail());
            usuario.setEmail(email);
            System.out.println("Novo email: " + usuario.getEmail());

            System.out.println("Senha atual: " + usuario.getSenha());
            usuario.setSenha(senha);
            System.out.println("Nova senha: " + usuario.getSenha());

            System.out.println("Data de Nascimento atual: " + usuario.getDataNascimento());
            usuario.setDataNascimento(data);
            System.out.println("Nova data de nascimento: " + usuario.getDataNascimento());
            conexaoPostgres.commit();

        } catch (Exception e) {
            conexaoPostgres.rollback();
            System.out.println("Erro (" + e.getMessage()
                    + ") ao tentar atualizar pessoa! Cofira os dados e tente novamente.");

        } finally {
            managerPostigres.close();
            conexao.close();
        }
        return "Opearação realizada com sucesso!";
    }

}
