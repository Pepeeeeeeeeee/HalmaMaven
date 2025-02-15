package halmapoc.extraUtil;

import java.sql.*;
import java.util.List;

public class DBTests implements DBConnect{
    private static void closeConnections(Connection conn, PreparedStatement ps, ResultSet rs) {
        try{
            conn.close();
            ps.close();
            rs.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private static boolean checkConnection() {
        boolean isValid = false;
        try {
            Connection con = DriverManager.getConnection(con_url);
            isValid = con.isValid(2);
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return isValid;
    }

    private static boolean checkTableExistence(String sql){
        boolean isValid = false;
        try{
            Connection con = DriverManager.getConnection(con_url);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 9999);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                isValid = true;
            }
            closeConnections(con, ps, rs);
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return isValid;
    }

    private static boolean checkPlayerTable() {
        return checkTableExistence("select player_id, username, password, created_at from Players where player_id = ?");
    }

    private static boolean checkGameTable() {
        return checkTableExistence("select game_id, game_status, game_date from Games where game_id = ?");
    }

    public static void runTests() throws InterruptedException {
        if(checkConnection()){
            if(!checkPlayerTable()){
                System.err.println("Player table does not exist");
                if(!checkGameTable()){
                    System.err.println("Game table does not exist");
                    System.out.println("Creating tables");
                    List<Boolean> rowsCreated = DBCreate.createTables();
                    for(Boolean i : rowsCreated){
                        System.out.printf("Creating table %s\n", i ? "success" : "fail");
                    }
                    System.out.println("Done creating tables, moving to filling tables...");
                    List<Integer> rowsFilled = DBFill.fillTables();
                    for(Integer j : rowsFilled){
                        System.out.printf("Created %d rows\n", j);
                    }
                    System.out.println("Done filling tables, retrying tests...");
                    Thread.sleep(5000);
                    runTests();
                }
            }
            else{
                System.out.print("All good");
                //return everything's good
            }
        }
        else{
            System.err.println("No connection established");
        }
    }
}
