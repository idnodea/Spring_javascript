package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;
// import mvjsp.jdbc.JdbcUtil;

public class BoardDao {
    
    private static Connection conn;
    private static BoardDao boardDao = new BoardDao();

    private BoardDao() {} // 생성자

    public static BoardDao getInstance() {
        if (conn == null) {
            getConnection();
            
        }
        return boardDao;
    }

    private static void getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
    }

    public ArrayList<Board> selectList() { //게시물 전체
        ArrayList<Board> bList = new ArrayList<Board>();
        String bSql = "select b.num, b.title, m.name, b.content, b.regtime, b.hits "
                + "from board b, member m "
                + "where b.memberno = m.memberno order by num desc";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Board board = new Board(
                        rs.getInt("num"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("regtime"),
                        rs.getInt("hits"),
                        rs.getInt("memberno"),
                        rs.getString("name")
                );
                bList.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return bList;
    }

    public Board selectOne(int num, boolean inc) { //게시물 하나
        Board board = null;
        String bSql = "select b.num, b.title, b.content, b.regtime, b.hits, m.name, b.memberno " +
                      "from board b, member m " +
                      "where b.memberno = m.memberno and b.num=? order by num desc";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setInt(1, num);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int memberno = rs.getInt("memberno");
                    board = new Board(
                            rs.getInt("num"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("regtime"),
                            rs.getInt("hits"),
                            memberno,
                            rs.getString("name")
                    );

                    if (inc) {
                        try (PreparedStatement updateStmt = conn.prepareStatement("update board set hits = hits+1 where num=?")) {
                            updateStmt.setInt(1, num);
                            updateStmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return board;
    }

    public int delete(int num) { // 게시글 삭제
        int result = 0;
        String sql = "delete from board where num=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, num);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return result;
    }

    public int insert(Board board) { // 글쓰기
        String bSql = "insert into board(num, title, content, regtime, hits, memberno) values (seq_board.nextval,?,?,?,0,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getRegtime());
            pstmt.setInt(4, board.getMemberno());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return 0;
    }

    public int update(Board board) {
        String bSql = "update board set title=?, content=?, regtime=? where num=?";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getRegtime());
            pstmt.setInt(4, board.getNum());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return 0;
    }
}