package halmapoc.extraUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCreate implements DBConnect {
    private static boolean createTable(String sql){
        boolean rowsCreated = false;
        try{
            Connection conn = DriverManager.getConnection(con_url);
            Statement ps = conn.createStatement();
            ps.execute(sql);
            rowsCreated = true;
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return rowsCreated;
    }

    private static boolean createPlayersTable(){
        return createTable("create table Players(player_id serial primary key, username varchar(255), password varchar(255), created_at timestamp);");
    }

    private static boolean createGamesTable(){
        return createTable("create table Games(game_id serial primary key, game_status varchar(15), game_date timestamp);");
    }

    public static List<Boolean> createTables(){
        List<Boolean> rowsCreated = new ArrayList<>();
        rowsCreated.add(createPlayersTable());
        rowsCreated.add(createGamesTable());
        return rowsCreated;
    }
}
