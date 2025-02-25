package model;

import controller.Lista;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ListaDAO {

    private DAO dao = new DAO();
    public boolean inserirLista(Lista lista) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            PreparedStatement novaLista = conexao.prepareStatement("INSERT INTO lista (nome) " +
                    "VALUES (?);");
            novaLista.setString(1, lista.getNome());
            int rowsAffected = novaLista.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean atualizarLista(Lista lista) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            PreparedStatement listaAtualizada = conexao.prepareStatement("UPDATE lista SET nome = ? WHERE id = ?;");
            listaAtualizada.setString(1, lista.getNome());
            listaAtualizada.setInt(2, lista.getId());

            int rowsAffected = listaAtualizada.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}

