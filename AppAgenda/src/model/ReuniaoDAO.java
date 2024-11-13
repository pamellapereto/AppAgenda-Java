package model;

import controller.Reuniao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReuniaoDAO {

    private DAO dao = new DAO();

    public boolean inserirReuniao(Reuniao reuniao) {
        try {
            Connection conexao = dao.conectar();

            //Preparar a execução da query SQL
            PreparedStatement novaReuniao = conexao.prepareStatement("INSERT INTO reuniao (dataReuniao, link) " +
                    "VALUES (?, ?);");
            novaReuniao.setString(1, reuniao.getDataReuniao() + " " + reuniao.getHoraReuniao());
            novaReuniao.setString(2, reuniao.getLink());

            int rowsAffected = novaReuniao.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
