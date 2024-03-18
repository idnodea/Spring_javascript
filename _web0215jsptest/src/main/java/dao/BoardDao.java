package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Board;
import mvjsp.board.dao.BoardDao;
import mvjsp.jdbc.JdbcUtil;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
	    return instance;
	}

	private BoardDao() {
	}

	public int selectCount(Connection conn) throws SQLException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        pstmt = conn.prepareStatement("select count(*) from board");
	        rs = pstmt.executeQuery();
	        rs.next();
	        return rs.getInt(1);
	    } finally {
	        JdbcUtil.close(rs);
	        JdbcUtil.close(pstmt);
	    }
	}
	
//	
//    private static Connection conn;
//    private static BoardDao boardDao = new BoardDao();
//
//    private BoardDao() {} // 생성자
//
//    public static BoardDao getInstance() {
//        BoardDao.getConnection();
//        return boardDao;
//    }
//
//    private static void getConnection() {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//    }

    public ArrayList<Board> selectList() { //게시물 전체
        ArrayList<Board> bList = new ArrayList<Board>();
        String bSql = "select b.num, b.title, m.name, b.content, b.regtime, b.hits, m.name "
                + "from board b, member m "
                + "where b.memberno = m.memberno order by num desc";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Board board = new Board(rs.getInt("num"), rs.getString("title"),
                		rs.getString("name"),rs.getString("content"),
                        rs.getString("regtime"), rs.getInt("hits"));
                bList.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
        return bList;
    }

    public Board selectOne(int num, boolean inc) { //게시물 하나
        Board board = null;
        String bSql = "select b.num, b.title, b.content, b.regtime, b.hits, m.name "
                + "from board b, member m "
                + "where b.memberno = m.memberno and b.num=? order by num desc";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setInt(1, num);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    board = new Board(
                            rs.getInt("num"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("regtime"),
                            rs.getInt("hits"),
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
        }finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
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
        }
        return result;
    }

    public int insert(Board board) { // 글쓰기
        String bSql = "insert into board(name, title, content, regtime, hits, memberno) values (?,?,?,?,0,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setString(1, board.getName());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getContent());
            pstmt.setString(4, board.getRegTime());
            pstmt.setInt(5, board.getMemberno());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
        return 0;
    }

    public int update(Board board) {
        String bSql = "update board set name=?, title=?, content=?, regtime=? where num=?";
        try (PreparedStatement pstmt = conn.prepareStatement(bSql)) {
            pstmt.setString(1, board.getName());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getContent());
            pstmt.setString(4, board.getRegTime());
            pstmt.setInt(5, board.getNum());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
        return 0;
    }
}