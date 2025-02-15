package halmapoc.extraUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBFill implements DBConnect{
    private static int fillTable(String sql){
        int rowsCreated = 0;
        try{
            Connection conn = DriverManager.getConnection(con_url);
            PreparedStatement ps = conn.prepareStatement(sql);
            rowsCreated += ps.executeUpdate();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return rowsCreated;
    }

    private static int fillPlayersTable(){
        return fillTable("insert into Players values(9999, 'test_user', 'password', now());");
    }

    private static int fillGamesTable(){
        return fillTable("insert into Games values(9999, 'finished', now());");
    }

    public static List<Integer> fillTables(){
        List<Integer> rowsCreated = new ArrayList<>();
        rowsCreated.add(fillPlayersTable());
        rowsCreated.add(fillGamesTable());
        return rowsCreated;
    }
}
