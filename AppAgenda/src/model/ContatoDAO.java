package model;

import controller.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContatoDAO {

    private DAO dao = new DAO();

    public boolean inserirContato(Contato contato) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            PreparedStatement novoContato = conexao.prepareStatement("INSERT INTO contato (nome, telefone) " +
                    "VALUES (?, ?);");
            novoContato.setString(1, contato.getNome());
            novoContato.setString(2, contato.getTelefone());

            int rowsAffected = novoContato.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
