package model;

import controller.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ContatoDAO {

    private DAO dao = new DAO();
    private int ultimoIDInserido = -1;

    public boolean inserirContato(Contato contato) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            PreparedStatement novoContato = conexao.prepareStatement("INSERT INTO contato (nome, telefone) " +
                    "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
            novoContato.setString(1, contato.getNome());
            novoContato.setString(2, contato.getTelefone());

            int rowsAffected = novoContato.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet chavePrimaria = novoContato.getGeneratedKeys();
                if (chavePrimaria.next()) {
                    ultimoIDInserido = chavePrimaria.getInt(1); // Armazena o último ID gerado
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    // Metodo para recuperar o último ID inserido
    public int getUltimoIDInserido() {
        return ultimoIDInserido;
    }
}
